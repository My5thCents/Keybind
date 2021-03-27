package model;

import com.sun.jna.*;
import com.sun.jna.platform.win32.*;
import model.profiles.commands.saveEverything;
import com.sun.jna.win32.W32APIOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/** Singleton class which interfaces with Windows OS. */
public class OSInterface implements HotkeyDetector, HotkeyRegistration, InputEmulator, OSSettingsWriter,
        Runnable {
    private static OSInterface instance = null;

    private User32 user32 = User32.INSTANCE;
    Runtime runtime;
    private WinDef.HWND hwnd;
    private HashMap<Integer, Hotkey> registeredKeys;
    private HashMap<Integer, Integer> pressedKeys;
    private WinUser.MSG msg;
    /** Signal for the OSInterface to stop it's thread runnable. **/
    private boolean stop = false;

    /** Stack for hotkeys to be registered. */
    private BlockingQueue<Hotkey> hotkeyRegQueue;
    private BlockingQueue<Integer> hotkeyUnRegQueue;
    /** Stack for keys to be emulated. */
    private BlockingQueue<WinUser.INPUT[]> keySendQueue;

    private OSInterface() {
        registeredKeys = new HashMap<>();
        pressedKeys = new HashMap<>();
        msg = new WinUser.MSG();
        runtime = Runtime.getRuntime();
        hotkeyRegQueue = new LinkedBlockingQueue<>();
        hotkeyUnRegQueue = new LinkedBlockingQueue<>();
        keySendQueue = new LinkedBlockingQueue<>();
    }

    /**
     * Gets the OSInterface instance.
     */
    public static OSInterface getInstance() {
        if (instance == null)
            instance = new OSInterface();

        return instance;
    }

    protected interface User32Extended extends User32 {
        User32Extended INSTANCE = (User32Extended)
                Native.load("user32", User32Extended.class, W32APIOptions.DEFAULT_OPTIONS);

        int SPI_GETMOUSESPEED = 0x0070;
        int SPI_SETMOUSESPEED = 0x0071;

        boolean SystemParametersInfo(
                int uiAction,
                int uiParam,
                Pointer pvParam,
                int fWinIni
        );

        boolean SystemParametersInfo(
                int uiAction,
                int uiParam,
                int pvParam,
                int fWinIni
        );
    }

    /**
     * Stops the OSInterface runnable.
     * Only should be called when the program is shutting down.
     */
    public void stop() throws IOException {
        this.stop = true;
        saveEverything end = new saveEverything();
        end.saveToFile();
    }

    /**
     * Main thread for checking messages and processing requests.
     */
    public void run() {
        boolean isMsg = user32.PeekMessage(msg, null, 0, 0, 1);
        while (msg.message != User32.WM_QUIT && !stop) {
            if (isMsg) {
                if (msg.message == User32.WM_HOTKEY) {
                    int keyPressed = msg.wParam.intValue();
                    if (registeredKeys.containsKey(keyPressed)) {
                        int keys = pressedKeys.get(keyPressed);
                        pressedKeys.put(keyPressed, keys + 1);
                    }
                }
            }

            Queue<Hotkey> toReg = new LinkedList<>();
            Queue<Integer> toUnReg = new LinkedList<>();
            Queue<WinUser.INPUT[]> toSendKeys = new LinkedList<>();
            hotkeyRegQueue.drainTo(toReg);
            hotkeyUnRegQueue.drainTo(toUnReg);
            keySendQueue.drainTo(toSendKeys);

            // Send all keys in the queue.
            while (!toSendKeys.isEmpty()) {
                WinUser.INPUT[] inputs = toSendKeys.remove();

                WinDef.DWORD length = new WinDef.DWORD(inputs.length);
                int sizeBytes = inputs[0].size();

                WinDef.DWORD sent = user32.SendInput(length, inputs, sizeBytes);

                if (sent.intValue() == 0) {
                    System.err.println("Error sending input!");
                }
            }

            registerQueuedHotkeys(toReg);
            unregisterQueuedHotkeys(toUnReg);

            isMsg = user32.PeekMessage(msg, null, 0, 0, 1);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.err.println("Problem sleeping.");
            }
        }

        // Unregister all hotkeys after program termination.
        registeredKeys.forEach((k, v) -> {
            if (!unregisterHotkeyThread(k)) {
                System.err.println("Error unregistering hotkey!");
            }
        });
    }

    /**
     * Sets the HWND to use for interfacing with the OS.
     * @param hwnd The HWND of a window.
     */
    public void setHWND(WinDef.HWND hwnd) {
        if (this.hwnd == null)
            this.hwnd = hwnd;
    }

    @Override
    public boolean registerHotkey(Hotkey hotkey) {
        int key = hotkey.getKeyCode();
        if (registeredKeys.containsKey(hotkey.getID()) || key < 1 || key > 254)
            return false;

        hotkeyRegQueue.add(new Hotkey(key, hotkey.getID(), hotkey.getModifier()));
        return true;
    }

    /**
     * The logic for registerHotkey that will run on the thread.
     * @param hotkey The hotkey to be registered.
     * @return If the hotkey registration was successful.
     */
    protected boolean registerHotkeyThread(Hotkey hotkey) {
        if (registeredKeys.containsKey(hotkey.getID()))
            return false;

        boolean success = user32.RegisterHotKey(null, hotkey.getID(), hotkey.getModifier(), hotkey.getKeyCode());
        if (success) {
            registeredKeys.put(hotkey.getID(), hotkey);
            pressedKeys.put(hotkey.getID(), 0);
        }

        return success;
    }

    /**
     * Registers all the hotkeys currently waiting to be registered with the OS.
     */
    protected void registerQueuedHotkeys(Queue<Hotkey> hotkeys) {
        while (!hotkeys.isEmpty()) {
            Hotkey hotkey = hotkeys.remove();
            if (!registerHotkeyThread(hotkey))
                System.err.println("Error registering hotkey: " + hotkey.toString());
        }
    }

    /**
     * Registers all the hotkeys currently waiting to be registered with the OS.
     */
    protected void unregisterQueuedHotkeys(Queue<Integer> ids) {
        while (!ids.isEmpty()) {
            int id = ids.remove();
            if (!unregisterHotkeyThread(id))
                System.err.println("Error registering hotkey ID: " + id);
        }
    }

    @Override
    public boolean unregisterHotkey(int id) {
        if (!registeredKeys.containsKey(id))
            return false;

        hotkeyUnRegQueue.add(id);

        return true;
    }

    /**
     * The logic for unregisterHotkey that will run on the thread.
     * @param id The id of the hotkey to be unregistered.
     * @return If the hotkey unregistration was successful.
     */
    private boolean unregisterHotkeyThread(int id) {
        return user32.UnregisterHotKey(null, id);
    }

    @Override
    public boolean setMouseSpeed(int speed) {
        if (speed < 1 || speed > 20)
            return false;

        boolean result = User32Extended.INSTANCE.SystemParametersInfo(
                User32Extended.SPI_SETMOUSESPEED,
                0,
                speed,
                0
        );

        return result;
    }

    @Override
    public boolean wasPressed(int id) {
        if (!pressedKeys.containsKey(id))
            return false;

        int keysLeft = pressedKeys.get(id);
        boolean pressed = keysLeft > 0;
        // Decrement the pressedKeys value.
        if (keysLeft > 0)
            pressedKeys.put(id, keysLeft - 1);

        return pressed;
    }

    private String stringProcessNameID(WinDef.DWORD processID) {
        return "";
    }

    public boolean launchApplication(String path) {
        try {
            runtime.exec(path);
            return true;
        } catch (Exception e) {
            System.err.println("Error launching applications: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void sendKey(int keyCode, boolean release) {
        if (keyCode > 0 && keyCode < 255) {
            WinUser.INPUT[] inputs = (WinUser.INPUT[]) new WinUser.INPUT().toArray(2);

            // Mouse input
            if (keyCode < 7 && keyCode != 3) {
                int mouseDown = MouseButtons.getDown(keyCode);
                int mouseUp = MouseButtons.getUp(keyCode);
                int xButton = MouseButtons.getXButton(keyCode);

                // Mouse button input
                inputs[0].type = new WinUser.DWORD(WinUser.INPUT.INPUT_MOUSE);
                inputs[0].input.setType("mi");

                if (xButton != 0) {
                    inputs[0].input.mi.mouseData = new WinDef.DWORD(xButton);
                }

                if (release)
                    inputs[0].input.mi.dwFlags = new WinDef.DWORD(mouseUp);
                else
                    inputs[0].input.mi.dwFlags = new WinDef.DWORD(mouseDown | mouseUp);

                inputs[0].input.mi.dwExtraInfo = new BaseTSD.ULONG_PTR(0);

            }
            // Keyboard input
            else {
                if (!release) {
                    // Key down input
                    inputs[0].type = new WinUser.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
                    inputs[0].input.setType("ki");
                    inputs[0].input.ki.wVk = new WinDef.WORD(keyCode);
                    inputs[0].input.ki.dwFlags = new WinDef.DWORD(0);
                    inputs[0].input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
                }

                // Key up input
                inputs[1].type = new WinUser.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
                inputs[1].input.setType("ki");
                inputs[1].input.ki.wVk = new WinDef.WORD(keyCode);
                inputs[1].input.ki.dwFlags = new WinDef.DWORD(WinUser.KEYBDINPUT.KEYEVENTF_KEYUP);
                inputs[1].input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
            }

            keySendQueue.add(inputs);
        }
    }

    /**
     * Moves the mouse by the given pixels.
     * @param x The pixels to move in the x-axis.
     * @param y The pixels to move in the y-axis.
     */
    public void moveMouse(int x, int y) {
        WinUser.INPUT[] inputs = (WinUser.INPUT[]) new WinUser.INPUT().toArray(1);

        final int MOUSEEVENTF_MOVE = 0x0001;
        final int MOUSEEVENTF_ABSOLUTE = 0x8000;

        inputs[0].type = new WinUser.DWORD(WinUser.INPUT.INPUT_MOUSE);
        inputs[0].input.setType("mi");
        inputs[0].input.mi.dx = new WinDef.LONG(x);
        inputs[0].input.mi.dy = new WinDef.LONG(y);
        inputs[0].input.mi.dwFlags = new WinDef.DWORD(MOUSEEVENTF_MOVE);
        inputs[0].input.mi.dwExtraInfo = new BaseTSD.ULONG_PTR(0);

        keySendQueue.add(inputs);
    }
}
package model;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

import java.util.HashMap;
import java.util.Stack;

/** Singleton class which interfaces with Windows OS. */
public class OSInterface implements HotkeyDetector, HotkeyRegistration, InputEmulator, OSSettingsWriter,
        Runnable {
    private static OSInterface instance = null;

    private User32 user32 = User32.INSTANCE;
    private WinDef.HWND hwnd;
    private HashMap<Integer, Hotkey> registeredKeys;
    private HashMap<Integer, Boolean> pressedKeys;
    private WinUser.MSG msg;

    /** Stack for hotkeys to be registered. */
    private Stack<Hotkey> hotkeyRegStack;
    /** Stack for hotkey presses to be checked. */
    private Stack<Integer> wasPressedStack;

    private OSInterface() {
        registeredKeys = new HashMap<>();
        pressedKeys = new HashMap<>();
        msg = new WinUser.MSG();
        hotkeyRegStack = new Stack<>();
        wasPressedStack = new Stack<>();
    }

    /**
     * Gets the OSInterface instance.
     */
    public static OSInterface getInstance() {
        if (instance == null)
            instance = new OSInterface();

        return instance;
    }

    /**
     * Main thread for checking messages and processing requests.
     */
    public void run() {
        boolean isMsg = user32.PeekMessage(msg, null, 0, 0, 1);
        while (msg.message != User32.WM_QUIT) {
            if (isMsg) {
                if (msg.message == User32.WM_HOTKEY) {

                }
            }

            while (!hotkeyRegStack.isEmpty()) {
                if (!registerHotkeyThread(hotkeyRegStack.pop())) {
                    System.out.println("Error registering hotkey!");
                }
            }

            isMsg = user32.PeekMessage(msg, null, 0, 0, 1);
        }
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
        if (registeredKeys.containsKey(hotkey.getID()))
            return false;

        hotkeyRegStack.push(new Hotkey(hotkey.getKeyCode(), hotkey.getID(), hotkey.getModifier()));
        return true;
    }

    /**
     * The logic for registerHotkey that will run on the thread.
     * @param hotkey The hotkey to be registered.
     * @return If the hotkey registration was successful.
     */
    private boolean registerHotkeyThread(Hotkey hotkey) {
        if (registeredKeys.containsKey(hotkey.getID()))
            return false;

        boolean success = user32.RegisterHotKey(null, hotkey.getID(), hotkey.getModifier(), hotkey.getKeyCode());
        if (success)
            registeredKeys.put(hotkey.getID(), hotkey);

        return success;
    }

    @Override
    public boolean unregisterHotkey(int id) {
        if (!registeredKeys.containsKey(id))
            return true;

        boolean success = user32.UnregisterHotKey(hwnd.getPointer(), id);
        if (success)
            registeredKeys.remove(id);

        return success;
    }

    @Override
    public boolean setMouseSpeed(int speed) {
        return false;
    }

    @Override
    public boolean wasPressed(int id) {
        return false;
    }

    /**
     * The logic for wasPressed that will run on the thread.
     * @param id The hotkey id to be checked.
     * @return If the hotkey was pressed.
     */
    public boolean wasPressedThread(int id) {
        return false;
    }

    @Override
    public void sendKey(int keyCode, boolean release) {

    }
}
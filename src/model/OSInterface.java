package model;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import java.util.HashMap;

/** Singleton class which interfaces with windows. */
public class OSInterface implements HotkeyDetector, HotkeyRegistration, InputEmulator, OSSettingsWriter {
    private static OSInterface instance = null;

    private User32 user32 = User32.INSTANCE;
    private WinDef.HWND hwnd;
    private HashMap<Integer, Hotkey> registeredKeys;

    private OSInterface() {
        registeredKeys = new HashMap<>();
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
     * Sets the HWND to use for interfacing with the OS.
     * @param hwnd The HWND of a window.
     */
    public void setHWND(WinDef.HWND hwnd) {
        this.hwnd = hwnd;
    }

    @Override
    public boolean registerHotkey(Hotkey hotkey) {
        if (registeredKeys.containsKey(hotkey.getID()))
            return false;

        boolean success = user32.RegisterHotKey(hwnd, hotkey.getID(), hotkey.getModifier(), hotkey.getKeyCode());
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

    @Override
    public void sendKey(int keyCode, boolean release) {

    }
}
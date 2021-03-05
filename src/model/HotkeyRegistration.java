package model;

public interface HotkeyRegistration {
    /**
     * Registers a given hotkey.
     * @param hotkey The hotkey to be registered. Must contain a unique ID.
     * @return If the registration was successful.
     */
    boolean registerHotkey(Hotkey hotkey);

    /**
     * Unregisters a hotkey with the given id.
     * @param id The id of the hotkey to be unregistered.
     * @return If the unregistration was successful.
     */
    boolean unregisterHotkey(int id);
}

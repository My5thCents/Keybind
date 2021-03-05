package model;

public interface HotkeyDetector {
    /**
     * Detects if a hotkey with the given id was pressed.
     * @param id The id of the hotkey which is checked.
     * @return If the hotkey was pressed.
     */
    boolean wasPressed(int id);
}

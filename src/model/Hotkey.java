package model;

public class Hotkey {
    /**
     * Virtual keycode of the hotkey.
     */
    protected final int keyCode;

    /**
     * Unique ID of the hotkey.
     */
    protected final int id;

    /**
     * Modifier for the hotkey.
     */
    protected final int modifier;

    /**
     * Constructs an immutable hotkey.
     * @param keyCode The virtual keycode of the hotkey.
     * @param id The unique ID of the hotkey.
     * @param modifier The modifier of the hotkey.
     */
    public Hotkey(int keyCode, int id, int modifier) {
        this.keyCode = keyCode;
        this.id = id;
        this.modifier = modifier;
    }

    /**
     * Gets the Hotkeys virtual keyCode.
     */
    public int getKeyCode() {
        return keyCode;
    }

    /**
     * Gets the hotkey's unique ID.
     */
    public int getID() {
        return id;
    }

    /**
     * Get's the hotkey's modifier.
     */
    public int getModifier() {
        return modifier;
    }
}

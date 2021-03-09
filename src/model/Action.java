package model;

import java.awt.*;

public class Action extends Hotkey implements InputEmulator{
    /**
     * Robot which simulates user key presses
     */
    Robot robot;

    /**
     * Constructs an immutable hotkey.
     * @param keyCode  The virtual keycode of the hotkey.
     * @param id       The unique ID of the hotkey.
     * @param modifier The modifier of the hotkey.
     */
    public Action(int keyCode, int id, int modifier) throws AWTException {
        super(keyCode, id, modifier);
        this.robot = new Robot();

    }

    /**
     * Sends a given key to be emulated.
     * @param keyCode The virtual keycode of the key.
     * @param release True if the key is to be a key release input.
     */
    @Override
    public void sendKey(int keyCode, boolean release) {
        if (release) {
            robot.keyPress(this.getKeyCode());
            robot.keyRelease(this.getKeyCode());
        }
    }
}

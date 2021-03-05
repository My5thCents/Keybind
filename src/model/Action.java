package model;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Action extends Hotkey{
    /**
     * Robot which simulates user key presses
     */
    Robot robot;

    /**
     * Constructs an immutable hotkey.
     *
     * @param keyCode  The virtual keycode of the hotkey.
     * @param id       The unique ID of the hotkey.
     * @param modifier The modifier of the hotkey.
     */
    public Action(int keyCode, int id, Modifier modifier) throws AWTException {
        super(keyCode, id, modifier);
        this.robot = new Robot();

    }

    /**
     * Simulates the pressing of the buttons specified by modifier and keycode
     */
    public void press(){
        robot.keyPress(this.getModifier().val());
        robot.keyPress(this.getKeyCode());
        robot.keyRelease(this.getModifier().val());
        robot.keyRelease(this.getKeyCode());
    }

}

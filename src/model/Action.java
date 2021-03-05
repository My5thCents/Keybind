package model;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Action implements InputEmulator{

    /**
     * Robot to simulate button presses
     */
    Robot robot;

    /**
     * Constructor to create a new robot to control key presses
     * @throws AWTException
     */
    public Action() throws AWTException {
        this.robot = new Robot();
    }

    /**
     * Sends a given key to be emulated.
     * @param keyCode The virtual keycode of the key.
     * @param release True if the key is to be a key release input.
     */
    @Override
    public void sendKey(int keyCode, boolean release) {
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }
}

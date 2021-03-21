package model;
import java.awt.*;

/**
 * To use:
 *     This is to be used when the user presses a certain key and wants to move their cursor.
 *     Here they ALREADY have the key bound this is just used whenever that key is pressed
 *     (This should be determined by the OS). Once it's pressed you create a new object and
 *     use its given functions accordingly.
 */
public class mouseEmulator {
    private int currentXCoord;
    private int currentYCoord;

    /**
     * When creating a new mouse Emulator we get the current position of
     * where the mouse is
     */
    public mouseEmulator() {
        PointerInfo pointer = MouseInfo.getPointerInfo();
        Point p = pointer.getLocation();
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.currentXCoord = p.x;
        this.currentYCoord  = p.y;
    }

    /**
     * To move the mouse to the right by 5 and update the coordinates
     */
    public void moveRight(){
        try{
            Robot robot = new Robot();
            robot.mouseMove(this.currentXCoord+5,this.currentYCoord);
            this.currentXCoord = this.currentXCoord+5;
        }
        catch(AWTException ignored){}
    }
    /**
     * To move the mouse to the left by 5 and update the coordinates
     */
    public void moveLeft(){
        try{
            Robot robot = new Robot();
            robot.mouseMove(this.currentXCoord-5,this.currentYCoord);
            this.currentXCoord = this.currentXCoord-5;
        }
        catch(AWTException ignored){}
    }
    /**
     * To move the mouse up by 5 and update the coordinates
     */
    public void moveUp(){
        try{
            Robot robot = new Robot();
            robot.mouseMove(this.currentXCoord,this.currentYCoord+5);
            this.currentYCoord = this.currentYCoord+5;
        }
        catch(AWTException ignored){}
    }
    /**
     * To move the mouse down by 5 and update the coordinates
     */
    public void moveDown(){
        try{
            Robot robot = new Robot();
            robot.mouseMove(this.currentXCoord,this.currentYCoord-5);
            this.currentYCoord = this.currentYCoord-5;
        }
        catch(AWTException ignored){}
    }
}

package model;

public interface OSSettingsWriter {
    /**
     * Sets the mouse pointer speed to a given new speed.
     * @param speed The new speed of the mouse pointer from 1 to 20
     * @return If setting the new mouse speed was successful.
     */
    boolean setMouseSpeed(int speed);
}

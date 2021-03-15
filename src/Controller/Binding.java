package Controller;

import model.Hotkey;

public class Binding {
    /**
     * Hotkey to be bound to an action
     */
    Hotkey hk1;

    /**
     * Action preformed when hotkey is pressed
     */
    Hotkey hk2;


    /**
     * Constructor to bind the hotkey and the action together
     *
     * @param hotkey1 hotkey which is submitted
     * @param hotkey2 the action to be preformed when the hotkey is pressed
     */
    public Binding(Hotkey hotkey1, Hotkey hotkey2) {
        this.hk1 = hotkey1;
        this.hk2 = hotkey2;
    }

    /**
     * return the ID of the hotkey/action binding
     * @return ID
     */
    public int getID() {
        return this.hk1.getID();
    }

    /**
     * return the action code to be preformed when the action is pressed
     * @return action keyCode
     */
    public int getActionCode() {
        return this.hk2.getKeyCode();
    }
}
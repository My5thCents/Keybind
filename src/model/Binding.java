package model;

public class Binding {
    /**
     * Hotkey to be bound to an action
     */
    Hotkey hotkey;

    /**
     * Action preformed when hotkey is pressed
     */
    Action action;

    /**
     * The id of the hotkey and action pairing
     */
    int id;

    /**
     * Constructor to bind the hotkey and the action together
     * @param hotkey hotkey which is submitted
     * @param action the action to be preformed when the hotkey is pressed
     */
    public Binding(Hotkey hotkey, Action action){
        this.hotkey = hotkey;
        this.action = action;
        this.id = hotkey.getID();
    }
}

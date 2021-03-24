package model;

public class mouseEmulator extends Hotkey implements InputEmulator{
    //Directions can be: L(left),R(right),U(up),D(down)
    private final String direction;
    /**
     * Constructs an immutable hotkey.
     *  @param keyCode  The virtual keycode of the hotkey.
     * @param id       The unique ID of the hotkey.
     * @param modifier The modifier of the hotkey.
     * @param d the direction in which the mouse should move
     */
    public mouseEmulator(int keyCode, int id, int modifier, String d) {
        super(keyCode, id, modifier);
        this.direction = d;
    }

    @Override
    public void sendKey(int keyCode, boolean release) {
        if(direction.equals("L")){
            OSInterface.getInstance().moveMouse(5,0);
        }
        else if(direction.equals("R")){
            OSInterface.getInstance().moveMouse(-5,0);
        }
        else if(direction.equals("U")){
            OSInterface.getInstance().moveMouse(0,5);
        }
        else if(direction.equals("D")){
            OSInterface.getInstance().moveMouse(0,-5);
        }
    }
}

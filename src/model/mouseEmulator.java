package model;

public class mouseEmulator extends Hotkey implements InputEmulator{
    //Directions can be: L(left),R(right),U(up),D(down)
    private final String direction;
    /**
     * Constructs an immutable hotkey.
     *  @param keyCode  The virtual keycode of the hotkey.
     * @param id       The unique ID of the hotkey.
     * @param modifier The modifier of the hotkey. (Should be null for this)
     * @param d the direction in which the mouse should move
     */
    public mouseEmulator(int keyCode, int id, int modifier, String d) {
        super(keyCode, id, modifier);
        this.direction = d;
    }

    public String move(){
        if(direction.equals("L")){
            OSInterface.getInstance().moveMouse(5,0);
            return "Moved left\n";
        }
        else if(direction.equals("R")){
            OSInterface.getInstance().moveMouse(-5,0);
            return "Moved right\n";
        }
        else if(direction.equals("U")){
            OSInterface.getInstance().moveMouse(0,5);
            return "Moved up\n";
        }
        else if(direction.equals("D")){
            OSInterface.getInstance().moveMouse(0,-5);
            return "Moved down\n";
        }
        return "Not moved\n";
    }

    @Override
    public void sendKey(int keyCode, boolean release) {
    }

    public static void main(String[] args){
        mouseEmulator test = new mouseEmulator(0,1,0,"L");
        mouseEmulator test2 = new mouseEmulator(2,2,0,"R");
        mouseEmulator test3 = new mouseEmulator(5,3,0,"U");
        mouseEmulator test4 = new mouseEmulator(4,4,0,"D");
        mouseEmulator test5 = new mouseEmulator(5,5,0,"E");
        System.out.println(test.direction);
        System.out.println(test2.direction);
        System.out.println(test3.direction);
        System.out.println(test4.direction);
        System.out.print(test.move());
        System.out.print(test2.move());
        System.out.print(test3.move());
        System.out.print(test4.move());
        System.out.println(test5.move());
    }
}

package model;

public class mouseEmulator{
    //Directions can be: L(left),R(right),U(up),D(down)
    private final String direction;
    /**
     * Constructs an mouseEmulator for a hotkey.
     * @param d the direction in which the mouse should move
     */
    public mouseEmulator(String d) {
        direction = d;
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
    public static void main(String[] args){
        mouseEmulator test = new mouseEmulator("L");
        mouseEmulator test2 = new mouseEmulator("R");
        mouseEmulator test3 = new mouseEmulator("U");
        mouseEmulator test4 = new mouseEmulator("D");
        mouseEmulator test5 = new mouseEmulator("E");
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

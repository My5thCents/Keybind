//package Controller;
//
//import model.OSInterface;
//
//public class mouseAction {
//    //L = left
//    //R = right
//    //D = down
//    //U = up
//    public String direction;
//    public mouseAction(String dir){
//        this.direction = dir;
//    }
//
//    /**
//     * Get the direction of the mouseAction
//     */
//    public String getDirection(){
//        return this.direction;
//    }
//
//    /**
//     * Move the mouse accordingly based on its direction
//     */
//    public void preformAction(){
//        //If its R move 5 pixels to the right
//        if(this.direction.equals("R")){
//            OSInterface.getInstance().moveMouse(5,0);
//        }
//        //If it L move 5 pixels to the left
//        else if(this.direction.equals("L")){
//            OSInterface.getInstance().moveMouse(-5,0);
//        }
//        //If it is U move 5 pixels up
//        else if(this.direction.equals("U")){
//            OSInterface.getInstance().moveMouse(0,5);
//        }
//        //If it is D move 5 pixels down
//        else if(this.direction.equals("D")){
//            OSInterface.getInstance().moveMouse(0,-5);
//        }
//    }
//}

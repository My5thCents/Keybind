package Controller;

import model.LaunchApplication;
import model.OSInterface;
import model.ProgramLaunchConverter;

import java.util.ArrayList;

public class Action {

    ArrayList<Integer> keyCodes;

    public Action(ArrayList<Integer> keys){
        this.keyCodes = keys;
    }

    /**
     * return all the keys in the action
     * @return keys in the action
     */
    public ArrayList<Integer> getKeys(){
        return this.keyCodes;
    }


    /**
     * calls all the keycodes in the list
     */
    public void preformAction(){

        if(keyCodes.get(0) == 10000){
            ArrayList<Integer> new_keyCodes = ProgramLaunchConverter.RemoveIdentification(keyCodes);
            String path = ProgramLaunchConverter.IntToString(new_keyCodes);
            LaunchApplication.runApplication(path);
        }
        else {
            //for each keycode in the list, preform it
            for (Integer keyCode : this.getKeys()) {
                if (keyCode >= 1000) {
                    mouseAction mouse;
                    switch (keyCode) {
                        case 1000:
                            mouse = new mouseAction("L");
                            mouse.preformAction();
                            break;
                        case 1001:
                            mouse = new mouseAction("R");
                            mouse.preformAction();
                            break;
                        case 1002:
                            mouse = new mouseAction("U");
                            mouse.preformAction();
                            break;
                        case 1003:
                            mouse = new mouseAction("D");
                            mouse.preformAction();
                            break;
                    }
                } else
                    OSInterface.getInstance().sendKey(keyCode, false);
            }
        }
    }
}
package Controller;

import model.OSInterface;

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
        //for each keycode in the list, preform it
        for(Integer keyCode:this.getKeys()){
            OSInterface.getInstance().sendKey(keyCode, true);
        }
    }
}
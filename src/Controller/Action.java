package Controller;

import model.Hotkey;
import model.OSInterface;

import java.util.ArrayList;

public class Action {
    /**
     * a list of keycodes which need to be sent
     */
    ArrayList<Integer> keyCodes;

    /**
     * a constructor to create a new Action list
     * @param keys a list of keyCodes
     */
    public Action(ArrayList<Integer> keys){
        this.keyCodes = keys;
    }

    /**
     * calls all the keycodes in the list
     */
    public void preformAction(){
        for(Integer i:keyCodes){
            OSInterface.getInstance().sendKey(i, true);
        }
    }
}
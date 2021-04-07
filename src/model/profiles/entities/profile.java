package model.profiles.entities;
import Controller.Action;
import model.Hotkey;

import java.util.Hashtable;
import java.util.LinkedHashMap;

public class profile {
    public String name;
    public LinkedHashMap<Integer, Action> HKeys;
    /**
     * Initializes an instance of a profile with no hotkeys
     * @param name the name of our profile
     */
    public profile(String name) {
        this.name = name;
        //Organized by their ID
        HKeys = new LinkedHashMap<>();
    }
    /**
     * Get the name of the entities.profile
     * @return the name of the entities.profile
     */
    public String getName() {

        return this.name;
    }
    /**
     * Get a hotkey using its ID
     * @param keyCode the unique ID for the hotkey in our profile
     * @return the hot key with the given id
     */
    public Action getHotKey(int keyCode){
        if(!HKeys.containsKey(keyCode)){
            return null;
        }
        return HKeys.get(keyCode);
    }

    /**
     * Check if a hotkey exists in our profilr
     * @param keyCode id of the hotkey to check for
     * @return true if it's in our profile false if not
     */
    public boolean hasHotkey(int keyCode){
        return HKeys.containsKey(keyCode);
    }
    /**
     * Adds a hotkey to our Treemap
     * @param a hotkey to add
     */
    public void addHotkey(int keyCode, Action a){
        HKeys.put(keyCode, a);
    }

    /**
     * Remove a hotkey from our TreeMap
     * @param keyCode the id of the hotkey to remove
     */
    public void removeHotKey(int keyCode){
        HKeys.remove(keyCode);
    }
}

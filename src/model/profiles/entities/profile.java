package model.profiles.entities;

import model.profiles.commands.*;
import model.Hotkey;

import java.util.TreeMap;

public class profile {
    public String name;
    private static TreeMap<Integer,Hotkey> HKeys;
    /**
     * Initializes an instance of a profile with no hotkeys
     * @param name the name of our profile
     */
    public profile(String name) {
        this.name = name;
        //Organized by their ID
        HKeys = new TreeMap<Integer, Hotkey>();
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
     * @param id the unique ID for the hotkey in our profile
     * @return
     */
    public Hotkey getHotKey(int id){
        if(!HKeys.containsKey(id)){
            return null;
        }
        return HKeys.get(id);
    }

    /**
     * Check if a hotkey exists in our profilr
     * @param id id of the hotkey to check for
     * @return true if it's in our profile false if not
     */
    public boolean hasHotkey(int id){
        return HKeys.containsKey(id);
    }
    /**
     * Adds a hotkey to our Treemap
     * @param h hotkey to add
     */
    public void addHotkey(Hotkey h){
        HKeys.put(h.getID(),h);
    }

    /**
     * Remove a hotkey from our TreeMap
     * @param id the id of the hotkey to remove
     */
    public void removeHotKey(int id){
        HKeys.remove(id);
    }
}

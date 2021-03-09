package model.profiles.database;

import java.util.TreeMap;
import model.profiles.entities.profile;

/**
 * This is used to store all of our profiles
 * We will be storing them in a TreeMap so removing and adding will be easier
 */
public class profileDatabase {
    private profileDatabase(){};

    //Active profile
    private static profile active;
    //Database of all our profiles
    private static TreeMap<String,profile> database;

    public static TreeMap<String, profile> database() {
        //Create our initial database if it doesn't exist
        if (database == null) {
            database = new TreeMap<String, profile>();
            //Default profile with default windows settings
            profile p = new profile("Default");
            database.put("Default",p);
        }
        return database;
    }
    /**
     * Set active profile to be p
     * @param p profile to be set as active
     */
    public static void setActive(profile p){
        active = p;
    }

    /**
     * Get the active profile
     * @return active profile
     */
    public static profile getActive(){
        return active;
    }
}
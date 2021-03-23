package model.profiles.commands;

import model.profiles.database.profileDatabase;
import model.profiles.entities.profile;


/**
 * Used to add a profile to our database if the name given isn't already in our database
 * This ONLY makes a profile with a name
 * To add a Hotkey to our new profile use "addHotKey" command
 */
public class addProfile extends CommandStatus{
    /**
     * Makes a new profile in our database
     * @param name The name we will use for the profile
     */
    public void AddProfile(String name){
        if(profileDatabase.database().containsKey(name)){
            successful = false;
            errorMessage = "Profile with name "+ name +" already exists";
        }
        else{
            //create a new profile containing the given name
            profile add = new profile(name);
            //add the newly made profile to our database
            profileDatabase.database().put(name,add);
            successful = true;
        }
    }
}

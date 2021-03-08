package model.profiles.commands;

import model.profiles.database.profileDatabase;
import model.profiles.entities.profile;

/**
 * Set the active profile to the given one with name = "name"
 */
public class setActive extends CommandStatus{
    public void SetActive(String name){
        if(!profileDatabase.database().containsKey(name)){
            successful = false;
            errorMessage = "Profile with name "+ name +" does not exist";
        }
        profile makeActive = profileDatabase.database().get(name);
        profileDatabase.setActive(makeActive);
        successful = true;
    }
}

package model.profiles.commands;

import model.profiles.database.profileDatabase;
import model.profiles.entities.profile;
/**
 * Used to check what active profile we are using if any
 */
public class checkActive extends CommandStatus{
    public profile CheckActive(){
        profile p = new profile("No Active Profile");
        if(profileDatabase.getActive() == null){
            successful = false;
            errorMessage = "No active profile";
            //Return an error profile
            return p;
        }
        successful = true;
        return profileDatabase.getActive();
    }
}
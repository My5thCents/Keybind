package model.profiles.commands;

import model.profiles.database.profileDatabase;
/**
 * Remove an existing profile and use our error handling command CommandStatus
 */
public class deleteProfile extends CommandStatus {
    public void DeleteProfile(String name){
        if(!profileDatabase.database().containsKey(name)){
            successful = false;
            errorMessage = "Profile with name "+ name +" does not exist";
        }
        else{
            //remove the profile from our database
            profileDatabase.database().remove(name);
            successful = true;
        }
    }

}

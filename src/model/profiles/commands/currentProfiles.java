package model.profiles.commands;

import java.util.Collection;
import model.profiles.entities.profile;
import model.profiles.database.profileDatabase;

/**
 * Get all the current profiles in the form of a String
 */
public class currentProfiles extends CommandStatus{
    /**
     * Get the names of all the profiles in our database
     * @return All the profiles in a String separated by \n characters
     */
    public String findAllProfiles(){
        String allProfiles = "";
        Collection<profile> profiles = profileDatabase.database().values();
        for(profile p : profiles){
            if( p == profileDatabase.getActive()){
                allProfiles = allProfiles + "ACTIVE: ";
                allProfiles = allProfiles + p.name + "\n";
            }
            else if(!p.getName().equals("") && !p.getName().equals("\n")){
                allProfiles = allProfiles + p.name + "\n";
            }
        }
        successful = true;
        return allProfiles;
    }
}

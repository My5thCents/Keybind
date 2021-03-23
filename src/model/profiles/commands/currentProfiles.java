package model.profiles.commands;

import java.util.ArrayList;
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
    public ArrayList<String> findAllProfiles(){
        ArrayList<String> allProfiles = new ArrayList<>();
        Collection<profile> profiles = profileDatabase.database().values();
        for(profile p : profiles){
            allProfiles.add(p.name);
        }
        successful = true;
        return allProfiles;
    }
}

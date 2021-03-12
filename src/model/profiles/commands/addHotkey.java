package model.profiles.commands;

import model.Hotkey;
import model.Modifier;
import model.profiles.database.profileDatabase;
import model.profiles.entities.profile;

/**
 * Add a hot key to an existing profile
 */
public class addHotkey extends CommandStatus {
    /**
     * Adds a hotkey to the given profile
     * @param name Name of the profile to add a hotkey to
     * @param id The id of the hotkey we are creating
     * @param mod The modifier of the hotkey we are creating
     * @param key The key of the hotkey we are making
     */
    public void AddHotkey(String name, int id, Modifier mod, int key){
        Hotkey add = new Hotkey(key,id,mod);
        if(!profileDatabase.database().containsKey(name)){
            successful = false;
            errorMessage = "Profile with name " + name + " does not exist";
        }
        else{
            profile p = profileDatabase.database().get(name);
            p.addHotkey(add);
        }
    }
}

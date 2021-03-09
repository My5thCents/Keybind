package model.profiles.commands;

import model.Hotkey;
import model.Modifier;
import model.profiles.database.profileDatabase;
import model.profiles.entities.profile;

/**
 * Add a hot key to an existing profile
 */
public class addHotkey extends CommandStatus {
    public void AddHotkey(String name, int id, Modifier mod, int key){
        Hotkey add = new Hotkey(key,id,mod);
        if(!profileDatabase.database().containsKey(name)){
            successful = false;
            errorMessage = "Profile with name does not exist";
        }
        else{
            profile p = profileDatabase.database().get(name);
            p.addHotkey(add);
        }
    }
}

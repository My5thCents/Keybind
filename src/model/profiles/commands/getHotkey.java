package model.profiles.commands;
import Controller.Action;
import model.Hotkey;
import model.profiles.database.profileDatabase;
import model.profiles.entities.profile;
public class getHotkey extends CommandStatus{
    /**
     * Gets a hotkey from a profile database
     * @param name name of the profile the hotkey should be in
     * @param keyCode the id of the hotkey we are looking for
     * @return
     */
    public Action GetHotkey(String name, int keyCode){
        if(!profileDatabase.database().containsKey(name)){
            successful = false;
            errorMessage = "Profile does not exist";
        }
        profile p = profileDatabase.database().get(name);
        if(!p.hasHotkey(keyCode)){
            successful = false;
            errorMessage = "Hotkey does not exist in this profile";
        }
        else{
            successful = true;
        }
        return p.getHotKey(keyCode);
    }
}

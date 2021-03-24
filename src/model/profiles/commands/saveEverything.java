package model.profiles.commands;
import com.google.gson.*;
import model.Hotkey;
import model.profiles.database.profileDatabase;
import model.profiles.entities.profile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class saveEverything {
    /**
     * Initialize to use the following methods
     */
    public saveEverything(){}

    /**
     * Converts our database into a JSON object and then stores it into a file
     * This is to be called before the program is terminated
     */
    public void saveToFile() throws IOException {
        //Stores all the profiles as each being an object
        JsonArray arrayOfProfiles = new JsonArray();
        for(Map.Entry<String, profile> profile: profileDatabase.database().entrySet()){
            JsonObject pro = new JsonObject();
            pro.addProperty("Name",profile.getKey());
            //Used to store all the hotkeys in the next loop
            JsonArray hotKeyArray = new JsonArray();
            for(Map.Entry<Integer, Hotkey> key: profile.getValue().HKeys.entrySet()){
                //One Json object that contains the hotkey information
                JsonObject hk = new JsonObject();
                hk.addProperty("ID",key.getValue().getID());
                hk.addProperty("keyCode",key.getValue().getKeyCode());
                hk.addProperty("Modifier",key.getValue().getModifier());
                hotKeyArray.add(hk);
            }
            //Add the hotkeys to our profile
            pro.add("HotKeys",hotKeyArray);
            //Add the profile to our arrayOfProfiles
            arrayOfProfiles.add(pro);
        }
        FileWriter file = new FileWriter("/Users/Shared/profiles.txt");
        file.write(String.valueOf(arrayOfProfiles));
    }
    /**
     * Get everything from a file and store it into our profileDatabase
     */
    public void getFromFile() throws IOException {

    }
}

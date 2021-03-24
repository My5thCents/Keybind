package model.profiles.commands;
import com.google.gson.*;
import model.Hotkey;
import model.profiles.database.profileDatabase;
import model.profiles.entities.profile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

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
                hk.addProperty("KeyCode",key.getValue().getKeyCode());
                hk.addProperty("Modifier",key.getValue().getModifier());
                hotKeyArray.add(hk);
            }
            //Add the hotkeys to our profile
            pro.add("HotKeys",hotKeyArray);
            //Add the profile to our arrayOfProfiles
            arrayOfProfiles.add(pro);
        }
        FileWriter file = new FileWriter("profiles.txt");
        file.write(String.valueOf(arrayOfProfiles));
        file.close();
    }
    /**
     * Get everything from a file and store it into our profileDatabase
     * To be run upon opening the program
     */
    public void getFromFile() throws IOException {
        JsonParser parser = new JsonParser();
        JsonArray file = (JsonArray) parser.parse(new FileReader("profiles.txt"));
        Iterator<JsonElement> eachProfile = file.iterator();
        while(eachProfile.hasNext()){
            //Get the profile from the JSON file
            JsonObject profile = (JsonObject) eachProfile.next();
            String profileName = profile.get("Name").toString();

            //Add the profile to the database
            profile addToDatabase = new profile(profileName);
            profileDatabase.database().put(profileName,addToDatabase);

            //Get the array of all the hotkeys in this profile
            JsonArray profileHotkeys = (JsonArray) profile.get("HotKeys");
            Iterator<JsonElement> eachHotkey = profileHotkeys.iterator();
            //Go through each hotkey in the profile and add it to the database
            //To the correct profile
            while(eachHotkey.hasNext()){
                //Get the hotkey values
                JsonObject theHotKeyValues = (JsonObject) eachHotkey.next();

                //Create a new addHotkey value
                addHotkey addHK = new addHotkey();
                //Get all our values from the JSON object
                int ID = theHotKeyValues.get("ID").getAsInt();
                int KeyCode = theHotKeyValues.get("KeyCode").getAsInt();
                int Mod = theHotKeyValues.get("Modifier").getAsInt();
                Hotkey addHotKeyToProfile = new Hotkey(KeyCode,ID,Mod);
                addHK.AddHotkey(profileName,addHotKeyToProfile);

            }
        }
    }

    public static void main(String[] args) throws IOException {

        saveEverything save = new saveEverything();
        save.saveToFile();
        save.getFromFile();
    }

}

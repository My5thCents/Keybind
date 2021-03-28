package model.profiles.commands;
import Controller.Action;
import com.google.gson.*;
import model.Hotkey;
import model.profiles.database.profileDatabase;
import model.profiles.entities.profile;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Used to save all the profiles upon closing and opening them back up once the program is reopened
 * Everything will be stored in a local file called profiles.txt
 */
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
            for(Map.Entry<Integer, Action> key: profile.getValue().HKeys.entrySet()){
                //One Json object that contains the hotkey information
                JsonObject hk = new JsonObject();
                hk.addProperty("KeyCode", key.getKey());
                Gson gson = new GsonBuilder().create();
                JsonArray newArray = gson.toJsonTree(key.getValue().getKeys()).getAsJsonArray();
                hk.add("Actions",newArray);
                hotKeyArray.add(hk);
            }
            //Add the hotkeys to our profile
            pro.add("HotKeys",hotKeyArray);
            //Add the profile to our arrayOfProfiles
            arrayOfProfiles.add(pro);
        }
        Writer file = new FileWriter("profiles.txt",false);
        file.write(String.valueOf(arrayOfProfiles));
        file.close();
    }
    /**
     * Get everything from a file and store it into our profileDatabase
     * To be run upon opening the program
     */
    public void getFromFile() throws IOException {
        try {
            JsonParser parser = new JsonParser();
            JsonArray file = (JsonArray) parser.parse(new FileReader("profiles.txt"));
            for (JsonElement jsonElement : file) {
                //Get the profile from the JSON file
                JsonObject profile = (JsonObject) jsonElement;
                String profileName = profile.get("Name").toString().substring(1, profile.get("Name").toString().length()-1);
                //Add the profile to the database
                profile addToDatabase = new profile(profileName);
                profileDatabase.database().put(profileName, addToDatabase);
                //Get the array of all the hotkeys in this profile
                JsonArray profileHotkeys = (JsonArray) profile.get("HotKeys");
                //Go through each hotkey in the profile and add it to the database
                //To the correct profile
                for (JsonElement profileHotkey : profileHotkeys) {

                    //Get the hotkey values
                    JsonObject theHotKeyValues = (JsonObject) profileHotkey;
                    //Create a new addHotkey value
                    addHotkey addHK = new addHotkey();
                    //Get all our values from the JSON object
                    int KeyCode = theHotKeyValues.get("KeyCode").getAsInt();
                    JsonArray hotkeys = theHotKeyValues.get("Actions").getAsJsonArray();
                    ArrayList<Integer> actions = new ArrayList<>();
                    if (hotkeys != null){
                        for (int i = 0; i<hotkeys.size(); i++){
                            actions.add(hotkeys.get(i).getAsInt());
                        }
                    }
                    Action addHotKeyToProfile = new Action(actions);
                    addHK.AddHotkey(profileName, KeyCode, addHotKeyToProfile);

                }
            }
        }
        catch(Exception ignored){ }
    }
}

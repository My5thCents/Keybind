package model.profiles.entities;
import model.profiles.commands.*;
import model.Hotkey;

import java.util.TreeMap;

public class profile {
    public String name;
    private static TreeMap<Integer,Hotkey> HKeys;
    /**
     * Initializes an instance of a profile with no hotkeys
     * @param name the name of our profile
     */
    public profile(String name) {
        this.name = name;
        //Organized by their ID
        HKeys = new TreeMap<Integer, Hotkey>();
    }
    /**
     * Get the name of the entities.profile
     * @return the name of the entities.profile
     */
    public String getName() {

        return this.name;
    }
    /**
     * Get a hotkey using its ID
     * @param id the unique ID for the hotkey in our profile
     * @return the hot key with the given id
     */
    public Hotkey getHotKey(int id){
        if(!HKeys.containsKey(id)){
            return null;
        }
        return HKeys.get(id);
    }

    /**
     * Check if a hotkey exists in our profilr
     * @param id id of the hotkey to check for
     * @return true if it's in our profile false if not
     */
    public boolean hasHotkey(int id){
        return HKeys.containsKey(id);
    }
    /**
     * Adds a hotkey to our Treemap
     * @param h hotkey to add
     */
    public void addHotkey(Hotkey h){
        HKeys.put(h.getID(),h);
    }

    /**
     * Remove a hotkey from our TreeMap
     * @param id the id of the hotkey to remove
     */
    public void removeHotKey(int id){
        HKeys.remove(id);
    }
    public static void main(String[] args) {
        System.out.println("**********TESTING*************");
        //Testing for profile class and getName()
        String name1 = "Eva";
        String name2 = "";
        String name3 = "123456";
        String name4 = "\n";
        String name5 = "Devin";
        String name6 = "Buffie";
        String name7 = "Terry";
        String name8 = "Barb";
        String name9 = "Debby";
        profile one = new profile(name1);
        profile two = new profile(name2);
        profile three = new profile(name3);
        profile four = new profile(name4);

        System.out.println("**********Make profiles*************");
        System.out.println(one.getName());
        //System.out.println(two.getName()); //Prints out and empty string
        System.out.println(three.getName());
        //System.out.println(four.getName());  //Prints out a newline character

        //Testing for addProfile() and deleteProfile()
        addProfile add = new addProfile();
        add.AddProfile(name1);
        add.AddProfile(name3);
        add.AddProfile(name4);
        add.AddProfile(name5);
        add.AddProfile(name6);
        add.AddProfile(name7);
        add.AddProfile(name8);
        add.AddProfile(name9);

        //Set and check active account
        System.out.println("**********Set Active*************");
        setActive set = new setActive();
        set.SetActive(name1);
        checkActive check = new checkActive();
        System.out.println("Should print out Eva:");
        System.out.println(check.CheckActive().getName());
        System.out.println("Should print out 123456:");
        set.SetActive(name3);
        System.out.println(check.CheckActive().getName());
        //Change for case where name isn't in our profile database
        System.out.println("Change active profile to one that doesn't exist (Should be No Active Profile)");
        set.SetActive("Gwen");
        System.out.println(check.CheckActive().getName());
        //Set active for remainder of check profiles
        set.SetActive(name6);


        //Print the names of all the profiles
        System.out.println("**********Print all profiles*************");
        currentProfiles p = new currentProfiles();
        String all =  p.findAllProfiles();
        System.out.println(all);

        //Delete a profile and print the results again
        System.out.println("**********Delete a profile and print results*************");
        System.out.println("Eva should be removed:");
        deleteProfile d = new deleteProfile();
        d.DeleteProfile(name1);
        String allDelete =  p.findAllProfiles();
        System.out.println(allDelete);
        d.DeleteProfile(name7);
        String tAndNullDelete =  p.findAllProfiles();
        System.out.println("Terry should be removed:");
        System.out.println(tAndNullDelete);
        d.DeleteProfile(name7);
        String NullDelete =  p.findAllProfiles();
        System.out.println("Nothing should be removed:");
        System.out.println(NullDelete);

        //Hotkey adding, getting and removing testing
        System.out.println("**********Add and remove Hotkeys*************");
        getHotkey g = new getHotkey();
        Hotkey h = g.GetHotkey(name3, 2);
        System.out.println(g.getErrorMessage()); //Should print out "Hotkey does not exist in this profile"
        removeHotkey r = new removeHotkey();
        r.RemoveHotkey("num",3);
        System.out.println(r.getErrorMessage()); //Should print out "No profile with name: num"
        r.RemoveHotkey(name8,12);
        System.out.println(r.getErrorMessage()); //Should print out "This profile does not have a hotkey with id: 12"
    }
}

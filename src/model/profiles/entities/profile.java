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
     * @return
     */
    public Hotkey getHotKey(int id){

        return HKeys.get(id);
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
        profile one = new profile(name1);
        profile two = new profile(name2);
        profile three = new profile(name3);
        profile four = new profile(name4);
        System.out.println("**********Make profiles*************");
        System.out.println(one.getName());
        //System.out.println(two.getName());
        System.out.println(three.getName());
        //System.out.println(four.getName());

        //Testing for addProfile() and deleteProfile()
        addProfile add = new addProfile();
        add.AddProfile(name1);
        add.AddProfile(name3);

        //Set and check active account
        System.out.println("**********Set Active*************");
        setActive set = new setActive();
        set.SetActive(name1);
        checkActive check = new checkActive();
        System.out.println(check.CheckActive().getName());

        set.SetActive(name3);
        System.out.println(check.CheckActive().getName());

        //Print the names of all the profiles
        System.out.println("**********Print all profiles*************");
        currentProfiles p = new currentProfiles();
        String all =  p.findAllProfiles();
        System.out.println(all);

        //Delete a profile and print the results again
        System.out.println("**********Delete a profile and print results*************");
        deleteProfile d = new deleteProfile();
        d.DeleteProfile(name1);
        currentProfiles prof = new currentProfiles();
        String allDelete =  p.findAllProfiles();
        System.out.println(allDelete);
        //Test to make sure it doesn't crash
        d.DeleteProfile(name2);
        d.DeleteProfile("Terry");

    }
}

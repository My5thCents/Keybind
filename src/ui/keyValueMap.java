package ui;

import java.util.Hashtable;

/**
 * keyValueMap initializes a Hashtable which maps the string value in the UI to a Windows Integer key code.
 */
public class keyValueMap {
    Hashtable<String, Integer> matchKey;

    public keyValueMap () {
        matchKey = new Hashtable<String, Integer>();
        //Add keys, codes
        matchKey.put("Q ", 81);
        matchKey.put("W ", 87);
        matchKey.put("E ", 69);
        matchKey.put("R ", 82);
        matchKey.put("T ", 84);
        matchKey.put("Y ", 89);
        matchKey.put("U ", 85);
        matchKey.put("I ", 73);
        matchKey.put("O ", 79);
        matchKey.put("P ", 80);
        matchKey.put("A ", 65);
        matchKey.put("S ", 83);
        matchKey.put("D ", 68);
        matchKey.put("F ", 70);
        matchKey.put("G ", 71);
        matchKey.put("H ", 72);
        matchKey.put("J ", 74);
        matchKey.put("K ", 75);
        matchKey.put("L ", 76);
        matchKey.put("Z ", 90);
        matchKey.put("X ", 88);
        matchKey.put("C ", 67);
        matchKey.put("V ", 86);
        matchKey.put("B ", 66);
        matchKey.put("N ", 78);
        matchKey.put("M ", 77);

    }

    /**
     * Returns the integer keycode for a given string parameter
     * @param keyPressed String parameter represetning a key
     * @return Keycode in matchKey for String parameter keyPressed
     */
    public Integer getKeyCode(String keyPressed) {
        return matchKey.get(keyPressed);
    }
}

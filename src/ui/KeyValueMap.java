package ui;

import java.util.Hashtable;

/**
 * keyValueMap initializes a Hashtable which maps the string value in the UI to a Windows Integer key code.
 */
class KeyValueMap {
    Hashtable<String, Integer> matchKey;

    public KeyValueMap() {
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
        matchKey.put("N ", 0x4E);
        matchKey.put(". Period", 0xBE);
        matchKey.put(", Comma", 0xBC);
        matchKey.put("/ Back slash", 0xBF);
        matchKey.put("Right shift", 0xA1);
        matchKey.put("[ Left square bracket", 0xDB);
        matchKey.put("] Right square bracket", 0xDD);
        matchKey.put("\\ Forward slash", 0xDC);
        matchKey.put("F1 ", 0x70);
        matchKey.put("F2 ", 0x71);
        matchKey.put("F3 ", 0x72);
        matchKey.put("F4 ", 0x73);
        matchKey.put("F5 ", 0x74);
        matchKey.put("F6 ", 0x75);
        matchKey.put("F7 ", 0x76);
        matchKey.put("F8 ", 0x77);
        matchKey.put("F9 ", 0x78);
        matchKey.put("F10 ", 0x79);
        matchKey.put("F11 ", 0x7A);
        matchKey.put("F12 ", 0x7B);
        matchKey.put("` Tilde", 0xC0);
        matchKey.put("1 ", 0x31);
        matchKey.put("2 ", 0x32);
        matchKey.put("3 ", 0x33);
        matchKey.put("4 ", 0x34);
        matchKey.put("5 ", 0x35);
        matchKey.put("6 ", 0x36);
        matchKey.put("7 ", 0x37);
        matchKey.put("8 ", 0x38);
        matchKey.put("9 ", 0x39);
        matchKey.put("0 ", 0x30);
        matchKey.put("- Dash", 0xBD);
        matchKey.put("= Equals", 0xBB);
        matchKey.put("Backspace", 0x08);
        matchKey.put("Tab", 0x09);
        matchKey.put("Caps Lock", 0x14);
        matchKey.put("Enter", 0x0D);
        matchKey.put("Left Shift", 0xA0);
        matchKey.put("Left Control", 0xA2);
        matchKey.put("Alt", 0x12);
        matchKey.put("Insert", 0x2D);
        matchKey.put("Home", 0x24);
        matchKey.put("Page Up", 0x21);
        matchKey.put("Delete", 0x2E);
        matchKey.put("End", 0x23);
        matchKey.put("Page Down", 0x22);
        matchKey.put("Left Arrow", 0x25);
        matchKey.put("Up Arrow", 0x26);
        matchKey.put("Down Arrow", 0x28);
        matchKey.put("Right Arrow", 0x27);
        matchKey.put("Number Lock", 0x90);
        matchKey.put("/ Numpad slash", 0x6F);
        matchKey.put("* Numpad asterisk", 0x6A);
        matchKey.put("- Numpad dash", 0x6D);
        matchKey.put("Numpad 7", 0x67);
        matchKey.put("Numpad 8", 0x68);
        matchKey.put("Numpad 9", 0x69);
        matchKey.put("+ Numpad plus", 0x6B);
        matchKey.put("Numpad 4", 0x64);
        matchKey.put("Numpad 5", 0x65);
        matchKey.put("Numpad 6", 0x66);
        matchKey.put("Numpad 1", 0x61);
        matchKey.put("Numpad 2", 0x62);
        matchKey.put("Numpad 3", 0x63);
        matchKey.put("Numpad 0", 0x60);
        matchKey.put(". Numpad period", 0x6E);
        matchKey.put("Mouse button 4", 0x05);
        matchKey.put("Mouse button 5", 0x06);
        matchKey.put("Volume mute/unmute", 0xAD);
        matchKey.put("Media play/pause", 0xB3);
        matchKey.put("Media next track", 0xB0);
        matchKey.put("Media previous track", 0xB1);

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

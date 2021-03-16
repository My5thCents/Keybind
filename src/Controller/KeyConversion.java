package Controller;

import java.util.HashMap;
import java.util.Map;

public final class KeyConversion {
    /**
     * key map to convert from the keylistener keycodes to the windows keycodes
     */
    public static final HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(){
        {
            put(0x0000, 0x07); // UNDEFINED
            put(0x000E, 0x08); // Backspace
            put(0x000F, 0x09); // Tab
            put(0xE04C, 0x0C); // Clear
            put(0x001C, 0x0D); // Enter
            put(0x0038, 0x12); // Alt Key
            put(0x0E45, 0x13); // Pause
            put(0x003A, 0x14); // Caps Lock
            put(0x0001, 0x1B); // Escape
            put(0x0039, 0x20); // SpaceBar
            put(0x0E49, 0x21); // Page Up Key
            put(0x0E51, 0x22); // Page Down Key
            put(0x0E4F, 0x23); // End Key
            put(0x0E47, 0x24); // Home Key
            put(0xE04B, 0x25); // Left Arrow Key
            put(0xE048, 0x26); // Up Arrow Key
            put(0xE04D, 0x27); // Right Arrow Key
            put(0xE050, 0x28); // Down Arrow Key
            put(0x0E37, 0x2C); // Print Screen
            put(0x0E52, 0x2D); // Insert
            put(0x0E53, 0x2E); // Delete
            put(0x000B, 0x30); // 0
            put(0x0002, 0x31); // 1
            put(0x0003, 0x32); // 2
            put(0x0004, 0x33); // 3
            put(0x0005, 0x34); // 4
            put(0x0006, 0x35); // 5
            put(0x0007, 0x36); // 6
            put(0x0008, 0x37); // 7
            put(0x0009, 0x38); // 8
            put(0x000A, 0x39); // 9
            put(0x001E, 0x41); // A
            put(0x0030, 0x42); // B
            put(0x002E, 0x43); // C
            put(0x0020, 0x44); // D
            put(0x0012, 0x45); // E
            put(0x0021, 0x46); // F
            put(0x0022, 0x47); // G
            put(0x0023, 0x48); // H
            put(0x0017, 0x49); // I
            put(0x0024, 0x4A); // J
            put(0x0025, 0x4B); // K
            put(0x0026, 0x4C); // L
            put(0x0032, 0x4D); // M
            put(0x0031, 0x4E); // N
            put(0x0018, 0x4F); // O
            put(0x0019, 0x50); // P
            put(0x0010, 0x51); // Q
            put(0x0013, 0x52); // R
            put(0x001F, 0x53); // S
            put(0x0014, 0x54); // T
            put(0x0016, 0x55); // U
            put(0x002F, 0x56); // V
            put(0x0011, 0x57); // W
            put(0x002D, 0x58); // X
            put(0x0015, 0x59); // Y
            put(0x002C, 0x5A); // Z
            put(0x0E5B, 0x5B); // Windows
            put(0x0E5C, 0x5C); // Windows
            put(0x0E5D, 0x5D); // Context Menu
            put(0xE05F, 0x5F); // Sleep
            put(0x0052, 0x60); // KP 0
            put(0x004F, 0x61); // KP 1
            put(0x0050, 0x62); // KP 2
            put(0x0051, 0x63); // KP 3
            put(0x004B, 0x64); // KP 4
            put(0x004C, 0x65); // KP 5
            put(0x004D, 0x66); // KP 6
            put(0x0047, 0x67); // KP 7
            put(0x0048, 0x68); // KP 8
            put(0x0049, 0x69); // KP 9
            put(0x0037, 0x6A); // KP Multiply
            put(0x004E, 0x6B); // KP Add
            put(0x0053, 0x6C); // KP Separator
            put(0x004A, 0x6D); // KP Subtract
            put(0x0E35, 0x6F); // KP Divide
            put(0x003B, 0x70); // F1
            put(0x003C, 0x71); // F2
            put(0x003D, 0x72); // F3
            put(0x003E, 0x73); // F4
            put(0x003F, 0x74); // F5
            put(0x0040, 0x75); // F6
            put(0x0041, 0x76); // F7
            put(0x0042, 0x77); // F8
            put(0x0043, 0x78); // F9
            put(0x0044, 0x79); // F10
            put(0x0057, 0x7A); // F11
            put(0x0058, 0x7B); // F12
            put(0x005B, 0x7C); // F13
            put(0x005C, 0x7D); // F14
            put(0x005D, 0x7E); // F15
            put(0x0063, 0x7F); // F16
            put(0x0064, 0x80); // F17
            put(0x0065, 0x81); // F18
            put(0x0066, 0x82); // F19
            put(0x0067, 0x83); // F20
            put(0x0068, 0x84); // F21
            put(0x0069, 0x85); // F22
            put(0x006A, 0x86); // F23
            put(0x006B, 0x87); // F24
            put(0x0045, 0x90); // NUM LOCK
            put(0x0046, 0x91); // SCROLL LOCK
            put(0x002A, 0xA0); // LSHIFT
            put(0x0036, 0xA1); // RSHIFT
            put(0x001D, 0xA2); // LCONTROL
            put(0x0E1D, 0xA3); // RCONTROL
            put(0xE06A, 0xA6); // Browser Back
            put(0xE069, 0xA7); // Browser Forward
            put(0xE067, 0xA8); // Browser Refresh
            put(0xE068, 0xA9); // Browser Stop
            put(0xE065, 0xAA); // Browser Search
            put(0xE066, 0xAB); // Browser Favorites
            put(0xE020, 0xAD); // Volume Mute
            put(0xE02E, 0xAE); // Volume Down
            put(0xE030, 0xAF); // Volume Up
            put(0xE019, 0xB0); // Media Next
            put(0xE010, 0xB1); // Previous Track
            put(0xE024, 0xB2); // Media Stop
            put(0xE022, 0xB3); // Media Play/Pause
            put(0xE06C, 0xB4); // Start Mail
            put(0xE06D, 0xB5); // Media Select
            put(0x0027, 0xBA); // ; key
            put(0x000D, 0xBB); // = key
            put(0x0033, 0xBC); // , key
            put(0x000C, 0xBD); // - key
            put(0x0034, 0xBE); // . key
            put(0x0035, 0xBF); // / key
            put(0x0029, 0xC0); // Back Quote
            put(0x001A, 0xDB); // [
            put(0x001B, 0xDD); // ]
            put(0x002B, 0xDC); // Backslash
            put(0x0028, 0xDE); // Quotes
        }
    };



}
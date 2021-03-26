package ui;

/**
 * OptionsList initializes a number of lists used in the UI views. All lists have a getter function to send to
 * the different views.
 */
public class OptionsList {
    String[] optionsPress;
    String[] optionsActions;
    public OptionsList() {
        //List of options for the user to bind an action to
        optionsPress = new String[] {
                "Q ", "W ", "E ", "R ", "T ", "Y ", "U ", "I ", "O ", "P ", "A ", "S ", "D ", "F ",
                "G ", "H ", "J ", "K ", "L ", "Z ", "X ", "C ", "V ", "B ", "N ", "M ", ". Period",
                ", Comma", "/ Back slash", "Right shift", "[ Left square bracket", "] Right square bracket",
                "\\ Forward slash", "Esc", "F1 ", "F2 ", "F3 ", "F4 ", "F5 ", "F6 ", "F7 ", "F8 ", "F9 ", "F10 ", "F11 ", "F12 ", "` Tilde",
                "1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "0 ", "- Dash", "= Equals", "Backspace", "Tab",
                "Caps Lock", "Enter", "Left Shift", "Left Control", "Alt", "Insert", "Home",
                "Page Up", "Delete", "End", "Page Down", "Left Arrow", "Up Arrow", "Down Arrow", "Right Arrow",
                "Number Lock", "/ Numpad slash", "* Numpad asterisk", "- Numpad dash", "Numpad 7", "Numpad 8", "Numpad 9",
                "+ Numpad plus", "Numpad 4", "Numpad 5", "Numpad 6", "Numpad 1", "Numpad 2", "Numpad 3",
                "Numpad 0", ". Numpad period", "Mouse button 4", "Mouse button 5"
        };
        //List of options the user can select as actions for the keybind
        optionsActions = new String[] {
                "Q ", "W ", "E ", "R ", "T ", "Y ", "U ", "I ", "O ", "P ", "A ", "S ", "D ", "F ",
                "G ", "H ", "J ", "K ", "L ", "Z ", "X ", "C ", "V ", "B ", "N ", "M ", ". Period",
                ", Comma", "/ Back slash", "Right shift", "[ Left square bracket", "] Right square bracket",
                "\\ Forward slash", "Esc", "F1 ", "F2 ", "F3 ", "F4 ", "F5 ", "F6 ", "F7 ", "F8 ", "F9 ", "F10 ", "F11 ", "F12 ", "` Tilde",
                "1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "0 ", "- Dash", "= Equals", "Backspace", "Tab",
                "Caps Lock", "Enter", "Left Shift", "Left Control", "Alt", "Insert", "Home",
                "Page Up", "Delete", "End", "Page Down", "Left Arrow", "Up Arrow", "Down Arrow", "Right Arrow",
                "Number Lock", "/ Numpad slash", "* Numpad asterisk", "- Numpad dash", "Numpad 7", "Numpad 8", "Numpad 9",
                "+ Numpad plus", "Numpad 4", "Numpad 5", "Numpad 6", "Numpad 1", "Numpad 2", "Numpad 3",
                "Numpad 0", ". Numpad period", "Volume mute/unmute", "Media play/pause",
                "Media next track", "Media previous track", "Move Mouse Left", "Move Mouse Right", "Move Mouse Up", "Move Mouse Down"
        };
    }

    public String[] getOptionstoPress() {
        return optionsPress;
    }

    public String[] getActionsPress() {
        return optionsActions;
    }
}

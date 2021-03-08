package ui;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.controlsfx.control.textfield.TextFields;

/**
 * KeybindView is the view screen for adding a new keybind to the active profile.
 * There are two fields to enter the details of the keybind, a back button to go
 * back to the main UI, and a save button which writes the keybind to the profile.
 */
public class KeybindView extends Pane {
    //The key to be pressed for the keybind action
    TextField  keyToBind = new TextField();
    //The key action once the bound buttton is pressed
    TextField keyAction = new TextField();
    //Options for selecting keys
    OptionsList lists = new OptionsList();
    //Mapping of key selections and key code integers
    keyValueMap keyValueMap = new keyValueMap();

    public KeybindView() {
        this.setStyle("-fx-background-color: #99aab5;");
        keyToBind.setLayoutX(60);
        keyToBind.setLayoutY(200);
        keyToBind.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; " +
                "-fx-pref-width: 400px; -fx-pref-height: 50px;");

        keyAction.setLayoutX(60);
        keyAction.setLayoutY(500);
        keyAction.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; " +
                "-fx-pref-width: 400px; -fx-pref-height: 50px;");

        //Available options to select in the text fields
        String[] keyToBindOptions = lists.getOptionstoPress();
        String[] keyActionOptions = lists.getActionsPress();

        //Labels for the text fields
        Label keyToBindLabel = new Label("Key to Bind:");
        keyToBindLabel.setLayoutX(60);
        keyToBindLabel.setLayoutY(150);
        keyToBindLabel.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");
        Label keyActionLabel = new Label("Assign Action:");
        keyActionLabel.setLayoutX(60);
        keyActionLabel.setLayoutY(450);
        keyActionLabel.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");

        TextFields.bindAutoCompletion(keyToBind, keyToBindOptions);
        TextFields.bindAutoCompletion(keyAction, keyActionOptions);
        this.getChildren().addAll(keyToBind, keyAction, keyActionLabel, keyToBindLabel);

    }

    /**
     * Returns an Integer value for the Windows key code for the string representation of a key.
     * Corresponds to the key which is being bound
     * @return an Integer value for the Windows key code for the string representation of a key
     */
    public Integer getKeyToBind() {

        return keyValueMap.getKeyCode(keyToBind.getText());
    }
    /**
     * Returns an Integer value for the Windows key code for the string representation of a key.
     * Corresponds to the resulting action when the bound key is pressed
     * @return an Integer value for the Windows key code for the string representation of a key
     */
    public Integer getKeyAction() {

        return keyValueMap.getKeyCode(keyAction.getText());
    }

}

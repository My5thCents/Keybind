package ui;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.controlsfx.control.textfield.TextFields;


/**
 * OpenProgramView is the view screen for adding a new keybind to the active profile which opens a program.
 * There are two fields to enter the details of the keybind, a back button to go
 * back to the main UI, and a save button which writes the keybind to the profile in the MainScreen class.
 */
public class OpenProgramView extends Pane {
    //The key to be pressed for the keybind action
    TextField keyToBind = new TextField();
    //The program path to open
    TextField programField = new TextField();
    //Options for selecting keys
    OptionsList lists = new OptionsList();
    //Mapping of key selections and key code integers
    KeyValueMap keyValueMap = new KeyValueMap();

    public OpenProgramView() {
        this.setStyle("-fx-background-color: #99aab5;");
        keyToBind.setLayoutX(60);
        keyToBind.setLayoutY(200);
        keyToBind.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; " +
                "-fx-pref-width: 400px; -fx-pref-height: 50px;");

        programField.setLayoutX(60);
        programField.setLayoutY(500);
        programField.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; " +
                "-fx-pref-width: 400px; -fx-pref-height: 50px;");

        //Available options to select in the text field
        String[] keyToBindOptions = lists.getOptionstoPress();

        //Labels for the text fields
        Label keyToBindLabel = new Label("Key to Bind:");
        keyToBindLabel.setLayoutX(60);
        keyToBindLabel.setLayoutY(150);
        keyToBindLabel.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");
        Label keyActionLabel = new Label("Program File Path:");
        keyActionLabel.setLayoutX(60);
        keyActionLabel.setLayoutY(450);
        keyActionLabel.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");

        TextFields.bindAutoCompletion(keyToBind, keyToBindOptions);
        TextFields.bindAutoCompletion(programField);
        this.getChildren().addAll(keyToBind, programField, keyActionLabel, keyToBindLabel);
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
     * Returns the string filepath the user inputs for the program they want to open when the
     * bound key is pressed
     * @return String filepath to be used for opening the program at the filepath
     */
    public String getProgramPath() {

        return programField.getText();
    }


}

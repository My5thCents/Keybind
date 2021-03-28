package ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.controlsfx.control.textfield.TextFields;

public class bindMouseView extends Pane{
    //The key to be pressed for the keybind action
    TextField  keyToBind = new TextField();
    //Button for left action
    Button left = new Button();
    //Button for right action
    Button right = new Button();
    //Button for up action
    Button up = new Button();
    //Button for down action
    Button down = new Button();
    //Options for selecting keys
    OptionsList lists = new OptionsList();
    //Mapping of key selections and key code integers
    KeyValueMap keyValueMap = new KeyValueMap();
    public bindMouseView(){
        this.setStyle("-fx-background-color: #99aab5;");
        keyToBind.setLayoutX(60);
        keyToBind.setLayoutY(200);
        keyToBind.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; " +
                "-fx-pref-width: 400px; -fx-pref-height: 50px;");

        //Available options to select in the text fields
        String[] keyToBindOptions = lists.getOptionstoPress();


        //Labels for the text fields
        Label keyToBindLabel = new Label("Key to Bind:");
        keyToBindLabel.setLayoutX(60);
        keyToBindLabel.setLayoutY(150);
        keyToBindLabel.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");
        Label keyActionLabel = new Label("Assign Action:");

        left.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
        left.setWrapText(true);
        left.setLayoutX(438);
        left.setLayoutY(200);

        right.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
        right.setWrapText(true);
        right.setLayoutX(438);
        right.setLayoutY(200);

        up.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
        up.setWrapText(true);
        up.setLayoutX(438);
        up.setLayoutY(200);

        down.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
        down.setWrapText(true);
        down.setLayoutX(438);
        down.setLayoutY(200);
    }
}

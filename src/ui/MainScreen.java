package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Controller.Binding;
import model.Hotkey;
import model.Modifier;
import model.OSInterface;

import java.util.ArrayList;

/**
 * mainScreen is the main UI page for the program. All user functions start here.
 */

public class MainScreen extends Pane {
        Stage primaryStage = new Stage();
        Scene mainScreenScene = new Scene(this, 800, 800);
        int id = 0;
        public static ArrayList<Binding> list = new ArrayList<>();


        public MainScreen() {
            this.setStyle("-fx-background-color: #99aab5;");
            primaryStage.setTitle("");
            primaryStage.setScene(mainScreenScene);
            primaryStage.show();



            /*
            Button to send user to screen to set a new keybind.
             */
            Button bKeybind = new Button("Set a Keybind");
            bKeybind.setOnAction(e -> goToKeybind());
            bKeybind.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; -fx-vertical-align: middle; " +
                    "-fx-pref-width: 260px; -fx-pref-height: 150px; -fx-text-align: center;");
            bKeybind.setWrapText(true);
            bKeybind.setLayoutX(89);
            bKeybind.setLayoutY(200);

            /*
            Button to send user to screen to set a new macro
             */
            Button bMacro = new Button("Bind a Key to Macro");
            bMacro.setOnAction(e -> System.out.println("Set Macro"));
            bMacro.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; -fx-vertical-align: middle; " +
                    "-fx-pref-width: 260px; -fx-pref-height: 150px; -fx-text-align: center;");
            bMacro.setWrapText(true);
            bMacro.setLayoutX(438);
            bMacro.setLayoutY(200);

            /*
            Button to send user to screen to set a new keybind.
             */
            Button bProgram = new Button("Bind a Key to Program");
            bProgram.setOnAction(e -> System.out.println("Bind a Key to Program"));
            bProgram.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; -fx-vertical-align: middle; " +
                    "-fx-pref-width: 260px; -fx-pref-height: 150px; -fx-text-align: center;");
            bProgram.setWrapText(true);
            bProgram.setLayoutX(89);
            bProgram.setLayoutY(450);


            /*
            Button to send user to screen to change mouse sensitivity
             */
            Button bMouseSens = new Button("Change Mouse Sensitivity");
            bMouseSens.setOnAction(e -> System.out.println("Change Mouse Sensitivity"));
            bMouseSens.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; -fx-vertical-align: middle; " +
                    "-fx-pref-width: 260px; -fx-pref-height: 150px; -fx-text-align: center;");
            bMouseSens.setWrapText(true);
            bMouseSens.setLayoutX(438);
            bMouseSens.setLayoutY(450);


            /*
            Button to toggle keybinds on/off
             */
            Button bToggle = new Button("Toggle Keybinds On/Off");
            bToggle.setOnAction(e -> System.out.println("Toggle On/Off"));
            bToggle.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                    "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
            bToggle.setWrapText(true);
            bToggle.setLayoutX(520);
            bToggle.setLayoutY(670);

            /*
            Drop down box to select profile
             */
            ComboBox<String> profileSelector = new ComboBox<String>();
            profileSelector.getItems().add("Profile 1");
            profileSelector.getItems().add("Profile 2");
            profileSelector.getItems().add("Profile 3");
            profileSelector.setValue("Profile 1");
            profileSelector.setStyle("-fx-background-color: lightgrey; -fx-text-fill: white; -fx-font-size: 20; -fx-vertical-align: middle; " +
                    "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
            profileSelector.setLayoutX(89);
            profileSelector.setLayoutY(45);
            profileSelector.setOnAction(e -> System.out.println(profileSelector.getValue()));

            /*
            Button to add new profile
             */
            Button bAddProfile = new Button("Add New Profile");
            bAddProfile.setOnAction(e -> System.out.println("Add New Profile"));
            bAddProfile.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                    "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
            bAddProfile.setWrapText(true);
            bAddProfile.setLayoutX(315);
            bAddProfile.setLayoutY(45);

            /*
            Button to delete the current profile
             */
            Button bDelProfile = new Button("Delete Current Profile");
            bDelProfile.setOnAction(e -> System.out.println("Delete Current Profile"));
            bDelProfile.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                    "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
            bDelProfile.setWrapText(true);
            bDelProfile.setLayoutX(541);
            bDelProfile.setLayoutY(45);



            this.getChildren().addAll(bKeybind, bMacro, bProgram, bMouseSens, bToggle, profileSelector, bAddProfile, bDelProfile);
        }

    /**
     * Function called when user wishes to make a new keybind. Opens the KeybindView class in the stage.
     */
    private void goToKeybind() {
        KeybindView KBV = new KeybindView();
        //Button to go back to main view
        Button back = new Button("Back");
        back.setLayoutX(510);
        back.setLayoutY(700);
        back.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        back.setOnAction(e -> primaryStage.setScene(mainScreenScene));

        //Button to save fields and enter keybind to profile
        Button save = new Button("Save");
        save.setLayoutX(640);
        save.setLayoutY(700);
        save.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        save.setOnAction(e -> {
            Hotkey newHotkey = new Hotkey(KBV.getKeyToBind(), id, Modifier.NONE.val());
            Hotkey action = new Hotkey(KBV.getKeyAction(), id, Modifier.NONE.val());
            Binding binding = new Binding(newHotkey, action);
            list.add(binding);
            id ++;
            boolean register = OSInterface.getInstance().registerHotkey(newHotkey);
            primaryStage.setScene(mainScreenScene);
        });
        primaryStage.setTitle("Set a Keybind");
        Scene testScene = new Scene(KBV, 800, 800);
        primaryStage.setScene(testScene);
        KBV.getChildren().addAll(back, save);


    }

}

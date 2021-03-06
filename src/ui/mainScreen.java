package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * mainScreen is the main UI page for the program. All user functions start here.
 */

public class mainScreen extends Pane {
        public mainScreen() {
            this.setStyle("-fx-background-color: #99aab5;");
            Stage primaryStage = new Stage();
            Scene mainScreenScene = new Scene(this, 800, 800);
            primaryStage.setScene(mainScreenScene);
            primaryStage.show();
            VBox root = new VBox();
            Button test = new Button("Test");
            Scene testScene = new Scene(root, 800, 800);
            root.getChildren().add(test);
            test.setOnAction(e -> primaryStage.setScene(mainScreenScene));

            /*
            Button to send user to screen to set a new keybind.
             */
            Button bKeybind = new Button("Set a Keybind");
            bKeybind.setOnAction(e -> primaryStage.setScene(testScene));
            bKeybind.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; -fx-vertical-align: middle; -fx-pref-width: 260px; -fx-pref-height: 150px; -fx-text-align: center;");
            bKeybind.setWrapText(true);
            bKeybind.setLayoutX(89);
            bKeybind.setLayoutY(200);

            /*
            Button to send user to screen to set a new macro
             */
            Button bMacro = new Button("Bind a Key to Macro");
            bMacro.setOnAction(e -> System.out.println("Set Macro"));
            bMacro.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; -fx-vertical-align: middle; -fx-pref-width: 260px; -fx-pref-height: 150px; -fx-text-align: center;");
            bMacro.setWrapText(true);
            bMacro.setLayoutX(438);
            bMacro.setLayoutY(200);

            /*
            Button to send user to screen to set a new keybind.
             */
            Button bProgram = new Button("Bind a Key to Program");
            bProgram.setOnAction(e -> System.out.println("Bind a Key to Program"));
            bProgram.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; -fx-vertical-align: middle; -fx-pref-width: 260px; -fx-pref-height: 150px; -fx-text-align: center;");
            bProgram.setWrapText(true);
            bProgram.setLayoutX(89);
            bProgram.setLayoutY(450);


            /*
            Button to send user to screen to change mouse sensitivity
             */
            Button bMouseSens = new Button("Change Mouse Sensitivity");
            bMouseSens.setOnAction(e -> System.out.println("Change Mouse Sensitivity"));
            bMouseSens.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; -fx-vertical-align: middle; -fx-pref-width: 260px; -fx-pref-height: 150px; -fx-text-align: center;");
            bMouseSens.setWrapText(true);
            bMouseSens.setLayoutX(438);
            bMouseSens.setLayoutY(450);


            /*
            Button to toggle keybinds on/off
             */
            Button bToggle = new Button("Toggle Keybinds On/Off");
            bToggle.setOnAction(e -> System.out.println("Toggle On/Off"));
            bToggle.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; -fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
            bToggle.setWrapText(true);
            bToggle.setLayoutX(520);
            bToggle.setLayoutY(670);

            /*
            Drop down box to select profile
             */
            ComboBox profileSelector = new ComboBox();
            profileSelector.getItems().add("Profile 1");
            profileSelector.getItems().add("Profile 2");
            profileSelector.getItems().add("Profile 3");
            profileSelector.setValue("Profile 1");
            profileSelector.setStyle("-fx-background-color: lightgrey; -fx-text-fill: white; -fx-font-size: 20; -fx-vertical-align: middle; -fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
            profileSelector.setLayoutX(89);
            profileSelector.setLayoutY(45);
            profileSelector.setOnAction(e -> System.out.println(profileSelector.getValue()));

            /*
            Button to add new profile
             */
            Button bAddProfile = new Button("Add New Profile");
            bAddProfile.setOnAction(e -> System.out.println("Add New Profile"));
            bAddProfile.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; -fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
            bAddProfile.setWrapText(true);
            bAddProfile.setLayoutX(315);
            bAddProfile.setLayoutY(45);

            /*
            Button to delete the current profile
             */
            Button bDelProfile = new Button("Delete Current Profile");
            bDelProfile.setOnAction(e -> System.out.println("Delete Current Profile"));
            bDelProfile.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; -fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
            bDelProfile.setWrapText(true);
            bDelProfile.setLayoutX(541);
            bDelProfile.setLayoutY(45);



            this.getChildren().addAll(bKeybind, bMacro, bProgram, bMouseSens, bToggle, profileSelector, bAddProfile, bDelProfile);
        }

}

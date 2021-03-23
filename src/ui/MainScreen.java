package ui;

import Controller.Action;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Hotkey;
import model.Modifier;
import model.OSInterface;
import model.profiles.commands.addProfile;
import model.profiles.commands.checkActive;
import model.profiles.commands.deleteProfile;
import org.jnativehook.NativeHookException;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * mainScreen is the main UI page for the program. All user functions start here.
 */

public class MainScreen extends Pane {
    Stage primaryStage = new Stage();
    Scene mainScreenScene = new Scene(this, 800, 800);
    int id = 0;
    int mouseSens = 10;
    public static Hashtable<Integer, Action> dict = new Hashtable<>();


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
        bMacro.setOnAction(e -> goToMacro());
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
        bMouseSens.setOnAction(e -> goToMouseSensitivity());
        bMouseSens.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; -fx-vertical-align: middle; " +
                "-fx-pref-width: 260px; -fx-pref-height: 150px; -fx-text-align: center;");
        bMouseSens.setWrapText(true);
        bMouseSens.setLayoutX(438);
        bMouseSens.setLayoutY(450);

        Button bCurrentBindings = new Button("View Current Bindings");
        bCurrentBindings.setOnAction(e -> goToCurrentBindings());
        bCurrentBindings.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
        bCurrentBindings.setWrapText(true);
        bCurrentBindings.setLayoutX(300);
        bCurrentBindings.setLayoutY(670);



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
        bAddProfile.setOnAction(e -> goToAddProfile());
        bAddProfile.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
        bAddProfile.setWrapText(true);
        bAddProfile.setLayoutX(315);
        bAddProfile.setLayoutY(45);

        /*
        Button to delete the current profile
         */
        Button bDelProfile = new Button("Delete Current Profile");
        bDelProfile.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete current profile?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                deleteProfile delP = new deleteProfile();
                checkActive active = new checkActive();
                delP.DeleteProfile(active.CheckActive().getName());
            }
        });
        bDelProfile.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
        bDelProfile.setWrapText(true);
        bDelProfile.setLayoutX(541);
        bDelProfile.setLayoutY(45);


        this.getChildren().addAll(bKeybind, bMacro, bProgram, bMouseSens, bToggle, bCurrentBindings, profileSelector, bAddProfile, bDelProfile);
    }

    /**
     * Function called when user wishes to make a new keybind. Opens the KeybindView class in the stage.
     */
    private void goToKeybind() {
        KeybindView KBV = new KeybindView();
        primaryStage.setTitle("Set a Keybind");
        Scene testScene = new Scene(KBV, 800, 800);
        primaryStage.setScene(testScene);
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
            try {
                Hotkey newHotkey = new Hotkey(KBV.getKeyToBind(), id, Modifier.NONE.val());
                Hotkey action = new Hotkey(KBV.getKeyAction(), id, Modifier.NONE.val());
                ArrayList<Integer> actionList = new ArrayList<>();
                actionList.add(action.getKeyCode());
                Action newAction = new Action(actionList);
                if (dict.containsKey(newHotkey.getKeyCode())){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "A binding already exists for that key\nRemove key before reassigning");
                    alert.show();
                    primaryStage.setScene(mainScreenScene);
                    return;
                }
                dict.put(newHotkey.getKeyCode(), newAction);
                id++;
                boolean register = OSInterface.getInstance().registerHotkey(newHotkey);
            } catch(Exception exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a key and action from the list");
                alert.show();
                goToKeybind();
                return;
            }
            primaryStage.setScene(mainScreenScene);
        });

        KBV.getChildren().addAll(back, save);


    }

    /**
     * Function called when user wishes to make a new Macro. Opens the MacroView class in the stage.
     */
    private void goToMacro() {
        KeybindView KBV = new KeybindView();
        //Button to go back to main view
        Button back = new Button("Back");
        back.setLayoutX(510);
        back.setLayoutY(700);
        back.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        back.setOnAction(e -> primaryStage.setScene(mainScreenScene));

        ArrayList<Integer> added = new ArrayList<>();
        Button add = new Button("Add Key");
        add.setLayoutX(380);
        add.setLayoutY(700);
        add.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        add.setOnAction(e -> {
            try {
                Hotkey newHotkey = new Hotkey(KBV.getKeyToBind(), id, Modifier.NONE.val());
                Hotkey action = new Hotkey(KBV.getKeyAction(), id, Modifier.NONE.val());
                if (dict.containsKey(newHotkey.getKeyCode())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "A binding already exists for that key\nRemove key before reassigning");
                    alert.show();
                    primaryStage.setScene(mainScreenScene);
                    return;
                }
                ArrayList<Integer> actionList = new ArrayList<>();
                actionList.add(action.getKeyCode());
                goToAddToMacro(newHotkey, actionList);
            } catch(Exception exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a key and action from the list");
                alert.show();
                goToMacro();
            }
        });


        //Button to save fields and enter keybind to profile
        Button save = new Button("Save");
        save.setLayoutX(640);
        save.setLayoutY(700);
        save.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        save.setOnAction(e -> {
            try {
                Hotkey newHotkey = new Hotkey(KBV.getKeyToBind(), id, Modifier.NONE.val());
                Hotkey action = new Hotkey(KBV.getKeyAction(), id, Modifier.NONE.val());
                ArrayList<Integer> actionList = new ArrayList<>();
                actionList.add(action.getKeyCode());
                Action newAction = new Action(actionList);
                dict.put(newHotkey.getKeyCode(), newAction);
                id++;
                boolean register = OSInterface.getInstance().registerHotkey(newHotkey);
                primaryStage.setScene(mainScreenScene);
            } catch (Exception exception){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a key and action from the list");
                alert.show();
                goToMacro();
            }
        });
        primaryStage.setTitle("Set a Keybind");
        Scene testScene = new Scene(KBV, 800, 800);
        primaryStage.setScene(testScene);
        KBV.getChildren().addAll(back, save, add);

    }

    /**
     * intermediate stage for adding multiple keys to the chain
     * @param hotkey hotkey to be added
     * @param added list of added keys
     */
    public void goToAddToMacro(Hotkey hotkey, ArrayList<Integer> added){
        MacroView KBV = new MacroView();
        //Button to go back to main view
        Button back = new Button("Back");
        back.setLayoutX(510);
        back.setLayoutY(700);
        back.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        back.setOnAction(e -> primaryStage.setScene(mainScreenScene));
        Button add = new Button("Add Key");

        //Button to add a new key to the macro
        add.setLayoutX(380);
        add.setLayoutY(700);
        add.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        add.setOnAction(e -> {
            try {
                //add the action to the list
                Hotkey action = new Hotkey(KBV.getKeyAction(), id, Modifier.NONE.val());
                added.add(action.getKeyCode());
                goToAddToMacro(hotkey, added);
            } catch (Exception exception){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select an action from the list");
                alert.show();
                goToAddToMacro(hotkey, added);
            }
        });

        Text hotkeyName = new Text();
        hotkeyName.setLayoutX(100);
        hotkeyName.setLayoutY(100);
        hotkeyName.setText("Key: " + KeyEvent.getKeyText(hotkey.getKeyCode()));
        hotkeyName.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");
        StringBuilder string = new StringBuilder("Keys added already: \n");

        Text list = new Text();
        list.setLayoutX(500);
        list.setLayoutY(100);
        for(Integer i : added){
            string.append(KeyEvent.getKeyText(i));
            string.append("\n");
        }
        list.setText(String.valueOf(string));
        list.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");

        Button save = new Button("Save");
        save.setLayoutX(640);
        save.setLayoutY(700);
        save.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        save.setOnAction(e -> {
            try {
                Hotkey action1 = new Hotkey(KBV.getKeyAction(), id, Modifier.NONE.val());
                added.add(action1.getKeyCode());
                Action newAction = new Action(added);
                dict.put(hotkey.getKeyCode(), newAction);
                id++;
                boolean register = OSInterface.getInstance().registerHotkey(hotkey);
                primaryStage.setScene(mainScreenScene);
            } catch (Exception exception){
                Action newAction = new Action(added);
                dict.put(hotkey.getKeyCode(), newAction);
                id++;
                boolean register = OSInterface.getInstance().registerHotkey(hotkey);
                primaryStage.setScene(mainScreenScene);
            }
        });

        primaryStage.setTitle("Set a Macro");
        Scene testScene = new Scene(KBV, 800, 800);
        primaryStage.setScene(testScene);
        KBV.getChildren().addAll(back, add, save, hotkeyName, list);

    }

    /**
     * Display the current keybindings in the current profile
     */
    public void goToCurrentBindings(){
        BlankView BV = new BlankView();
        primaryStage.setTitle("Currently Bound Keys");
        Scene testScene = new Scene(BV, 800, 800);
        primaryStage.setScene(testScene);
        int baseY = 110;
        Button back = new Button("Back");
        back.setLayoutX(640);
        back.setLayoutY(700);
        back.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        back.setOnAction(e -> primaryStage.setScene(mainScreenScene));

        Text title = new Text();
        title.setLayoutY(100);
        title.setLayoutX(50);
        title.setText("Current Key Bindings: ");
        title.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");


        Text text = new Text();
        text.setLayoutY(130);
        text.setLayoutX(100);
        StringBuilder list = new StringBuilder("");
        //Text to
        for(Integer i: dict.keySet()){
            list.append("Key: ");
            list.append(KeyEvent.getKeyText(i));
            list.append("\tAction(s): ");
            for(Integer j: dict.get(i).getKeys()){
                list.append(KeyEvent.getKeyText(j));
                list.append(" ");
            }
            list.append("\n\n");
            Button remove = new Button("Remove");;
            remove.setLayoutX(700);
            remove.setLayoutY(baseY);
            baseY += 44;
            remove.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 12; -fx-vertical-align: middle; " +
                    "-fx-pref-width: 75px; -fx-pref-height: 30px; -fx-text-align: center;");
            remove.setOnAction(e -> {
                dict.remove(i);
                primaryStage.setScene(mainScreenScene);
                OSInterface.getInstance().unregisterHotkey(i);
            });
            BV.getChildren().add(remove);
        }
        text.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 15;");
        text.setText(String.valueOf(list));

        BV.getChildren().addAll(title, text, back);
    }

    /**
     * Function called when user wishes to add a new profile. Reads in a profile name and creates a new profile. User can also
     * use back button to return without making changes.
     */
    private void goToAddProfile() {
        AddProfileScreen profileScreen = new AddProfileScreen();
        //Button to go back to main view
        Button back = new Button("Back");
        back.setLayoutX(510);
        back.setLayoutY(700);
        back.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        back.setOnAction(e -> primaryStage.setScene(mainScreenScene));

        //Button to save name field and create profile
        Button save = new Button("Save");
        save.setLayoutX(640);
        save.setLayoutY(700);
        save.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        save.setOnAction(e -> {
            new addProfile(profileScreen.getProfileName());
            primaryStage.setScene(mainScreenScene);
        });
        primaryStage.setTitle("Add New Profile");
        Scene profScene = new Scene(profileScreen, 800, 800);
        primaryStage.setScene(profScene);
        profileScreen.getChildren().addAll(back, save);
    }

    /**
     * Function called when user wishes to change mouse sensitivity. Reads in a slider value, save button saves changes,
     * back button does nothing and goes back to main screen.
     */
    private void goToMouseSensitivity() {
        MouseSensitivityScreen mouseSensScreen = new MouseSensitivityScreen(mouseSens);
        //Button to go back to main view
        Button back = new Button("Back");
        back.setLayoutX(510);
        back.setLayoutY(700);
        back.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        back.setOnAction(e -> primaryStage.setScene(mainScreenScene));

        //Button to save sensitivity and return to main screen
        Button save = new Button("Save");
        save.setLayoutX(640);
        save.setLayoutY(700);
        save.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        save.setOnAction(e -> {
            mouseSens = (int) mouseSensScreen.getSensitivity();
            OSInterface.getInstance().setMouseSpeed(mouseSens);
            primaryStage.setScene(mainScreenScene);
        });
        primaryStage.setTitle("Add New Profile");
        Scene sensScene = new Scene(mouseSensScreen, 800, 800);
        primaryStage.setScene(sensScene);
        mouseSensScreen.getChildren().addAll(back, save);
    }


}

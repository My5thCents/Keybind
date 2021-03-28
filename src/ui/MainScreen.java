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
import model.ProgramLaunchConverter;
import model.profiles.commands.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import static ui.KeyValueMap.matchKey;

/**
 * mainScreen is the main UI page for the program. All user functions start here.
 */

public class MainScreen extends Pane {
    saveEverything save = new saveEverything();
    Stage primaryStage = new Stage();
    Scene mainScreenScene = new Scene(this, 800, 800);
    int id = 0;
    int mouseSens = 10;
    public static Hashtable<Integer, Action> dict = new Hashtable<>();
    ComboBox<String> profileSelector;
    boolean isOn = true;



    public MainScreen() throws IOException {
        this.setStyle("-fx-background-color: #99aab5;");
        primaryStage.setTitle("");
        primaryStage.setScene(mainScreenScene);
        primaryStage.show();
        save.getFromFile();
        primaryStage.setOnCloseRequest(e -> {
            try {
                save.saveToFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });



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
        Button to send user to screen to set a new keybind which opens a program.
         */
        Button bProgram = new Button("Bind a Key to Program");
        bProgram.setOnAction(e -> goToAddProgram());
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


        /*
        Button to view current bindings saved
         */
        Button bCurrentBindings = new Button("View Current Bindings");
        bCurrentBindings.setOnAction(e -> goToCurrentBindings());
        bCurrentBindings.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
        bCurrentBindings.setWrapText(true);
        bCurrentBindings.setLayoutX(300);
        bCurrentBindings.setLayoutY(670);

        /*
        Button to view select running programs
         */
        Button bProgramsRunning = new Button("View Running Programs");
        bProgramsRunning.setOnAction(e -> goToProgramsRunning());
        bProgramsRunning.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
        bProgramsRunning.setWrapText(true);
        bProgramsRunning.setLayoutX(80);
        bProgramsRunning.setLayoutY(670);



        /*
        Button to toggle keybinds on/off
         */
        Button bToggle = new Button("Toggle Keybinds Off");
        bToggle.setOnAction(e -> {
            checkActive check = new checkActive();
            setActive setProf = new setActive();
            if (isOn) {
                setProf.SetActive("Default");
                for (int i=0; i<this.id; i++){
                    OSInterface.getInstance().unregisterHotkey(i);
                }
                isOn = false;
                bToggle.setText("Toggle Keybinds On");
            } else {
                System.out.println(id);
                setActive setActive = new setActive();
                setProf.SetActive(profileSelector.getValue());
                isOn = true;
                bToggle.setText("Toggle Keybinds Off");
                setActive.SetActive(profileSelector.getValue());
                for (Integer keyCode: check.CheckActive().HKeys.keySet()){
                    Hotkey hotkey = new Hotkey(keyCode, id, 0);
                    OSInterface.getInstance().registerHotkey(hotkey);
                    id++;
                }
            }
        });
        bToggle.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
        bToggle.setWrapText(true);
        bToggle.setLayoutX(520);
        bToggle.setLayoutY(670);

            /*
        Drop down box to select profile
         */
        profileSelector = new ComboBox<>();
        checkActive activeP = new checkActive();
        profileSelector.setValue(activeP.CheckActive().name);
        currentProfiles profiles = new currentProfiles();
        for (String p : profiles.findAllProfiles()) {
            profileSelector.getItems().add(p);
        }
        profileSelector.setStyle("-fx-background-color: lightgrey; -fx-text-fill: white; -fx-font-size: 20; -fx-vertical-align: middle; " +
                "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
        profileSelector.setLayoutX(89);
        profileSelector.setLayoutY(45);
        profileSelector.setValue("Default");
        setActive setActive = new setActive();
        setActive.SetActive("Default");
        checkActive check = new checkActive();
        profileSelector.setOnAction(e -> {
            for (int i=0; i<this.id; i++){
                OSInterface.getInstance().unregisterHotkey(i);
            }
            setActive.SetActive(profileSelector.getValue());
            for (Integer keyCode: check.CheckActive().HKeys.keySet()){
                Hotkey hotkey = new Hotkey(keyCode, id, 0);
                OSInterface.getInstance().registerHotkey(hotkey);
                id++;
            }

        });

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
                if (!active.CheckActive().getName().equals("Default")) {
                    profileSelector.getItems().remove(active.CheckActive().getName());
                    delP.DeleteProfile(active.CheckActive().getName());
                    setActive set = new setActive();
                    set.SetActive("Default");
                }
            }
        });
        bDelProfile.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 200px; -fx-pref-height: 50px; -fx-text-align: center;");
        bDelProfile.setWrapText(true);
        bDelProfile.setLayoutX(541);
        bDelProfile.setLayoutY(45);


        this.getChildren().addAll(bKeybind, bMacro, bProgram, bMouseSens, bToggle, bCurrentBindings, profileSelector, bAddProfile, bDelProfile, bProgramsRunning);
    }

    /**
     * Function called when user wishes to make a new keybind. Opens the KeybindView class in the stage.
     */
    private void goToKeybind() {
        checkActive check = new checkActive();
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
        back.setOnAction(e -> {
            primaryStage.setScene(mainScreenScene);
            primaryStage.setTitle("");
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
                if (check.CheckActive().hasHotkey(newHotkey.getKeyCode())){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "A binding already exists for that key\nRemove key before reassigning");
                    alert.show();
                    primaryStage.setScene(mainScreenScene);
                    primaryStage.setTitle("");
                    return;
                }
                check.CheckActive().addHotkey(newHotkey.getKeyCode(), newAction);
                id++;
                boolean register = OSInterface.getInstance().registerHotkey(newHotkey);
            } catch(Exception exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a key and action from the list");
                alert.show();
                goToKeybind();
                return;
            }
            primaryStage.setScene(mainScreenScene);
            primaryStage.setTitle("");
        });

        KBV.getChildren().addAll(back, save);


    }

    /**
     * Function called when user wishes to make a new Macro. Opens the MacroView class in the stage.
     */
    private void goToMacro() {
        checkActive check = new checkActive();
        KeybindView KBV = new KeybindView();
        //Button to go back to main view
        Button back = new Button("Back");
        back.setLayoutX(510);
        back.setLayoutY(700);
        back.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        back.setOnAction(e -> {
            primaryStage.setScene(mainScreenScene);
            primaryStage.setTitle("");
        });

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
                if (check.CheckActive().hasHotkey(newHotkey.getKeyCode())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "A binding already exists for that key\nRemove key before reassigning");
                    alert.show();
                    primaryStage.setScene(mainScreenScene);
                    primaryStage.setTitle("");
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
                check.CheckActive().addHotkey(newHotkey.getKeyCode(), newAction);
                id++;
                boolean register = OSInterface.getInstance().registerHotkey(newHotkey);
                primaryStage.setScene(mainScreenScene);
                primaryStage.setTitle("");
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
        checkActive check = new checkActive();
        MacroView KBV = new MacroView();
        //Button to go back to main view
        Button back = new Button("Back");
        back.setLayoutX(510);
        back.setLayoutY(700);
        back.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        back.setOnAction(e -> {
            primaryStage.setScene(mainScreenScene);
            primaryStage.setTitle("");
        });
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
                check.CheckActive().addHotkey(hotkey.getKeyCode(), newAction);
                id++;
                boolean register = OSInterface.getInstance().registerHotkey(hotkey);
                primaryStage.setScene(mainScreenScene);
                primaryStage.setTitle("");
            } catch (Exception exception){
                Action newAction = new Action(added);
                check.CheckActive().addHotkey(hotkey.getKeyCode(), newAction);
                id++;
                boolean register = OSInterface.getInstance().registerHotkey(hotkey);
                primaryStage.setScene(mainScreenScene);
                primaryStage.setTitle("");
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
        KeyValueMap key = new KeyValueMap();
        Hashtable<Integer, String> reverseMap = new Hashtable<>();
        for(Map.Entry<String, Integer> entry: matchKey.entrySet()){
            reverseMap.put(entry.getValue(), entry.getKey());
        }
        checkActive check = new checkActive();
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
        back.setOnAction(e -> {
            primaryStage.setScene(mainScreenScene);
            primaryStage.setTitle("");
        });

        Text title = new Text();
        title.setLayoutY(100);
        title.setLayoutX(50);
        title.setText("Current Key Bindings: ");
        title.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");


        Text text = new Text();
        text.setLayoutY(130);
        text.setLayoutX(100);
        StringBuilder list = new StringBuilder("");
        int counter = 0;
        for(Integer i: check.CheckActive().HKeys.keySet()){
            list.append("Key: ");
            list.append(KeyEvent.getKeyText(i));
            list.append("\tAction(s): ");
            for(Integer j: check.CheckActive().getHotKey(i).getKeys()){
                list.append(reverseMap.get(j));
                list.append(" ");
            }
            list.append("\n\n");
            Button remove = new Button("Remove");
            remove.setLayoutX(700);
            remove.setLayoutY(baseY);
            baseY += 44;
            remove.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 12; -fx-vertical-align: middle; " +
                    "-fx-pref-width: 75px; -fx-pref-height: 30px; -fx-text-align: center;");
            int finalCounter = counter;
            remove.setOnAction(e -> {
                check.CheckActive().removeHotKey(i);
                primaryStage.setScene(mainScreenScene);
                primaryStage.setTitle("");
                OSInterface.getInstance().unregisterHotkey(finalCounter);
            });
            BV.getChildren().add(remove);
            counter += 1;
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
        back.setOnAction(e -> {
            primaryStage.setScene(mainScreenScene);
            primaryStage.setTitle("");
        });

        //Button to save name field and create profile
        Button save = new Button("Save");
        save.setLayoutX(640);
        save.setLayoutY(700);
        save.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        save.setOnAction(e -> {
            new addProfile(profileScreen.getProfileName());
            profileSelector.getItems().add(profileScreen.getProfileName());
            profileSelector.setValue(profileScreen.getProfileName());
            setActive setActive = new setActive();
            setActive.SetActive(profileScreen.getProfileName());
            primaryStage.setScene(mainScreenScene);
            primaryStage.setTitle("");

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
        back.setOnAction(e -> {
            primaryStage.setScene(mainScreenScene);
            primaryStage.setTitle("");
        });

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
            primaryStage.setTitle("");
        });
        primaryStage.setTitle("Set Mouse Sensitivity");
        Scene sensScene = new Scene(mouseSensScreen, 800, 800);
        primaryStage.setScene(sensScene);
        mouseSensScreen.getChildren().addAll(back, save);
    }

    /**
     * Function called when user wishes to make a new keybind. Opens the KeybindView class in the stage.
     */
    private void goToAddProgram() {
        checkActive check = new checkActive();
        OpenProgramView programView = new OpenProgramView();
        primaryStage.setTitle("Bind a Key to Open Program");
        Scene programScene = new Scene(programView, 800, 800);
        primaryStage.setScene(programScene);
        //Button to go back to main view
        Button back = new Button("Back");
        back.setLayoutX(510);
        back.setLayoutY(700);
        back.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        back.setOnAction(e -> {
            primaryStage.setScene(mainScreenScene);
            primaryStage.setTitle("");
        });

        //Button to save fields and enter keybind to profile
        Button save = new Button("Save");
        save.setLayoutX(640);
        save.setLayoutY(700);
        save.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        save.setOnAction(e -> {
            try {
                Hotkey newHotkey = new Hotkey(programView.getKeyToBind(), id, Modifier.NONE.val());
                // Need to add functionality to add open program as keybind action
                String str = programView.getProgramPath();
                ArrayList<Integer> actionList = new ArrayList<>();
                actionList = ProgramLaunchConverter.StringToInt(str);
                Action newAction = new Action(actionList);
                if (check.CheckActive().hasHotkey(newHotkey.getKeyCode())){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "A binding already exists for that key\nRemove key before reassigning");
                    alert.show();
                    primaryStage.setScene(mainScreenScene);
                    primaryStage.setTitle("");
                    return;
                }
                check.CheckActive().addHotkey(newHotkey.getKeyCode(), newAction);
                id++;
                boolean register = OSInterface.getInstance().registerHotkey(newHotkey);
            } catch(Exception exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a key and action from the list");
                alert.show();
                goToKeybind();
                return;
            }
            primaryStage.setScene(mainScreenScene);
            primaryStage.setTitle("");
        });

        programView.getChildren().addAll(back, save);


    }
    /**
     * Function called when user wishes to view select running programs. Back returns user to the main view
     */
    private void goToProgramsRunning() {
        RunningProgramsView runningProgramsView = new RunningProgramsView();
        primaryStage.setTitle("View Running Programs");
        Scene runningScene = new Scene(runningProgramsView, 800, 800);
        primaryStage.setScene(runningScene);
        //Button to go back to main view
        Button back = new Button("Back");
        back.setLayoutX(640);
        back.setLayoutY(700);
        back.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 16; -fx-vertical-align: middle; " +
                "-fx-pref-width: 100px; -fx-pref-height: 50px; -fx-text-align: center;");
        back.setOnAction(e -> {
            primaryStage.setScene(mainScreenScene);
            primaryStage.setTitle("");
        });
        runningProgramsView.getChildren().addAll(back);
    }
}

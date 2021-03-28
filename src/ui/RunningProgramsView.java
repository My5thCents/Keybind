package ui;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.RunProgramDetection;


/**
 * RunningProgramsView is the view screen for viewing whch of selected programs are running.
 * The back button returns the user to the main UI view
 */
public class RunningProgramsView extends Pane {

    public RunningProgramsView() {
        this.setStyle("-fx-background-color: #99aab5;");

        Text title = new Text();
        title.setLayoutY(100);
        title.setLayoutX(50);
        title.setText("Current Programs: ");
        title.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");

        Text discord = new Text();
        discord.setLayoutX(150);
        discord.setLayoutY(230);
        Text chrome = new Text();
        chrome.setLayoutX(150);
        chrome.setLayoutY(340);
        Text notepad = new Text();
        notepad.setLayoutX(150);
        notepad.setLayoutY(450);
        Text explorer = new Text();
        explorer.setLayoutX(150);
        explorer.setLayoutY(560);

        Boolean[] isRunning = RunProgramDetection.ProgramsRunning();
        if (isRunning[0]){
            discord.setText("Discord: Currently running");
            discord.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");
        } else {
            discord.setText("Discord: Not currently running");
            discord.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");
        }

        if (isRunning[1]){
            chrome.setText("Google Chrome: Currently running");
            chrome.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");
        } else {
            chrome.setText("Google Chrome: Not currently running");
            chrome.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");
        }

        if (isRunning[2]){
            notepad.setText("Notepad: Currently running");
            notepad.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");
        } else {
            notepad.setText("Notepad: Not currently running");
            notepad.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");
        }

        if (isRunning[3]){
            explorer.setText("File Explorer: Currently running");
            explorer.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");
        } else {
            explorer.setText("File Explorer: Not currently running");
            explorer.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");
        }

        this.getChildren().addAll(title, discord, chrome, notepad, explorer);

    }

}

package ui;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class AddProfileScreen extends Pane {
    TextField nameTextBox = new TextField();

    public AddProfileScreen() {
        this.setStyle("-fx-background-color: #99aab5;");

        nameTextBox.setLayoutX(60);
        nameTextBox.setLayoutY(375);
        nameTextBox.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; " +
                "-fx-pref-width: 680px; -fx-pref-height: 50px;");

        Label profileNameLabel = new Label("New Profile Name:");
        profileNameLabel.setLayoutX(60);
        profileNameLabel.setLayoutY(325);
        profileNameLabel.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");

        this.getChildren().addAll(nameTextBox, profileNameLabel);
    }

    public String getProfileName() {
        return nameTextBox.getText();
    }

}

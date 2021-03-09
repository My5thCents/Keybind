package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Initialize at main UI screen
        new mainScreen();


    }


    public static void main(String[] args) {
        launch(args);
    }
}

import javafx.application.Application;
import javafx.stage.Stage;
import Controller.RunHotkeys;
import model.OSInterface;
import org.jnativehook.NativeHookException;
import ui.MainScreen;
import model.profiles.commands.saveEverything;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Initialize at main UI screen
        new MainScreen();
        saveEverything start = new saveEverything();
        start.getFromFile();
    }

    public static void main(String[] args) throws NativeHookException, IOException {
        RunHotkeys runHotkeys = new RunHotkeys();
        Thread thread = new Thread(OSInterface.getInstance());
        new Thread(runHotkeys);
        thread.start();
        launch(args);

        OSInterface.getInstance().stop();
        runHotkeys.stop();
    }
}

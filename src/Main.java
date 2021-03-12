import javafx.application.Application;
import javafx.stage.Stage;
import Controller.RunHotkeys;
import model.OSInterface;
import ui.MainScreen;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Initialize at main UI screen
        new MainScreen();


    }


    public static void main(String[] args) {
        RunHotkeys runHotkeys = new RunHotkeys();
        Thread thread = new Thread(OSInterface.getInstance());
        Thread demoThread = new Thread(runHotkeys);
        thread.start();
        demoThread.start();

        launch(args);

        OSInterface.getInstance().stop();
        runHotkeys.stop();
    }
}

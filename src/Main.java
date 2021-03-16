import javafx.application.Application;
import javafx.stage.Stage;
import Controller.RunHotkeys;
import model.OSInterface;
import org.jnativehook.NativeHookException;
import ui.MainScreen;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Initialize at main UI screen
        new MainScreen();


    }


    public static void main(String[] args) throws NativeHookException {
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

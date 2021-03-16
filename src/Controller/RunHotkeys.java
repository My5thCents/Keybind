package Controller;

import model.OSInterface;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import ui.MainScreen;

import static Controller.KeyConversion.map;
import static ui.MainScreen.dict;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class RunHotkeys implements Runnable {
    boolean stop = false;

    public RunHotkeys() throws NativeHookException {
        GlobalScreen.registerNativeHook();

        GlobalScreen.addNativeKeyListener(new KeyListener());
        LogManager.getLogManager().reset();

// Get the logger for "org.jnativehook" and set the level to off.
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
    }

     public void run() {
         while (!stop) {
             }
         }

     public void stop() {
        stop = true;
     }


}

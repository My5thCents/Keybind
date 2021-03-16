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
    /**
     * allows the stopping of the key listener
     */
    boolean stop = false;

    /**
     * Creates a new keylistener
     * @throws NativeHookException
     */
    public RunHotkeys() throws NativeHookException {
        LogManager.getLogManager().reset();

// Get the logger for "org.jnativehook" and set the level to off.
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        GlobalScreen.registerNativeHook();


        GlobalScreen.addNativeKeyListener(new KeyListener());

    }

    /**
     * run until stoppage
     */
     public void run() {
         while (!stop) {
             }
         }

    /**
     * stop the key listener
     */
    public void stop() {
        stop = true;
     }


}

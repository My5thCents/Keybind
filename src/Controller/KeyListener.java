package Controller;

import model.OSInterface;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import static Controller.KeyConversion.map;
import static ui.MainScreen.dict;

public class KeyListener implements NativeKeyListener {
    /**
     * empty constructor
     */
    public KeyListener(){}

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        //if key pressed is in dictionary
        try{
            OSInterface.getInstance().sendKey(dict.get(map.get(nativeKeyEvent.getKeyCode())), true);
        } catch(Exception ignored) {
        }

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }
}

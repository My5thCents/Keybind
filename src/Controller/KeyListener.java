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
        if (dict.containsKey(map.get(nativeKeyEvent.getKeyCode())))
            dict.get(map.get(nativeKeyEvent.getKeyCode())).preformAction();

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }
}

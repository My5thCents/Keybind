package Controller;

import model.OSInterface;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import static Controller.KeyConversion.map;
import static ui.MainScreen.dict;

public class KeyListener implements NativeKeyListener {
    public KeyListener(){}

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        try{
            OSInterface.getInstance().sendKey(dict.get(map.get(nativeKeyEvent.getKeyCode())), true);
        } catch(Exception e) {
            System.out.println(map.get(nativeKeyEvent.getKeyCode()));
        }

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }
}

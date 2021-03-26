package Controller;

import model.OSInterface;
import model.profiles.commands.checkActive;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import static Controller.KeyConversion.map;
import static ui.MainScreen.dict;

public class KeyListener implements NativeKeyListener {


    /**
     * empty constructor
     */
    public KeyListener(){
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        //if key pressed is in dictionary
        checkActive check = new checkActive();
        if (check.CheckActive().hasHotkey(map.get(nativeKeyEvent.getKeyCode())))
            check.CheckActive().getHotKey(map.get(nativeKeyEvent.getKeyCode())).preformAction();
        System.out.println(check.CheckActive().HKeys);

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }
}

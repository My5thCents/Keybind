package Controller;

import model.OSInterface;
import model.profiles.commands.checkActive;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import static Controller.KeyConversion.map;
import static ui.MainScreen.dict;

public class KeyListener implements NativeKeyListener {

    checkActive check;

    /**
     * empty constructor
     */
    public KeyListener(){
        this.check = new checkActive();
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        //if key pressed is in dictionary
        if (this.check.CheckActive().hasHotkey(map.get(nativeKeyEvent.getKeyCode())))
            check.CheckActive().getHotKey(map.get(nativeKeyEvent.getKeyCode())).preformAction();

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }
}

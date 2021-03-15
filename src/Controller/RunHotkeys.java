package Controller;

import model.OSInterface;
import ui.MainScreen;

import java.util.ArrayList;

public class RunHotkeys implements Runnable {
    boolean stop = false;
    ArrayList<Binding> list = MainScreen.list;

    public RunHotkeys() {

    }

     public void run() {
         while (!stop) {
             for (Binding binding : list) {
                 if (OSInterface.getInstance().wasPressed(binding.getID())) {
                     OSInterface.getInstance().sendKey(binding.getActionCode(), true);
                     }
                 }
             }
         }

     public void stop() {
        stop = true;
     }
}

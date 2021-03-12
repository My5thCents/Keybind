package model;

import ui.MainScreen;

import java.util.ArrayList;
import java.util.List;

public class Demo implements Runnable {
    int id;
    boolean stop = false;
    ArrayList<Binding> list = MainScreen.list;

    public Demo() {

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

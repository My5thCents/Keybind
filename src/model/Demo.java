package model;

public class Demo implements Runnable {
    int id = 0;
    boolean stop = false;

    public Demo() {

    }

     public void run() {
         while (!stop) {
             if (OSInterface.getInstance().wasPressed(id)) {

             }
         }
     }

     public void stop() {
        stop = true;
     }
}

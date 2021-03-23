package model;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LaunchApplication {

    /**
     * starts a program at the FilePath location if it isn't already running
     * @param FilePath the absolute file path to the .exe of the program.
     */
    public static void runApplication(String FilePath){
        File application = new File(FilePath);
        String Name = application.getName();

        try {
            boolean alreadyRunning = DetectProgram.isRunning(Name);
            if(alreadyRunning == false){
                Desktop.getDesktop().open(application);
            }
        }
        catch (IOException ex){
            System.out.println(ex.toString());
        }
    }

}

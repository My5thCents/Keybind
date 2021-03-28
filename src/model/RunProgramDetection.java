package model;

import java.util.ArrayList;
import java.util.List;

public class RunProgramDetection {

    private static String[] Supported = {"Discord", "chrome", "notepad", "explorer"};


    public static Boolean[] ProgramsRunning (){

        Boolean[] AreRunning = new Boolean[4];

        for(int i=0; i<4; i=i+1){
            try{
                AreRunning[i]= DetectProgram.isRunning(Supported[i]);
            }
            catch (Exception e){
                System.out.println("something went wrong with RunProgramDetection");
            }
        }

        return AreRunning;
    }

}
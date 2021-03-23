package model;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class DetectProgram {

    public static boolean isRunning(String Name) throws IOException {

        ProcessBuilder processbuildier = new ProcessBuilder("tasklist.exe");
        Process process = processbuildier.start();

        return true;
    }

    public static String toString(InputStream input){
        Scanner scan = new Scanner(input, "UTF-8").useDelimiter("\\A");
        String output = scan.hasNext() ? scan.next() : "";
        scan.close();

        return output;
    }
}

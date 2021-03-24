package model.profiles.commands;
import com.google.gson.*;
import model.profiles.database.profileDatabase;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Going to be used to save all information into a JSON file
 * TODO
 */
public class saveEverything {
    private String j;
    /**
     * Takes our databse and converts it into a string
     */
    public saveEverything(){
        j = profileDatabase.database().toString();
    }

    /**
     * Save everything into file
     */
    public void saveToFile() throws IOException {
        FileWriter file = new FileWriter("save.txt");
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.print(this.j);
        printWriter.close();
    }
    public void getFromFile(){

    }


}

package model.profiles.commands;

/**
 * This is used to handle errors and avoid crashes
 */
public class CommandStatus {
    protected boolean successful = false;
    protected String errorMessage = "No Errors :)";

    public boolean wasSuccessful(){
        return successful;
    }
    public String getErrorMessage(){
        return errorMessage;
    }
}
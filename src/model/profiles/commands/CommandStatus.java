package model.profiles.commands;

/**
 * This is used to handle errors and avoid crashes
 */
public class CommandStatus {
    protected boolean successful = false;
    protected String errorMessage;

    public boolean wasSuccessful(){
        return successful;
    }
    public String getErrorMessage(){
        if(wasSuccessful()){
            throw new RuntimeException("Something went wrong :(");
        }
        return errorMessage;
    }
}
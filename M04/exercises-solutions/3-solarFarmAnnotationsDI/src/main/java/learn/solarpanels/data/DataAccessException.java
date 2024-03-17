package learn.solarpanels.data;

public class DataAccessException extends Exception {
    public DataAccessException(String message) {
        super(message); // if the DataAccessException is thrown it will pass the message to Exception
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause); // this method will run if it gets a message and cause and will pass it up to Exception
    }
}

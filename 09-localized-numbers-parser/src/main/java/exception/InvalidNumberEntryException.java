package exception;

public class InvalidNumberEntryException extends Exception {
    public InvalidNumberEntryException() {
        super();
    }

    public InvalidNumberEntryException(String message) {
        super(message);
    }

    public InvalidNumberEntryException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumberEntryException(Throwable cause) {
        super(cause);
    }

    public InvalidNumberEntryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package exception;

public class InvalidFileException extends Exception {
    public InvalidFileException() {
        super();
    }

    public InvalidFileException(String message) {
        super(message);
    }

    public InvalidFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFileException(Throwable cause) {
        super(cause);
    }

    protected InvalidFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

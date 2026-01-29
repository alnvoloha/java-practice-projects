package exception;

public class InvalidTextException extends RuntimeException {
    public InvalidTextException() {
        super();
    }

    public InvalidTextException(String message) {
        super(message);
    }

    public InvalidTextException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTextException(Throwable cause) {
        super(cause);
    }

    public InvalidTextException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

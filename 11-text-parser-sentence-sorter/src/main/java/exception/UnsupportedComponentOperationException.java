package exception;

public class UnsupportedComponentOperationException extends RuntimeException {
    public UnsupportedComponentOperationException() {
        super();
    }

    public UnsupportedComponentOperationException(String message) {
        super(message);
    }

    public UnsupportedComponentOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedComponentOperationException(Throwable cause) {
        super(cause);
    }

    public UnsupportedComponentOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package exception;

public class TextReadException extends RuntimeException {
    public TextReadException() {
        super();
    }

    public TextReadException(String message) {
        super(message);
    }

    public TextReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextReadException(Throwable cause) {
        super(cause);
    }
}

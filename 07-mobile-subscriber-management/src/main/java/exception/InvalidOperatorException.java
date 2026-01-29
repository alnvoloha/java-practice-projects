package exception;

public class InvalidOperatorException extends RuntimeException {
    public InvalidOperatorException() {
        super("Указан недопустимый оператор.");
    }

    public InvalidOperatorException(String message) {
        super(message);
    }

    public InvalidOperatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOperatorException(Throwable cause) {
        super(cause);
    }
}

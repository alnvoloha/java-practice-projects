package exception;
/**
 * Исключение, выбрасываемое при ошибках создания или валидации товара.
 */

public class InvalidItemException extends Exception {
    public InvalidItemException() {
    }

    public InvalidItemException(String message) {
        super(message);
    }

    public InvalidItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidItemException(Throwable cause) {
        super(cause);
    }

    public InvalidItemException(String message, Throwable cause,
                                boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

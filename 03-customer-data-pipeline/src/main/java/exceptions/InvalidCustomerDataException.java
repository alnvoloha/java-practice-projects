package exceptions;

public class InvalidCustomerDataException extends Exception {

    public InvalidCustomerDataException() {
        super();
    }

    public InvalidCustomerDataException(String message) {
        super(message);
    }

    public InvalidCustomerDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCustomerDataException(Throwable cause) {
        super(cause);
    }

    public InvalidCustomerDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

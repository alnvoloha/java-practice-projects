package exception;

public class NegativeTopUpException extends RuntimeException {
    public NegativeTopUpException() {
        super("Нельзя пополнить счет на отрицательную сумму.");
    }

    public NegativeTopUpException(String message) {
        super(message);
    }

    public NegativeTopUpException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeTopUpException(Throwable cause) {
        super(cause);
    }
}

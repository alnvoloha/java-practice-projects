package exception;

public class InvalidTariffException extends RuntimeException {
    public InvalidTariffException() {
        super("Указан некорректный тарифный план.");
    }

    public InvalidTariffException(String message) {
        super(message);
    }

    public InvalidTariffException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTariffException(Throwable cause) {
        super(cause);
    }
}

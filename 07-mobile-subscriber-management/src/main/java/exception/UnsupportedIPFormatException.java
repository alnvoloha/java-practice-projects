package exception;

public class UnsupportedIPFormatException extends RuntimeException {
    public UnsupportedIPFormatException() {
        super("Неподдерживаемый формат IP-адреса.");
    }

    public UnsupportedIPFormatException(String message) {
        super(message);
    }

    public UnsupportedIPFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedIPFormatException(Throwable cause) {
        super(cause);
    }
}

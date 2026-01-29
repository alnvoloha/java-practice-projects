package exception;

public class ChatException extends Exception {
    public ChatException() { super(); }
    public ChatException(String msg) { super(msg); }
    public ChatException(String msg, Throwable cause) { super(msg, cause); }
    public ChatException(Throwable cause) { super(cause); }
    protected ChatException(String msg, Throwable cause,
                            boolean enableSuppression, boolean writableStackTrace) {
        super(msg, cause, enableSuppression, writableStackTrace);
    }
}

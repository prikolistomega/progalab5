package exceptions;

public class RecursionLimitException extends RuntimeException {
    public RecursionLimitException(String message) {
        super(message);
    }
}

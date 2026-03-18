package exceptions;

public class EmptyDequeException extends RuntimeException {
    public EmptyDequeException(String message) {
        super(message);
    }
}

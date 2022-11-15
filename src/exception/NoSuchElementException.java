package exception;

public class NoSuchElementException extends RuntimeException{
    public NoSuchElementException() {
    }

    public NoSuchElementException(String message) {
        super(message);
    }
}

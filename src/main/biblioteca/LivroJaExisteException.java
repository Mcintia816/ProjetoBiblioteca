package main.biblioteca;

public class LivroJaExisteException extends RuntimeException {
    public LivroJaExisteException(String message) {
        super(message);
    }
}

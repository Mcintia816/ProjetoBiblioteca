package main.biblioteca;

public class LivroNaoExisteException extends RuntimeException {
    public LivroNaoExisteException(String message) {
        super(message);
    }
}
//
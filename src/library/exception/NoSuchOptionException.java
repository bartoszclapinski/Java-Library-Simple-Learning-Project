package library.exception;

public class NoSuchOptionException extends RuntimeException {
    public NoSuchOptionException(String s) {
        System.out.println(s);
    }
}

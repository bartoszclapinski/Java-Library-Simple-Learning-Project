package library.app;

public class LibraryApp {

    private static final String APP_NAME = "Library v1.8";

    public static void main(String[] args) {
        System.out.println(APP_NAME);
        new LibraryControl().controlLoop();
    }
}

package library.app;

public enum Option {
    EXIT(0, "Exit the program"),
    ADD_BOOK(1, "Add new book"),
    PRINT_BOOKS(2, "Print all books"),
    ADD_MAGAZINE(3, "Add new magazine"),
    PRINT_MAGAZINES(4, "Print all magazines");

    private int value;
    private String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static Option createFromInt(int option) {
        return Option.values()[option];
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }
}

package library.app;

import library.exception.NoSuchOptionException;

public enum Option {
    EXIT(0, "Exit the program"),
    ADD_BOOK(1, "Add new book"),
    PRINT_BOOKS(2, "Print all books"),
    ADD_MAGAZINE(3, "Add new magazine"),
    PRINT_MAGAZINES(4, "Print all magazines");

    private final int value;
    private final String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static Option createFromInt(int option) throws NoSuchOptionException {
        try {
            return Option.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("No option with id " + option);
        }
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }
}

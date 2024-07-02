package library.app;

import library.exception.DataImportException;
import library.exception.NoSuchOptionException;
import library.io.ConsolePrinter;
import library.io.DataReader;
import library.io.file.FileManager;
import library.io.file.FileManagerBuilder;
import library.model.Library;
import library.model.Magazine;
import library.model.Publication;
import library.model.comparator.AlphabeticalComparator;

import java.util.Arrays;
import java.util.InputMismatchException;

public class LibraryControl {
    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private final DataReader dataReader = new DataReader(consolePrinter);
    private FileManager fileManager;
    private Library library;

    public LibraryControl() {
        fileManager = new FileManagerBuilder(consolePrinter, dataReader).build();
        try {
            library = fileManager.importData();
            consolePrinter.printLine("Data has been imported from file.");
        } catch (DataImportException e) {
            consolePrinter.printLine(e.getMessage());
            consolePrinter.printLine("New database has been initialized.");
            library = new Library();
        }
    }

    void controlLoop() {
        Option option;
        do {
            printOptions();
            option = getOption();
            switch (option) {
                case ADD_BOOK -> addBook();
                case PRINT_BOOKS -> printBooks();
                case ADD_MAGAZINE -> addMagazine();
                case PRINT_MAGAZINES -> printMagazines();
                case EXIT -> exit();
                case DELETE_BOOK -> deleteBook();
                case DELETE_MAGAZINE -> deleteMagazine();

                default -> consolePrinter.printLine("There is no such option, choose again!");
            }
        } while (option != Option.EXIT);
    }


    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                consolePrinter.printLine("Provide again: ");
            } catch (InputMismatchException e) {
                consolePrinter.printLine("Input is not a number, provide again: ");
            }
        }
        return option;
    }

    private void addMagazine() {
        try {
            library.addPublication(dataReader.readAndCreateMagazine());
        } catch (InputMismatchException e) {
            consolePrinter.printLine("Wrong data entered, try again.");
        } catch (ArrayIndexOutOfBoundsException e) {
            consolePrinter.printLine("Max publications number reached!");
        }
    }

    private void printMagazines() {
            Publication[] publications = getSortedPublications();
            consolePrinter.printMagazines(publications);
        }

    private void exit() {
        try {
            fileManager.exportData(library);
            consolePrinter.printLine("Data exported to file.");
        } catch (DataImportException e) {
            consolePrinter.printLine(e.getMessage());
        }
        consolePrinter.printLine("Bye bye!");
        dataReader.close();
    }

    private void printBooks() {
        Publication[] publications = getSortedPublications();
        consolePrinter.printBooks(publications);
    }

    private Publication[] getSortedPublications() {
        Publication[] publications = library.getPublications();
        Arrays.sort(publications, new AlphabeticalComparator());
        return publications;
    }

    private void addBook() {
        try {
            library.addPublication(dataReader.readAndCreateBook());
        } catch (InputMismatchException e) {
            consolePrinter.printLine("Wrong data entered, try again.");
        } catch (ArrayIndexOutOfBoundsException e) {
            consolePrinter.printLine("Max publications number reached!");
        }
    }

    private void deleteMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            if (library.removePublication(magazine)) consolePrinter.printLine("Magazine deleted.");
            else consolePrinter.printLine("No such magazine in library.");
        } catch (InputMismatchException e) {
            consolePrinter.printLine("Wrong data entered, try again.");
        }
    }

    private void deleteBook() {
        try {
            Publication book = dataReader.readAndCreateBook();
            if (library.removePublication(book)) consolePrinter.printLine("Book deleted.");
            else consolePrinter.printLine("No such book in library.");
        } catch (InputMismatchException e) {
            consolePrinter.printLine("Wrong data entered, try again.");        }

    }

    private void printOptions() {
        System.out.println("Choose option: ");
        for (Option option : Option.values()) {
            consolePrinter.printLine(option.toString());
        }
    }

    private enum Option {
        EXIT(0, "Exit the program"),
        ADD_BOOK(1, "Add new book"),
        PRINT_BOOKS(2, "Print all books"),
        ADD_MAGAZINE(3, "Add new magazine"),
        PRINT_MAGAZINES(4, "Print all magazines"),
        DELETE_BOOK(5, "Delete book"),
        DELETE_MAGAZINE(6, "Delete magazine");

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

}

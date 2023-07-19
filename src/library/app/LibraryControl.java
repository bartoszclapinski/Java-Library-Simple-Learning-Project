package library.app;

import library.io.DataReader;
import library.model.Library;

public class LibraryControl {
    private final DataReader dataReader = new DataReader();
    private final Library library = new Library();

    public void controlLoop() {
        Option option;

        do {
            printOptions();
            option = Option.createFromInt(dataReader.getInt());
            switch (option) {
                case ADD_BOOK -> addBook();
                case PRINT_BOOKS -> printBooks();
                case EXIT -> exit();
                default -> System.out.println("There is no such option, choose again!");
            }
        } while (option != Option.EXIT);
    }

    private void exit() {
        System.out.println("Bye bye!");
        dataReader.close();
    }

    private void printBooks() {
        library.printBooks();
    }

    private void addBook() {
        library.addBook(dataReader.readAndCreateBook());
    }

    private void printOptions() {
        System.out.println("Choose option: ");
        for (Option option : Option.values()) {
            System.out.println(option);
        }
    }
}

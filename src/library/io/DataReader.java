package library.io;

import library.model.Book;
import library.model.Magazine;

import java.util.Scanner;

public class DataReader {
    private final Scanner scanner = new Scanner(System.in);
    ConsolePrinter consolePrinter;

    public DataReader(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public Book readAndCreateBook() {
        consolePrinter.printLine("Title: ");
        String title = scanner.nextLine();
        consolePrinter.printLine("Author: ");
        String author = scanner.nextLine();
        consolePrinter.printLine("Release date: ");
        int releaseDate = getInt();
        consolePrinter.printLine("Pages: ");
        int pages = getInt();
        consolePrinter.printLine("Publisher: ");
        String publisher = scanner.nextLine();
        consolePrinter.printLine("ISBN: ");
        String isbn = scanner.nextLine();

        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        consolePrinter.printLine("Title: ");
        String title = scanner.nextLine();
        consolePrinter.printLine("Publisher: ");
        String publisher = scanner.nextLine();
        consolePrinter.printLine("Release date: ");
        int releaseDate = scanner.nextInt();
        scanner.nextLine();
        consolePrinter.printLine("Month: ");
        int month = getInt();
        consolePrinter.printLine("Day: ");
        int day = getInt();
        consolePrinter.printLine("Language: ");
        String language = scanner.nextLine();

        return new Magazine(title, publisher, releaseDate, month, day, language);
    }

    public int getInt() {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

    public void close() {
        scanner.close();
    }
}

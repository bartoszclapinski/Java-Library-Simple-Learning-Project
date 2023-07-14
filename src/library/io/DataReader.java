package library.io;

import library.model.Book;

import java.util.Scanner;

public class DataReader {
    private final Scanner scanner = new Scanner(System.in);

    public Book readAndCreateBook() {
        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Author: ");
        String author = scanner.nextLine();
        System.out.println("Release date: ");
        int releaseDate = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Pages: ");
        int pages = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Publisher: ");
        String publisher = scanner.nextLine();
        System.out.println("ISBN: ");
        String isbn = scanner.nextLine();

        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public void close() {
        scanner.close();
    }
}

package library.app;

import library.io.DataReader;
import library.model.Book;

public class Library {
    public static void main(String[] args) {
        final String appName = "Library v0.8";
        DataReader dataReader = new DataReader();

        Book[] books = new Book[1000];
        books[0] = dataReader.readAndCreateBook();
        books[1] = dataReader.readAndCreateBook();
        books[2] = dataReader.readAndCreateBook();

        dataReader.close();

        System.out.println(appName);
        System.out.println("Books available in the library:");
        books[0].printInfo();
        books[1].printInfo();
        books[2].printInfo();
    }
}

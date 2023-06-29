package library.app;

import library.model.Book;

public class Library {
    public static void main(String[] args) {
        final String appName = "Library v0.7";

        Book[] books = new Book[1000];

        books[0] = new Book("Java. Effective programming. Guide for the good developer",
                "Joshua Bloch",
                2009,
                352,
                "Helion",
                "978-83-246-1829-1");

        books[1] = new Book("ASP.NET MVC 5. Professional programming in C#",
                "Wojciech Suwała",
                2016,
                1072,
                "Helion",
                "978-83-283-0234-8");

        books[2] = new Book("Thinking in Java",
                "Bruce Eckel",
                2005,
                1168,
                "Helion");

        System.out.println(appName);
        System.out.println("Books available in the library:");
        books[0].printInfo();
        books[1].printInfo();
        books[2].printInfo();
    }
}

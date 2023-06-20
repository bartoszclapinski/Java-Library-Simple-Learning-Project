package library.app;

import library.model.Book;

public class Library {
    public static void main(String[] args) {
        final String appName = "Library v0.5";

        Book book1 = new Book("Java. Effective programming. Guide for the good developer",
                "Joshua Bloch",
                2009,
                352,
                "Helion",
                "978-83-246-1829-1");

        Book book2 = new Book("ASP.NET MVC 5. Professional programming in C#",
                "Wojciech Suwała",
                2016,
                1072,
                "Helion",
                "978-83-283-0234-8");

        Book book3 = new Book("Thinking in Java",
                "Bruce Eckel",
                2005,
                1168,
                "Helion");

        System.out.println(appName);
        System.out.println("Books available in the library:");
        book1.printInfo();
        book2.printInfo();
        book3.printInfo();
    }
}

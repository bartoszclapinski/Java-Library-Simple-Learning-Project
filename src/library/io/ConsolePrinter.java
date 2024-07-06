package library.io;

import library.model.Book;
import library.model.LibraryUser;
import library.model.Magazine;
import library.model.Publication;

import java.util.Collection;

public class ConsolePrinter {

    public void printBooks(Collection<Publication> publications) {
        int count = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                printLine(publication.toString());
                count++;
            }
        }

        if (count == 0) {
            printLine("No books in library!");
        }
    }

    public void printMagazines(Collection<Publication> publications) {
        int count = 0;
        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                printLine(publication.toString());
                count++;
            }
        }

        if (count == 0) {
            printLine("No magazines in library!");
        }
    }

    public void printLine(String text) {
        System.out.println(text);
    }

    public void printUsers(Collection<LibraryUser> users) {
        for (LibraryUser user : users) {
            printLine(user.toString());
        }
    }
}

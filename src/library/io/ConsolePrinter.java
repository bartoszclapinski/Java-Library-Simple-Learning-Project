package library.io;

import library.model.Book;
import library.model.Magazine;
import library.model.Publication;

public class ConsolePrinter {

    public void printBooks(Publication[] publications) {
        int count = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                System.out.println(publication);
                count++;
            }
        }

        if (count == 0) {
            printLine("No books in library!");
        }
    }

    public void printMagazines(Publication[] publications) {
        int count = 0;
        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                System.out.println(publication);
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
}

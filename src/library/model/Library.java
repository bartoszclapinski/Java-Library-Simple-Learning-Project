package library.model;

public class Library {
    private static final int MAX_PUBLICATIONS = 2000;
    private int publicationsNumber = 0;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];

    public void addBook(Book book) {
        if (publicationsNumber < MAX_PUBLICATIONS) {
            publications[publicationsNumber] = book;
            publicationsNumber++;
        } else {
            System.out.println("Max books number reached!");
        }
    }

    public void printBooks() {
        int count = 0;
        for (int i = 0; i < publicationsNumber; i++) {
            if (publications[i] instanceof Book) {
                System.out.println(publications[i]);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No books in library!");
        }
    }

    public void addMagazine(Magazine magazine) {
        if (publicationsNumber < MAX_PUBLICATIONS) {
            publications[publicationsNumber] = magazine;
            publicationsNumber++;
        } else {
            System.out.println("Max magazines number reached!");
        }
    }

    public void printMagazines() {
        int count = 0;
        for (int i = 0; i < publicationsNumber; i++) {
            if (publications[i] instanceof Magazine) {
                System.out.println(publications[i]);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No magazines in library!");
        }
    }

}

package library.model;

public class Library {
    private static final int MAX_PUBLICATIONS = 2000;
    private int publicationsNumber = 0;
    private final Publication[] publications = new Publication[MAX_PUBLICATIONS];

    public void addBook(Book book) {
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationsNumber];
        System.arraycopy(publications, 0, result, 0, result.length);
        return result;
    }

    private void addPublication(Publication publication) {
        if (publicationsNumber >= MAX_PUBLICATIONS) {
            throw new ArrayIndexOutOfBoundsException("Max publications number reached!");
        }
        publications[publicationsNumber] = publication;
        publicationsNumber++;
    }
}

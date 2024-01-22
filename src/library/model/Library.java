package library.model;

import java.io.Serializable;

public class Library implements Serializable {
    private static final int MAX_PUBLICATIONS = 2000;
    private int publicationsNumber = 0;
    private final Publication[] publications = new Publication[MAX_PUBLICATIONS];

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationsNumber];
        System.arraycopy(publications, 0, result, 0, result.length);
        return result;
    }

    public void addPublication(Publication publication) {
        if (publicationsNumber >= MAX_PUBLICATIONS) {
            throw new ArrayIndexOutOfBoundsException("Max publications number reached!");
        }
        publications[publicationsNumber] = publication;
        publicationsNumber++;
    }
}

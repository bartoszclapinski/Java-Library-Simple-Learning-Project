package library.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryUser extends User {
    private final List<Publication> publicationHistory = new ArrayList<>();
    private final List<Publication> borrowedPublications = new ArrayList<>();

    public LibraryUser(String firstName, String lastName, String pesel) {
        super(firstName, lastName, pesel);
    }

    @Override
    public String toCsv() {
        return getFirstName() + ";" + getLastName() + ";" + getPesel() + ";";
    }

    public List<Publication> getPublicationHistory() {
        return publicationHistory;
    }

    public List<Publication> getBorrowedPublications() {
        return borrowedPublications;
    }

    public void addPublicationToHistory(Publication publication) {
        publicationHistory.add(publication);
    }

    public void borrowPublication(Publication publication) {
        borrowedPublications.add(publication);
    }

    public boolean returnPublication(Publication publication) {
        if (borrowedPublications.contains(publication)) {
            borrowedPublications.remove(publication);
            addPublicationToHistory(publication);
            return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LibraryUser that = (LibraryUser) o;
        return Objects.equals(getPublicationHistory(), that.getPublicationHistory()) && Objects.equals(getBorrowedPublications(), that.getBorrowedPublications());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPublicationHistory(), getBorrowedPublications());
    }
}

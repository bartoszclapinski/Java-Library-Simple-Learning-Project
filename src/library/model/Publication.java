package library.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public abstract class Publication implements Serializable, Comparable<Publication> {
    private int year;
    private String title;
    private String publisher;
    private int copies;

    public Publication(int year, String title, String publisher) {
        this.year = year;
        this.title = title;
        this.publisher = publisher;
        this.copies = 1;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public abstract String toCsv();

    /*
        @Overriding
     */

    @Override
    public String toString() {
        return "Publication{" +
                "year=" + year +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return getYear() == that.getYear() && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getPublisher(), that.getPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getTitle(), getPublisher());
    }

    @Override
    public int compareTo(Publication o) {
        return title.compareToIgnoreCase(o.title);
    }


}

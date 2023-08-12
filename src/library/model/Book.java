package library.model;

import java.util.Objects;

public class Book extends Publication{
    private String author;
    private int pages;
    private String isbn;

    public Book(String title, String author, int releaseDate, int pages, String publisher, String isbn) {
        super(releaseDate, title, publisher);
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /*
        @Overriding
     */

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", pages=" + pages +
                ", isbn='" + isbn + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return getPages() == book.getPages() && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getIsbn(), book.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAuthor(), getPages(), getIsbn());
    }
}

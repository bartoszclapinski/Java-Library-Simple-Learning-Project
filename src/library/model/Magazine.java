package library.model;

import java.util.Objects;

public class Magazine extends Publication{
    private int month;
    private int day;
    private String language;
    public static final String TYPE = "Magazine";

    public Magazine(String title, String publisher, int year, int month, int day, String language) {
        super(year, title, publisher);
        this.month = month;
        this.day = day;
        this.language = language;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /*
        @Overriding
     */

    @Override
    public String toCsv() {
        return TYPE + ";" +
                getTitle() + ";" +
                getPublisher() + ";" +
                getYear() + ";" +
                getMonth() + ";" +
                getDay() + ";" +
                getLanguage();
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "month=" + month +
                ", day=" + day +
                ", language='" + language + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return getMonth() == magazine.getMonth() && getDay() == magazine.getDay() && Objects.equals(getLanguage(), magazine.getLanguage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMonth(), getDay(), getLanguage());
    }
}

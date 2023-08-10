package library.model;

public class Magazine extends Publication{
    private int month;
    private int day;
    private String language;

    public Magazine(String title, String publisher, int year, int month, int day, String language) {
        super(year, title, publisher);
        this.month = month;
        this.day = day;
        this.language = language;
    }

    @Override
    public void printInfo() {
        String info = getTitle() + "; " + getPublisher() + "; " + getYear() + "-" + month + "-" + day;
        if (language != null) info = info + "; " + language;
        System.out.println(info);
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
}

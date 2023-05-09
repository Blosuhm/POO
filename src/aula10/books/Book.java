package aula10.books;

public class Book implements Comparable<Book> {

    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        validate(title, author, year);
        this.title = title;
        this.author = author;
        this.year = year;
    }

    private static void validate(String title, String author, int year) {
        validateString(title);
        validateString(author);
        validateYear(year);
    }

    private static void validateString(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("String is null or empty");
        }
    }

    private static void validateYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Year is negative");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("Book: %s, by %s (%d)", title, author, year);
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.title);
    }
}

package library.entity;

import java.util.Objects;

public class Book {
    private final String title;
    private final BookType type;

    public Book(String title, BookType type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public BookType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[" + title + " - " + type + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(title, book.title) && type == book.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type);
    }
}

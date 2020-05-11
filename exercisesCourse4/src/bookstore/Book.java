package bookstore;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int pageCount;

    public Book(String title, String author, String publisher, int pageCount) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pageCount == book.pageCount &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publisher, pageCount);
    }


    @Override
    public String toString() {
        return "BOOK_TITLE: [" + title.toUpperCase() + "]\n" +
                "BOOk_AUTHOR: [" + author + "]\n" +
                "BOOK_PUBLISHER: [" + publisher.toLowerCase() + "]\n";
    }
}

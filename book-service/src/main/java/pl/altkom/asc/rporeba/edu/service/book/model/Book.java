package pl.altkom.asc.rporeba.edu.service.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Book {

    private Long id;
    private String isbn;
    private String bookTitle;
    private Long numberOfPage;

    public Book() {
    }

    public Book(Long id, String isbn, String bookTitle, Long numberOfPage) {
        this.id = id;
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.numberOfPage = numberOfPage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Long getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(Long numberOfPage) {
        this.numberOfPage = numberOfPage;
    }
}

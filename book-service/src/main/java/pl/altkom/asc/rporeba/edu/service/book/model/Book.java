package pl.altkom.asc.rporeba.edu.service.book.model;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Book {

    private Long id;
    private String isbn;
    private String bookTitle;
    private Long numberOfPage;
    private List<Recommendation> recommendations = Lists.newArrayList();
    private List<Renting> rentings = Lists.newArrayList();

    public Book(Long id, String isbn, String bookTitle, Long numberOfPage) {
        this.id = id;
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.numberOfPage = numberOfPage;
    }

}

package pl.altkom.asc.rporeba.edu.service.book.model;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.altkom.asc.rporeba.edu.service.recommendation.model.Recommendation;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Book {

    private Long id;
    private String isbn;
    private String bookTitle;
    private Long numberOfPage;
    private Set<Recommendation> recommendations = Sets.newHashSet();

    public Book(Long id, String isbn, String bookTitle, Long numberOfPage) {
        this.id = id;
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.numberOfPage = numberOfPage;
    }

}

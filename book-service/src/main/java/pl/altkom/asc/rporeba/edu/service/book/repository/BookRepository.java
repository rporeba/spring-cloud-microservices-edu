package pl.altkom.asc.rporeba.edu.service.book.repository;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.altkom.asc.rporeba.edu.service.book.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookRepository {

    private List<Book> books = Lists.newArrayList();

    public Book findById(Long id) {
        Optional<Book> book = repository().books.stream().filter(a -> a.getId().equals(id)).findFirst();
        if (book.isPresent())
            return book.get();
        else
            return null;
    }

    public List<Book> findAll() {
        return repository().books;
    }

//    public List<Book> findByBorrowId(Long borrowId) {
//        return repository().books.stream().filter(a -> a.getDepartmentId().equals(borrowId)).collect(Collectors.toList());
//    }

    public Book add(Book book) {
        book.setId((long) (books.size()+1));
        books.add(book);
        return book;
    }

    @Bean
    BookRepository repository() {
        BookRepository repository = new BookRepository();
        repository.add(new Book(1L, "9788328308497", "Spring w Akcji", 450L ));
        repository.add(new Book(2L, "6255322423423", "Java 8", 300L ));
        repository.add(new Book(3L, "9085673458745", "Czysty Kod", 380L ));
        return repository;
    }
}

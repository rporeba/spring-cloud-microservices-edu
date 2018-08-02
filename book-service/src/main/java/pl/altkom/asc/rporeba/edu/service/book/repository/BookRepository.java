package pl.altkom.asc.rporeba.edu.service.book.repository;

import com.google.common.collect.Lists;
import pl.altkom.asc.rporeba.edu.service.book.model.Book;

import java.util.List;
import java.util.Optional;

public class BookRepository {

    private List<Book> books = Lists.newArrayList();

    public Book findById(Long id) {
        Optional<Book> book = books.stream().filter(a -> a.getId().equals(id)).findFirst();
        if (book.isPresent())
            return book.get();
        else
            return null;
    }

    public List<Book> findAll() {
        return books;
    }

    public Book add(Book book) {
        book.setId((long) (books.size()+1));
        books.add(book);
        return book;
    }

    public Book deleteBook(Book book) {
        book.setId((long) (books.size()-1));
        books.remove(book);
        return book;
    }

}

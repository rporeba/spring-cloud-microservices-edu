package pl.altkom.asc.rporeba.edu.service.book.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.altkom.asc.rporeba.edu.service.book.model.Book;
import pl.altkom.asc.rporeba.edu.service.book.repository.BookRepository;

import java.util.List;

@RestController
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable("id") Long id) {
        LOGGER.info("Book find: id={}", id);
        return bookRepository.findById(id);
    }

    @GetMapping("/")
    public List<Book> findAll() {
        LOGGER.info("Books find");
        return bookRepository.findAll();
    }

//    @GetMapping("/borrow/{borrowId}")
//    public List findByBorrow(@PathVariable("borrowId") Long borrowId) {
//        LOGGER.info("Employee find: borrowId={}", borrowId);
//        return bookRepository.findByborrowId(borrowId);
//    }
}

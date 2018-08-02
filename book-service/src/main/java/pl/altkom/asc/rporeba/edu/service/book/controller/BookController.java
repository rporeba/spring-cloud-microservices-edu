package pl.altkom.asc.rporeba.edu.service.book.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.altkom.asc.rporeba.edu.service.book.client.RecommendationClient;
import pl.altkom.asc.rporeba.edu.service.book.client.RentingClient;
import pl.altkom.asc.rporeba.edu.service.book.model.Book;
import pl.altkom.asc.rporeba.edu.service.book.repository.BookRepository;

import java.util.List;

@RestController
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    private final BookRepository bookRepository;
    private final RecommendationClient recommendationClient;
    private final RentingClient rentingClient;

    @Autowired
    public BookController(BookRepository bookRepository, RecommendationClient recommendationClient, RentingClient rentingClient) {
        this.bookRepository = bookRepository;
        this.recommendationClient = recommendationClient;
        this.rentingClient = rentingClient;
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

    @GetMapping("/{id}/with-recommendation")
    public Book findBookByIdWithRecommendation(@PathVariable("id") Long id) {
        LOGGER.info("Book find: id={}", id);
        Book book = bookRepository.findById(id);
        book.setRecommendations(recommendationClient.findRecommendationByBookId(book.getId()));
        return book;
    }

    @GetMapping("/{id}/with-renting")
    public Book findBookByIdWithRenting(@PathVariable("id") Long id) {
        LOGGER.info("Book find: id={}", id);
        Book book = bookRepository.findById(id);
        book.setRentings(rentingClient.findRentingByBookId(book.getId()));
        return book;
    }

    @GetMapping("/{id}/with-renting-and-recommendation")
    public Book findBookByIdWithRentingAndRecommendation(@PathVariable("id") Long id) {
        LOGGER.info("Book find: id={}", id);
        Book book = bookRepository.findById(id);
        book.setRentings(rentingClient.findRentingWithRecommendationByBookId(book.getId()));
        return book;
    }


    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        LOGGER.info("Book add: {}", book);
        return bookRepository.addBook(book);
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public Book addBook(@PathVariable("bookId") Long bookId) {
        LOGGER.info("Book deleted with id: {}", bookId);
        Book book = bookRepository.findById(bookId);
        return bookRepository.deleteBook(book);
    }


}

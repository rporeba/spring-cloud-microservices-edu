package pl.altkom.asc.rporeba.edu.service.renting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.altkom.asc.rporeba.edu.service.renting.client.RecommendationClient;
import pl.altkom.asc.rporeba.edu.service.renting.model.Rent;
import pl.altkom.asc.rporeba.edu.service.renting.repository.RentingRepository;

import java.util.List;

@RestController
public class RentingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RentingController.class);

    private final RentingRepository rentingRepository;
    private final RecommendationClient recommendationClient;

    @Autowired
    public RentingController(RentingRepository rentingRepository, RecommendationClient recommendationClient) {
        this.rentingRepository = rentingRepository;
        this.recommendationClient = recommendationClient;
    }

    @GetMapping("/book/{bookId}")
    public List<Rent> findByBook(@PathVariable("bookId") Long bookId) {
        LOGGER.info("Renting find: bookId={}", bookId);
        return rentingRepository.findByBook(bookId);
    }

    @GetMapping("/book/{bookId}/with-recommendation")
    public List<Rent> findRentingWithRecommendationByBookId(@PathVariable("bookId") Long bookId) {
        LOGGER.info("Renting find: bookId={}", bookId);
        List<Rent> rents = rentingRepository.findByBook(bookId);
        rents.forEach(rent -> rent.setRecommendations(recommendationClient.findRecommendationByRentingId(rent.getId())));
        return rents;
    }
}

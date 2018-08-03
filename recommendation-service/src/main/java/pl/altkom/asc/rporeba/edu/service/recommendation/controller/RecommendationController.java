package pl.altkom.asc.rporeba.edu.service.recommendation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.altkom.asc.rporeba.edu.service.recommendation.model.Recommendation;
import pl.altkom.asc.rporeba.edu.service.recommendation.repository.RecommendationRepository;

import java.util.List;

/**
 * @author rporeba
 */
@RestController
public class RecommendationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecommendationController.class);

    private final RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationController(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @GetMapping("/book/{bookId}")
    public List<Recommendation> findByBook(@PathVariable("bookId") Long bookId) {
        LOGGER.info("Recommendation find: bookId={}", bookId);
        return recommendationRepository.findByBook(bookId);
    }

    @GetMapping("/renting/{rentingId}")
    public List<Recommendation> findByRenting(@PathVariable("rentingId") Long rentingId) {
        LOGGER.info("Recommendation find: rentingId={}", rentingId);
        return recommendationRepository.findByRenting(rentingId);
    }

    @PostMapping("/createRecommendation")
    public Recommendation createRecommendation(@RequestBody Recommendation recommendation){
        LOGGER.info("Recommendation created for book: bookId={}", recommendation.getBookId());
        return recommendationRepository.addRecommendation(recommendation);
    }

}

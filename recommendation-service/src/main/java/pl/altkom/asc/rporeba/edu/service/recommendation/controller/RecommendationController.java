package pl.altkom.asc.rporeba.edu.service.recommendation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.altkom.asc.rporeba.edu.service.recommendation.client.BookClient;

/**
 * @author rporeba
 */
@RestController
public class RecommendationController {

    private final BookClient bookClient;

    @Autowired
    public RecommendationController(BookClient bookClient) {
        this.bookClient = bookClient;
    }


}

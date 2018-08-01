package pl.altkom.asc.rporeba.edu.service.book.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.altkom.asc.rporeba.edu.service.recommendation.model.Recommendation;

import java.util.Set;

/**
 * @author rporeba
 */
@FeignClient(name = "recommendation-service")
public interface RecommendationClient {

    @GetMapping("/book/{bookId}")
    Set<Recommendation> findRecommendationByBookId(@PathVariable("bookId") Long bookId);

}

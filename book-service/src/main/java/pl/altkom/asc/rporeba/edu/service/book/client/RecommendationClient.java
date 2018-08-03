package pl.altkom.asc.rporeba.edu.service.book.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.altkom.asc.rporeba.edu.service.book.model.Recommendation;

import java.util.List;

@FeignClient(name = "recommendation-service")
public interface RecommendationClient {

    @GetMapping("/book/{bookId}")
    List<Recommendation> findRecommendationByBookId(@PathVariable("bookId") Long bookId);

}

package pl.altkom.asc.rporeba.edu.service.renting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.altkom.asc.rporeba.edu.service.renting.model.Recommendation;

import java.util.List;

@FeignClient("recommendation-service")
public interface RecommendationClient {

    @GetMapping("/renting/{rentingId}")
    List<Recommendation> findRecommendationByRentingId(@PathVariable("rentingId") Long rentingId);
}

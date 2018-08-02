package pl.altkom.asc.rporeba.edu.service.book.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.altkom.asc.rporeba.edu.service.book.model.Renting;

import java.util.List;

@FeignClient(name = "renting-service")
public interface RentingClient {

    @GetMapping("/book/{bookId}")
    public List<Renting> findRentingByBookId(@PathVariable("bookId") Long bookId);

    @GetMapping("/book/{bookId}/with-recommendation")
    public List<Renting> findRentingWithRecommendationByBookId(@PathVariable("bookId") Long bookId);

}

package pl.altkom.asc.rporeba.edu.service.book.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.altkom.asc.rporeba.edu.service.renting.Renting;

import java.util.List;

/**
 * @author rporeba
 */
@FeignClient(name = "renting-service")
public interface RentingClient {

    @GetMapping("/book/{bookId}")
    List<Renting> findRentingByBookId(@PathVariable("bookId") Long bookId);

}

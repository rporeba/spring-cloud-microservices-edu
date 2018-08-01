package pl.altkom.asc.rporeba.edu.service.renting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.altkom.asc.rporeba.edu.service.renting.repository.RentingRepository;
import pl.altkom.asc.rporeba.edu.service.renting.model.Rent;

import java.util.List;

@RestController
public class RentingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RentingController.class);

    private final RentingRepository rentingRepository;

    @Autowired
    public RentingController(RentingRepository rentingRepository) {
        this.rentingRepository = rentingRepository;
    }

    @GetMapping("/book/{bookId}")
    public List<Rent> findByRenting(@PathVariable("bookId") Long bookId) {
        LOGGER.info("Renting find: bookId={}", bookId);
        return rentingRepository.findByRenting(bookId);
    }
}

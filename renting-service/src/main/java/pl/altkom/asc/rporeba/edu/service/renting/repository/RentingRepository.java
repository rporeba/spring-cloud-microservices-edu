package pl.altkom.asc.rporeba.edu.service.renting.repository;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.altkom.asc.rporeba.edu.service.renting.model.Rent;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RentingRepository {

    private List<Rent> rents = Lists.newArrayList();

    public Rent add(Rent rent) {
        rent.setId((long) (rents.size()+1));
        rents.add(rent);
        return rent;
    }

    public Rent findById(Long id) {
        Optional<Rent> recommendation = repository().rents.stream().filter(a -> a.getId().equals(id)).findFirst();
        if (recommendation.isPresent())
            return recommendation.get();
        else
            return null;
    }

    public List<Rent> findByBook(Long bookId) {
        return repository().rents.stream().filter(a -> a.getBookId().equals(bookId))
                .collect(Collectors.toList());
    }

    public List<Rent> findAll() {
        return repository().rents;
    }

    @Bean
    RentingRepository repository() {
        RentingRepository repository = new RentingRepository();
        repository.add(new Rent(1L, "Jan Kowalski", 2L));
        repository.add(new Rent(2L, "Anna Nowak" , 2L));
        repository.add(new Rent(3L, "Maria Lewandowska" , 3L));
        return repository;
    }
}

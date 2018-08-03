package pl.altkom.asc.rporeba.edu.service.renting.repository;

import com.google.common.collect.Lists;
import pl.altkom.asc.rporeba.edu.service.renting.model.Rent;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RentingRepository {

    private List<Rent> rents = Lists.newArrayList();

    public Rent addRenting(Rent rent) {
        rent.setId((long) (rents.size()+1));
        rents.add(rent);
        return rent;
    }

    public Rent giveBookBack(Rent rent) {
        rent.setId((long) (rents.size()-1));
        rents.remove(rent);
        return rent;
    }

    public Rent findById(Long id) {
        Optional<Rent> recommendation = rents.stream().filter(a -> a.getId().equals(id)).findFirst();
        if (recommendation.isPresent())
            return recommendation.get();
        else
            return null;
    }

    public List<Rent> findByBook(Long bookId) {
        return rents.stream().filter(a -> a.getBookId().equals(bookId))
                .collect(Collectors.toList());
    }

    public List<Rent> findAll() {
        return rents;
    }


}

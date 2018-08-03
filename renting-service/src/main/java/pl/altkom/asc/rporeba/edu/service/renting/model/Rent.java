package pl.altkom.asc.rporeba.edu.service.renting.model;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Rent {

    private Long id;
    private String borrowerNameAndSurname;
    private Long bookId;
    private List<Recommendation> recommendations = Lists.newArrayList();

    public Rent(Long id, String borrowerNameAndSurname, Long bookId) {
        this.id = id;
        this.borrowerNameAndSurname = borrowerNameAndSurname;
        this.bookId = bookId;
    }
}

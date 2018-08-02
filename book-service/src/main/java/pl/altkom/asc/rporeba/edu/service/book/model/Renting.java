package pl.altkom.asc.rporeba.edu.service.book.model;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Renting {

    private Long id;
    private String borrowerNameAndSurname;
    private List<Recommendation> recommendations = Lists.newArrayList();

    public Renting(Long id, String borrowerNameAndSurname, List<Recommendation> recommendations) {
        this.id = id;
        this.borrowerNameAndSurname = borrowerNameAndSurname;
        this.recommendations = recommendations;
    }
}

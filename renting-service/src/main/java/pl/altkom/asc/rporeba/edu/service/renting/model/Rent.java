package pl.altkom.asc.rporeba.edu.service.renting.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author rporeba
 */
@Getter
@Setter
@NoArgsConstructor
public class Rent {

    private Long id;
    private String borrowerNameAndSurname;
    private Long bookId;

    public Rent(Long id, String borrowerNameAndSurname, Long bookId) {
        this.id = id;
        this.borrowerNameAndSurname = borrowerNameAndSurname;
        this.bookId = bookId;
    }
}

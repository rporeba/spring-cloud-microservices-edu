package pl.altkom.asc.rporeba.edu.service.book.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Recommendation {

    private Long id;
    private int stars;
    private String description;

    public Recommendation(Long id, int stars, String description) {
        this.id = id;
        this.stars = stars;
        this.description = description;
    }
}

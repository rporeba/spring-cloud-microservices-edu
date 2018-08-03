package pl.altkom.asc.rporeba.edu.service.recommendation.model;

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
    private Long bookId;

    public Recommendation(Long id, int stars, String description, Long bookId) {
        this.id = id;
        this.stars = stars;
        this.description = description;
        this.bookId = bookId;
    }
}

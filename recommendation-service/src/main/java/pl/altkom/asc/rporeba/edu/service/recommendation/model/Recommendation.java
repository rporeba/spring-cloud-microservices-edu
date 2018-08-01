package pl.altkom.asc.rporeba.edu.service.recommendation.model;

/**
 * @author rporeba
 */
public class Recommendation {

    private Long id;
    private int stars;
    private String description;

    public Recommendation() {
    }

    public Recommendation(Long id, int stars, String description) {
        this.id = id;
        this.stars = stars;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

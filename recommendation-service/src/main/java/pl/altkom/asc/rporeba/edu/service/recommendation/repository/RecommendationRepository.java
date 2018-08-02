package pl.altkom.asc.rporeba.edu.service.recommendation.repository;

import com.google.common.collect.Lists;
import pl.altkom.asc.rporeba.edu.service.recommendation.model.Recommendation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecommendationRepository {

    private List<Recommendation> recommendations = Lists.newArrayList();

    public Recommendation addRecommendation(Recommendation recommendation) {
        recommendation.setId((long) (recommendations.size()+1));
        recommendations.add(recommendation);
        return recommendation;
    }

    public Recommendation findById(Long id) {
        Optional<Recommendation> recommendation = recommendations.stream().filter(a -> a.getId().equals(id)).findFirst();
        if (recommendation.isPresent())
            return recommendation.get();
        else
            return null;
    }

    public List<Recommendation> findByBook(Long bookId) {
        return recommendations.stream().filter(a -> a.getBookId().equals(bookId))
                .collect(Collectors.toList());
    }

    public List<Recommendation> findByRenting(Long rentingId) {
        return recommendations.stream().filter(a -> a.getBookId().equals(rentingId))
                .collect(Collectors.toList());
    }

    public List<Recommendation> findAll() {
        return recommendations;
    }

}

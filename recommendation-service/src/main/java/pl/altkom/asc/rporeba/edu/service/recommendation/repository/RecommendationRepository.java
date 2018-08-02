package pl.altkom.asc.rporeba.edu.service.recommendation.repository;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.altkom.asc.rporeba.edu.service.recommendation.model.Recommendation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RecommendationRepository {

    private List<Recommendation> recommendations = Lists.newArrayList();

    public Recommendation add(Recommendation recommendation) {
        recommendation.setId((long) (recommendations.size()+1));
        recommendations.add(recommendation);
        return recommendation;
    }

    public Recommendation findById(Long id) {
        Optional<Recommendation> recommendation = repository().recommendations.stream().filter(a -> a.getId().equals(id)).findFirst();
        if (recommendation.isPresent())
            return recommendation.get();
        else
            return null;
    }

    public List<Recommendation> findByBook(Long bookId) {
        return repository().recommendations.stream().filter(a -> a.getBookId().equals(bookId))
                .collect(Collectors.toList());
    }

    public List<Recommendation> findAll() {
        return repository().recommendations;
    }

    @Bean
    RecommendationRepository repository() {
        RecommendationRepository repository = new RecommendationRepository();
        repository.add(new Recommendation(1L, 5, "Książka godna polecenia. Warta swoich pieniędzy", 2L));
        repository.add(new Recommendation(2L, 2, "Nie warto. Szkoda czasu i pieniedzy" , 2L));
        repository.add(new Recommendation(3L, 4, "Polecam!" , 3L));
        return repository;
    }
}

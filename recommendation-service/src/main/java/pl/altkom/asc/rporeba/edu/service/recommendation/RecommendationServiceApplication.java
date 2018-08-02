package pl.altkom.asc.rporeba.edu.service.recommendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import pl.altkom.asc.rporeba.edu.service.recommendation.model.Recommendation;
import pl.altkom.asc.rporeba.edu.service.recommendation.repository.RecommendationRepository;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class RecommendationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecommendationServiceApplication.class, args);
	}

	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("pl.altkom.asc.rporeba.edu.service.recommendation.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Recommendation API").description("Documentation Recommendation API v1.0").build());
	}

	@Bean
	RecommendationRepository repository() {
		RecommendationRepository repository = new RecommendationRepository();
		repository.addRecommendation(new Recommendation(1L, 5, "Książka godna polecenia, warta swoich pieniędzy", 2L));
		repository.addRecommendation(new Recommendation(2L, 2, "Nie warto, szkoda czasu i pieniedzy" , 2L));
		repository.addRecommendation(new Recommendation(3L, 4, "Polecam!" , 3L));
		return repository;
	}
}

package pl.altkom.asc.rporeba.edu.service.renting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import pl.altkom.asc.rporeba.edu.service.renting.model.Rent;
import pl.altkom.asc.rporeba.edu.service.renting.repository.RentingRepository;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class RentingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentingServiceApplication.class, args);
	}

	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("pl.altkom.asc.rporeba.edu.service.renting.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Renting API").description("Renting Book API v1.0").build());
	}

	@Bean
	RentingRepository repository() {
		RentingRepository repository = new RentingRepository();
		repository.addRenting(new Rent(1L, "Jan Kowalski", 2L));
		repository.addRenting(new Rent(2L, "Anna Nowak" , 2L));
		repository.addRenting(new Rent(3L, "Maria Lewandowska" , 3L));
		return repository;
	}
}

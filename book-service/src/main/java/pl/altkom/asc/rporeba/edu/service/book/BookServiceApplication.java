package pl.altkom.asc.rporeba.edu.service.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import pl.altkom.asc.rporeba.edu.service.book.model.Book;
import pl.altkom.asc.rporeba.edu.service.book.repository.BookRepository;
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
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("pl.altkom.asc.rporeba.edu.service.book.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Book API").description("Documentation Book API v1.0").build());
	}

	@Bean
	BookRepository repository() {
		BookRepository repository = new BookRepository();
		repository.add(new Book(1L, "9788328308497", "Spring w Akcji", 450L));
		repository.add(new Book(2L, "6255322423423", "Java 8", 300L));
		repository.add(new Book(3L, "9085673458745", "Czysty Kod", 380L ));
		return repository;
	}
}

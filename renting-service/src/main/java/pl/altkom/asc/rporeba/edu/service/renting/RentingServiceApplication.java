package pl.altkom.asc.rporeba.edu.service.renting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RentingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentingServiceApplication.class, args);
	}
}

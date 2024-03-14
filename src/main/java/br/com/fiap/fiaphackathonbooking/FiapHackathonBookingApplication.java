package br.com.fiap.fiaphackathonbooking;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Swagger OpenApi", version = "1", description = "Fiap-Hackathon-grupo-12"))
@SpringBootApplication
public class FiapHackathonBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiapHackathonBookingApplication.class, args);
	}

}

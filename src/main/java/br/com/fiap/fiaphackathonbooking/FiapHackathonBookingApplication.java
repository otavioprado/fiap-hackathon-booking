package br.com.fiap.fiaphackathonbooking;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "HACKATHON FIAP - BOOKING - Grupo-12", version = "1", description = "Este projeto é um sistema de gestão de hospitalidade, especificamente um sistema de reservas para hotéis. Ele permite aos usuários agendar, buscar a melhor solução custo-benefício e pré-reservar serviços e opções."))
@SpringBootApplication
public class FiapHackathonBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiapHackathonBookingApplication.class, args);
    }

}

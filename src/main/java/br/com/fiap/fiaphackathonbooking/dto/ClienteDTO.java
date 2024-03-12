package br.com.fiap.fiaphackathonbooking.dto;

import br.com.fiap.fiaphackathonbooking.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class ClienteDTO {
    @JsonIgnore // Ignorar o campo "id" na serialização no método POST
    private Long id;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @Size(min = 2, max = 50)
    private String nomeCompleto;

    @Past
    private LocalDate dataNascimento;

    @CPF
    private String cpf;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Email
    @NotBlank
    private String email;

    @NotBlank(message = "Precisa inserir número de telefone")
    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4}-\\d{4}", message = "Número de telefone inválido")
    private String telefone;
    @NotBlank (message = "Precisa inserir País de origem")
    private String paisDeOrigem;
    @NotBlank (message = "Precisa inserir seu endereço")
    private String endereco;

    @JsonProperty // Incluir o campo "id" na serialização no método GET
    public Long getId() {
        return id;
    }

}

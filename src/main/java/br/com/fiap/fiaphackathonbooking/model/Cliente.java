package br.com.fiap.fiaphackathonbooking.model;

import br.com.fiap.fiaphackathonbooking.enums.Sexo;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String cpf;
    private String passaporte;
    private String paisDeOrigem;
    private String endereco;
    private String email;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}

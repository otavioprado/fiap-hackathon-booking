package br.com.fiap.fiaphackathonbooking.model;

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

// TODO: FINALIZAR CLASSE CLIENTE
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private String email;
    private String telefone;

    @OneToOne
    private Endereco endereco;
    private String parentesco;
    @JsonIgnore
    private Long usuario;}
}

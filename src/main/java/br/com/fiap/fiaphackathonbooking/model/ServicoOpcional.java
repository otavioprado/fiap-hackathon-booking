package br.com.fiap.fiaphackathonbooking.model;

import br.com.fiap.fiaphackathonbooking.enums.TipoServico;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ServicoOpcional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double valor;
    @Enumerated(EnumType.STRING)
    private TipoServico tipo; // "Serviço" ou "Item"
}

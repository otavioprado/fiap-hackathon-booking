package br.com.fiap.fiaphackathonbooking.model;

import br.com.fiap.fiaphackathonbooking.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
@ToString
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "data_entrada")
    private LocalDate dataEntrada;

    @Column(name = "data_saida")
    private LocalDate dataSaida;

    @Column(name = "total_pessoas")
    private int totalPessoas;

    @ManyToMany
    @JoinTable(
            name = "reserva_quarto",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "quarto_id")
    )
    private Set<Quarto> quartos = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "reserva_servico_opcional",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_opcional_id")
    )
    private Set<ServicoOpcional> servicosOpcionais = new HashSet<>();

    @Column(name = "valor_total")
    private double valorTotal;

    @Enumerated(EnumType.STRING)
    private Status status;
}


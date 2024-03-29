package br.com.fiap.fiaphackathonbooking.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "total_pessoas")
    private int totalPessoas;

    @Column(name = "total_camas")
    private int totalCamas;

    @Column(name = "outros_moveis")
    private String outrosMoveis;

    @Column(name = "valor_diaria")
    private double valorDiaria;

    @ManyToOne
    @JoinColumn(name = "predio_id")
    private Predio predio;

    @ManyToMany(mappedBy = "quartos")
    private Set<Reserva> reservas = new HashSet<>();

    @Column(name = "blocked_by_admin")
    private boolean isBlockedByAdmin;
}


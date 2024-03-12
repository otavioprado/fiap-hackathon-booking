package br.com.fiap.fiaphackathonbooking.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Predio {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nome")
        private String nome;

        @ManyToOne
        @JoinColumn(name = "localidade_id")
        private Localidade localidade;

        @OneToMany(mappedBy = "predio")
        private List<Quarto> quartos;
}

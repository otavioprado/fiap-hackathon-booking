package br.com.fiap.fiaphackathonbooking.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ReservaDTO {

    @JsonIgnore // Ignorar o campo "id" na serialização no método POST
    private Long id;
    private Long clienteId;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private List<Long> quartosIds;
    private List<String> servicosOpcionais;

    @JsonIgnore // Ignorar o campo "id" na serialização no método POST
    private double valorTotal;

    @JsonProperty // Incluir o campo "id" na serialização no método GET
    public Long getId() {
        return id;
    }

    @JsonProperty // Incluir o campo "valorTotal" na serialização no método GET
    public double getValorTotal() {
        return valorTotal;
    }
}
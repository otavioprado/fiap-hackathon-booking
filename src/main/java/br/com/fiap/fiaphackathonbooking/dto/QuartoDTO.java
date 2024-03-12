package br.com.fiap.fiaphackathonbooking.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuartoDTO {
    @JsonIgnore // Ignorar o campo "id" na serialização no método POST
    private Long id;
    private String tipo;
    private int totalPessoas;
    private int totalCamas;
    private String outrosMoveis;
    private double valorDiaria;

    @JsonProperty // Incluir o campo "id" na serialização no método GET
    public Long getId() {
        return id;
    }
}

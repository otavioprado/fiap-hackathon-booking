package br.com.fiap.fiaphackathonbooking.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PredioDTO {

    @JsonIgnore
    private Long id;
    private String nome;
    private Long localidadeId;

    @JsonProperty
    public Long getId() { return id; }
}

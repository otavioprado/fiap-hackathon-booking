package br.com.fiap.fiaphackathonbooking.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PredioDTO {

    @JsonIgnore
    private Long id;
    @NotBlank(message = "Nome do prédio é obrigatório")
    private String nome;
    @NotNull(message = "Localidade do prédio é obrigatório")
    private Long localidadeId;

    @JsonProperty
    public Long getId() { return id; }
}

package br.com.fiap.fiaphackathonbooking.dto;

import br.com.fiap.fiaphackathonbooking.enums.TipoServico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServicoOpcionalDTO {
    @JsonIgnore // Ignorar o campo "id" na serialização no método POST
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotNull(message = "O valor é obrigatório.")
    @Min(value = 1, message = "O valor deve ser maior ou igual a um.")
    private double valor;

    @NotNull(message = "O tipo é obrigatório.")
    private TipoServico tipo;

    @JsonProperty // Incluir o campo "id" na serialização no método GET
    public Long getId() {
        return id;
    }
}

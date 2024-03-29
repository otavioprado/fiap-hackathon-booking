package br.com.fiap.fiaphackathonbooking.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class QuartoDTO {
    @JsonIgnore // Ignorar o campo "id" na serialização no método POST
    private Long id;

    @NotBlank(message = "Tipo do quarto é obrigatório")
    private String tipo;
    @NotNull(message = "Total de Pessoas é obrigatório")
    @Min(value = 1, message = "O valor deve ser maior ou igual a um.")
    private int totalPessoas;
    @NotNull(message = "Total de Camas é obrigatório")
    @Min(value = 1, message = "O valor deve ser maior ou igual a um.")
    private int totalCamas;
    @NotBlank(message = "Outros móveis é obrigatório")
    private String outrosMoveis;
    @NotNull(message = "Valor da diária é obrigatório")
    private double valorDiaria;
    @NotNull(message = "Id do prédio é obrigatório")
    private Long predioId;
    @JsonIgnore // Ignorar o campo "isBlockedByAdmin" na serialização no método POST
    private boolean isBlockedByAdmin;

    @JsonProperty // Incluir o campo "id" na serialização no método GET
    public Long getId() {
        return id;
    }

    @JsonProperty // Incluir o campo "isBlockedByAdmin" na serialização no método GET
    public boolean isBlockedByAdmin() {
        return isBlockedByAdmin;
    }
}

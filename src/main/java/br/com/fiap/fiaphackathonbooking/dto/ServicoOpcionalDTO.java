package br.com.fiap.fiaphackathonbooking.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ServicoOpcionalDTO {
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotNull(message = "O valor é obrigatório.")
    @Min(value = 1, message = "O valor deve ser maior ou igual a um.")
    private double valor;

    @NotBlank(message = "O tipo é obrigatório.")
    private String tipo;
}

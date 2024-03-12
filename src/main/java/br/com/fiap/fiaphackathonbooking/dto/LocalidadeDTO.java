package br.com.fiap.fiaphackathonbooking.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalidadeDTO {

    @JsonIgnore // Ignorar o campo "id" na serialização no método POST
    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "Amenidades é obrigatório")
    private String amenidades;
    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;
    @NotBlank(message = "CEP é obrigatório")
    private String cep;
    @NotBlank(message = "Número é obrigatório")
    private String numero;
    @NotBlank(message = "Complemento é obrigatório")
    private String complemento;
    @NotBlank(message = "Bairro é obrigatório")
    private String bairro;
    @NotBlank(message = "Cidade é obrigatório")
    private String cidade;
    @NotBlank(message = "Estado é obrigatório")
    private String estado;

    @JsonProperty // Incluir o campo "id" na serialização no método GET
    public Long getId() { return id; }
}

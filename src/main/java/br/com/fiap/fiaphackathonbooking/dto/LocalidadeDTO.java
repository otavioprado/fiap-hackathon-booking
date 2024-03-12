package br.com.fiap.fiaphackathonbooking.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalidadeDTO {

    @JsonIgnore // Ignorar o campo "id" na serialização no método POST
    private Long id;
    private String nome;
    private String amenidades;
    private String endereco;
    private String cep;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    @JsonProperty // Incluir o campo "id" na serialização no método GET
    public Long getId() { return id; }
}

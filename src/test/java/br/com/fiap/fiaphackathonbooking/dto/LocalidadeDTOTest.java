package br.com.fiap.fiaphackathonbooking.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocalidadeDTOTest {

    @Test
    void testGetterAndSetter() {
        LocalidadeDTO localidadeDTO = new LocalidadeDTO();

        Long id = 1L;
        localidadeDTO.setId(id);
        assertEquals(id, localidadeDTO.getId());

        String nome = "Localidade A";
        localidadeDTO.setNome(nome);
        assertEquals(nome, localidadeDTO.getNome());

    }

    @Test
    void testGetterAndSetter2() {
        LocalidadeDTO localidadeDTO = new LocalidadeDTO();

        Long id = 1L;
        localidadeDTO.setId(id);
        assertEquals(id, localidadeDTO.getId());

        String nome = "Localidade A";
        localidadeDTO.setNome(nome);
        assertEquals(nome, localidadeDTO.getNome());

        String amenidades = "Piscina, Academia";
        localidadeDTO.setAmenidades(amenidades);
        assertEquals(amenidades, localidadeDTO.getAmenidades());

        String endereco = "Rua das Flores";
        localidadeDTO.setEndereco(endereco);
        assertEquals(endereco, localidadeDTO.getEndereco());

        String cep = "12345-678";
        localidadeDTO.setCep(cep);
        assertEquals(cep, localidadeDTO.getCep());

        String numero = "123";
        localidadeDTO.setNumero(numero);
        assertEquals(numero, localidadeDTO.getNumero());

        String complemento = "Apto 101";
        localidadeDTO.setComplemento(complemento);
        assertEquals(complemento, localidadeDTO.getComplemento());

        String bairro = "Centro";
        localidadeDTO.setBairro(bairro);
        assertEquals(bairro, localidadeDTO.getBairro());

        String cidade = "São Paulo";
        localidadeDTO.setCidade(cidade);
        assertEquals(cidade, localidadeDTO.getCidade());

        String estado = "SP";
        localidadeDTO.setEstado(estado);
        assertEquals(estado, localidadeDTO.getEstado());
    }
}

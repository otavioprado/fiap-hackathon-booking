package br.com.fiap.fiaphackathonbooking.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PredioDTOTest {

    @Test
    void testGetterAndSetter() {
        PredioDTO predioDTO = new PredioDTO();

        Long id = 1L;
        predioDTO.setId(id);
        assertEquals(id, predioDTO.getId());

        String nome = "Prédio A";
        predioDTO.setNome(nome);
        assertEquals(nome, predioDTO.getNome());
    }
}

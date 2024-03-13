package br.com.fiap.fiaphackathonbooking.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuartoDTOTest {

    @Test
    public void testGetterAndSetter() {
        QuartoDTO quartoDTO = new QuartoDTO();

        Long id = 1L;
        quartoDTO.setId(id);
        assertEquals(id, quartoDTO.getId());

        String tipo = "Suite";
        quartoDTO.setTipo(tipo);
        assertEquals(tipo, quartoDTO.getTipo());
    }
}

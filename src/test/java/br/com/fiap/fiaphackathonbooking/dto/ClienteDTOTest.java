package br.com.fiap.fiaphackathonbooking.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteDTOTest {

    @Test
    void testGetterAndSetter() {
        ClienteDTO clienteDTO = new ClienteDTO();

        Long id = 1L;
        clienteDTO.setId(id);
        assertEquals(id, clienteDTO.getId());

        String nomeCompleto = "Fulano de Tal";
        clienteDTO.setNomeCompleto(nomeCompleto);
        assertEquals(nomeCompleto, clienteDTO.getNomeCompleto());
    }
}

package br.com.fiap.fiaphackathonbooking.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ServicoOpcionalDTOTest {
    @Test
    public void testGetterAndSetter() {
        ServicoOpcionalDTO servicoOpcionalDTO = new ServicoOpcionalDTO();

        Long id = 1L;
        servicoOpcionalDTO.setId(id);
        assertEquals(id, servicoOpcionalDTO.getId());

        String nome = "Serviço A";
        servicoOpcionalDTO.setNome(nome);
        assertEquals(nome, servicoOpcionalDTO.getNome());
    }
}

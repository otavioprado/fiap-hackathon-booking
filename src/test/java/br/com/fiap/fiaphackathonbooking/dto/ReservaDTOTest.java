package br.com.fiap.fiaphackathonbooking.dto;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ReservaDTOTest {

    @Test
    public void testGetterAndSetter() {
        ReservaDTO reservaDTO = new ReservaDTO();

        Long id = 1L;
        reservaDTO.setId(id);
        assertEquals(id, reservaDTO.getId());

        Long clienteId = 2L;
        reservaDTO.setClienteId(clienteId);
        assertEquals(clienteId, reservaDTO.getClienteId());

        LocalDate dataEntrada = LocalDate.now();
        reservaDTO.setDataEntrada(dataEntrada);
        assertEquals(dataEntrada, reservaDTO.getDataEntrada());
    }
}

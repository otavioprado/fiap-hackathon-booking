package br.com.fiap.fiaphackathonbooking.mapper;

import br.com.fiap.fiaphackathonbooking.dto.ClienteDTO;
import br.com.fiap.fiaphackathonbooking.dto.QuartoDTO;
import br.com.fiap.fiaphackathonbooking.enums.Sexo;
import br.com.fiap.fiaphackathonbooking.model.Cliente;
import br.com.fiap.fiaphackathonbooking.model.Quarto;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class QuartoUnitTest {
    @Mock
    private QuartoMapper mapper;

    @Test
    void toDtoShouldReturnExpectedDto() {
        // Open Mockito annotations to use @Mock
        MockitoAnnotations.openMocks(this);

        // Initialize the ServicoOpcional entity
        Quarto quarto = new Quarto();
        quarto.setId(1L);
        quarto.setTipo("Luxo Jack");
        quarto.setTotalPessoas(2);
        quarto.setTotalCamas(1);
        quarto.setOutrosMoveis("1 x Cadeira de escritório, 1 x Mesa de escritório, 1 x TV Led 62 pols, 1 x Frigobar, 1 x Sofá, 2 x Poltronas");
        quarto.setValorDiaria(750.0);


        // Create expected DTO
        QuartoDTO expectedDto = new QuartoDTO();
        expectedDto.setId(1L);
        expectedDto.setTipo("Luxo Jack");
        expectedDto.setTotalPessoas(2);
        expectedDto.setTotalCamas(1);
        expectedDto.setOutrosMoveis("1 x Cadeira de escritório, 1 x Mesa de escritório, 1 x TV Led 62 pols, 1 x Frigobar, 1 x Sofá, 2 x Poltronas");
        expectedDto.setValorDiaria(750.0);


        // Define behaviour of mapper mock
        when(mapper.toDTO(quarto)).thenReturn(expectedDto);

        // Perform actual conversion using mock
        QuartoDTO actualDto = mapper.toDTO(quarto);

        // Assert that the conversion was successful
        assertNotNull(actualDto, "The QuartoDTO não pode ser nulo");
        assertEquals(expectedDto, actualDto, "O DTO resultante não é o esperado");
    }
}

package br.com.fiap.fiaphackathonbooking.mapper;

import br.com.fiap.fiaphackathonbooking.dto.ServicoOpcionalDTO;
import br.com.fiap.fiaphackathonbooking.enums.TipoServico;
import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class ServicoOpcionalMapperUnitTest {

    @Mock
    private ServicoOpcionalMapper mapper;

    @Test
    void toDtoShouldReturnExpectedDto() {
        // Open Mockito annotations to use @Mock
        MockitoAnnotations.openMocks(this);

        // Initialize the ServicoOpcional entity
        ServicoOpcional servicoOpcional = new ServicoOpcional();
        servicoOpcional.setId(1L);
        servicoOpcional.setNome("Some Service");
        servicoOpcional.setValor(100.0);
        servicoOpcional.setTipo(TipoServico.SERVICO);

        // Create expected DTO
        ServicoOpcionalDTO expectedDto = new ServicoOpcionalDTO();
        expectedDto.setId(1L);
        expectedDto.setNome("Some Service");
        expectedDto.setValor(100.0);
        expectedDto.setTipo(TipoServico.ITEM);

        // Define behaviour of mapper mock
        when(mapper.toDTO(servicoOpcional)).thenReturn(expectedDto);

        // Perform actual conversion using mock
        ServicoOpcionalDTO actualDto = mapper.toDTO(servicoOpcional);

        // Assert that the conversion was successful 
        assertNotNull(actualDto, "The ServicoOpcionalDTO should not be null");
        assertEquals(expectedDto, actualDto, "The resulting DTO does not match the expected DTO");
    }
}
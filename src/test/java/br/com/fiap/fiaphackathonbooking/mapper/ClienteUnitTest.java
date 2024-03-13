package br.com.fiap.fiaphackathonbooking.mapper;

import br.com.fiap.fiaphackathonbooking.dto.ClienteDTO;
import br.com.fiap.fiaphackathonbooking.dto.ServicoOpcionalDTO;
import br.com.fiap.fiaphackathonbooking.enums.Sexo;
import br.com.fiap.fiaphackathonbooking.enums.TipoServico;
import br.com.fiap.fiaphackathonbooking.model.Cliente;
import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;
import jakarta.validation.constraints.Past;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class ClienteUnitTest {
    @Mock
    private ClienteMapper mapper;

    @Test
    void toDtoShouldReturnExpectedDto() {
        // Open Mockito annotations to use @Mock
        MockitoAnnotations.openMocks(this);

        // Initialize the ServicoOpcional entity
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNomeCompleto("Jack Sparrow");
        cliente.setDataNascimento(LocalDate.of(2023,04,12));
        cliente.setCpf("48464167040");
        cliente.setSexo(Sexo.MASCULINO);
        cliente.setEmail("jackzinho_matadordedragao@gmail.com");
        cliente.setTelefone("(11) 1234-1234");
        cliente.setPaisDeOrigem("Brasil");
        cliente.setEndereco("Rua dos alfineiros, 61");

        // Create expected DTO
        ClienteDTO expectedDto = new ClienteDTO();
        expectedDto.setId(1L);
        expectedDto.setNomeCompleto("Jack Sparrow");
        expectedDto.setDataNascimento(LocalDate.of(2023,04,12));
        expectedDto.setCpf("48464167040");
        expectedDto.setSexo(Sexo.MASCULINO);
        expectedDto.setEmail("jackzinho_matadordedragao@gmail.com");
        expectedDto.setTelefone("(11) 1234-1234");
        expectedDto.setPaisDeOrigem("Brasil");
        expectedDto.setEndereco("Rua dos alfineiros, 61");

        // Define behaviour of mapper mock
        when(mapper.toDTO(cliente)).thenReturn(expectedDto);

        // Perform actual conversion using mock
        ClienteDTO actualDto = mapper.toDTO(cliente);

        // Assert that the conversion was successful
        assertNotNull(actualDto, "The ClienteDTO não pode ser nulo");
        assertEquals(expectedDto, actualDto, "O DTO resultante não é o esperado");
    }
}

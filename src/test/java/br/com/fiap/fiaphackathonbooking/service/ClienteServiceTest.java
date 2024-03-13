package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.dto.ClienteDTO;
import br.com.fiap.fiaphackathonbooking.exceptions.NotFoundException;
import br.com.fiap.fiaphackathonbooking.model.Cliente;
import br.com.fiap.fiaphackathonbooking.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void atualizarClienteTest() {
        // setting up a mock cliente entity
        Cliente clienteMock = new Cliente();
        clienteMock.setId(1L);
        // creating a clientDTO with updated details
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(1L);
        clienteDTO.setNomeCompleto("Updated Name");
        clienteDTO.setDataNascimento(LocalDate.now());
        clienteDTO.setCpf("12345678901");
        // assuming it to be ENUM of some sort
        // clienteDTO.setSexo(Sex.MALE);
        clienteDTO.setEmail("updated.email@example.com");
        clienteDTO.setTelefone("(12) 3456-7890");
        clienteDTO.setPaisDeOrigem("Updated Country");
        clienteDTO.setEndereco("Updated Address");

        // mocking repository and modelMapper methods
        when(clienteRepository.findById(1L)).thenReturn(java.util.Optional.of(clienteMock));
        when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteMock);

        // call the method to test
        ClienteDTO returnedClienteDTO = clienteService.atualizarCliente(1L, clienteDTO);

        // assertions
        assertEquals(clienteDTO.getId(), returnedClienteDTO.getId(), "The id should match");
        assertEquals(clienteDTO.getNomeCompleto(), returnedClienteDTO.getNomeCompleto(), "The name should be updated and match");
        assertEquals(clienteDTO.getEmail(), returnedClienteDTO.getEmail(), "The email should be updated and match");
    }

    @Test
    void atualizarClienteNotFoundTest() {
        // creating a clientDTO with updated details
        ClienteDTO clienteDTO = new ClienteDTO();

        //Mocking the clienteRepository.findById() method to throw an exception
        when(clienteRepository.findById(1L)).thenThrow(new NotFoundException("Cliente não encontrado com id: " + 1L));

        try {
            // Call the method we are testing
            ClienteDTO returnedClienteDTO = clienteService.atualizarCliente(1L, clienteDTO);
        } catch (Exception e) {
            assertEquals(NotFoundException.class, e.getClass(), "Exception class should match");
            assertEquals("404 Cliente não encontrado com id: 1", e.getMessage(), "Exception message should match");
        }
    }
}
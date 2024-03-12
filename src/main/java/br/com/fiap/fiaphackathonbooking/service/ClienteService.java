package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.dto.ClienteDTO;
import br.com.fiap.fiaphackathonbooking.exceptions.NotFoundException;
import br.com.fiap.fiaphackathonbooking.model.Cliente;
import br.com.fiap.fiaphackathonbooking.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public ClienteDTO adicionarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteRepository.findByCpf(clienteDTO.getCpf())
                .ifPresent(clienteCpf -> {
                    throw new NotFoundException("CPF já cadastrado!: " + clienteDTO.getCpf());
                });
        Cliente novoCliente = clienteRepository.save(cliente);
        return modelMapper.map(novoCliente, ClienteDTO.class);
    }

    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado com id: " + id));
        clienteDTO.setId(id);
        modelMapper.map(clienteDTO, cliente);
        Cliente clienteAtualizado = clienteRepository.save(cliente);
        return modelMapper.map(clienteAtualizado, ClienteDTO.class);
    }

    public void deletarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado com id: " + id));
        clienteRepository.delete(cliente);
    }

    public List<ClienteDTO> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado com id: " + id));
        return modelMapper.map(cliente, ClienteDTO.class);
    }

}

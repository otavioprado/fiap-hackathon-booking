package br.com.fiap.fiaphackathonbooking.service;


import br.com.fiap.fiaphackathonbooking.dto.ClienteDTO;
import br.com.fiap.fiaphackathonbooking.dto.QuartoDTO;
import br.com.fiap.fiaphackathonbooking.exceptions.NotFoundException;
import br.com.fiap.fiaphackathonbooking.model.Cliente;
import br.com.fiap.fiaphackathonbooking.model.Quarto;
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
        clienteRepository.findById(clienteDTO.getClienteId())
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado com id: " + clienteDTO.getPredioId()));
        Quarto novoQuarto = quartoRepository.save(quarto);
        return modelMapper.map(novoQuarto, QuartoDTO.class);
    }

    public QuartoDTO atualizarQuarto(Long id, QuartoDTO quartoDTO) {
        Quarto quarto = quartoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Quarto não encontrado com id: " + id));
        predioRepository.findById(quartoDTO.getPredioId())
                .orElseThrow(() -> new NotFoundException("Prédio não encontrado com id: " + quartoDTO.getPredioId()));
        quartoDTO.setId(id);
        modelMapper.map(quartoDTO, quarto);
        Quarto quartoAtualizado = quartoRepository.save(quarto);
        return modelMapper.map(quartoAtualizado, QuartoDTO.class);
    }

    public void deletarQuarto(Long id) {
        Quarto quarto = quartoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Quarto não encontrado com id: " + id));
        quartoRepository.delete(quarto);
    }

    public List<QuartoDTO> listarTodos() {
        List<Quarto> quartos = quartoRepository.findAll();
        return quartos.stream()
                .map(quarto -> modelMapper.map(quarto, QuartoDTO.class))
                .collect(Collectors.toList());
    }

    public QuartoDTO buscarPorId(Long id) {
        Quarto quarto = quartoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Quarto não encontrado com id: " + id));
        return modelMapper.map(quarto, QuartoDTO.class);
    }

  /*  public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public ServicoOpcional adicionar(Cliente cliente) {   return repository.save(cliente);
    }

    @Transactional
    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado com id: " + id));

        cliente.setNomeCompleto(clienteAtualizado.getNomeCompleto());
                return repository.save(cliente);
    }

    @Transactional
    public void remover(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado com id: " + id));

        repository.delete(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado com id: " + id));
    }

    public ClienteDTO adicionarCliente(ClienteDTO clienteDTO) {
    }
}

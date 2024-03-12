package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.exceptions.NotFoundException;
import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;
import br.com.fiap.fiaphackathonbooking.repository.ServicoOpcionalRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicoOpcionalService {

    private ServicoOpcionalRepository repository;

    public List<ServicoOpcional> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public ServicoOpcional adicionar(ServicoOpcional servicoOpcional) {
        return repository.save(servicoOpcional);
    }

    @Transactional
    public ServicoOpcional atualizar(Long id, ServicoOpcional servicoOpcionalAtualizado) {
        ServicoOpcional servicoOpcional = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Serviço/Opcional não encontrado com id: " + id));

        servicoOpcional.setNome(servicoOpcionalAtualizado.getNome());
        servicoOpcional.setValor(servicoOpcionalAtualizado.getValor());
        servicoOpcional.setTipo(servicoOpcionalAtualizado.getTipo());

        return repository.save(servicoOpcional);
    }

    @Transactional
    public void remover(Long id) {
        ServicoOpcional servicoOpcional = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Serviço/Opcional não encontrado com id: " + id));

        repository.delete(servicoOpcional);
    }

    public ServicoOpcional buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Serviço/Opcional não encontrado com id: " + id));
    }
}

package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.dto.LocalidadeDTO;
import br.com.fiap.fiaphackathonbooking.exceptions.NotFoundException;
import br.com.fiap.fiaphackathonbooking.model.Localidade;
import br.com.fiap.fiaphackathonbooking.repository.LocalidadeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LocalidadeService {

    private final LocalidadeRepository localidadeRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public LocalidadeDTO adicionarLocalidade(LocalidadeDTO localidadeDTO) {
        Localidade localidade = modelMapper.map(localidadeDTO, Localidade.class);
        Localidade novaLocalidade = localidadeRepository.save(localidade);
        return modelMapper.map(novaLocalidade, LocalidadeDTO.class);
    }

    @Transactional
    public LocalidadeDTO atualizarLocalidade(Long id, LocalidadeDTO localidadeDTO) {
        Localidade localidade = localidadeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Localidade não encontrada com id: " + id));
        modelMapper.map(localidadeDTO, localidade);
        Localidade localidadeAtualizada = localidadeRepository.save(localidade);
        return modelMapper.map(localidadeAtualizada, LocalidadeDTO.class);
    }

    @Transactional
    public void deletarLocalidade(Long id) {
        Localidade localidade = localidadeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Localidade não encontrada com id: " + id));
        localidadeRepository.delete(localidade);
    }

    public List<LocalidadeDTO> listarTodos() {
        List<Localidade> localidades = localidadeRepository.findAll();
        return localidades.stream()
                .map(localidade -> modelMapper.map(localidade, LocalidadeDTO.class))
                .collect(Collectors.toList());
    }

    public LocalidadeDTO buscarPorId(Long id) {
        Localidade localidade = localidadeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Localidade não encontrada com id: " + id));
        return modelMapper.map(localidade, LocalidadeDTO.class);
    }
}

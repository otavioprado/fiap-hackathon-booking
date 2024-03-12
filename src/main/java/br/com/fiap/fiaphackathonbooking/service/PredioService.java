package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.dto.PredioDTO;
import br.com.fiap.fiaphackathonbooking.exceptions.NotFoundException;
import br.com.fiap.fiaphackathonbooking.model.Predio;
import br.com.fiap.fiaphackathonbooking.repository.LocalidadeRepository;
import br.com.fiap.fiaphackathonbooking.repository.PredioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PredioService {

    private final PredioRepository predioRepository;
    private final LocalidadeRepository localidadeRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public PredioDTO adicionarPredio(PredioDTO predioDTO) {
        Predio predio = modelMapper.map(predioDTO, Predio.class);
        localidadeRepository.findById(predioDTO.getLocalidadeId())
                .orElseThrow(() -> new NotFoundException("Localidade não encontrada com id: "
                        + predioDTO.getLocalidadeId()));
        Predio novoPredio = predioRepository.save(predio);
        return modelMapper.map(novoPredio, PredioDTO.class);
    }

    @Transactional
    public PredioDTO atualizarPredio(Long id, PredioDTO predioDTO) {
        Predio predio = predioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Predio não encontrado com id: " + id));
        modelMapper.map(predioDTO, predio);
        Predio predioAtualizado = predioRepository.save(predio);
        return modelMapper.map(predioAtualizado, PredioDTO.class);
    }

    @Transactional
    public void deletarPredio(Long id) {
        Predio predio = predioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Predio não encontrado com id: " + id));
        predioRepository.delete(predio);
    }

    public List<PredioDTO> listarTodos() {
        List<Predio> predios = predioRepository.findAll();
        return predios.stream()
                .map(predio -> modelMapper.map(predio, PredioDTO.class))
                .collect(Collectors.toList());
    }

    public PredioDTO buscarPorId(Long id) {
        Predio predio = predioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Predio não encontrado com id: " + id));
        return modelMapper.map(predio, PredioDTO.class);
    }
}

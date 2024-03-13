package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.dto.QuartoDTO;
import br.com.fiap.fiaphackathonbooking.exceptions.NotFoundException;
import br.com.fiap.fiaphackathonbooking.mapper.QuartoMapper;
import br.com.fiap.fiaphackathonbooking.model.Quarto;
import br.com.fiap.fiaphackathonbooking.repository.PredioRepository;
import br.com.fiap.fiaphackathonbooking.repository.QuartoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuartoService {
    private final QuartoRepository quartoRepository;
    private final PredioRepository predioRepository;
    private final ModelMapper modelMapper;
    private final QuartoMapper quartoMapper;

    @Transactional
    public QuartoDTO adicionarQuarto(QuartoDTO quartoDTO) {
        Quarto quarto = modelMapper.map(quartoDTO, Quarto.class);
        predioRepository.findById(quartoDTO.getPredioId())
                .orElseThrow(() -> new NotFoundException("Prédio não encontrado com id: " + quartoDTO.getPredioId()));
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

    public QuartoDTO updateBlockedByAdmin(Long quartoId, boolean blockedByAdmin) {
        Quarto quarto = quartoRepository.findById(quartoId)
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado com o ID: " + quartoId));
        quarto.setBlockedByAdmin(blockedByAdmin);
        Quarto save = quartoRepository.save(quarto);
        return quartoMapper.toDTO(save);
    }
}

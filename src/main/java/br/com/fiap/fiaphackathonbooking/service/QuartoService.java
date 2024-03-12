package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.dto.QuartoDTO;
import br.com.fiap.fiaphackathonbooking.exceptions.NotFoundException;
import br.com.fiap.fiaphackathonbooking.model.Quarto;
import br.com.fiap.fiaphackathonbooking.repository.QuartoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuartoService {
    private final QuartoRepository quartoRepository;
    private final ModelMapper modelMapper;

    public QuartoDTO adicionarQuarto(QuartoDTO quartoDTO) {
        Quarto quarto = modelMapper.map(quartoDTO, Quarto.class);
        Quarto novoQuarto = quartoRepository.save(quarto);
        return modelMapper.map(novoQuarto, QuartoDTO.class);
    }

    public QuartoDTO atualizarQuarto(Long id, QuartoDTO quartoDTO) {
        Quarto quarto = quartoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Quarto não encontrado com id: " + id));
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
}

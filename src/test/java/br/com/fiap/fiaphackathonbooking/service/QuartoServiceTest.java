package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.dto.QuartoDTO;
import br.com.fiap.fiaphackathonbooking.exceptions.NotFoundException;
import br.com.fiap.fiaphackathonbooking.model.Predio;
import br.com.fiap.fiaphackathonbooking.model.Quarto;
import br.com.fiap.fiaphackathonbooking.repository.PredioRepository;
import br.com.fiap.fiaphackathonbooking.repository.QuartoRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuartoServiceTest {

    @InjectMocks
    private QuartoService quartoService;

    @Mock
    private QuartoRepository quartoRepository;

    @Mock
    private PredioRepository predioRepository;

    private static ModelMapper modelMapper;
    private static QuartoDTO quartoDTO;

    @BeforeAll
    public static void setup() {
        modelMapper = new ModelMapper();
        quartoDTO = new QuartoDTO();
        quartoDTO.setId(1L);
        quartoDTO.setTipo("suite");
        quartoDTO.setTotalPessoas(2);
        quartoDTO.setTotalCamas(1);
        quartoDTO.setOutrosMoveis("cabinet");
        quartoDTO.setPredioId(1L);
        quartoDTO.setValorDiaria(200.0);
    }

    @Test
    @DisplayName("Testa a adição de um quarto")
    void deveriaAdicionarQuarto() {
        when(predioRepository.findById(any(Long.class))).thenReturn(Optional.of(new Predio()));
        when(quartoRepository.save(any(Quarto.class))).thenAnswer(i -> {
            Quarto quarto = i.getArgument(0);
            quarto.setId(1L);
            return quarto;
        });

        QuartoDTO savedQuarto = quartoService.adicionarQuarto(quartoDTO);

        assertEquals(quartoDTO.getId(), savedQuarto.getId());
        assertEquals(quartoDTO.getTipo(), savedQuarto.getTipo());
    }

    @Test
    @DisplayName("Testa a falha na adição de um quarto devido à inexistência do predio")
    void naoDeveriaAdicionarQuartoPoisPredioNaoExiste() {
        when(predioRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> quartoService.adicionarQuarto(quartoDTO));
    }

}
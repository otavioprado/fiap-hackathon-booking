package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.dto.PredioDTO;
import br.com.fiap.fiaphackathonbooking.exceptions.NotFoundException;
import br.com.fiap.fiaphackathonbooking.model.Localidade;
import br.com.fiap.fiaphackathonbooking.model.Predio;
import br.com.fiap.fiaphackathonbooking.repository.LocalidadeRepository;
import br.com.fiap.fiaphackathonbooking.repository.PredioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PredioServiceTest {
 
    @InjectMocks
    PredioService predioService;
    
    @Mock
    PredioRepository predioRepository;

    @Mock
    LocalidadeRepository localidadeRepository;

    @Test
    void testAdicionarPredio() {
        PredioDTO input = new PredioDTO();
        input.setId(1L);
        input.setNome("Predio Teste");
        input.setLocalidadeId(1000L);

        Predio mappedPredio = new Predio();
        mappedPredio.setId(input.getId());
        mappedPredio.setNome(input.getNome());

        Predio savedPredio = new Predio();
        savedPredio.setId(mappedPredio.getId());
        savedPredio.setNome(mappedPredio.getNome());

        PredioDTO expected = new PredioDTO();
        expected.setId(savedPredio.getId());
        expected.setNome(savedPredio.getNome());
        
        when(localidadeRepository.findById(anyLong())).thenReturn(Optional.of(new Localidade()));
        when(predioRepository.save(any(Predio.class))).thenReturn(savedPredio);
      
        PredioDTO actual = predioService.adicionarPredio(input);
        
        assertEquals(expected, actual);
        verify(localidadeRepository, times(1)).findById(anyLong());
        verify(predioRepository, times(1)).save(any(Predio.class));
    }

    @Test
    void testAdicionarPredioInvalidLocalidade() {
        PredioDTO input = new PredioDTO();
        input.setId(1L);
        input.setNome("Predio Teste");
        input.setLocalidadeId(1000L);
          
        when(localidadeRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> predioService.adicionarPredio(input));
        
        verify(localidadeRepository, times(1)).findById(anyLong());
        verify(predioRepository, times(0)).save(any(Predio.class));
    }
}
package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.dto.ReservaDTO;
import br.com.fiap.fiaphackathonbooking.mapper.ReservaMapper;
import br.com.fiap.fiaphackathonbooking.repository.ClienteRepository;
import br.com.fiap.fiaphackathonbooking.repository.QuartoRepository;
import br.com.fiap.fiaphackathonbooking.repository.ReservaRepository;
import br.com.fiap.fiaphackathonbooking.repository.ServicoOpcionalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReservaServiceTest {

    @InjectMocks
    private ReservaService reservaService;

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private QuartoRepository quartoRepository;

    @Mock
    private ServicoOpcionalRepository servicoOpcionalRepository;

    @Mock
    private ReservaMapper reservaMapper;

    @Test
    void salvarReserva_InvalidInput_ThrowsDataIntegrityViolationException() {
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setId(1L);
        reservaDTO.setClienteId(1L);
        reservaDTO.setQuartosIds(new ArrayList<>());
        reservaDTO.setServicosOpcionais(new ArrayList<>());
        reservaDTO.setDataEntrada(LocalDate.now());
        reservaDTO.setDataSaida(LocalDate.now().plusDays(7));

        when(clienteRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(DataIntegrityViolationException.class, () -> reservaService.salvarReserva(1L, reservaDTO));
    }

}
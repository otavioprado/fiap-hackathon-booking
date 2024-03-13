package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.dto.ReservaDTO;
import br.com.fiap.fiaphackathonbooking.enums.Status;
import br.com.fiap.fiaphackathonbooking.exceptions.UnprocessableEntityException;
import br.com.fiap.fiaphackathonbooking.mapper.ReservaMapper;
import br.com.fiap.fiaphackathonbooking.model.Reserva;
import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;
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

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

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

    @Test
    void adicionarItemReserva_ValidInput_Success() {
        // Mock do objeto de reserva
        Reserva reserva = new Reserva();
        reserva.setDataEntrada(new Date(System.currentTimeMillis()).toLocalDate());
        reserva.setDataSaida(new Date(System.currentTimeMillis()).toLocalDate());
        reserva.setStatus(Status.CRIADO);

        // Mock do objeto de serviço opcional
        ServicoOpcional servicoOpcional = new ServicoOpcional();
        servicoOpcional.setId(1L);

        // Mock dos repositórios
        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));
        when(servicoOpcionalRepository.findById(1L)).thenReturn(Optional.of(servicoOpcional));

        // Execução do método
        reservaService.adicionarItemReserva(1L, 1L);

        // Verificação
        assertTrue(reserva.getServicosOpcionais().contains(servicoOpcional));
        verify(reservaRepository, times(1)).save(reserva);
    }

    @Test
    void adicionarItemReserva_ReservaAtiva_UnprocessableEntityException() {
        // Mock do objeto de reserva com status diferente de CRIADO
        Reserva reserva = new Reserva();
        reserva.setStatus(Status.CONFIRMADO);

        // Mock dos repositórios
        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));

        // Execução do método e verificação da exceção
        assertThrows(UnprocessableEntityException.class, () -> reservaService.adicionarItemReserva(1L, 1L));
        verify(reservaRepository, never()).save(reserva);
    }

    @Test
    void deletarReserva_ValidInput_Success() {
        // Mock do objeto de reserva
        Reserva reserva = new Reserva();

        // Mock do repositório
        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));

        // Execução do método
        reservaService.deletarReserva(1L);

        // Verificação
        verify(reservaRepository).delete(reserva);
    }

}
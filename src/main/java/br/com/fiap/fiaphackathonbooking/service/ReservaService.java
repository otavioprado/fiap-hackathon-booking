package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.dto.ReservaDTO;
import br.com.fiap.fiaphackathonbooking.mapper.ReservaMapper;
import br.com.fiap.fiaphackathonbooking.model.Quarto;
import br.com.fiap.fiaphackathonbooking.model.Reserva;
import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;
import br.com.fiap.fiaphackathonbooking.repository.ClienteRepository;
import br.com.fiap.fiaphackathonbooking.repository.QuartoRepository;
import br.com.fiap.fiaphackathonbooking.repository.ReservaRepository;
import br.com.fiap.fiaphackathonbooking.repository.ServicoOpcionalRepository;
import br.com.fiap.fiaphackathonbooking.utils.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final ClienteRepository clienteRepository;
    private final QuartoRepository quartoRepository;
    private final ServicoOpcionalRepository servicoOpcionalRepository;
    private final ReservaMapper reservaMapper;

    public ReservaDTO criarReserva(ReservaDTO reservaDTO) {
        if (!clienteRepository.existsById(reservaDTO.getClienteId())) {
            throw new DataIntegrityViolationException("Cliente não encontrado com o ID: " + reservaDTO.getClienteId());
        }

        // Verificação da disponibilidade dos quartos
        for (Long quartoId : reservaDTO.getQuartosIds()) {
            boolean disponivel = quartoRepository.isQuartoDisponivel(quartoId, reservaDTO.getDataEntrada(), reservaDTO.getDataSaida());

            if (!disponivel) {
                throw new RuntimeException("Quarto com ID " + quartoId + " não está disponível nas datas selecionadas.");
            }
        }

        Set<Quarto> quartos = reservaDTO.getQuartosIds().stream()
                .map(quartoId -> quartoRepository.findById(quartoId)
                        .orElseThrow(() -> new RuntimeException("Quarto não encontrado com o ID: " + quartoId)))
                .collect(Collectors.toSet());


        Reserva reserva = reservaMapper.reservaDTOToReserva(reservaDTO);
        reserva.setQuartos(quartos); // Associa os quartos à reserva

        // Buscar e associar Serviços Opcionais
        if (reservaDTO.getServicosOpcionais() != null && !reservaDTO.getServicosOpcionais().isEmpty()) {
            List<ServicoOpcional> servicosOpcionais = new ArrayList<>();
            for (String nomeServico : reservaDTO.getServicosOpcionais()) {
                List<ServicoOpcional> servicosEncontrados = servicoOpcionalRepository.findByNomeLikeIgnoreCase(nomeServico);
                if (servicosEncontrados.isEmpty()) {
                    throw new RuntimeException("Serviço opcional não encontrado: " + nomeServico);
                }
                servicosOpcionais.addAll(servicosEncontrados);
            }
            reserva.setServicosOpcionais(new HashSet<>(servicosOpcionais));
        }

        Reserva novaReserva = reservaRepository.save(reserva);
        return reservaMapper.reservaToReservaDTO(novaReserva);
    }

    public ReservaDTO atualizarReserva(Long id, ReservaDTO reservaDTO) {
        Reserva reservaExistente = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + id));

        Reserva reservaAtualizada = reservaRepository.save(reservaExistente);
        return reservaMapper.reservaToReservaDTO(reservaAtualizada);
    }

    public void cancelarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + id));
        reservaRepository.delete(reserva);
    }

    public List<ReservaDTO> listarTodasReservas() {
        List<Reserva> reservas = reservaRepository.findAll();
        return reservas.stream()
                .map(reservaMapper::reservaToReservaDTO)
                .collect(Collectors.toList());
    }

    public ReservaDTO buscarReservaPorId(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + id));
        return reservaMapper.reservaToReservaDTO(reserva);
    }

    public boolean enviarEmailConfirmacao(Long idReserva) {
        // TODO: implementar a lógica para enviar um email
        return true;
    }
}


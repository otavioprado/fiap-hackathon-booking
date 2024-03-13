package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.dto.ReservaDTO;
import br.com.fiap.fiaphackathonbooking.mapper.ReservaMapper;
import br.com.fiap.fiaphackathonbooking.model.Cliente;
import br.com.fiap.fiaphackathonbooking.model.Quarto;
import br.com.fiap.fiaphackathonbooking.model.Reserva;
import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;
import br.com.fiap.fiaphackathonbooking.repository.ClienteRepository;
import br.com.fiap.fiaphackathonbooking.repository.QuartoRepository;
import br.com.fiap.fiaphackathonbooking.repository.ReservaRepository;
import br.com.fiap.fiaphackathonbooking.repository.ServicoOpcionalRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final ClienteRepository clienteRepository;
    private final QuartoRepository quartoRepository;
    private final ServicoOpcionalRepository servicoOpcionalRepository;
    private final ReservaMapper reservaMapper;
    private final EmailService emailService;

    public ReservaDTO salvarReserva(Long id, ReservaDTO reservaDTO) {
        Optional<Cliente> clientById = clienteRepository.findById(reservaDTO.getClienteId());

        if (clientById.isEmpty()) {
            throw new DataIntegrityViolationException("Cliente não encontrado com o ID: " + reservaDTO.getClienteId());
        }

        // Verificação da disponibilidade dos quartos
        for (Long quartoId : reservaDTO.getQuartosIds()) {
            boolean disponivel = quartoRepository.isQuartoDisponivel(quartoId, reservaDTO.getDataEntrada(), reservaDTO.getDataSaida());

            if (id == null && !disponivel) {
                // se for uma nova reserva, verificar se o quarto está disponível
                throw new RuntimeException("Quarto com ID " + quartoId + " não está disponível nas datas selecionadas.");
            }

            if (id != null) {
                // Se for uma atualização de reserva, verifica se as datas podem ser expandidas ou se irá conflitar com alguma outra reserva que não seja a própria
                Reserva reservaExistente = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + id));

                LocalDate novaDataEntrada = reservaDTO.getDataEntrada();
                LocalDate novaDataSaida = reservaDTO.getDataSaida();

                // Verificar se as novas datas conflitam com outras reservas
                boolean conflitoComOutrasReservas = reservaRepository.existsReservaConflitoOutrasReservas(id, quartoId, novaDataEntrada, novaDataSaida);
                if (conflitoComOutrasReservas) {
                    throw new RuntimeException("As novas datas da reserva conflitam com outra reserva para o Quarto com ID " + quartoId + ".");
                }
            }

            Quarto quarto = quartoRepository.findById(quartoId).orElseThrow(() -> new RuntimeException("Quarto não encontrado com o ID: " + quartoId));
            if (quarto.isBlockedByAdmin()) {
                throw new RuntimeException("Quarto com ID " + quartoId + " não está disponível para reserva, pois foi bloqueado por um administrador.");
            }
        }

        Set<Quarto> quartos = reservaDTO.getQuartosIds().stream()
                .map(quartoId -> quartoRepository.findById(quartoId)
                        .orElseThrow(() -> new RuntimeException("Quarto não encontrado com o ID: " + quartoId)))
                .collect(Collectors.toSet());


        Reserva reserva = reservaMapper.reservaDTOToReserva(reservaDTO);
        reserva.setQuartos(quartos); // Associa os quartos à reserva

        // Calcular o número de dias entre a data de entrada e a data de saída
        long dias = ChronoUnit.DAYS.between(reservaDTO.getDataEntrada(), reservaDTO.getDataSaida());

        // Calcular o valor total dos quartos
        double valorTotalQuartos = quartos.stream().mapToDouble(quarto -> quarto.getValorDiaria() * dias).sum();

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

            // Somar os valores dos serviços opcionais ao valor total
            double valorTotalServicos = servicosOpcionais.stream().mapToDouble(ServicoOpcional::getValor).sum();
            reserva.setValorTotal(valorTotalQuartos + valorTotalServicos);
        } else {
            reserva.setValorTotal(valorTotalQuartos);
        }

        reserva.setCliente(clientById.get());

        Reserva novaReserva;
        if (id != null) {
            // Atualizar reserva existente
            Reserva reservaExistente = reservaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + id));
            reservaExistente.setDataEntrada(reservaDTO.getDataEntrada());
            reservaExistente.setDataSaida(reservaDTO.getDataSaida());
            reservaExistente.setQuartos(reserva.getQuartos());
            reservaExistente.setServicosOpcionais(reserva.getServicosOpcionais());
            reservaExistente.setValorTotal(reserva.getValorTotal());
            novaReserva = reservaRepository.save(reservaExistente);
        } else {
            // Criar nova reserva
            novaReserva = reservaRepository.save(reserva);
        }

        return reservaMapper.reservaToReservaDTO(novaReserva);
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
        Reserva reserva = reservaRepository.findById(idReserva)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + idReserva));

        // Construa o corpo do e-mail
        String destinatario = reserva.getCliente().getEmail();
        String assunto = "Confirmação de Reserva";
        String corpo = "Sua reserva foi confirmada com sucesso! Detalhes:\n" +
                "ID da Reserva: " + reserva.getId() + "\n" +
                "Data de Entrada: " + reserva.getDataEntrada() + "\n" +
                "Data de Saída: " + reserva.getDataSaida() + "\n" +
                "Valor Total: " + reserva.getValorTotal();

        // Envie o e-mail de confirmação
        emailService.enviarEmailConfirmacao(destinatario, assunto, corpo);

        return true;
    }
}


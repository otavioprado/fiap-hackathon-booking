package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.dto.ReservaDTO;
import br.com.fiap.fiaphackathonbooking.model.Reserva;
import br.com.fiap.fiaphackathonbooking.repository.ClienteRepository;
import br.com.fiap.fiaphackathonbooking.repository.ReservaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    public ReservaDTO criarReserva(ReservaDTO reservaDTO) {
        if (!clienteRepository.existsById(reservaDTO.getClienteId())) {
            throw new DataIntegrityViolationException("Cliente não encontrado com o ID: " + reservaDTO.getClienteId());
        }

        Reserva reserva = modelMapper.map(reservaDTO, Reserva.class);
        Reserva novaReserva = reservaRepository.save(reserva);
        return modelMapper.map(novaReserva, ReservaDTO.class);
    }

    public ReservaDTO atualizarReserva(Long id, ReservaDTO reservaDTO) {
        Reserva reservaExistente = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + id));
        // Aqui você pode atualizar os campos de reservaExistente com os valores de reservaDTO
        Reserva reservaAtualizada = reservaRepository.save(reservaExistente);
        return modelMapper.map(reservaAtualizada, ReservaDTO.class);
    }

    public void cancelarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + id));
        reservaRepository.delete(reserva);
    }

    public List<ReservaDTO> listarTodasReservas() {
        List<Reserva> reservas = reservaRepository.findAll();
        return reservas.stream()
                .map(reserva -> modelMapper.map(reserva, ReservaDTO.class))
                .collect(Collectors.toList());
    }

    public ReservaDTO buscarReservaPorId(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + id));
        return modelMapper.map(reserva, ReservaDTO.class);
    }

    public boolean enviarEmailConfirmacao(Long idReserva) {
        // TODO: implementar a lógica para enviar um email
        return true;
    }
}


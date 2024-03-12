package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.ReservaDTO;
import br.com.fiap.fiaphackathonbooking.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> criarReserva(@RequestBody ReservaDTO reservaDTO) {
        ReservaDTO novaReserva = reservaService.criarReserva(reservaDTO);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> atualizarReserva(@PathVariable Long id, @RequestBody ReservaDTO reservaDTO) {
        ReservaDTO reservaAtualizada = reservaService.atualizarReserva(id, reservaDTO);
        return ResponseEntity.ok(reservaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarReserva(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> listarReservas() {
        // Método para listar todas as reservas ou com filtros específicos
        return ResponseEntity.ok(reservaService.listarTodasReservas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> buscarReservaPorId(@PathVariable Long id) {
        ReservaDTO reserva = reservaService.buscarReservaPorId(id);
        return ResponseEntity.ok(reserva);
    }

    // Aqui você pode adicionar outros endpoints conforme necessário, como verificar disponibilidade, calcular valores, etc.

    // Endpoint simulado para enviar email de confirmação (exemplo simplificado)
    @PostMapping("/enviarEmail/{idReserva}")
    public ResponseEntity<String> enviarEmailConfirmacao(@PathVariable Long idReserva) {
        // Simulação do envio de email
        boolean emailEnviado = reservaService.enviarEmailConfirmacao(idReserva);
        if (emailEnviado) {
            return ResponseEntity.ok("Email de confirmação enviado.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao enviar email.");
        }
    }
}

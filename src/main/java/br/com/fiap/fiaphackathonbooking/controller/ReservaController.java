package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.ReservaDTO;
import br.com.fiap.fiaphackathonbooking.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
@Tag(name = "Reservas", description = "API de Reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @Operation(summary = "Adiciona um item a uma Reserva")
    @PostMapping("/{id}/adicionar-item/{idItem}")
    public ResponseEntity<Void> adicionarItemReserva(@PathVariable Long id, @PathVariable Long idItem) {
        reservaService.adicionarItemReserva(id, idItem);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Remove um item de uma Reserva")
    @PostMapping("/{id}/remover-item/{idItem}")
    public ResponseEntity<Void> removeItemReserva(@PathVariable Long id, @PathVariable Long idItem) {
        reservaService.removeItemReserva(id, idItem);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Cancela uma Reserva")
    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarReserva(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Confirma uma Reserva")
    @PostMapping("/{id}/confirmar")
    public ResponseEntity<Void> confirmarReserva(@PathVariable Long id) {
        reservaService.confirmarReserva(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Cria uma nova Reserva")
    @PostMapping
    public ResponseEntity<ReservaDTO> criarReserva(@RequestBody ReservaDTO reservaDTO) {
        ReservaDTO novaReserva = reservaService.salvarReserva(null, reservaDTO);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
    }

    @Operation(summary = "Atualiza uma Reserva")
    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> atualizarReserva(@PathVariable Long id, @RequestBody ReservaDTO reservaDTO) {
        ReservaDTO reservaAtualizada = reservaService.salvarReserva(id, reservaDTO);
        return ResponseEntity.ok(reservaAtualizada);
    }

    @Operation(summary = "Deleta uma Reserva")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReserva(@PathVariable Long id) {
        reservaService.deletarReserva(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Lista todas as Reservas")
    @GetMapping
    public ResponseEntity<?> listarReservas() {
        return ResponseEntity.ok(reservaService.listarTodasReservas());
    }

    @Operation(summary = "Busca uma Reserva por id")
    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> buscarReservaPorId(@PathVariable Long id) {
        ReservaDTO reserva = reservaService.buscarReservaPorId(id);
        return ResponseEntity.ok(reserva);
    }
    @Operation(summary = "Envia um E-mail de Confirmação para o Cliente")
    @PostMapping("/{id}/enviar-email")
    public ResponseEntity<String> enviarEmailConfirmacao(@PathVariable Long id) {
        // Simulação do envio de email
        boolean emailEnviado = reservaService.enviarEmailConfirmacao(id);
        if (emailEnviado) {
            return ResponseEntity.ok("Email de confirmação enviado.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao enviar email.");
        }
    }
}

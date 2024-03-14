package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.QuartoDTO;
import br.com.fiap.fiaphackathonbooking.model.Quarto;
import br.com.fiap.fiaphackathonbooking.service.QuartoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quartos")
@AllArgsConstructor
@Tag(name = "Quarto", description = "API de Quartos")
public class QuartoController {

    private final QuartoService quartoService;

    @PostMapping
    public ResponseEntity<QuartoDTO> adicionarQuarto(@RequestBody @Valid QuartoDTO quartoDTO) {
        QuartoDTO novoQuarto = quartoService.adicionarQuarto(quartoDTO);
        return new ResponseEntity<>(novoQuarto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuartoDTO> atualizarQuarto(@PathVariable Long id, @RequestBody @Valid QuartoDTO quartoDTO) {
        QuartoDTO atualizado = quartoService.atualizarQuarto(id, quartoDTO);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarQuarto(@PathVariable Long id) {
        quartoService.deletarQuarto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<QuartoDTO>> listarTodosOsQuartos() {
        List<QuartoDTO> quartos = quartoService.listarTodos();
        return ResponseEntity.ok(quartos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuartoDTO> buscarQuartoPorId(@PathVariable Long id) {
        QuartoDTO quarto = quartoService.buscarPorId(id);
        return ResponseEntity.ok(quarto);
    }

    @PostMapping("/{quartoId}/admin/bloquear")
    public ResponseEntity<QuartoDTO> bloquearQuartoPorAdmin(@PathVariable Long quartoId) {
        QuartoDTO quartoDTO = quartoService.updateBlockedByAdmin(quartoId, true);
        return ResponseEntity.ok(quartoDTO);
    }

    @PostMapping("/{quartoId}/admin/desbloquear")
    public ResponseEntity<QuartoDTO> desbloquearQuartoPorAdmin(@PathVariable Long quartoId) {
        QuartoDTO quartoDTO = quartoService.updateBlockedByAdmin(quartoId, false);
        return ResponseEntity.ok(quartoDTO);
    }
}

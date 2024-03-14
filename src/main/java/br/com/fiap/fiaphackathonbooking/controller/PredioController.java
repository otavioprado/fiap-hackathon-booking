package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.PredioDTO;
import br.com.fiap.fiaphackathonbooking.service.PredioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/predios")
@AllArgsConstructor
@Tag(name = "Prédios", description = "API de Prédios")
public class PredioController {

    private final PredioService predioService;

    @Operation(summary = "Adiciona um Prédio")
    @PostMapping
    public ResponseEntity<PredioDTO> adicionarPredio(@RequestBody @Valid PredioDTO predioDTO) {
        PredioDTO novoPredio = predioService.adicionarPredio(predioDTO);
        return new ResponseEntity<>(novoPredio, HttpStatus.CREATED);
    }

    @Operation(summary = "Atualiza um Prédio")
    @PutMapping("/{id}")
    public ResponseEntity<PredioDTO> atualizarPredio(@PathVariable Long id, @RequestBody @Valid PredioDTO predioDTO) {
        PredioDTO atualizado = predioService.atualizarPredio(id, predioDTO);
        return ResponseEntity.ok(atualizado);
    }

    @Operation(summary = "Deleta um Prédio")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPredio(@PathVariable Long id) {
        predioService.deletarPredio(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Lista todos os Prédios")
    @GetMapping
    public ResponseEntity<List<PredioDTO>> listarTodosOsPredios() {
        List<PredioDTO> predios = predioService.listarTodos();
        return ResponseEntity.ok(predios);
    }

    @Operation(summary = "Busca um Prédio por id")
    @GetMapping("/{id}")
    public ResponseEntity<PredioDTO> buscarPredioPorId(@PathVariable Long id) {
        PredioDTO predio = predioService.buscarPorId(id);
        return ResponseEntity.ok(predio);
    }
}

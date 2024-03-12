package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.PredioDTO;
import br.com.fiap.fiaphackathonbooking.service.PredioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/predios")
@AllArgsConstructor
public class PredioController {

    private final PredioService predioService;

    @PostMapping
    public ResponseEntity<PredioDTO> adicionarPredio(@RequestBody @Valid PredioDTO predioDTO) {
        PredioDTO novoPredio = predioService.adicionarPredio(predioDTO);
        return new ResponseEntity<>(novoPredio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PredioDTO> atualizarPredio(@PathVariable Long id, @RequestBody @Valid PredioDTO predioDTO) {
        PredioDTO atualizado = predioService.atualizarPredio(id, predioDTO);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPredio(@PathVariable Long id) {
        predioService.deletarPredio(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PredioDTO>> listarTodosOsPredios() {
        List<PredioDTO> predios = predioService.listarTodos();
        return ResponseEntity.ok(predios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PredioDTO> buscarPredioPorId(@PathVariable Long id) {
        PredioDTO predio = predioService.buscarPorId(id);
        return ResponseEntity.ok(predio);
    }
}

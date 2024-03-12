package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.LocalidadeDTO;
import br.com.fiap.fiaphackathonbooking.service.LocalidadeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localidades")
@AllArgsConstructor
public class LocalidadeController {

    private final LocalidadeService localidadeService;

    @PostMapping
    public ResponseEntity<LocalidadeDTO> adicionarLocalidade(@RequestBody @Valid LocalidadeDTO localidadeDTO) {
        LocalidadeDTO novaLocalidade = localidadeService.adicionarLocalidade(localidadeDTO);
        return new ResponseEntity<>(novaLocalidade, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalidadeDTO> atualizarLocalidade(@PathVariable Long id, @RequestBody @Valid LocalidadeDTO localidadeDTO) {
        LocalidadeDTO atualizado = localidadeService.atualizarLocalidade(id, localidadeDTO);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLocalidade(@PathVariable Long id) {
        localidadeService.deletarLocalidade(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<LocalidadeDTO>> listarTodasAsLocalidades() {
        List<LocalidadeDTO> localidades = localidadeService.listarTodos();
        return ResponseEntity.ok(localidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalidadeDTO> buscarLocalidadePorId(@PathVariable Long id) {
        LocalidadeDTO localidade = localidadeService.buscarPorId(id);
        return ResponseEntity.ok(localidade);
    }

}

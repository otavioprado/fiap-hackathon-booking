package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.LocalidadeDTO;
import br.com.fiap.fiaphackathonbooking.service.LocalidadeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localidades")
@AllArgsConstructor
@Tag(name = "Localidades", description = "API de Localidades")
public class LocalidadeController {

    private final LocalidadeService localidadeService;

    @Operation(summary = "Adiciona uma Localidade")
    @PostMapping
    public ResponseEntity<LocalidadeDTO> adicionarLocalidade(@RequestBody @Valid LocalidadeDTO localidadeDTO) {
        LocalidadeDTO novaLocalidade = localidadeService.adicionarLocalidade(localidadeDTO);
        return new ResponseEntity<>(novaLocalidade, HttpStatus.CREATED);
    }

    @Operation(summary = "Atualiza uma Localidade")
    @PutMapping("/{id}")
    public ResponseEntity<LocalidadeDTO> atualizarLocalidade(@PathVariable Long id, @RequestBody @Valid LocalidadeDTO localidadeDTO) {
        LocalidadeDTO atualizado = localidadeService.atualizarLocalidade(id, localidadeDTO);
        return ResponseEntity.ok(atualizado);
    }

    @Operation(summary = "Deleta uma Localidade")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLocalidade(@PathVariable Long id) {
        localidadeService.deletarLocalidade(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Lista todas as Localidades")
    @GetMapping
    public ResponseEntity<List<LocalidadeDTO>> listarTodasAsLocalidades() {
        List<LocalidadeDTO> localidades = localidadeService.listarTodos();
        return ResponseEntity.ok(localidades);
    }

    @Operation(summary = "Busca uma Localidade por id")
    @GetMapping("/{id}")
    public ResponseEntity<LocalidadeDTO> buscarLocalidadePorId(@PathVariable Long id) {
        LocalidadeDTO localidade = localidadeService.buscarPorId(id);
        return ResponseEntity.ok(localidade);
    }

}

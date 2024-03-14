package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.QuartoDTO;
import br.com.fiap.fiaphackathonbooking.model.Quarto;
import br.com.fiap.fiaphackathonbooking.service.QuartoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@Tag(name = "Quartos", description = "API de Quartos")
public class QuartoController {

    private final QuartoService quartoService;

    @Operation(summary = "Adiciona um Quarto")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Quarto encontrado"),
            @ApiResponse(responseCode = "201", description = "Quarto adicionado"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            @ApiResponse(responseCode = "404", description = "Quarto não encontrado"),
            @ApiResponse(responseCode = "422", description = "Erro de validação"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public ResponseEntity<QuartoDTO> adicionarQuarto(@RequestBody @Valid QuartoDTO quartoDTO) {
        QuartoDTO novoQuarto = quartoService.adicionarQuarto(quartoDTO);
        return new ResponseEntity<>(novoQuarto, HttpStatus.CREATED);
    }

    @Operation(summary = "Atualiza um Quarto")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Quarto encontrado"),
            @ApiResponse(responseCode = "201", description = "Quarto adicionado"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            @ApiResponse(responseCode = "404", description = "Quarto não encontrado"),
            @ApiResponse(responseCode = "422", description = "Erro de validação"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<QuartoDTO> atualizarQuarto(@PathVariable Long id, @RequestBody @Valid QuartoDTO quartoDTO) {
        QuartoDTO atualizado = quartoService.atualizarQuarto(id, quartoDTO);
        return ResponseEntity.ok(atualizado);
    }

    @Operation(summary = "Deleta um Quarto")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Quarto encontrado"),
            @ApiResponse(responseCode = "201", description = "Quarto adicionado"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            @ApiResponse(responseCode = "404", description = "Quarto não encontrado"),
            @ApiResponse(responseCode = "422", description = "Erro de validação"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarQuarto(@PathVariable Long id) {
        quartoService.deletarQuarto(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Lista todos os Quartos")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Quarto encontrado"),
            @ApiResponse(responseCode = "201", description = "Quarto adicionado"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            @ApiResponse(responseCode = "404", description = "Quarto não encontrado"),
            @ApiResponse(responseCode = "422", description = "Erro de validação"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public ResponseEntity<List<QuartoDTO>> listarTodosOsQuartos() {
        List<QuartoDTO> quartos = quartoService.listarTodos();
        return ResponseEntity.ok(quartos);
    }

    @Operation(summary = "Busca um Quarto por id")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Quarto encontrado"),
            @ApiResponse(responseCode = "201", description = "Quarto adicionado"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            @ApiResponse(responseCode = "404", description = "Quarto não encontrado"),
            @ApiResponse(responseCode = "422", description = "Erro de validação"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<QuartoDTO> buscarQuartoPorId(@PathVariable Long id) {
        QuartoDTO quarto = quartoService.buscarPorId(id);
        return ResponseEntity.ok(quarto);
    }

    @Operation(summary = "Bloqueia um Quarto")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Quarto encontrado"),
            @ApiResponse(responseCode = "201", description = "Quarto adicionado"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            @ApiResponse(responseCode = "404", description = "Quarto não encontrado"),
            @ApiResponse(responseCode = "422", description = "Erro de validação"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping("/{quartoId}/admin/bloquear")
    public ResponseEntity<QuartoDTO> bloquearQuartoPorAdmin(@PathVariable Long quartoId) {
        QuartoDTO quartoDTO = quartoService.updateBlockedByAdmin(quartoId, true);
        return ResponseEntity.ok(quartoDTO);
    }

    @Operation(summary = "Desbloqueia um Quarto")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Quarto encontrado"),
            @ApiResponse(responseCode = "201", description = "Quarto adicionado"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            @ApiResponse(responseCode = "404", description = "Quarto não encontrado"),
            @ApiResponse(responseCode = "422", description = "Erro de validação"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping("/{quartoId}/admin/desbloquear")
    public ResponseEntity<QuartoDTO> desbloquearQuartoPorAdmin(@PathVariable Long quartoId) {
        QuartoDTO quartoDTO = quartoService.updateBlockedByAdmin(quartoId, false);
        return ResponseEntity.ok(quartoDTO);
    }
}

package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.ClienteDTO;
import br.com.fiap.fiaphackathonbooking.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
@Tag(name = "Clientes", description = "API de Clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @Operation(summary = "Adiciona um Cliente")
    @PostMapping
    public ResponseEntity<ClienteDTO> adicionarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        ClienteDTO novoCliente = clienteService.adicionarCliente(clienteDTO);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @Operation(summary = "Lista todos os Clientes")
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodosClientes() {
        List<ClienteDTO> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    @Operation(summary = "Busca um Cliente por id")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable Long id) {
        ClienteDTO cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "Atualiza um Cliente")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteDTO) {
        ClienteDTO atualizado = clienteService.atualizarCliente(id, clienteDTO);
        return ResponseEntity.ok(atualizado);
    }

    @Operation(summary = "Deleta um Cliente")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.ok("Cliente excluído!");
    }

}

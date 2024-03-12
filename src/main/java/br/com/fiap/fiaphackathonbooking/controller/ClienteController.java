package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.ClienteDTO;
import br.com.fiap.fiaphackathonbooking.model.Cliente;
import br.com.fiap.fiaphackathonbooking.service.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDTO){
        return null;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>>listarTodosClientes(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO>buscarClientePorId(@PathVariable Long id){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteDTO){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCliente(){
        return null;
    }

}

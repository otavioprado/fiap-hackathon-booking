package br.com.fiap.fiaphackathonbooking.controller;

<<<<<<< HEAD

import br.com.fiap.fiaphackathonbooking.dto.ClienteDTO;
import br.com.fiap.fiaphackathonbooking.dto.QuartoDTO;
import br.com.fiap.fiaphackathonbooking.dto.ServicoOpcionalDTO;
import br.com.fiap.fiaphackathonbooking.model.Cliente;
import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;
import br.com.fiap.fiaphackathonbooking.service.ClienteService;
import br.com.fiap.fiaphackathonbooking.service.ServicoOpcionalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
=======
import br.com.fiap.fiaphackathonbooking.dto.ClienteDTO;
import br.com.fiap.fiaphackathonbooking.model.Cliente;
import br.com.fiap.fiaphackathonbooking.service.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
>>>>>>> 4ab50fcbe404bc0efc210cac05a4d80884e84573
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cliente")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> adicionarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        ClienteDTO novoCliente = clienteService.adicionarCliente(clienteDTO);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
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


   /* private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodos() {
        List<Cliente> cliente = clienteService.listarTodos();
        List<ClienteDTO> clienteDTO = cliente.stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping

    public ResponseEntity<ClienteDTO> Cliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        ClienteDTO novoCliente = quartoService.adicionarQuarto(quartoDTO);
        return new ResponseEntity<>(novoQuarto, HttpStatus.CREATED);
    /*public ResponseEntity<ClienteDTO> adicionarCliente (@RequestBody @Valid ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente novoCliente = service.adicionar(cliente);
        ClienteDTO novoClienteDTO = modelMapper.map(novoCliente, ClienteDTO.class);
        return new ResponseEntity<>(novoClienteDTO, HttpStatus.CREATED);


    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente (@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente atualizadoCliente = service.atualizar(id, cliente);
        ClienteDTO atualizadoClienteDTO = modelMapper.map(atualizadoCliente, ClienteDTO.class);
        return ResponseEntity.ok(atualizadoClienteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCliente(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id) {
        Cliente cliente = service.buscarPorId(id);
        ClienteDTO clienteDTO= modelMapper.map(cliente, ClienteDTO.class);
        return ResponseEntity.ok(clienteDTO);
    }

    */
=======

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

>>>>>>> 4ab50fcbe404bc0efc210cac05a4d80884e84573
}

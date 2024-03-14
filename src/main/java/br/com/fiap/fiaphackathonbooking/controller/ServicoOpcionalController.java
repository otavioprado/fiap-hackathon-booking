package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.ServicoOpcionalDTO;
import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;
import br.com.fiap.fiaphackathonbooking.service.ServicoOpcionalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/servicos-opcionais")
@AllArgsConstructor
@Tag(name = "Serviços Opcionais", description = "API de Serviços Opcionais")
public class ServicoOpcionalController {

    private ServicoOpcionalService service;
    private ModelMapper modelMapper;

    @Operation(summary = "Lista todos os Serviços Opcionais")
    @GetMapping
    public ResponseEntity<List<ServicoOpcionalDTO>> listarTodos() {
        List<ServicoOpcional> servicos = service.listarTodos();
        List<ServicoOpcionalDTO> servicosDTO = servicos.stream()
                .map(servico -> modelMapper.map(servico, ServicoOpcionalDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(servicosDTO);
    }

    @Operation(summary = "Adiciona um Serviço Opcional")
    @PostMapping
    public ResponseEntity<ServicoOpcionalDTO> adicionarServicoOpcional(@RequestBody @Valid ServicoOpcionalDTO servicoOpcionalDTO) {
        ServicoOpcional servicoOpcional = modelMapper.map(servicoOpcionalDTO, ServicoOpcional.class);
        ServicoOpcional novoServico = service.adicionar(servicoOpcional);
        ServicoOpcionalDTO novoServicoDTO = modelMapper.map(novoServico, ServicoOpcionalDTO.class);
        return new ResponseEntity<>(novoServicoDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Atualiza um Serviço Opcional")
    @PutMapping("/{id}")
    public ResponseEntity<ServicoOpcionalDTO> atualizarServicoOpcional(@PathVariable Long id, @RequestBody @Valid ServicoOpcionalDTO servicoOpcionalDTO) {
        ServicoOpcional servicoOpcional = modelMapper.map(servicoOpcionalDTO, ServicoOpcional.class);
        ServicoOpcional atualizadoServico = service.atualizar(id, servicoOpcional);
        ServicoOpcionalDTO atualizadoServicoDTO = modelMapper.map(atualizadoServico, ServicoOpcionalDTO.class);
        return ResponseEntity.ok(atualizadoServicoDTO);
    }

    @Operation(summary = "Deleta um Serviço Opcional")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerServicoOpcional(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Busca um Serviço Opcional por Id")
    @GetMapping("/{id}")
    public ResponseEntity<ServicoOpcionalDTO> buscarPorId(@PathVariable Long id) {
        ServicoOpcional servico = service.buscarPorId(id);
        ServicoOpcionalDTO servicoDTO = modelMapper.map(servico, ServicoOpcionalDTO.class);
        return ResponseEntity.ok(servicoDTO);
    }
}

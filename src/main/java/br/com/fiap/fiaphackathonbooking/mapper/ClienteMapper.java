package br.com.fiap.fiaphackathonbooking.mapper;

import br.com.fiap.fiaphackathonbooking.dto.ClienteDTO;
import br.com.fiap.fiaphackathonbooking.dto.ServicoOpcionalDTO;
import br.com.fiap.fiaphackathonbooking.model.Cliente;
import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;

public interface ClienteMapper {
    ClienteDTO toDTO(Cliente tenant);

    Cliente toEntity (ClienteDTO dto);
}

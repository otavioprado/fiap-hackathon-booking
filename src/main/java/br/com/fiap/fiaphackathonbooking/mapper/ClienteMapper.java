package br.com.fiap.fiaphackathonbooking.mapper;

import br.com.fiap.fiaphackathonbooking.dto.ServicoOpcionalDTO;
import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;

public interface ClienteMapper {
    ServicoOpcionalDTO toDTO(ServicoOpcional tenant);

    ServicoOpcional toEntity(ServicoOpcionalDTO dto);
}

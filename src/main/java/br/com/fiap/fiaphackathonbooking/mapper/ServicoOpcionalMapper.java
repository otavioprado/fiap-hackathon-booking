package br.com.fiap.fiaphackathonbooking.mapper;

import br.com.fiap.fiaphackathonbooking.dto.ServicoOpcionalDTO;
import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;
import org.mapstruct.Mapper;

@Mapper
public interface ServicoOpcionalMapper {
    ServicoOpcionalDTO toDTO(ServicoOpcional tenant);

    ServicoOpcional toEntity(ServicoOpcionalDTO dto);
}

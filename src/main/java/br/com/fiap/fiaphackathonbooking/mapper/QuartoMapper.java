package br.com.fiap.fiaphackathonbooking.mapper;

import br.com.fiap.fiaphackathonbooking.dto.QuartoDTO;
import br.com.fiap.fiaphackathonbooking.model.Quarto;
import org.mapstruct.Mapper;

@Mapper
public interface QuartoMapper {
    QuartoDTO toDTO(Quarto tenant);

    Quarto toEntity(QuartoDTO dto);
}

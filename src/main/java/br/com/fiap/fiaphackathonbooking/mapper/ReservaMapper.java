package br.com.fiap.fiaphackathonbooking.mapper;

import br.com.fiap.fiaphackathonbooking.dto.ReservaDTO;
import br.com.fiap.fiaphackathonbooking.model.Quarto;
import br.com.fiap.fiaphackathonbooking.model.Reserva;
import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(target = "quartosIds", source = "quartos")
    @Mapping(target = "servicosOpcionais", source = "servicosOpcionais", qualifiedByName = "servicosOpcionaisToNomes")
    ReservaDTO reservaToReservaDTO(Reserva reserva);

    @Mapping(target = "quartos", ignore = true)
    @Mapping(target = "servicosOpcionais", ignore = true)
    Reserva reservaDTOToReserva(ReservaDTO reservaDTO);

    // Método de mapeamento diretamente reconhecido pelo MapStruct sem @Named
    default List<Long> quartosToQuartosIds(Set<Quarto> quartos) {
        if (quartos == null) {
            return null;
        }
        return quartos.stream()
                .map(Quarto::getId)
                .collect(Collectors.toList());
    }

    @Named("servicosOpcionaisToNomes")
    default List<String> servicosOpcionaisToNomes(Set<ServicoOpcional> servicosOpcionais) {
        if (servicosOpcionais == null) {
            return null;
        }
        return servicosOpcionais.stream()
                .map(ServicoOpcional::getNome)
                .collect(Collectors.toList());
    }
}

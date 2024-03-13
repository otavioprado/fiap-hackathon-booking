package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.dto.LocalidadeDTO;
import br.com.fiap.fiaphackathonbooking.model.Localidade;
import br.com.fiap.fiaphackathonbooking.repository.LocalidadeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class LocalidadeServiceTest {

    @MockBean
    private LocalidadeRepository localidadeRepository;

    @MockBean
    private ModelMapper modelMapper;

    /**
     * Here we are testing the 'listarTodos' method
     * of the LocalidadeService. This method is supposed
     * to retrieve all 'Localidade' entities from the repository
     * and to convert them to DTO objects before returning.
     */
    @Test
    void testListarTodos() {
        // setup
        LocalidadeService localidadeService = new LocalidadeService(localidadeRepository, modelMapper);
        Localidade localidade1 = new Localidade();
        Localidade localidade2 = new Localidade();
        List<Localidade> localidades = Arrays.asList(localidade1, localidade2);
        LocalidadeDTO localidadeDTO1 = new LocalidadeDTO();
        LocalidadeDTO localidadeDTO2 = new LocalidadeDTO();
        doReturn(localidades).when(localidadeRepository).findAll();
        doReturn(localidadeDTO1).when(modelMapper).map(localidade1, LocalidadeDTO.class);
        doReturn(localidadeDTO2).when(modelMapper).map(localidade2, LocalidadeDTO.class);

        // execute
        List<LocalidadeDTO> result = localidadeService.listarTodos();

        // verify
        assertEquals(2, result.size(), "listarTodos should return 2 localidades");
    }
}
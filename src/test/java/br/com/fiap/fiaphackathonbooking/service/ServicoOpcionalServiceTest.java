package br.com.fiap.fiaphackathonbooking.service;

import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;
import br.com.fiap.fiaphackathonbooking.repository.ServicoOpcionalRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ServicoOpcionalServiceTest {

    @InjectMocks
    private ServicoOpcionalService service;

    @Mock
    private ServicoOpcionalRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
        service = null;
    }

    @Test
    void listarTodos() {
        ServicoOpcional servicoOpcional = new ServicoOpcional();
        servicoOpcional.setId(1L);

        when(repository.findAll()).thenReturn(Collections.singletonList(servicoOpcional));

        List<ServicoOpcional> result = service.listarTodos();

        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getId());
    }
}
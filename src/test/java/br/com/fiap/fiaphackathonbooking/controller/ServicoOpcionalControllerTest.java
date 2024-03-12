package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.ServicoOpcionalDTO;
import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;
import br.com.fiap.fiaphackathonbooking.service.ServicoOpcionalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ServicoOpcionalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicoOpcionalService servicoOpcionalService;

    @Test
    void listarTodosTest() throws Exception {
        ServicoOpcional servicoOpcional = new ServicoOpcional();
        servicoOpcional.setId(1L);

        when(servicoOpcionalService.listarTodos()).thenReturn(Collections.singletonList(servicoOpcional));

        MvcResult result = mockMvc.perform(get("/api/servicos-opcionais")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).contains("\"id\":1");
    }
}
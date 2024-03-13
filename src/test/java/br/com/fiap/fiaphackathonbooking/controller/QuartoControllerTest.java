package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.QuartoDTO;
import br.com.fiap.fiaphackathonbooking.service.QuartoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuartoController.class)
@ExtendWith(SpringExtension.class)
class QuartoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuartoService quartoService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testAdicionarQuarto() throws Exception {
        QuartoDTO quartoDTO = new QuartoDTO();
        quartoDTO.setPredioId(1L);
        quartoDTO.setTotalPessoas(2);
        quartoDTO.setTipo("Simples");
        quartoDTO.setTotalCamas(2);
        quartoDTO.setOutrosMoveis("mesa, cadeira");
        given(quartoService.adicionarQuarto(quartoDTO)).willReturn(quartoDTO);

        mockMvc.perform(post("/api/quartos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(quartoDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(quartoDTO)));
    }
}
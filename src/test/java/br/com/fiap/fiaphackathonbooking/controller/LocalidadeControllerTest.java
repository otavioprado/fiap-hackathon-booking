package br.com.fiap.fiaphackathonbooking.controller;

import br.com.fiap.fiaphackathonbooking.dto.LocalidadeDTO;
import br.com.fiap.fiaphackathonbooking.service.LocalidadeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LocalidadeController.class)
class LocalidadeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocalidadeService localidadeService;

    @Test
    void listarTodasAsLocalidades_ShouldReturnEmptyList_WhenNoLocalidadeExists() throws Exception {

        // Arrange
        List<LocalidadeDTO> localidades = new ArrayList<>();
        given(localidadeService.listarTodos()).willReturn(localidades);

        // Act & Assert
        mockMvc.perform(get("/api/localidades")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        assertThat(localidades).isEmpty();
    }
}
package br.com.fiap.fiaphackathonbooking.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ModelMapperConfigTest {

    @SpyBean
    private ModelMapperConfig modelMapperConfig;

    @Autowired
    private ModelMapper modelMapper;

    @BeforeEach
    public void setup() {
        modelMapperConfig = new ModelMapperConfig();
    }

    @Test
    void modelMapper_beanConfigured() {
        ModelMapper testMapper = modelMapperConfig.modelMapper();
        assertThat(testMapper).isNotNull();
        assertThat(testMapper).isInstanceOf(ModelMapper.class);
    }
}
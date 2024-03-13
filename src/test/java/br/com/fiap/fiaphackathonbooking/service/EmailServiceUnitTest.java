package br.com.fiap.fiaphackathonbooking.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@ExtendWith(MockitoExtension.class)
class EmailServiceUnitTest {

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private EmailService emailService;

    @Test
    void enviarEmailConfirmacaoTest() {
        // Initialize objects
        MimeMessage mensagem = Mockito.mock(MimeMessage.class);

        // Mock required methods
        Mockito.when(javaMailSender.createMimeMessage()).thenReturn(mensagem);

        final String DESTINATARIO = "test@test.com";
        final String ASSUNTO = "Test Assunto";
        final String CORPO = "Test Corpo";

        // Define what we expect to happen
        Executable executable = () -> emailService.enviarEmailConfirmacao(DESTINATARIO, ASSUNTO, CORPO);

        // Assert that no exception was thrown when invoking the method
        Assertions.assertDoesNotThrow(executable);

        // Verify that the javaMailSender.send() was called once.
        Mockito.verify(javaMailSender, Mockito.times(1)).send(mensagem);
    }
}
package br.com.fiap.fiaphackathonbooking.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviarEmailConfirmacao(String destinatario, String assunto, String corpo) {
        MimeMessage mensagem = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        try {
            helper = new MimeMessageHelper(mensagem, true);
            helper.setFrom("ksilvaribeiro97@gmail.com");
            helper.setTo(destinatario);
            helper.setSubject(assunto);
            helper.setText(corpo, true);

            javaMailSender.send(mensagem);
        } catch (MessagingException e) {
            throw new RuntimeException("Erro ao enviar e-mail de confirmação", e);
        }
    }
}

package br.com.fiap.fiaphackathonbooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class NotFoundException extends HttpClientErrorException {
    public NotFoundException(String text) {
        super(HttpStatus.NOT_FOUND, text);
    }
}


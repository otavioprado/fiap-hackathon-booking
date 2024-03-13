package br.com.fiap.fiaphackathonbooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class InvalidRequestNotFoundException extends HttpClientErrorException {
    public InvalidRequestNotFoundException(String text) {
        super(HttpStatus.BAD_REQUEST, text);
    }
}


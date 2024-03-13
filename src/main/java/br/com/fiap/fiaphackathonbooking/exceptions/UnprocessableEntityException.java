package br.com.fiap.fiaphackathonbooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class UnprocessableEntityException extends HttpClientErrorException {
    public UnprocessableEntityException(String text) { super(HttpStatus.UNPROCESSABLE_ENTITY, text); }
}


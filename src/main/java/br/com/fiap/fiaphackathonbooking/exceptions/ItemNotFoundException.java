package br.com.fiap.fiaphackathonbooking.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id) {
        super("Item não encontrado com ID: " + id);
    }
}


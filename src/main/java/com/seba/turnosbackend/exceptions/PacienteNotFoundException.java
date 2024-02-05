package com.seba.turnosbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PacienteNotFoundException extends RuntimeException {

    private String resourceName;

    public PacienteNotFoundException(String mensaje) {
        super(mensaje);
    }
}
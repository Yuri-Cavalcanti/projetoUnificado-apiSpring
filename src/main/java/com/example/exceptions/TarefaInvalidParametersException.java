package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class TarefaInvalidParametersException extends RuntimeException {
    public TarefaInvalidParametersException(String message) {
        super(message);
    }
}

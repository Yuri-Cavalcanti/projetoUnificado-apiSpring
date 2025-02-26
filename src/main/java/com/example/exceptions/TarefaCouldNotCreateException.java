package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class TarefaCouldNotCreateException extends RuntimeException {
    public TarefaCouldNotCreateException(String message) {
        super(message);
    }
}

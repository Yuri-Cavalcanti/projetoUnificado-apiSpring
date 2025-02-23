package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED) // 400
public class TarefaCouldNotCreateException extends RuntimeException {
    public TarefaCouldNotCreateException(String message) {
        super(message);
    }
}

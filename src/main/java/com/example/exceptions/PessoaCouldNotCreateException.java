package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PessoaCouldNotCreateException extends RuntimeException {
    public PessoaCouldNotCreateException(String message) {
        super(message);
    }
}

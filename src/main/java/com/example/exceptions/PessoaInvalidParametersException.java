package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PessoaInvalidParametersException extends RuntimeException {
    public PessoaInvalidParametersException(String message) {
        super(message);
    }
}

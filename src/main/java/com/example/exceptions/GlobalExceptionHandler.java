package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PessoaNotFoundException.class)
    public ResponseEntity<String> handlePessoaNaoEncontradoException(PessoaNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
	
	@ExceptionHandler(TarefaNotFoundException.class)
    public ResponseEntity<String> handleTarefaNotFoundException(TarefaNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
	
	@ExceptionHandler(PessoaResourceException.class)
    public ResponseEntity<String> handlePessoaResourceException(PessoaResourceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    
    @ExceptionHandler(TarefaResourceException.class)
    public ResponseEntity<String> handleTarefaResourceException(TarefaResourceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(PessoaInvalidParametersException.class)
    public ResponseEntity<String> handlePessoaInvalidParametersExceptionException(PessoaInvalidParametersException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    
    @ExceptionHandler(TarefaInvalidParametersException.class)
    public ResponseEntity<String> handleTarefaInvalidParametersException(TarefaInvalidParametersException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    
    @ExceptionHandler(PessoaCouldNotCreateException.class)
    public ResponseEntity<String> handlePessoaCouldNotCreateException(PessoaCouldNotCreateException ex){
    	return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ex.getMessage());
    }
    
    @ExceptionHandler(TarefaCouldNotCreateException.class)
    public ResponseEntity<String> handleTarefaCouldNotCreateException(TarefaCouldNotCreateException ex){
    	return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor.");
    }

}

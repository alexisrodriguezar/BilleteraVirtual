package com.billeteravirtual.Billetera.controller;

import com.billeteravirtual.Billetera.exception.OperacionInvalidaException;
import com.billeteravirtual.Billetera.exception.RecursoNoEncontradoException;
import com.billeteravirtual.Billetera.exception.SaldoInsuficienteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadoDeErrores {

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<String> manejarNoEncontrado(RecursoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler({OperacionInvalidaException.class, SaldoInsuficienteException.class})
    public ResponseEntity<String> manejarSolicitudInvalida(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
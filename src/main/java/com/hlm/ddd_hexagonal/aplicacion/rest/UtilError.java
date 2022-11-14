package com.hlm.ddd_hexagonal.aplicacion.rest;

import com.hlm.ddd_hexagonal.dominio.entidades.ResponseError;
import com.hlm.ddd_hexagonal.infraestructura.datos.servicios.clientes.rest.service.ExecptionError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class UtilError {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions() {
        ResponseError responseError=ResponseError.builder().codigo("ERROR").mesaje("ERROR INFORMACION").build();
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExecptionError.class)
    public ResponseEntity<ResponseError>error(){
        ResponseError responseError=ResponseError.builder().codigo("ERROR").mesaje("SIN INFORMACION").build();
        return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError>error2(){
        ResponseError responseError=ResponseError.builder().codigo("ERROR").mesaje("CONTACTACE CON SU PROVEEDOR").build();
        return new ResponseEntity<>(responseError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package com.sebastianmoreno.climate_microservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MunicipioNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleMunicipioNotFound(
            MunicipioNotFoundException ex){

        return new ResponseEntity<>(
                Map.of("error",ex.getMessage()), HttpStatus.NOT_FOUND
        );
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handleGeneralError(Exception ex){

        // Si el error viene de Swagger o SpringDoc, lo dejamos pasar
        String msg = ex.getClass().getName();

        if (msg.contains("springdoc") || msg.contains("swagger")) {
            throw new RuntimeException(ex); // deja que Spring lo maneje
        }

        return new ResponseEntity<>(
                Map.of("error","error interno del servidor"),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}

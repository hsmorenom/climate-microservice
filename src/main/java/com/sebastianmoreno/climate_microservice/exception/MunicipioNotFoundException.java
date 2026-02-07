package com.sebastianmoreno.climate_microservice.exception;

public class MunicipioNotFoundException extends RuntimeException {

    public MunicipioNotFoundException(String municipio){
        super("Municipion no encontrado "+municipio);
    }
}

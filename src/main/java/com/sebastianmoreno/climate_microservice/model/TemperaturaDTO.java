package com.sebastianmoreno.climate_microservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemperaturaDTO {
    //Relaciona el nombre de la variable del api "codigoestacion" para que se le asigne el valor a la variable creada en
    // este codigo bajo codigoestacion, si fuera tipo camelCase, seria "codigoEstacion"
    @JsonProperty("codigoestacion")
    private String codigoEstacion;

    @JsonProperty("codigosensor")
    private String codigoSensor;

    @JsonProperty("fechaobservacion")
    private String fechaObservacion;

    @JsonProperty("valorobservado")
    private String valorObservado;

    @JsonProperty("nombrestacion")
    private String nombreEstacion;

    @JsonProperty("departamento")
    private String departamento;

    @JsonProperty("municipio")
    private String municipio;

    @JsonProperty("zonahidrografica")
    private String zonaHidrografica;

    @JsonProperty("latitud")
    private String latitud;

    @JsonProperty("longitud")
    private String longitud;

    @JsonProperty("descripcionsensor")
    private String descripcionSensor;

    @JsonProperty("unidadmedida")
    private String unidadMedida;

    //Getters y Setters

    public String getCodigoEstacion() {
        return codigoEstacion;
    }

    public void setCodigoEstacion(String codigoEstacion) {
        this.codigoEstacion = codigoEstacion;
    }

    public String getCodigoSensor() {
        return codigoSensor;
    }

    public void setCodigoSensor(String codigoSensor) {
        this.codigoSensor = codigoSensor;
    }

    public String getFechaObservacion() {
        return fechaObservacion;
    }

    public void setFechaObservacion(String fechaObservacion) {
        this.fechaObservacion = fechaObservacion;
    }

    public String getValorObservado() {
        return valorObservado;
    }

    public void setValorObservado(String valorObservado) {
        this.valorObservado = valorObservado;
    }

    public String getNombreEstacion() {
        return nombreEstacion;
    }

    public void setNombreEstacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getZonaHidrografica() {
        return zonaHidrografica;
    }

    public void setZonaHidrografica(String zonaHidrografica) {
        this.zonaHidrografica = zonaHidrografica;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDescripcionSensor() {
        return descripcionSensor;
    }

    public void setDescripcionSensor(String descripcionSensor) {
        this.descripcionSensor = descripcionSensor;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}

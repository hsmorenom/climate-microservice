package com.sebastianmoreno.climate_microservice.model;

import java.time.LocalDate;

public class ClimateResponseDTO {

    private String estacion;

    private String municipio;

    private String departamento;

    private String unidadPrecipitacion;

    private double precipitacionMensualMm;

    private String unidadTemperatura;

    private double temperaturaMediaC;

    private String unidadEvapotranspiracion;

    private double evapotranspiracionMm;

    private LocalDate fechaRegistro;

    private String interpretacionTecnicaPrecipitacion;

    private String interpretacionTecnicaTemperatura;

    //Constructor Vacio que lo necesita SpringBoot
    public ClimateResponseDTO() {
    }
    //Constructor de las variables

    public ClimateResponseDTO(String estacion, String municipio, String departamento, String unidadPrecipitacion, double precipitacionMensualMm, String unidadTemperatura, double temperaturaMediaC,String unidadEvapotranspiracion, double evapotranspiracionMm, LocalDate fechaRegistro, String interpretacionTecnicaPrecipitacion, String interpretacionTecnicaTemperatura) {
        this.estacion = estacion;
        this.municipio = municipio;
        this.departamento = departamento;
        this.unidadPrecipitacion = unidadPrecipitacion;
        this.precipitacionMensualMm = precipitacionMensualMm;
        this.unidadTemperatura = unidadTemperatura;
        this.temperaturaMediaC = temperaturaMediaC;
        this.unidadEvapotranspiracion= unidadEvapotranspiracion;
        this.evapotranspiracionMm = evapotranspiracionMm;
        this.fechaRegistro = fechaRegistro;
        this.interpretacionTecnicaPrecipitacion = interpretacionTecnicaPrecipitacion;
        this.interpretacionTecnicaTemperatura = interpretacionTecnicaTemperatura;
    }


    //Getters y Setters


    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getPrecipitacionMensualMm() {
        return precipitacionMensualMm;
    }

    public void setPrecipitacionMensualMm(double precipitacionMensualMm) {
        this.precipitacionMensualMm = precipitacionMensualMm;
    }

    public double getTemperaturaMediaC() {
        return temperaturaMediaC;
    }

    public void setTemperaturaMediaC(double temperaturaMediaC) {
        this.temperaturaMediaC = temperaturaMediaC;
    }

    public double getEvapotranspiracionMm() {
        return evapotranspiracionMm;
    }

    public void setEvapotranspiracionMm(double evapotranspiracionMm) {
        this.evapotranspiracionMm = evapotranspiracionMm;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getInterpretacionTecnicaPrecipitacion() {
        return interpretacionTecnicaPrecipitacion;
    }

    public void setInterpretacionTecnicaPrecipitacion(String interpretacionTecnicaPrecipitacion) {
        this.interpretacionTecnicaPrecipitacion = interpretacionTecnicaPrecipitacion;
    }

    public String getInterpretacionTecnicaTemperatura() {
        return interpretacionTecnicaTemperatura;
    }

    public void setInterpretacionTecnicaTemperatura(String interpretacionTecnicaTemperatura) {
        this.interpretacionTecnicaTemperatura = interpretacionTecnicaTemperatura;
    }

    public String getUnidadPrecipitacion() {
        return unidadPrecipitacion;
    }

    public void setUnidadPrecipitacion(String unidadPrecipitacion) {
        this.unidadPrecipitacion = unidadPrecipitacion;
    }

    public String getUnidadTemperatura() {
        return unidadTemperatura;
    }

    public void setUnidadTemperatura(String unidadTemperatura) {
        this.unidadTemperatura = unidadTemperatura;
    }

    public String getUnidadEvapotranspiracion() {
        return unidadEvapotranspiracion;
    }

    public void setUnidadEvapotranspiracion(String unidadEvapotranspiracion) {
        this.unidadEvapotranspiracion = unidadEvapotranspiracion;
    }
}
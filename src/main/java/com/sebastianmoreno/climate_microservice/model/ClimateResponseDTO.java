package com.sebastianmoreno.climate_microservice.model;

import java.time.LocalDate;

public class ClimateResponseDTO {
    private String estacion;
    private String ciudad;
    private String departamento;
    private double precipitacionMensualMm;
    private double temperaturaMediaC;
    private double evapotranspiracionMm;
    private LocalDate fechaRegistro;
    private String InterpretacionTecnica;

    //Constructor Vacio que lo necesita SpringBoot
    public ClimateResponseDTO(){

    }
    //Constructor de las variables
    public ClimateResponseDTO(String estacion, String ciudad, String departamento, double precipitacionMensualMm,
                              double temperaturaMediaC, double evapotranspiracionMm, LocalDate fechaRegistro,
                              String interpretacionTecnica) {
        this.estacion = estacion;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.precipitacionMensualMm = precipitacionMensualMm;
        this.temperaturaMediaC = temperaturaMediaC;
        this.evapotranspiracionMm = evapotranspiracionMm;
        this.fechaRegistro = fechaRegistro;
        InterpretacionTecnica = interpretacionTecnica;
    }

    //Getters y Setters de las variables

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public String getInterpretacionTecnica() {
        return InterpretacionTecnica;
    }

    public void setInterpretacionTecnica(String interpretacionTecnica) {
        InterpretacionTecnica = interpretacionTecnica;
    }
}

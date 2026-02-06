package com.sebastianmoreno.climate_microservice.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Respuesta del reporte climático integrado con cálculo de evapotranspiración")
public class ClimateResponseDTO {
    @Schema(description = "Nombre de la estación IDEAM", example = "Estación IDEAM")
    private String estacion;
    @Schema(description = "Municipio consultado", example = "BOGOTA")
    private String municipio;
    @Schema(description = "Departamento al que pertenece el municipio", example = "CUNDINAMARCA")
    private String departamento;
    @Schema(description = "Precipitación mensual promedio en milímetros", example = "85.5")
    private double precipitacionMensualMm;
    @Schema(description = "Temperatura media en grados Celsius", example = "14.5")
    private double temperaturaMediaC;
    @Schema(description = "Evapotranspiración calculada en milímetros", example = "28.3")
    private double evapotranspiracionMm;
    @Schema(description = "Fecha de generación del reporte")
    private LocalDate fechaRegistro;
    @Schema(description = "Interpretación técnica de la precipitación")
    private String interpretacionTecnicaPrecipitacion;
    @Schema(description = "Interpretación técnica de la temperatura")
    private String interpretacionTecnicaTemperatura;

    //Constructor Vacio que lo necesita SpringBoot
    public ClimateResponseDTO() {
    }
    //Constructor de las variables


    public ClimateResponseDTO(String estacion, String municipio, String departamento, double precipitacionMensualMm, double temperaturaMediaC, double evapotranspiracionMm, LocalDate fechaRegistro, String interpretacionTecnicaPrecipitacion, String interpretacionTecnicaTemperatura) {
        this.estacion = estacion;
        this.municipio = municipio;
        this.departamento = departamento;
        this.precipitacionMensualMm = precipitacionMensualMm;
        this.temperaturaMediaC = temperaturaMediaC;
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
}
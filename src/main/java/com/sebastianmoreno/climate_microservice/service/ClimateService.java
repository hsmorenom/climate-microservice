package com.sebastianmoreno.climate_microservice.service;

import com.sebastianmoreno.climate_microservice.exception.MunicipioNotFoundException;
import com.sebastianmoreno.climate_microservice.model.ClimateResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClimateService {
    private final PrecipitacionService precipitacionService;
    private final TemperaturaService temperaturaService;

    //Constructor
    public ClimateService(PrecipitacionService precipitacionService, TemperaturaService temperaturaService) {
        this.precipitacionService = precipitacionService;
        this.temperaturaService = temperaturaService;
    }

    public ClimateResponseDTO getClimateReport(String municipio) {

        double precipitacionPromedio =
                precipitacionService.getPrecipitationByMunicipio(municipio);

        if (!precipitacionService.existsMunicipio(municipio)) {
            throw new MunicipioNotFoundException(municipio);
        }
        String departamento;

        if(precipitacionService.getDepartamentoByMunicipio(municipio)==null){
            departamento= temperaturaService.getDepartamentoByMunicipio(municipio);
        }else{
            departamento= precipitacionService.getDepartamentoByMunicipio(municipio);
        };

        double temperatura = temperaturaService.getTemperatureByMunicipio(municipio);

        if (!temperaturaService.existsMunicipio(municipio)) {
            throw new MunicipioNotFoundException(municipio);
        }
        double evapotranspiracion = calcularEvapotranspiracion(temperatura);

        String interpretacionPrecipitacion;

        if (precipitacionPromedio > 100) {
            interpretacionPrecipitacion =
                    "Alta precipitación: posible riesgo de saturación hídrica.";
        } else {
            interpretacionPrecipitacion =
                    "Precipitación moderada: condiciones estables.";
        }

        String interpretacionTemperatura;
        if(temperatura>=20 && temperatura<=25){
            interpretacionTemperatura= "Temperatura ambiente: medición confortable para el ser humano";
        }else if(temperatura <20){
            interpretacionTemperatura= "Temperatura de clima frio";
        }else{
            interpretacionTemperatura="Temperatura de clima calido";
        }

        return new ClimateResponseDTO(
                "Estación IDEAM",
                municipio,
                departamento,"mm",
                precipitacionPromedio,"°C",
                temperatura,"mm/dia",
                evapotranspiracion,
                LocalDate.now(),
                interpretacionPrecipitacion,
                interpretacionTemperatura
        );
    }

    private double calcularEvapotranspiracion(double temperatura) {
        // Fórmula simplificada tipo ingeniería ambiental
        if (temperatura <= 0) {
            return 0;
        }

        // Thornthwaite simplificado (ETP mensual aproximada en mm)
        double etpMensual = 16 * Math.pow((10 * temperatura / 100), 1.514);

        // Lo conviertes a mm/día para que coincida con tu unidad actual
        return etpMensual / 30.0;
    }

}

package com.sebastianmoreno.climate_microservice.service;

import com.sebastianmoreno.climate_microservice.model.ClimateResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClimateService {
    private final PrecipitacionService precipitacionService;

    //Constructor
    public ClimateService(PrecipitacionService precipitacionService) {
        this.precipitacionService = precipitacionService;
    }

    public ClimateResponseDTO getClimateReport(String municipio) {

        double precipitacionPromedio =
                precipitacionService.getPrecipitationByMunicipio(municipio);

        // Por ahora valores simulados (luego los podemos obtener de otra API)
        String departamento=precipitacionService.getDepartamentoByMunicipio(municipio);
        double temperatura = 14.0;
        double evapotranspiracion = 40.0;

        String interpretacion;

        if (precipitacionPromedio > 100) {
            interpretacion =
                    "Alta precipitación: posible riesgo de saturación hídrica.";
        } else {
            interpretacion =
                    "Precipitación moderada: condiciones estables.";
        }

        return new ClimateResponseDTO(
                "Estación IDEAM",
                municipio,
                departamento,
                precipitacionPromedio,
                temperatura,
                evapotranspiracion,
                LocalDate.now(),
                interpretacion
        );
    }
}

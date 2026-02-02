package com.sebastianmoreno.climate_microservice.service;

import com.sebastianmoreno.climate_microservice.model.ClimateResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClimateService {
    public ClimateResponseDTO getClimateReport(String ciudad){
        //Simulación de datos obtenidos de API
        double precipitacion = 120.5;
        double temperatura = 13.8;
        double evapotranspiracion = 45.2;

        String interpretacion;
        //Simulacion de interpretación de datos
        if(precipitacion>100){
            interpretacion = "Alta precipitación: posible riesgo de saturación hídrica en suelos.";
        } else{
            interpretacion ="Precipitación moderada: condiciones estables para cultivos.";
        }

        //Construccion de modelo limpio de dto
        ClimateResponseDTO dto=new ClimateResponseDTO(
                "Estación El Dorado",ciudad,"Cundinamarca",precipitacion,temperatura,evapotranspiracion,
                LocalDate.now(),interpretacion
        );
        return dto;
    }
}

package com.sebastianmoreno.climate_microservice.service;

import com.sebastianmoreno.climate_microservice.model.ClimateResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ClimateService {
    public ClimateResponseDTO getStatus(){
        return new ClimateResponseDTO(
                "Climate Microservice", "Running", "v1.0"
        );
    }
}

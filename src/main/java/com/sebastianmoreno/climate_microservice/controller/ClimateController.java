package com.sebastianmoreno.climate_microservice.controller;

import com.sebastianmoreno.climate_microservice.model.ClimateResponseDTO;
import com.sebastianmoreno.climate_microservice.service.ClimateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/climate")
public class ClimateController {

    private final ClimateService climateService;

    public ClimateController(ClimateService climateService) {
        this.climateService = climateService;
    }

    @GetMapping("/{municipio}")
    public ClimateResponseDTO getClimateReport(@PathVariable String municipio) {
        return climateService.getClimateReport(municipio);
    };
}


package com.sebastianmoreno.climate_microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClimateController {

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}

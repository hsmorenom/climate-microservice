package com.sebastianmoreno.climate_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sebastianmoreno.climate_microservice")
public class ClimateMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClimateMicroserviceApplication.class, args);
	}

}

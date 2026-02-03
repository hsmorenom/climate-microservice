package com.sebastianmoreno.climate_microservice.service;

import com.sebastianmoreno.climate_microservice.model.PrecipitacionDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PrecipitacionService {

    private static final String API_URL =
            "https://www.datos.gov.co/resource/s54a-sgyg.json?$limit=2000\n";
    //Obtener precipitación media
    public double getPrecipitationByMunicipio(String municipio){

        RestTemplate restTemplate = new RestTemplate();

        PrecipitacionDTO[] response =
                restTemplate.getForObject(API_URL, PrecipitacionDTO[].class);

        if (response == null){
            return 0.0;
        }

        List<PrecipitacionDTO> datos = Arrays.asList(response);

        double suma = 0;
        int contador = 0;

        for(PrecipitacionDTO registro : datos){

            if (registro.getMunicipio() != null &&
                    registro.getMunicipio().toLowerCase()
                            .contains(municipio.toLowerCase())) {

                try {
                    suma += Double.parseDouble(registro.getValorObservado());
                    contador++;

                } catch (Exception e) {
                    // ignoramos datos inválidos
                }
            }
        }

        if(contador == 0){
            return 0.0;
        }

        // Promedio aproximado de precipitación
        return suma / contador;
    }

    //Obtener nombre departamento
    public String getDepartamentoByMunicipio(String municipio){
        RestTemplate restTemplate = new RestTemplate();

        PrecipitacionDTO[] response =
                restTemplate.getForObject(API_URL, PrecipitacionDTO[].class);

        if (response == null){
            return null;
        }

        for (PrecipitacionDTO registro : response) {

            if (registro.getMunicipio() != null &&
                    registro.getMunicipio().toLowerCase()
                            .contains(municipio.toLowerCase())) {

                // Devuelve el primer departamento que coincida
                return registro.getDepartamento();
            }
        }
        // Si no encontró nada
        return null;

    };
}

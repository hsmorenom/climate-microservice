package com.sebastianmoreno.climate_microservice.service;

import com.sebastianmoreno.climate_microservice.model.PrecipitacionDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PrecipitacionService {

    private static final String API_URL =
            "https://www.datos.gov.co/resource/s54a-sgyg.json";

    public final RestTemplate restTemplate;

    public PrecipitacionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Obtener precipitación media
    public double getPrecipitationByMunicipio(String municipio){

        PrecipitacionDTO[] response =
                restTemplate.getForObject(API_URL, PrecipitacionDTO[].class);

        if (response == null){
            return 0.0;
        }

        List<PrecipitacionDTO> datos = Arrays.asList(response);

        double suma = 0;
        int contador = 0;

        String municipioBuscado = limpiarAcentos(municipio.toLowerCase());

        for(PrecipitacionDTO registro : datos){

            if (registro.getMunicipio() != null &&
                    registro.getMunicipio().toLowerCase().contains(municipioBuscado)) {

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

        PrecipitacionDTO[] response =
                restTemplate.getForObject(API_URL, PrecipitacionDTO[].class);

        if (response == null){
            return null;
        }
        String municipioBuscado = limpiarAcentos(municipio.toLowerCase());

        for (PrecipitacionDTO registro : response) {
            if (registro.getMunicipio() != null) {
                // Normalizamos el dato que viene de la API
                String municipioApi = limpiarAcentos(registro.getMunicipio().toLowerCase());

                if (municipioApi.contains(municipioBuscado)) {
                    return registro.getDepartamento();
                }
            }
        }
        // Si no encontró nada
        return null;

    };

    //Método auxiliar para quitar tildes
    private String limpiarAcentos(String texto) {
        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern patron = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return patron.matcher(normalizado).replaceAll("");
    }
}

package com.sebastianmoreno.climate_microservice.service;

import com.sebastianmoreno.climate_microservice.model.PrecipitacionDTO;
import com.sebastianmoreno.climate_microservice.model.TemperaturaDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class TemperaturaService {

    private static final String API_URL="https://www.datos.gov.co/resource/sbwg-7ju4.json";

    public final RestTemplate restTemplate;

    public TemperaturaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double getTemperatureByMunicipio(String municipio){

        //Se usa [] porque el API posee un array de varios objetos, si el api solo tiene un objeto, no se escribe el [], aca se adquiere la información de los datos del api al dto creado por temperaturaDTO en un array estatico
        TemperaturaDTO[] response = restTemplate.getForObject(API_URL,TemperaturaDTO[].class);

        if (response ==null){
            return 0.0;
        }
        /*Convierte el array del response en list para que sea mas flexible en su manipulación, para filtrar, mapear, añadir o borrar info*/
        List<TemperaturaDTO> datos = Arrays.asList(response);

        double suma = 0;
        int contador = 0;

        String municipioBuscado = limpiarAcentos(municipio.toLowerCase());

        //Se usan los : para decir que itere los datos que cumplan segun la condicion dentro de registro, como datos es una lista este tiene un zize, este es el contador por decirlo asi
        for(TemperaturaDTO registro :datos){
            if(registro.getMunicipio() != null &&
                    registro.getMunicipio().toLowerCase().contains(municipioBuscado)){
                try{
                    suma+=Double.parseDouble(registro.getValorObservado());
                    contador++;
                }catch (Exception e){
                };
            }
        }

        if(contador ==0){
            return 0.0;
        }

        return suma/contador;
    }

    //Obtener nombre departamento
    public String getDepartamentoByMunicipio(String municipio){

        TemperaturaDTO[] response =
                restTemplate.getForObject(API_URL, TemperaturaDTO[].class);

        if (response == null){
            return null;
        }

        String municipioBuscado = limpiarAcentos(municipio.toLowerCase());

        for (TemperaturaDTO registro : response) {
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

    /*Método auxiliar para quitar tildes*/
    private String limpiarAcentos(String texto) {
        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern patron = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return patron.matcher(normalizado).replaceAll("");
    }
}




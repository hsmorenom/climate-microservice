package com.sebastianmoreno.climate_microservice.model;

public class ClimateResponseDTO {
    private String name;
    private String status;
    private String version;

    public ClimateResponseDTO(String name, String status, String version){
        this.name=name;
        this.status=status;
        this.version=version;
    }
    public String getName(){
        return name;
    }
    public String getStatus(){
        return status;
    }

    public String getVersion(){
        return version;
    }

}

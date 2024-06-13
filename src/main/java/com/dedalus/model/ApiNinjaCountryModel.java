package com.dedalus.model;

import lombok.Data;

import javax.json.bind.annotation.JsonbProperty;

@Data
public class ApiNinjaCountryModel {
    private String name;
    @JsonbProperty("iso2")
    private String countryCode;
    private String population;
    @JsonbProperty("region")
    private String continent;
}

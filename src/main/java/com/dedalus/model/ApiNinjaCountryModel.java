package com.dedalus.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.json.bind.annotation.JsonbProperty;

@Data
@Accessors(chain = true)
public class ApiNinjaCountryModel {
    private String name;
    @JsonbProperty("iso2")
    private String countryCode;
    private String population;
    @JsonbProperty("region")
    private String continent;
}

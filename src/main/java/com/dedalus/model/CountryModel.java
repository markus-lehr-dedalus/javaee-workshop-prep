package com.dedalus.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CountryModel {
    private Long id;
    private String name;
    private String countryCode;
    private Long population;
    private String continent;
}

package com.dedalus.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class CountryModel {
    private Long id;
    @NotBlank
    @Size(min = 3) // for strings the size constraints are not created using @Min and @Max, but with @Size
    private String name;
    @NotBlank
    private String countryCode;
    @Min(1000)
    private Long population;
    private String continent;
}

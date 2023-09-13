package com.dedalus.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@Accessors(chain = true)
public class CarModel {
    private String id;
    @NotBlank
    private String manufacturer;
    @NotBlank
    private String model;
    @Pattern(message = "The given colour must be one of: ...", regexp = "black|khaki|amaranth|aureolin|celadon", flags = Pattern.Flag.CASE_INSENSITIVE)
    @NotNull
    private String color;
    @Min(1)
    @NotNull
    private Integer horsepower;
}

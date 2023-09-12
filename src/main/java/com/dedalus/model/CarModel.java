package com.dedalus.model;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class CarModel {
    private String id;
    private String manufacturer;
    private String model;
    private String color;
    private Integer horsepower;
}

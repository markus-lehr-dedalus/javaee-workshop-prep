package com.dedalus.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity(name = "CAR")
@Accessors(chain = true)
public class CarEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String manufacturer;
    private String model;
    private String color;
    private Integer horsepower;
}

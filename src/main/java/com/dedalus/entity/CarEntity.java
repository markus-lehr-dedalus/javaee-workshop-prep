package com.dedalus.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity(name = "CAR")
@Accessors(chain = true)
public class CarEntity {
    @Id
    @GeneratedValue
    private UUID id;

    // only use FetchType.EAGER when you are sure
    // that you are not unnecessarily overfetching
    @ManyToOne(fetch = FetchType.EAGER)
    private ManufacturerEntity manufacturer;
    private String model;

    // alternatively you can use a custom @Converter class
    // to have more fine-grained control over how enums are represented
    @Enumerated(EnumType.STRING)
    private ColorType color;
    private Integer horsepower;
}

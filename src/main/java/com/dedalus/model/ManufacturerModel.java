package com.dedalus.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ManufacturerModel {
    private String id;
    private String name;
    private String existsSince;
}

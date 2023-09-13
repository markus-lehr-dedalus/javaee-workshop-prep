package com.dedalus.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity(name = "MANUFACTURER")
@Data
// specifying UniqueConstraints like this is not necessary
// when you manually specify them in the DB schema.
// It is good practice, however, to specify both.
@Table(
        name = "MANUFACTURER",
        uniqueConstraints = @UniqueConstraint(columnNames = "MANUFACTURER_NAME")
)
@Accessors(chain = true)
public class ManufacturerEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "MANUFACTURER_NAME") // specify this over "NAME", since it's a reserved keyword in some databases
    private String name;
    @CreationTimestamp
    private Instant existsSince;
}

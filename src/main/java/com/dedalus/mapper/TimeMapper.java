package com.dedalus.mapper;

import javax.enterprise.context.ApplicationScoped;
import java.time.Instant;

@ApplicationScoped
public class TimeMapper {
    public Instant mapToInstant(String value) {
        if (value == null) {
            return null;
        }
        return Instant.parse(value);
    }

    public String mapToString(Instant instant) {
        return String.valueOf(instant);
    }
}

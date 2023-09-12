package com.dedalus.mapper;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class UUIDMapper {
    public UUID mapToUUID(String id) {
        if (id == null) {
            return null;
        }
        return UUID.fromString(id);
    }

    public String mapToString(UUID uuid) {
        return String.valueOf(uuid);
    }
}

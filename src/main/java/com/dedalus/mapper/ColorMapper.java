package com.dedalus.mapper;

import com.dedalus.entity.ColorType;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class ColorMapper {
    public ColorType mapToColorType(String frontendString) {
        return ColorType.fromFrontendString(frontendString).orElse(null);
    }

    public String mapToString(ColorType colorType) {
        return colorType == null ? null : colorType.getFrontendString();
    }
}

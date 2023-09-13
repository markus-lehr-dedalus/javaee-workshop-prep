package com.dedalus.entity;

import java.util.Arrays;
import java.util.Optional;

public enum ColorType {
    BLACK("black"),
    KHAKI("khaki"),
    AMARANTH("amaranth"),
    AUREOLIN("aureolin"),
    CELADON("celadon");

    private final String frontendString;

    ColorType(String frontendString) {
        this.frontendString = frontendString;
    }

    public static Optional<ColorType> fromFrontendString(String frontendString) {
        return Arrays.stream(values())
                .filter(v -> v.frontendString.equals(frontendString))
                .findFirst();
    }

    public String getFrontendString() {
        return frontendString;
    }
}

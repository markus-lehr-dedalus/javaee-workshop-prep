package com.dedalus.control;

import com.dedalus.entity.CountryEntity;
import com.dedalus.model.CountryModel;

import javax.enterprise.context.ApplicationScoped;

/**
 * Mappers like these could (and IMO should) also be generated using libraries like Mapstruct.
 */
@ApplicationScoped
public class CountryMapper {
    public CountryModel map(CountryEntity entity) {
        if (entity == null) {
            return null;
        }
        return new CountryModel()
                .setId(entity.getId())
                .setName(entity.getName())
                .setCountryCode(entity.getCountryCode())
                .setPopulation(entity.getPopulation())
                .setContinent(entity.getContinent());
    }

    public CountryEntity map(CountryModel model) {
        if (model == null) {
            return null;
        }
        return new CountryEntity()
                .setName(model.getName())
                .setCountryCode(model.getCountryCode())
                .setPopulation(model.getPopulation())
                .setContinent(model.getContinent());
    }
}

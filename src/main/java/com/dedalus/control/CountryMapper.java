package com.dedalus.control;

import com.dedalus.entity.CountryEntity;
import com.dedalus.model.ApiNinjaCountryModel;
import com.dedalus.model.CountryModel;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

/**
 * Mappers like these could (and IMO should) also be generated using libraries like Mapstruct.
 */
@ApplicationScoped
public class CountryMapper {
    public CountryModel mapEntityToModel(CountryEntity entity) {
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
    public CountryModel mapApiNinjaToModel(ApiNinjaCountryModel model) {
        if (model == null) {
            return null;
        }
        return new CountryModel()
                .setName(model.getName())
                .setCountryCode(model.getCountryCode())
                .setPopulation(new BigDecimal(model.getPopulation()).longValue())
                .setContinent(model.getContinent());
    }

    public CountryEntity mapModelToEntity(CountryModel model) {
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

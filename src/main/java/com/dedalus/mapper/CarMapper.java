package com.dedalus.mapper;

import com.dedalus.entity.CarEntity;
import com.dedalus.model.CarModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CarMapper {
    @Inject UUIDMapper uuidMapper;

    public CarEntity mapToEntity(CarModel carModel) {
        return new CarEntity()
                .setId(uuidMapper.mapToUUID(carModel.getId()))
                .setHorsepower(carModel.getHorsepower())
                .setModel(carModel.getModel())
                .setManufacturer(carModel.getManufacturer())
                .setColor(carModel.getColor());
    }

    public CarModel mapToModel(CarEntity carEntity) {
        return new CarModel()
                .setId(uuidMapper.mapToString(carEntity.getId()))
                .setHorsepower(carEntity.getHorsepower())
                .setModel(carEntity.getModel())
                .setManufacturer(carEntity.getManufacturer())
                .setColor(carEntity.getColor());
    }
}

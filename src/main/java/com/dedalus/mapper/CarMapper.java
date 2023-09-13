package com.dedalus.mapper;

import com.dedalus.entity.CarEntity;
import com.dedalus.entity.ColorType;
import com.dedalus.model.CarModel;
import com.dedalus.service.ManufacturerService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/*
These kinds of mappers could be replaced by automatically generated ones from MapStruct.
https://mapstruct.org/

To see a mapper in use in a Dedalus Project, go see for example the
MedicalQuestionRepresentationMapping in the u-specimen project
https://trrsuv040.agfahealthcare.com/orbis-u/u-specimen/-/blob/master/backend/src/main/java/com/orbis/u/specimen/mapping/question/MedicalQuestionRepresentationMapping.java

Note the CDI specific configuration in the pom.xml
https://trrsuv040.agfahealthcare.com/orbis-u/u-specimen/-/blob/master/backend/pom.xml
 */
@ApplicationScoped
public class CarMapper {
    @Inject
    UUIDMapper uuidMapper;
    @Inject
    ColorMapper colorMapper;
    @Inject
    ManufacturerService manufacturerService;

    public CarEntity mapToEntity(CarModel carModel) {
        return new CarEntity()
                .setId(uuidMapper.mapToUUID(carModel.getId()))
                .setHorsepower(carModel.getHorsepower())
                .setModel(carModel.getModel())
                .setManufacturer(manufacturerService.getOrCreateByName(carModel.getManufacturer()))
                .setColor(colorMapper.mapToColorType(carModel.getColor()));
    }

    public CarModel mapToModel(CarEntity carEntity) {
        return new CarModel()
                .setId(uuidMapper.mapToString(carEntity.getId()))
                .setHorsepower(carEntity.getHorsepower())
                .setModel(carEntity.getModel())
                .setManufacturer(carEntity.getManufacturer() == null ? null : carEntity.getManufacturer().getName())
                .setColor(colorMapper.mapToString(carEntity.getColor()));
    }
}

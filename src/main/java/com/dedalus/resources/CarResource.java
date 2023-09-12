package com.dedalus.resources;

import com.dedalus.entity.CarEntity;
import com.dedalus.mapper.CarMapper;
import com.dedalus.model.CarModel;
import com.dedalus.persistence.CarRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/resources/car")
@RequestScoped
public class CarResource {
    @Inject
    CarRepository carRepository;
    @Inject
    CarMapper carMapper;

    @POST
    public CarModel create(CarModel carModel) {
        CarEntity carEntity = carMapper.mapToEntity(carModel);
        carEntity = carRepository.save(carEntity);
        return carMapper.mapToModel(carEntity);
    }
}

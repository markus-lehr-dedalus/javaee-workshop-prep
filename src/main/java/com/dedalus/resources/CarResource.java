package com.dedalus.resources;

import com.dedalus.entity.CarEntity;
import com.dedalus.mapper.CarMapper;
import com.dedalus.model.CarModel;
import com.dedalus.persistence.CarRepository;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;
import java.util.stream.Collectors;

@Path("/resources/car")
@RequestScoped
@Slf4j
public class CarResource {
    @Inject
    CarRepository carRepository;
    @Inject
    CarMapper carMapper;

    @POST
    @Transactional
    public CarModel create(CarModel carModel) {
        CarEntity carEntity = carMapper.mapToEntity(carModel);
        carEntity = carRepository.save(carEntity);
        log.info("Created car " + carEntity);
        return carMapper.mapToModel(carEntity);
    }

    @GET
    public List<CarModel> getAll() {
        return carRepository.getAll()
                            .stream()
                            .map(carMapper::mapToModel)
                            .collect(Collectors.toList());
    }
}

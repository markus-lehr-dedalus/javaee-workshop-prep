package com.dedalus.resources;

import com.dedalus.entity.CarEntity;
import com.dedalus.mapper.CarMapper;
import com.dedalus.model.CarModel;
import com.dedalus.persistence.CarRepository;
import com.dedalus.service.CarApiNinjaService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;
import java.util.stream.Collectors;

@Path("/resources/car")
@RequestScoped
@Slf4j
public class CarResource {
    @ConfigProperty(name = "API_NINJA_KEY")
    String apiNinjaApiKey;

    @Inject
    CarRepository carRepository;
    @Inject
    CarMapper carMapper;
    @Inject
    @RestClient
    CarApiNinjaService carApiNinjaService;

    @POST
    @Transactional
    public CarModel create(@Valid CarModel carModel) {
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

    @GET
    @Path("further-info")
    public Object testApi() {
        return carApiNinjaService.getCarInfo("audi", "a3", apiNinjaApiKey);
    }
}

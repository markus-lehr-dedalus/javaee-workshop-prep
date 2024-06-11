package com.dedalus.animal.resource;

import com.dedalus.animal.model.AnimalDto;
import com.dedalus.animal.service.AnimalService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("animal")
public class AnimalResource {

    @Inject
    AnimalService animalService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AnimalDto> listAll() {
        return animalService.findAll();
    }
}

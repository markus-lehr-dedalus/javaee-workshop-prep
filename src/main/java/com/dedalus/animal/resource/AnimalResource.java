package com.dedalus.animal.resource;

import com.dedalus.animal.model.AnimalDetailedDto;
import com.dedalus.animal.model.AnimalDto;
import com.dedalus.animal.service.AnimalService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
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

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public AnimalDetailedDto put(AnimalDetailedDto request) {
        return animalService.createOrUpdate(request);
    }
}

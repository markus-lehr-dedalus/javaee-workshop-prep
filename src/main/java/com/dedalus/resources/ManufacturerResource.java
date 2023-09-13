package com.dedalus.resources;

import com.dedalus.mapper.ManufacturerMapper;
import com.dedalus.model.ManufacturerModel;
import com.dedalus.persistence.ManufacturerRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.stream.Collectors;

@Path("/resources/manufacturer")
@RequestScoped
public class ManufacturerResource {
    @Inject
    ManufacturerRepository manufacturerRepository;
    @Inject
    ManufacturerMapper manufacturerMapper;

    @GET
    public List<ManufacturerModel> getAll() {
        return manufacturerRepository
                .getAll()
                .stream()
                .map(manufacturerMapper::mapToModel)
                .collect(Collectors.toList());
    }
}

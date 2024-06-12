package com.dedalus.resource;

import com.dedalus.control.CountryMapper;
import com.dedalus.model.CountryModel;
import com.dedalus.persistence.CountryRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@Path("country")
@RequestScoped
public class CountryResource {
    @Inject
    CountryRepository repository;
    @Inject
    CountryMapper mapper;

    @GET
    public List<CountryModel> getCountries() {
        return repository.getAll()
                         .stream()
                         .map(mapper::map)
                         .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    public CountryModel getCountry(@PathParam("id") Long countryId) {
        return mapper.map(repository.findById(countryId));
    }

    @POST
    @Transactional
    public CountryModel addCountry(CountryModel country) {
        return mapper.map(repository.save(mapper.map(country)));
    }
}

















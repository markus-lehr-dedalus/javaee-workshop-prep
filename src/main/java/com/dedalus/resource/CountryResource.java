package com.dedalus.resource;

import com.dedalus.control.ApiNinjaService;
import com.dedalus.control.CountryMapper;
import com.dedalus.model.CountryModel;
import com.dedalus.persistence.CountryRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collectors;

@Path("country")
@RequestScoped
public class CountryResource {
    @Inject
    CountryRepository repository;
    @Inject
    CountryMapper mapper;
    @Inject
    ApiNinjaService apiNinjaService;

    @GET
    public List<CountryModel> getCountries() {
        return repository.getAll()
                         .stream()
                         .map(mapper::mapEntityToModel)
                         .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    public CountryModel getCountry(@PathParam("id") Long countryId) {
        return mapper.mapEntityToModel(repository.findById(countryId));
    }

    @POST
    @Transactional
    public CountryModel addCountry(@Valid CountryModel country) {
        return mapper.mapEntityToModel(repository.save(mapper.mapModelToEntity(country)));
    }

    @POST
    @Path("import")
    @Transactional
    public List<CountryModel> importCountries(@QueryParam("name") String name, @QueryParam("numberOfCountries") Integer numberOfCountries) {
        List<CountryModel> countries = apiNinjaService.getCountries(name, numberOfCountries);
        countries = countries
                .stream()
                .map(mapper::mapModelToEntity)
                .map(repository::save)
                .map(mapper::mapEntityToModel)
                .collect(Collectors.toList());
        System.out.println(countries);
        return countries;
    }
}

















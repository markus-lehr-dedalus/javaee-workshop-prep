package com.dedalus.control.mock;

import com.dedalus.control.ApiNinjaRestClient;
import com.dedalus.model.ApiNinjaCountryModel;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
@RestClient
@Alternative
public class FakingApiNinjaRestClient implements ApiNinjaRestClient {
    public static final ApiNinjaCountryModel DUMMY_MODEL = new ApiNinjaCountryModel()
            .setName("My Country")
            .setCountryCode("MC")
            .setContinent("My Continent")
            .setPopulation("69420");

    @Override
    public Collection<ApiNinjaCountryModel> getCountries(String name, Integer limit, String apiKey) {
        return List.of(DUMMY_MODEL);
    }
}

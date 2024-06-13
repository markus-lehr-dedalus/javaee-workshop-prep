package com.dedalus.control.mock;

import com.dedalus.control.ApiNinjaRestClient;
import com.dedalus.model.ApiNinjaCountryModel;
import io.quarkus.arc.Priority;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.Collection;

@ApplicationScoped
@RestClient
@Alternative
public class FailingApiNinjaRestClient implements ApiNinjaRestClient {
    @Override
    public Collection<ApiNinjaCountryModel> getCountries(String name, Integer limit, String apiKey) {
        throw new RuntimeException("Always fails");
    }
}

package com.dedalus.control;

import com.dedalus.model.ApiNinjaCountryModel;
import com.dedalus.model.CountryModel;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ApiNinjaService {
    @Inject
    CountryMapper countryMapper;
    @Inject
    @RestClient
    ApiNinjaRestClient restClient;
    @ConfigProperty(name = "API_NINJA_KEY")
    String apiKey;

    @Retry
    @Fallback(fallbackMethod = "countryFallback")
    public List<CountryModel> getCountries(String name, Integer limit) {
        System.out.println("Attempting to get countries");
        if (Math.random() < 0.5) {
            throw new RuntimeException("Random error occurred");
        }
        Collection<ApiNinjaCountryModel> countries = restClient.getCountries(name, limit, apiKey);
        return countries.stream().map(countryMapper::map).collect(Collectors.toList());
    }

    private List<CountryModel> countryFallback(String name, Integer limit) {
        return new ArrayList<>();
    }
}

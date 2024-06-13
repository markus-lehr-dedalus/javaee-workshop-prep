package com.dedalus.control;

import com.dedalus.model.ApiNinjaCountryModel;
import com.dedalus.model.CountryModel;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ApiNinjaService {
    public static final List<CountryModel> FALLBACK_COUNTRIES = List.of();

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
        Collection<ApiNinjaCountryModel> countries = restClient.getCountries(name, limit, apiKey);
        return countries
                .stream()
                .map(countryMapper::mapApiNinjaToModel)
                .collect(Collectors.toList());
    }

    private List<CountryModel> countryFallback(String name, Integer limit) {
        System.err.println("Falling back");
        return FALLBACK_COUNTRIES;
    }
}

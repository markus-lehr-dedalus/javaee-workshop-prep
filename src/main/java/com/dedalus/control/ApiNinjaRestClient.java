package com.dedalus.control;

import com.dedalus.model.ApiNinjaCountryModel;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.Collection;

@RegisterRestClient(baseUri = "https://api.api-ninjas.com/v1")
@ApplicationScoped
public interface ApiNinjaRestClient {
    @GET
    @Path("country")
    Collection<ApiNinjaCountryModel> getCountries(
            @QueryParam("name") String name,
            @QueryParam("limit") Integer limit,
            @HeaderParam("X-Api-Key") String apiKey);
}

package com.dedalus.resources;

import com.dedalus.model.GreetingEntity;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public GreetingEntity hello() {
        GreetingEntity greetingEntity = new GreetingEntity();
        greetingEntity.setPhrase("Hello World!");
        greetingEntity.persistAndFlush();
        return greetingEntity;
    }
}
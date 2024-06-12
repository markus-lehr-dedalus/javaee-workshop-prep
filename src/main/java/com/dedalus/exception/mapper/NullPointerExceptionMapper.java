package com.dedalus.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NullPointerExceptionMapper implements ExceptionMapper<NullPointerException> {
    @Override
    public Response toResponse(NullPointerException exception) {
        return Response.ok("The property you tried to access was null: " + exception.getMessage())
                       .status(510)
                       .build();
    }
}

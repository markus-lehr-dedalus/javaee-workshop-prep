package com.dedalus.exception;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/*
You could map exceptions in the recommended scheme of HAC in a place like this
https://confluence.dedalus.com/display/HAC/Exception+handling+and+bean+validation+concept
*/
@Provider
public class ContstraintValidationExceptionMapper implements ExceptionMapper<ValidationException> {
    @Override
    public Response toResponse(ValidationException exception) {
        return Response.status(442)
                       .entity("You did bad")
                       .build();
    }
}

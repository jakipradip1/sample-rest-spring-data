package com.cubic.exceptionhandler;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.cubic.exception.ValidationException;
import com.cubic.rest.ErrorResponse;

@Component
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ValidationExceptionHandler implements ExceptionMapper<ValidationException> {

	public ValidationExceptionHandler() {
		// TODO Auto-generated constructor stub
	}

	public Response toResponse(ValidationException error) {
		// TODO Auto-generated method stub
		ErrorResponse er = new ErrorResponse();
		er.setCode("CUST-520");
		er.setError(error.getMessage());
		return Response.status(520).entity(er).build();
	}

}

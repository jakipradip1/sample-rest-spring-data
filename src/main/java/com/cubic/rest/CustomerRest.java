package com.cubic.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cubic.service.CustomerService;
import com.cubic.service.CustomerServiceImplementation;
import com.cubic.vo.CustomerVO;

@Service
@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerRest {

	@Autowired
	@Qualifier("csSData")
	private CustomerService service;

	private final static Logger logger = LoggerFactory.getLogger(CustomerRest.class);

	@GET
	@Path("/all")
	public Response findALl() {
		CustomerList customerList = new CustomerList(service.findAll());
		return Response.ok().entity(customerList).build();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response findCustomer(@PathParam("id") final Long id) {
		final CustomerVO vo = service.find(id);

		ResponseBuilder rb = Response.ok();
		if (vo.getfName().startsWith("J")) {
			rb = rb.type(MediaType.APPLICATION_JSON);
		} else {
			rb = rb.type(MediaType.APPLICATION_XML);
		}
		return rb.entity(vo).build();
	}

	@POST
	public Response createCustomer(final CustomerVO vo) {
		logger.debug("Entering CustomerRest.createCustomer");
		logger.debug("Customer VO = {}", vo);
		logger.debug("Customer FirstName = {}, Lastname = {}", vo.getfName(), vo.getlName());
		CustomerVO vo1 = service.create(vo);

		logger.debug("Created Customer Sucessfully. ResponseEntity = {}", vo1);
		logger.debug("Exiting CustomerRest.createCustomer");
		return Response.ok().entity(vo1).build();

	}

	@PUT
	public Response updateCustomer(final CustomerVO vo) {
		CustomerVO vo1 = service.update(vo);
		return Response.ok().entity(vo).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteCustomer(@PathParam("id") final Long id) {
		service.delete(id);
		return Response.noContent().build();
	}

	@GET
	@Path("/find")
	public Response searchByName(@QueryParam("name") final String name) {

		return Response.ok().entity(new CustomerList(service.findByName(name))).build();
	}

	@GET
	@Path("/matrix")
	public Response searchByMatrix(@MatrixParam("name") final String name) {
		return Response.ok().entity(new CustomerList(service.findByName(name))).build();
	}

	@GET
	@Path("/getUsingHeader")
	public Response searchByHeader(@HeaderParam("name") final String name) {
		return Response.ok().entity(new CustomerList(service.findByName(name))).build();

	}

	@GET
	@Path("/getUsingHeaderContext")
	public Response searchByHeader(@Context final HttpHeaders headers) {
		final String name = headers.getRequestHeader("name").get(0);
		return Response.ok().entity(new CustomerList(service.findByName(name))).build();

	}

}

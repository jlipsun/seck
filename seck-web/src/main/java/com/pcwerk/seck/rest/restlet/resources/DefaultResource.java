package com.pcwerk.seck.rest.restlet.resources;

import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class DefaultResource extends ServerResource {

	// Create methods that handle appropriate HTTP methods,
	// such as GET, POST, PUT, DELETE and add the corresponding
	// annotations @GET, @POST @PUT, @DELETE above the method declaration
	@Get
	public String processGetRequest() throws ResourceException {
		return "Resource " + getReference().getPath() + " not found";
	}
}

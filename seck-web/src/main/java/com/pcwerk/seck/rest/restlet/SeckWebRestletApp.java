package com.pcwerk.seck.rest.restlet;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.pcwerk.seck.rest.restlet.resources.DefaultResource;

public class SeckWebRestletApp extends Application {

	/**
	 * Creates a root Restlet that will receive all incoming requests.
	 */
	@Override
	public synchronized Restlet createInboundRoot() {
		// Create a router Restlet that routes requests to an appropriate
		// ServerResource object that will process the request
		Router router = new Router(getContext());

		// TODO: Define URI mapping to classes that extend ServerResource class
		// TODO: Put ServerResource subclass in the
		// com.pcwerk.seck.rest.reslet.resources package
		// Example: router.attach("/search", SearchResource.class);

		// Default resource handler for unmapped URIs
		router.attachDefault(DefaultResource.class);

		return router;
	}
}

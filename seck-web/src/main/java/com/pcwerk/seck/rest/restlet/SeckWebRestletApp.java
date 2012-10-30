package com.pcwerk.seck.rest.restlet;

import java.util.Date;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.ext.freemarker.ContextTemplateLoader;
import org.restlet.routing.Router;

import com.pcwerk.seck.rest.entities.GuestEntry;
import com.pcwerk.seck.rest.models.GuestBook;
import com.pcwerk.seck.rest.models.InMemoryGuestBook;
import com.pcwerk.seck.rest.restlet.resources.DefaultResource;
import com.pcwerk.seck.rest.restlet.resources.HelloWorldResource;

import freemarker.template.Configuration;

public class SeckWebRestletApp extends Application {

	// Freemarker configuration
	private Configuration configuration;

	private GuestBook guestBook;

	public SeckWebRestletApp() {
		this.guestBook = new InMemoryGuestBook();
		populateGuestBook();
	}

	/**
	 * Creates a root Restlet that will receive all incoming requests.
	 */
	@Override
	public synchronized Restlet createInboundRoot() {
		// Create a router Restlet that routes requests to an appropriate
		// ServerResource object that will process the request
		Router router = new Router(getContext());

		// Set freemarker configuration
		configuration = new Configuration();
		configuration.setTemplateLoader(new ContextTemplateLoader(getContext(),
				"war:///WEB-INF/templates"));

		// TODO: Define URI mapping to classes that extend ServerResource class
		// TODO: Put ServerResource subclass in the
		// com.pcwerk.seck.rest.reslet.resources package
		// Example: router.attach("/search", SearchResource.class);
		router.attach("/helloworld", HelloWorldResource.class);
		router.attach("/helloworld/", HelloWorldResource.class);
		router.attach("/helloworld/{name}", HelloWorldResource.class);

		// Default resource handler for unmapped URIs
		router.attachDefault(DefaultResource.class);

		return router;
	}

	public GuestBook getGuestBook() {
		return guestBook;
	}

	public Configuration getConfiguration() {
		return configuration;
	}
	
	private void populateGuestBook() {
		final int MAX_GUESTS = 10;
		final String name = "Guest";

		for (int i = 0; i < MAX_GUESTS; i++) {
			this.guestBook.addGuestEntry(new GuestEntry(name + i, new Date(),
					"Hello from " + (name + i)));
		}

	}
}
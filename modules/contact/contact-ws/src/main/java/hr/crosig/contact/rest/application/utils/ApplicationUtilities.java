package hr.crosig.contact.rest.application.utils;

import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * @author marcelo.mazurky
 */
public class ApplicationUtilities {

	public static synchronized Client getDefaultHttpClient() {
		ClientBuilder clientBuilder;
		clientBuilder = ClientBuilder.newBuilder();

		clientBuilder.connectTimeout(10, TimeUnit.SECONDS);
		clientBuilder.readTimeout(60, TimeUnit.SECONDS);

		return clientBuilder.build();
	}

}
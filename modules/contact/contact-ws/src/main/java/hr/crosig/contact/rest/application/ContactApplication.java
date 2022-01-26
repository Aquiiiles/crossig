package hr.crosig.contact.rest.application;

import hr.crosig.contact.rest.application.utils.ApiConstants;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author victor.catanante
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/agent-portal-contact",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Contact.Rest",
		JaxrsWhiteboardConstants.JAX_RS_MEDIA_TYPE + "=application/json",
		"auth.verifier.guest.allowed=false",
		"liferay.access.control.disable=false"
	},
	service = Application.class
)
public class ContactApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(
		@QueryParam("q") String query, @QueryParam("city") String city,
		@QueryParam("address") String address,
		@QueryParam("phoneCountryCode") String phoneCountryCode,
		@QueryParam("phoneAreaCode") String phoneAreaCode,
		@QueryParam("phoneNumber") String phoneNumber,
		@QueryParam("email") String email) {

		try {
			return getClient(
			).target(
				ApiConstants.MOCK_CONTACTS_API_URL
			).request(
			).get();
		}
		catch (Exception exception) {
			return Response.serverError(
			).build();
		}
	}

	protected Client getClient() {
		if (_client == null) {
			ClientBuilder clientBuilder = ClientBuilder.newBuilder();

			clientBuilder.connectTimeout(10, TimeUnit.SECONDS);
			clientBuilder.readTimeout(60, TimeUnit.SECONDS);

			_client = clientBuilder.build();
		}

		return _client;
	}

	private Client _client;

}
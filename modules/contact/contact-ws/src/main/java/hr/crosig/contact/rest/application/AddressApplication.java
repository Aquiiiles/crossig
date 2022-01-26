package hr.crosig.contact.rest.application;

import hr.crosig.contact.rest.application.utils.ApiConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author marcelo.mazurky
 */
@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/agent-portal/city",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=City.Rest",
                JaxrsWhiteboardConstants.JAX_RS_MEDIA_TYPE + "=application/json",
                "auth.verifier.guest.allowed=true",
                "liferay.access.control.disable=true"
        },
        service = Application.class
)
public class AddressApplication extends Application {

    private Client _client;

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCities() {

        try {
            return getClient(
            ).target(
                    ApiConstants.MOCK_CITIES_ALL_API_URL
            ).request(
            ).get();
        } catch (Exception exception) {
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

}
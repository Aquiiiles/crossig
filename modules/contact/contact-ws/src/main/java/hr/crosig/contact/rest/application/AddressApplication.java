package hr.crosig.contact.rest.application;

import hr.crosig.contact.rest.application.utils.AddressApplicationConstants;
import hr.crosig.contact.rest.application.utils.ApplicationUtilities;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.Set;

/**
 * @author marcelo.mazurky
 */
@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/agent-portal/city",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=City.Rest",
                JaxrsWhiteboardConstants.JAX_RS_MEDIA_TYPE + "=application/json",
                "auth.verifier.guest.allowed=false",
                "liferay.access.control.disable=false"
        },
        service = Application.class
)
public class AddressApplication extends Application {

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCities() {

        try {
            return ApplicationUtilities.getDefaultHttpClient(
            ).target(
                    AddressApplicationConstants.MOCK_CITIES_ALL_API_URL
            ).request(
            ).get();
        } catch (Exception exception) {
            return Response.serverError(
            ).build();
        }
    }

    @GET
    @Path("/{cityId}/streets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStreetsByCity(@PathParam("cityId") long cityId) {

        try {
            return ApplicationUtilities.getDefaultHttpClient(
            ).target(
                    AddressApplicationConstants.MOCK_CITIES_STREET_API_URL
            ).request(
            ).get();
        } catch (Exception exception) {
            return Response.serverError(
            ).build();
        }
    }

}
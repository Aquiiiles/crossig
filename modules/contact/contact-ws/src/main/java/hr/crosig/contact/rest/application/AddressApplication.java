package hr.crosig.contact.rest.application;

import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.common.ws.response.ServiceResponse;
import hr.crosig.contact.rest.application.utils.ApplicationUtilities;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
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
            ServiceResponse serviceResponse = _iditwsClient.getCities();

            return ApplicationUtilities.handleServiceResponse(serviceResponse);
        } catch (Exception exception) {
            return ApplicationUtilities.handleErrorResponse(exception);
        }
    }

	@GET
	@Path("/{cityId}/streets")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStreetsByCity(@PathParam("cityId") long cityId) {
		try {
			ServiceResponse serviceResponse =  _iditwsClient.getStreetsByCityId(cityId);

			return ApplicationUtilities.handleServiceResponse(serviceResponse);
		} catch (Exception exception) {
			return ApplicationUtilities.handleErrorResponse(exception);
		}
	}

    @Reference
    private IDITWSClient _iditwsClient;

}
package hr.crosig.contact.rest.application;

import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.common.ws.response.ServiceResponse;
import hr.crosig.contact.rest.application.utils.ApplicationUtilities;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author marcelo.mazurky
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/agent-portal/phone",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Phone.Rest",
		JaxrsWhiteboardConstants.JAX_RS_MEDIA_TYPE + "=application/json",
		"auth.verifier.guest.allowed=false",
		"liferay.access.control.disable=false"
	},
	service = Application.class
)
public class AreaCodeApplication extends Application {

	@GET
	@Path("/area-code")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAreaCodes() {
		try {
			ServiceResponse serviceResponse = _iditwsClient.getAreaCodes();

			return ApplicationUtilities.handleServiceResponse(serviceResponse);
		}
		catch (Exception exception) {
			return ApplicationUtilities.handleErrorResponse(exception);
		}
	}

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@Reference
	private IDITWSClient _iditwsClient;

}
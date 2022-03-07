package hr.crosig.proposal.rest.application;

import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.common.ws.response.ServiceResponse;
import hr.crosig.proposal.rest.application.utils.ApplicationUtilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Guilherme Kfouri
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/agent-portal/vessel",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Vessel.Rest",
		JaxrsWhiteboardConstants.JAX_RS_MEDIA_TYPE + "=application/json",
		"auth.verifier.guest.allowed=false",
		"liferay.access.control.disable=false"
	},
	service = Application.class
)
public class VesselApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@Path("/search")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchVessels(
		@QueryParam("vesselType") String vesselType,
		@QueryParam("vesselName") String vesselName,
		@QueryParam("registrationMark") String registrationMark,
		@QueryParam("nib") String nib) {

		try {
			HashMap<String, Object> vesselRequestMap = new HashMap<>();

			vesselRequestMap.put("nib", nib);
			vesselRequestMap.put("registrationMark", registrationMark);
			vesselRequestMap.put("vesselName", vesselName);
			vesselRequestMap.put("vesselType", vesselType);

			String jsonRequest = ApplicationUtilities.createEntityJsonString(
				vesselRequestMap);

			ServiceResponse serviceResponse = _iditwsClient.searchVessel(
				jsonRequest);

			return ApplicationUtilities.handleServiceResponse(serviceResponse);
		}
		catch (Exception exception) {
			return ApplicationUtilities.handleErrorResponse(exception);
		}
	}

	@Reference
	private IDITWSClient _iditwsClient;

}
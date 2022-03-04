package hr.crosig.proposal.rest.application;

import hr.crosig.proposal.dto.VesselSearchResultDTO;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
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

	@Path("/search")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCoveragePlansByCategory(
		@QueryParam("vesselType") String vesselType,
		@QueryParam("vesselName") String vesselName,
		@QueryParam("registrationMark") String registrationMark,
		@QueryParam("nib") String nib) {

		Response.ResponseBuilder responseBuilder;

		try {
			VesselSearchResultDTO vesselSearchResultDTO =
				new VesselSearchResultDTO();

			responseBuilder = Response.ok(
			).entity(
				vesselSearchResultDTO
			);
		}
		catch (Exception exception) {
			responseBuilder = Response.serverError(
			).entity(
				exception.getMessage()
			);
		}

		return responseBuilder.build();
	}

}
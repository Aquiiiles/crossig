package hr.crosig.proposal.rest.application;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import hr.crosig.proposal.rest.application.enums.InsuredRole;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author victor.catanante
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/agent-portal/proposal",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Proposal.Rest",
		JaxrsWhiteboardConstants.JAX_RS_MEDIA_TYPE + "=application/json",
		"auth.verifier.guest.allowed=false",
		"liferay.access.control.disable=false"
	},
	service = Application.class
)
public class ProposalApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@Path("/insured-roles")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInsuredRoleTypes() {
		Response.ResponseBuilder responseBuilder;

		try {
			List<InsuredRole> insuredRoles = Arrays.asList(InsuredRole.values());
			responseBuilder = Response.ok().entity(insuredRoles);
		} catch (Exception exception) {
			responseBuilder = Response.serverError().entity(exception.getMessage());
		}

		return responseBuilder.build();
	}
}
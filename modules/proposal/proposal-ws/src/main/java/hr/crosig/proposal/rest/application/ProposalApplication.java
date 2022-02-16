package hr.crosig.proposal.rest.application;

import hr.crosig.proposal.model.Product;
import hr.crosig.proposal.rest.application.enums.InsuredRole;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import hr.crosig.proposal.service.ProductLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author victor.catanante
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/agent-portal/proposal",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Proposal.Rest",
		JaxrsWhiteboardConstants.JAX_RS_MEDIA_TYPE + "=application/json",
		"auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true"
	},
	service = Application.class
)
public class ProposalApplication extends Application {

	@GET
	@Path("/insured-roles")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInsuredRoleTypes() {
		Response.ResponseBuilder responseBuilder;

		try {
			List<InsuredRole> insuredRoles = Arrays.asList(
				InsuredRole.values());

			responseBuilder = Response.ok(
			).entity(
				insuredRoles
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

	@GET
	@Path("/products/{roleId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts(@PathParam("roleId") long roleId) {
		Response.ResponseBuilder responseBuilder;
		try {
			List<Product> products = _productLocalService.getProducts(roleId);

			responseBuilder = Response.ok(
			).entity(
					products
			);
		} catch (Exception exception) {
			responseBuilder = Response.serverError(
			).entity(
					exception.getMessage()
			);

		}
		return responseBuilder.build();
	}

	@Reference
	protected ProductLocalService _productLocalService;


	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

}
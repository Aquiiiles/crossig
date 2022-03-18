package hr.crosig.proposal.rest.application;

import hr.crosig.proposal.dto.CoveragePlanDTO;
import hr.crosig.proposal.dto.InsuredRoleDTO;
import hr.crosig.proposal.dto.ProductDTO;
import hr.crosig.proposal.dto.ProposalDTO;
import hr.crosig.proposal.service.CoveragePlanLocalService;
import hr.crosig.proposal.service.InsuredRoleLocalService;
import hr.crosig.proposal.service.ProductLocalService;
import hr.crosig.proposal.service.ProposalLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

	@GET
	@Path("/coverage-plans")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCoveragePlansByCategory(
		@QueryParam("category") String category) {

		Response.ResponseBuilder responseBuilder;

		try {
			List<CoveragePlanDTO> coveragePlans =
				_coveragePlanLocalService.getCoveragePlansByCategory(category);

			responseBuilder = Response.ok(
			).entity(
				coveragePlans
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
	@Path("/insured-roles")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInsuredRoles() {
		Response.ResponseBuilder responseBuilder;

		try {
			List<InsuredRoleDTO> insuredRole =
				_insuredRoleLocalService.getAllInsuredRole();

			responseBuilder = Response.ok(
			).entity(
				insuredRole
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
	@Path("/products/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductsByUserId(@PathParam("userId") long userId) {
		Response.ResponseBuilder responseBuilder;

		try {
			List<ProductDTO> products =
				_productLocalService.getProductsByUserId(userId);

			responseBuilder = Response.ok(
			).entity(
				products
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

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProposal(ProposalDTO proposalDTO) {
		Response.ResponseBuilder responseBuilder;

		try {
			proposalDTO = _proposalLocalService.createProposal(proposalDTO);

			responseBuilder = Response.ok(
			).entity(
					proposalDTO
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

	@PUT
	@Path("/{proposalId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProposal(@PathParam("proposalId") long proposalId, ProposalDTO proposalDTO) {
		Response.ResponseBuilder responseBuilder;

		try {
			proposalDTO = _proposalLocalService.updateProposal(proposalId, proposalDTO);

			responseBuilder = Response.ok(
			).entity(
					proposalDTO
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

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@Reference
	private CoveragePlanLocalService _coveragePlanLocalService;

	@Reference
	private InsuredRoleLocalService _insuredRoleLocalService;

	@Reference
	private ProductLocalService _productLocalService;

	@Reference
	private ProposalLocalService _proposalLocalService;

}
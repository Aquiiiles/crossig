package hr.crosig.proposal.rest.application;

import com.liferay.portal.kernel.exception.PortalException;

import hr.crosig.proposal.dto.CoveragePlanDTO;
import hr.crosig.proposal.dto.InsuredRoleDTO;
import hr.crosig.proposal.dto.ProductDTO;
import hr.crosig.proposal.dto.ProposalDTO;
import hr.crosig.proposal.service.CoveragePlanLocalService;
import hr.crosig.proposal.service.InsuredRoleLocalService;
import hr.crosig.proposal.service.ProductLocalService;
import hr.crosig.proposal.service.ProposalLocalService;

import java.util.Collections;
import java.util.List;
import java.util.Set;

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
		"auth.verifier.guest.allowed=false",
		"liferay.access.control.disable=false"
	},
	service = Application.class
)
public class ProposalApplication extends Application {

	@Path("/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProposal(ProposalDTO proposalDTO) {
		Response.ResponseBuilder responseBuilder;

		try {
			responseBuilder = Response.ok(
			).entity(
				_proposalLocalService.createProposal(proposalDTO)
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
	@Path("/agent/{agentUserId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAgentProposals(
		@PathParam("agentUserId") long agentUserId) {

		Response.ResponseBuilder responseBuilder;

		try {
			responseBuilder = Response.ok(
			).entity(
				_proposalLocalService.getAgentProposals(agentUserId)
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

	@GET
	@Path("/{proposalId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProposal(@PathParam("proposalId") long proposalId) {
		Response.ResponseBuilder responseBuilder;

		try {
			ProposalDTO proposalDTO = _proposalLocalService.getProposalDTO(
				proposalId);

			if (proposalDTO == null) {
				responseBuilder = Response.status(Response.Status.NOT_FOUND);
			}
			else {
				responseBuilder = Response.ok(
				).entity(
					proposalDTO
				);
			}
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

	@Path("/{proposalId}")
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public Response updateProposal(
		@PathParam("proposalId") long proposalId, ProposalDTO proposalDTO) {

		Response.ResponseBuilder responseBuilder;

		try {
			proposalDTO = _proposalLocalService.updateProposal(
				proposalId, proposalDTO);

			responseBuilder = Response.ok(
			).entity(
				proposalDTO
			);
		}
		catch (PortalException portalException) {
			responseBuilder = Response.status(
				Response.Status.BAD_REQUEST
			).entity(
				portalException.getMessage()
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

	@Reference
	private CoveragePlanLocalService _coveragePlanLocalService;

	@Reference
	private InsuredRoleLocalService _insuredRoleLocalService;

	@Reference
	private ProductLocalService _productLocalService;

	@Reference
	private ProposalLocalService _proposalLocalService;

}
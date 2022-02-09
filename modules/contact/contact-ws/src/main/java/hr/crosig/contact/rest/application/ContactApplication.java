package hr.crosig.contact.rest.application;

import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.common.ws.response.ServiceResponse;
import hr.crosig.contact.dto.ContactDTO;
import hr.crosig.contact.dto.EmailDTO;
import hr.crosig.contact.dto.TelephoneDTO;
import hr.crosig.contact.rest.application.utils.ApplicationUtilities;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/agent-portal/contact",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Contact.Rest",
		JaxrsWhiteboardConstants.JAX_RS_MEDIA_TYPE + "=application/json",
		"auth.verifier.guest.allowed=false",
		"liferay.access.control.disable=false"
	},
	service = Application.class
)
public class ContactApplication extends Application {

	@Path("/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createContact(ContactDTO contactDTO) {
		try {
			String entityJSON = ApplicationUtilities.createEntityJsonString(
				contactDTO);

			ServiceResponse serviceResponse = _iditwsClient.createContact(
				entityJSON);

			return ApplicationUtilities.handleServiceResponse(serviceResponse);
		}
		catch (Exception exception) {
			return ApplicationUtilities.handleErrorResponse(exception);
		}
	}

	@GET
	@Path("/{extNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getContact(@PathParam("extNumber") String extNumber) {
		try {
			ServiceResponse serviceResponse = _iditwsClient.getContact(
				extNumber);

			return ApplicationUtilities.handleServiceResponse(serviceResponse);
		}
		catch (Exception exception) {
			return ApplicationUtilities.handleErrorResponse(exception);
		}
	}

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public Response updateContact(ContactDTO contactDTO) {
		try {
			String entityJSON = ApplicationUtilities.createEntityJsonString(
				contactDTO);

			ServiceResponse serviceResponse = _iditwsClient.updateContact(
				entityJSON);

			return ApplicationUtilities.handleServiceResponse(serviceResponse);
		}
		catch (Exception exception) {
			return ApplicationUtilities.handleErrorResponse(exception);
		}
	}

	@Path("/email/verification")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response validateEmail(List<EmailDTO> emails) {
		try {
			String entityJSON = ApplicationUtilities.createEntityJsonString(
				emails);

			ServiceResponse serviceResponse = _iditwsClient.validateEmail(
				entityJSON);

			return ApplicationUtilities.handleServiceResponse(serviceResponse);
		}
		catch (Exception exception) {
			return ApplicationUtilities.handleErrorResponse(exception);
		}
	}

	@Path("/phone/verification")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response validatePhoneNumber(List<TelephoneDTO> telephoneDTOS) {
		try {
			String entityJSON = ApplicationUtilities.createEntityJsonString(
				telephoneDTOS);

			ServiceResponse serviceResponse = _iditwsClient.validatePhone(
				entityJSON);

			return ApplicationUtilities.handleServiceResponse(serviceResponse);
		}
		catch (Exception exception) {
			return ApplicationUtilities.handleErrorResponse(exception);
		}
	}

	@Reference
	private IDITWSClient _iditwsClient;

}
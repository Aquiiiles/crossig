package hr.crosig.contact.rest.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.crosig.contact.rest.application.dto.ContactDTO;
import hr.crosig.contact.rest.application.dto.EmailDTO;
import hr.crosig.contact.rest.application.dto.PhoneNumberDTO;
import hr.crosig.contact.rest.application.utils.ApplicationUtilities;
import hr.crosig.contact.rest.application.utils.ContactApplicationConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
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
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/agent-portal/contact",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Contact.Rest",
		JaxrsWhiteboardConstants.JAX_RS_MEDIA_TYPE + "=application/json",
		"auth.verifier.guest.allowed=false",
		"liferay.access.control.disable=false"
	},
	service = Application.class
)
public class ContactApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(
		@QueryParam("nameOrOIB") String nameOrOIB,
		@QueryParam("city") String city,
		@QueryParam("streetAddress") String streetAddress,
		@QueryParam("phoneCountryCode") String phoneCountryCode,
		@QueryParam("phoneAreaCode") String phoneAreaCode,
		@QueryParam("phoneNumber") String phoneNumber,
		@QueryParam("email") String email) {

		try {
			return ApplicationUtilities.getDefaultHttpClient(
			).target(
				ContactApplicationConstants.MOCK_CONTACTS_API_URL
			).request(
			).get();
		}
		catch (Exception exception) {
			return Response.serverError(
			).build();
		}
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createContact(ContactDTO contactDTO) {
		try {
			String entityJson = createEntityJsonString(contactDTO);
			return ApplicationUtilities.getDefaultHttpClient(
			).target(
					"http://demo8853560.mockable.io/"
			).request(
			).post(Entity.json(entityJson));
		}
		catch (Exception exception) {
			return Response.serverError(
			).build();
		}
	}

	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateContact(ContactDTO contactDTO) {
		try {
			String entityJson = createEntityJsonString(contactDTO);
			return ApplicationUtilities.getDefaultHttpClient(
			).target(
					"http://demo8853560.mockable.io/"
			).request(
			).put(Entity.json(entityJson));
		}
		catch (Exception exception) {
			return Response.serverError(
			).build();
		}
	}

	@POST
	@Path("/email/verification")
	@Produces(MediaType.APPLICATION_JSON)
	public Response validateEmail(List<EmailDTO> emails) {
		try {
			String entityJson = createEntityJsonString(emails);
			return ApplicationUtilities.getDefaultHttpClient(
			).target(
				ContactApplicationConstants.MOCK_CONTACTS_EMAIL_VERIFICATION
			).request(
			).post(Entity.json(entityJson));
		}
		catch (Exception exception) {
			return Response.serverError(
			).build();
		}
	}

	@POST
	@Path("/phone/verification")
	@Produces(MediaType.APPLICATION_JSON)
	public Response validatePhoneNumber(List<PhoneNumberDTO> phoneNumberDTOS) {
		try {
			String entityJson = createEntityJsonString(phoneNumberDTOS);
			return ApplicationUtilities.getDefaultHttpClient(
			).target(
				ContactApplicationConstants.MOCK_CONTACTS_PHONE_VERIFICATION
			).request(
			).post(Entity.json(entityJson));
		}
		catch (Exception exception) {
			return Response.serverError(
			).build();
		}
	}

	protected String createEntityJsonString(Object entity) throws JsonProcessingException {
		ObjectMapper mapper = configureMapper();
		return mapper.writeValueAsString(entity);
	}

	protected ObjectMapper configureMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(
				JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(),
				true
		);
		return mapper;
	}

}
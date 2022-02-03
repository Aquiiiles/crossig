package hr.crosig.contact.rest.application;

import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.common.ws.response.ServiceResponse;
import hr.crosig.contact.rest.application.dto.ContactDTO;
import hr.crosig.contact.rest.application.dto.EmailDTO;
import hr.crosig.contact.rest.application.dto.PhoneNumberDTO;
import hr.crosig.contact.rest.application.utils.ApplicationUtilities;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createContact(ContactDTO contactDTO) {
		try {
			String entityJson = ApplicationUtilities.createEntityJsonString(contactDTO);
			ServiceResponse serviceResponse = _iditwsClient.createContact(entityJson);

			return ApplicationUtilities.handleServiceResponse(serviceResponse);
		} catch (Exception exception) {
			return ApplicationUtilities.handleErrorResponse(exception);
		}
	}

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createContact(ContactDTO contactDTO) {
        try {
            String entityJson = ApplicationUtilities.createEntityJsonString(contactDTO);
            ServiceResponse serviceResponse = _iditwsClient.createContact(entityJson);

            return ApplicationUtilities.handleServiceResponse(serviceResponse);
        } catch (Exception exception) {
            return ApplicationUtilities.handleErrorResponse(exception);
        }
    }

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateContact(ContactDTO contactDTO) {
        try {
            String entityJson = ApplicationUtilities.createEntityJsonString(contactDTO);
            ServiceResponse serviceResponse = _iditwsClient.updateContact(entityJson);

            return ApplicationUtilities.handleServiceResponse(serviceResponse);
        } catch (Exception exception) {
            return ApplicationUtilities.handleErrorResponse(exception);
        }
    }

    @POST
    @Path("/email/verification")
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateEmail(List<EmailDTO> emails) {
        try {
            String entityJson = ApplicationUtilities.createEntityJsonString(emails);
            ServiceResponse serviceResponse = _iditwsClient.validateEmail(entityJson);

            return ApplicationUtilities.handleServiceResponse(serviceResponse);
        } catch (Exception exception) {
            return ApplicationUtilities.handleErrorResponse(exception);
        }
    }

    @POST
    @Path("/phone/verification")
    @Produces(MediaType.APPLICATION_JSON)
    public Response validatePhoneNumber(List<PhoneNumberDTO> phoneNumberDTOS) {
        try {
            String entityJson = ApplicationUtilities.createEntityJsonString(phoneNumberDTOS);
            ServiceResponse serviceResponse = _iditwsClient.validatePhone(entityJson);

            return ApplicationUtilities.handleServiceResponse(serviceResponse);
        } catch (Exception exception) {
            return ApplicationUtilities.handleErrorResponse(exception);
        }
    }

	@Reference
	private IDITWSClient _iditwsClient;
}
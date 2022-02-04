package hr.crosig.contact.rest.application;

import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.common.ws.response.ServiceResponse;
import hr.crosig.contact.dto.SearchDTO;
import hr.crosig.contact.rest.application.utils.ApplicationUtilities;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author victor.catanante
 */
@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/agent-portal",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=Search.Rest",
                JaxrsWhiteboardConstants.JAX_RS_MEDIA_TYPE + "=application/json",
                "auth.verifier.guest.allowed=false",
                "liferay.access.control.disable=false"
        },
        service = Application.class
)
public class SearchApplication extends Application {

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @POST
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(SearchDTO searchDTO) {

        try {
            List contactSearchDTOList = Arrays.asList(searchDTO);

            String entityJson = ApplicationUtilities.createEntityJsonString(contactSearchDTOList);
            ServiceResponse serviceResponse = _iditwsClient.search(entityJson);

            return ApplicationUtilities.handleServiceResponse(serviceResponse);
        } catch (Exception exception) {
            return ApplicationUtilities.handleErrorResponse(exception);
        }
    }

	@Reference
	private IDITWSClient _iditwsClient;
}
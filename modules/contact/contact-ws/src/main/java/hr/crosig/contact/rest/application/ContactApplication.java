package hr.crosig.contact.rest.application;

import hr.crosig.contact.rest.application.utils.ApiConstants;
import hr.crosig.contact.rest.application.utils.HttpRequest;
import hr.crosig.contact.rest.application.utils.WebserviceUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.Set;

/**
 * @author victor.catanante
 */
@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/agent-portal",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=Contact.Rest",
                "auth.verifier.guest.allowed=false",
                "liferay.access.control.disable=false"
        },
        service = Application.class
)
@Produces(MediaType.APPLICATION_JSON)
@Path("/contacts")
public class ContactApplication extends Application {
    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @GET
    @Path("/search")
    public Response search(@QueryParam("q") String query,
                           @QueryParam("city") String city,
                           @QueryParam("address") String address,
                           @QueryParam("phoneCountryCode") String phoneCountryCode,
                           @QueryParam("phoneAreaCode") String phoneAreaCode,
                           @QueryParam("phoneNumber") String phoneNumber,
                           @QueryParam("email") String email) {
        try {
            String response = new HttpRequest().sendRequestWithResponse(ApiConstants.MOCK_CONTACTS_API_URL, null, ApiConstants.METHOD.GET);

            return WebserviceUtils.successResponse(response);
        } catch (Exception e) {
            return WebserviceUtils.errorResponse(e);
        }
    }


}
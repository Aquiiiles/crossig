package hr.crosig.contact.rest.application;

import hr.crosig.contact.rest.application.utils.ApplicationUtilities;
import hr.crosig.contact.rest.application.utils.AreaCodeApplicationConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.Set;

/**
 * @author marcelo.mazurky
 */
@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/agent-portal/phone",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=Phone.Rest",
                JaxrsWhiteboardConstants.JAX_RS_MEDIA_TYPE + "=application/json",
                "auth.verifier.guest.allowed=false",
                "liferay.access.control.disable=false"
        },
        service = Application.class
)
public class AreaCodeApplication extends Application {

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @GET
    @Path("/area-code")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAreaCodes() {

        try {
            return ApplicationUtilities.getDefaultHttpClient(
            ).target(
                    AreaCodeApplicationConstants.MOCK_PHONES_AREA_CODE_API_URL
            ).request(
            ).get();
        } catch (Exception exception) {
            return Response.serverError(
            ).build();
        }
    }

}
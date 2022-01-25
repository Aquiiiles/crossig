package hr.crosig.contact.rest.application;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    private static final Log log = LogFactoryUtil.getLog(ContactApplication.class);

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    private Response handleError(Exception e) {
        log.error(e);

        return Response.status(
                Response.Status.INTERNAL_SERVER_ERROR
        ).entity(
                e.getMessage()
        ).build();
    }

    private Response success(JSONObject entity) {
        return Response.status(
                Response.Status.OK
        ).entity(
                entity.toJSONString()
        ).build();
    }
}
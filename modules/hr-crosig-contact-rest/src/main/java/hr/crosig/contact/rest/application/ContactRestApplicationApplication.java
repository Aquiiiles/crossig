package hr.crosig.contact.rest.application;

import com.liferay.portal.kernel.json.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/hr-crosig-contact",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Contact.Rest"
	},
	service = Application.class
)
@Produces(MediaType.APPLICATION_JSON)
@Path("/{userId}")
public class ContactRestApplicationApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	public Response getMyAccountInfo(
			@PathParam("userId") long userId) {

		try {
			User user = userLocalService.getUserById(userId);
			JSONObject response = JSONFactoryUtil.createJSONObject(JSONFactoryUtil.serialize(user));

			return success(response);
		} catch (Exception pe) {
			return handleError(pe);
		}
	}


	private Response success(JSONObject entity) {
		return Response.status(
				Response.Status.OK
		).entity(
				entity.toJSONString()
		).build();
	}

	private Response handleError(Exception e) {
		log.error(e);

		return Response.status(
				Response.Status.INTERNAL_SERVER_ERROR
		).entity(
				e.getMessage()
		).build();
	}

	@Reference
	private UserLocalService userLocalService;

	private static final Log log = LogFactoryUtil.getLog(ContactRestApplicationApplication.class);

	@Reference
	private Portal portal;
}
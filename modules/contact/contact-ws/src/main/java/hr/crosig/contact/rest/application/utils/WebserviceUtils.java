package hr.crosig.contact.rest.application.utils;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.ws.rs.core.Response;

/**
 * @author marcelo.mazurky
 */
public class WebserviceUtils {

	public static Response errorResponse(Exception exception) {
		_log.error(exception);

		return Response.status(
			Response.Status.INTERNAL_SERVER_ERROR
		).entity(
			exception.getMessage()
		).build();
	}

	public static Response successResponse(JSONObject entity) {
		return Response.status(
			Response.Status.OK
		).entity(
			entity.toJSONString()
		).build();
	}

	public static Response successResponse(String entity) {
		return Response.status(
			Response.Status.OK
		).entity(
			entity
		).build();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		WebserviceUtils.class);

}
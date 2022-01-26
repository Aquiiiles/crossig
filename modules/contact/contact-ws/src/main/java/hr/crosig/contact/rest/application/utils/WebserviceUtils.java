package hr.crosig.contact.rest.application.utils;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.ws.rs.core.Response;

public class WebserviceUtils {
    private static final Log log = LogFactoryUtil.getLog(WebserviceUtils.class);

    public static Response errorResponse(Exception e) {
        log.error(e);

        return Response.status(
                Response.Status.INTERNAL_SERVER_ERROR
        ).entity(
                e.getMessage()
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
}

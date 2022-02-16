package hr.crosig.proposal.ws.util;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author david.martini
 */
public class ApplicationUtilities {

    public static Response handleErrorResponse(Exception exception) {
        _log.error(exception);

        return Response.status(
                Response.Status.INTERNAL_SERVER_ERROR
        ).entity(
                Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase()
        ).build();
    }

    public static Response handleSuccessResponse(List response) {

        return Response.status(
                Response.Status.OK
        ).entity(
                parseToJSON(response)
        ).build();
    }


    public static String parseToJSON(List list) {

        return JSONUtil.toString(JSONFactoryUtil.createJSONArray(list));

    }

    private static final Log _log = LogFactoryUtil.getLog(
            ApplicationUtilities.class);

}

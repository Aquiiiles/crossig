package hr.crosig.contact.rest.application.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import hr.crosig.common.ws.response.ServiceResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author marcelo.mazurky
 */
public class ApplicationUtilities {

    private static final Log log = LogFactoryUtil.getLog(ApplicationUtilities.class);

    /**
     * Gets the Default HTTP Client
     * @return
     */
    public static synchronized Client getDefaultHttpClient() {
        ClientBuilder clientBuilder;
        clientBuilder = ClientBuilder.newBuilder();

		clientBuilder.connectTimeout(10, TimeUnit.SECONDS);
		clientBuilder.readTimeout(60, TimeUnit.SECONDS);

		return clientBuilder.build();
	}

    /**
     * Handles the Service Response
     * @param serviceResponse
     * @return
     */
    public static Response handleServiceResponse(ServiceResponse serviceResponse) {
        boolean success = serviceResponse.getCode() == 200;

        if (success) {
            return handleSuccessResponse(serviceResponse.getContent());
        } else {
            return handleErrorResponse(serviceResponse.getCode(), serviceResponse.getContent());
        }
    }

    /**
     * Handles the Success Response
     * @param response
     * @return
     */
    private static Response handleSuccessResponse(String response) {
        return Response.status(
                Response.Status.OK
        ).entity(
                response
        ).build();
    }

    /**
     * Handles the Error Response by Exception
     * @param e
     * @return
     */
    public static Response handleErrorResponse(Exception e) {
        log.error(e);

        return Response.status(
                Response.Status.INTERNAL_SERVER_ERROR
        ).entity(
                Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase()
        ).build();
    }

    /**
     * Handles Error Response by Status Code and Response
     * @param statusCode
     * @param response
     * @return
     */
    private static Response handleErrorResponse(int statusCode, String response) {
        return Response.status(
                statusCode
        ).entity(
                Response.Status.fromStatusCode(statusCode).getReasonPhrase()
        ).build();
    }

    /**
     * Creates an Entity Json in String by an Entity Map
     * @param entity
     * @return
     */
    public static String createEntityJsonString(Map<String, Object> entity) {
        Gson gson = new Gson();
        return gson.toJson(entity);
    }

    /**
     * Creates an Entity Json in String by an Entity Object
     * @param entity
     * @return
     * @throws JsonProcessingException
     */
    public static String createEntityJsonString(Object entity) throws JsonProcessingException {
        ObjectMapper mapper = configureJsonMapper();
        return mapper.writeValueAsString(entity);
    }

    /**
     * Configures the Json Mapper
     * @return
     */
    private static ObjectMapper configureJsonMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(
                JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(),
                true
        );
        return mapper;
    }
}
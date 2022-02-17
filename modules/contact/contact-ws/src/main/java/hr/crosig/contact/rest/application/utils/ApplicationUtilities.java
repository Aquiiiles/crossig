package hr.crosig.contact.rest.application.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.portal.kernel.util.Validator;
import hr.crosig.common.ws.response.ServiceResponse;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 * @author marcelo.mazurky
 */
public class ApplicationUtilities {

    /**
     * Creates an Entity Json in String by an Entity Map
     *
     * @param entity
     * @return
     */
    public static String createEntityJsonString(Map<String, Object> entity) {
        Gson gson = new Gson();

        return gson.toJson(entity);
    }

    /**
     * Creates an Entity Json in String by an Entity Object
     *
     * @param entity
     * @return
     */
    public static String createEntityJsonString(Object entity)
            throws JsonProcessingException {

        ObjectMapper mapper = _configureJsonMapper();

        return mapper.writeValueAsString(entity);
    }

    /**
     * Gets the Default HTTP Client
     *
     * @return
     */
    public static synchronized Client getDefaultHttpClient() {
        ClientBuilder clientBuilder = ClientBuilder.newBuilder();

        clientBuilder.connectTimeout(10, TimeUnit.SECONDS);
        clientBuilder.readTimeout(60, TimeUnit.SECONDS);

        return clientBuilder.build();
    }

    /**
     * Handles the Error Response by Exception
     *
     * @param e
     * @return
     */
    public static Response handleErrorResponse(Exception exception) {
        _log.error(exception);

        return Response.status(
                Response.Status.INTERNAL_SERVER_ERROR
        ).entity(
                Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase()
        ).build();
    }

    /**
     * Handles Error Response by Status Code and Response
     *
     * @param statusCode
     * @param response
     * @return
     */
    public static Response handleErrorResponse(
            int statusCode, String response) {

        if (Validator.isNotNull(response)) {
            _log.error(response);
        }

        Response.Status status = Response.Status.fromStatusCode(statusCode);

        String resp = status != null && status.getReasonPhrase() != null ? status.getReasonPhrase() : Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase();

        return Response.status(
                statusCode
        ).entity(
                resp
        ).build();
    }


    /**
     * Handles the Service Response
     *
     * @param serviceResponse
     * @return
     */
    public static Response handleServiceResponse(
            ServiceResponse serviceResponse) {

        boolean success = false;

        if (serviceResponse.getCode() == 200) {
            success = true;
        }

        if (success) {
            return handleSuccessResponse(serviceResponse.getContent());
        }

        return handleErrorResponse(
                serviceResponse.getCode(), serviceResponse.getContent());
    }



    /**
     * Handles the Success Response
     *
     * @param response
     * @return
     */
    public static Response handleSuccessResponse(String response) {
        return Response.status(
                Response.Status.OK
        ).entity(
                response
        ).build();
    }

    /**
     * Configures the Json Mapper
     *
     * @return
     */
    private static ObjectMapper _configureJsonMapper() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(
                JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(),
                true);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return mapper;
    }

    private static final Log _log = LogFactoryUtil.getLog(
            ApplicationUtilities.class);

}
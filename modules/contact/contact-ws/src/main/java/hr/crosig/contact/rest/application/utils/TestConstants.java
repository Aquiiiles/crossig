package hr.crosig.contact.rest.application.utils;

import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.contact.rest.application.dto.ContactDTO;
import hr.crosig.contact.rest.application.dto.SearchDTO;
import hr.crosig.contact.rest.application.dto.EmailDTO;
import hr.crosig.contact.rest.application.dto.PhoneNumberDTO;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * @author marcelo.mazurky
 */
public class TestConstants {

    // api response constants
    public static final int API_SUCCESS_STATUS_CODE = Response.Status.OK.getStatusCode();
    public static final String API_SUCCESS_STATUS_CONTENT = Response.Status.OK.getReasonPhrase();
    public static final int API_ERROR_STATUS_CODE = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
    public static final String API_ERROR_STATUS_CONTENT = Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase();
    public static final ServiceInvocationException API_SERVICE_INVOCATION_EXCEPTION = new ServiceInvocationException(Response.Status.REQUEST_TIMEOUT.getReasonPhrase());

    // valid request values
    public static final long VALID_CITY_ID = 50;
    public static final SearchDTO VALID_SEARCH_REQUEST = new SearchDTO();
    public static final ContactDTO VALID_CONTACT_REQUEST =  new ContactDTO();
    public static final List<EmailDTO> VALID_EMAIL_REQUEST = new ArrayList<>();
    public static final List<PhoneNumberDTO> VALID_PHONE_NUMBER_REQUEST = new ArrayList<>();
}

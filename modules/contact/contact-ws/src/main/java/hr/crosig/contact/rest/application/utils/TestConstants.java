package hr.crosig.contact.rest.application.utils;

import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.contact.dto.CityDTO;
import hr.crosig.contact.dto.ContactDTO;
import hr.crosig.contact.dto.EmailDTO;
import hr.crosig.contact.dto.SearchDTO;
import hr.crosig.contact.dto.TelephoneDTO;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * @author marcelo.mazurky
 */
public class TestConstants {

	// api response constants

	public static final int API_BAD_REQUEST_STATUS_CODE =
			Response.Status.BAD_REQUEST.getStatusCode();

	public static final String API_BAD_REQUEST_STATUS_CONTENT =
			Response.Status.BAD_REQUEST.getReasonPhrase();

	public static final int API_ERROR_STATUS_CODE =
		Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();

	public static final String API_ERROR_STATUS_CONTENT =
		Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase();

	public static final ServiceInvocationException
		API_SERVICE_INVOCATION_EXCEPTION = new ServiceInvocationException(
			Response.Status.REQUEST_TIMEOUT.getReasonPhrase());

	public static final int API_SUCCESS_STATUS_CODE =
		Response.Status.OK.getStatusCode();

	public static final String API_SUCCESS_STATUS_CONTENT =
		Response.Status.OK.getReasonPhrase();

	// valid request values

	public static final long VALID_CITY_ID = 50;

	public static final String VALID_CITY_NAME = "SOKOLOVAC";

	public static final ContactDTO VALID_CONTACT_REQUEST = new ContactDTO();

	public static final String VALID_GET_CONTACT_REQUEST = "10";

	public static final SearchDTO VALID_SEARCH_REQUEST = new SearchDTO();

	public static final String VALID_STREET_NAME = "VUGRINŠČAK";

	public static final List<CityDTO> validCity = new ArrayList<>();

	public static final List<EmailDTO> validEmailRequest = new ArrayList<>();

	public static final List<TelephoneDTO> validPhoneNumberRequest =
		new ArrayList<>();

	public static final List<String> validStreet = new ArrayList<>();

}
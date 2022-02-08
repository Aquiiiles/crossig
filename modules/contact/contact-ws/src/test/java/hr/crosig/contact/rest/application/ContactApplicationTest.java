package hr.crosig.contact.rest.application;

import com.fasterxml.jackson.core.JsonProcessingException;

import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.common.ws.response.ServiceResponse;
import hr.crosig.contact.rest.application.utils.ApplicationUtilities;
import hr.crosig.contact.rest.application.utils.TestConstants;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * @author marcelo.mazurky
 */
@PrepareForTest(
	fullyQualifiedNames = "hr/crosig/contact/rest/application/ContactApplication"
)
@RunWith(PowerMockRunner.class)
public class ContactApplicationTest {

	@Test
	public void createContact_ApiError()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiError();

		Response response = _contactApplication.createContact(
			TestConstants.VALID_CONTACT_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleErrorResponse(
			TestConstants.API_ERROR_STATUS_CODE,
			TestConstants.API_ERROR_STATUS_CONTENT);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void createContact_ApiException()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiException();

		Response response = _contactApplication.createContact(
			TestConstants.VALID_CONTACT_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleErrorResponse(
			TestConstants.API_SERVICE_INVOCATION_EXCEPTION);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void createContact_ApiSuccess()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiSuccess();

		Response response = _contactApplication.createContact(
			TestConstants.VALID_CONTACT_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleSuccessResponse(
			TestConstants.API_SUCCESS_STATUS_CONTENT);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Before
	public void setUp() {
		_injectMocks();
	}

	@Test
	public void updateContact_ApiError()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiError();

		Response response = _contactApplication.updateContact(
			TestConstants.VALID_CONTACT_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleErrorResponse(
			TestConstants.API_ERROR_STATUS_CODE,
			TestConstants.API_ERROR_STATUS_CONTENT);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void updateContact_ApiException()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiException();

		Response response = _contactApplication.updateContact(
			TestConstants.VALID_CONTACT_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleErrorResponse(
			TestConstants.API_SERVICE_INVOCATION_EXCEPTION);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void updateContact_ApiSuccess()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiSuccess();

		Response response = _contactApplication.updateContact(
			TestConstants.VALID_CONTACT_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleSuccessResponse(
			TestConstants.API_SUCCESS_STATUS_CONTENT);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void validateEmail_ApiError()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiError();

		Response response = _contactApplication.validateEmail(
			TestConstants.VALID_EMAIL_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleErrorResponse(
			TestConstants.API_ERROR_STATUS_CODE,
			TestConstants.API_ERROR_STATUS_CONTENT);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void validateEmail_ApiException()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiException();

		Response response = _contactApplication.validateEmail(
			TestConstants.VALID_EMAIL_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleErrorResponse(
			TestConstants.API_SERVICE_INVOCATION_EXCEPTION);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void validateEmail_ApiSuccess()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiSuccess();

		Response response = _contactApplication.validateEmail(
			TestConstants.VALID_EMAIL_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleSuccessResponse(
			TestConstants.API_SUCCESS_STATUS_CONTENT);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void validatePhoneNumber_ApiError()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiError();

		Response response = _contactApplication.validatePhoneNumber(
			TestConstants.VALID_PHONE_NUMBER_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleErrorResponse(
			TestConstants.API_ERROR_STATUS_CODE,
			TestConstants.API_ERROR_STATUS_CONTENT);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void validatePhoneNumber_ApiException()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiException();

		Response response = _contactApplication.validatePhoneNumber(
			TestConstants.VALID_PHONE_NUMBER_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleErrorResponse(
			TestConstants.API_SERVICE_INVOCATION_EXCEPTION);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void validatePhoneNumber_ApiSuccess()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiSuccess();

		Response response = _contactApplication.validatePhoneNumber(
			TestConstants.VALID_PHONE_NUMBER_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleSuccessResponse(
			TestConstants.API_SUCCESS_STATUS_CONTENT);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void getContact_ApiError()
			throws JsonProcessingException, ServiceInvocationException {

		_mockApiError();

		Response response = _contactApplication.getContact(
				TestConstants.VALID_GET_CONTACT_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleErrorResponse(
				TestConstants.API_ERROR_STATUS_CODE,
				TestConstants.API_ERROR_STATUS_CONTENT);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void getContact_ApiException()
			throws JsonProcessingException, ServiceInvocationException {

		_mockApiException();

		Response response = _contactApplication.getContact(
				TestConstants.VALID_GET_CONTACT_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleErrorResponse(
				TestConstants.API_SERVICE_INVOCATION_EXCEPTION);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void getContact_ApiSuccess()
			throws JsonProcessingException, ServiceInvocationException {

		_mockApiSuccess();

		Response response = _contactApplication.getContact(
				TestConstants.VALID_GET_CONTACT_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleSuccessResponse(
				TestConstants.API_SUCCESS_STATUS_CONTENT);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	private void _injectMocks() {
		Whitebox.setInternalState(
			_contactApplication, "_iditwsClient", _iditwsClient);
	}

	private void _mockApiError()
		throws JsonProcessingException, ServiceInvocationException {

		ServiceResponse serviceResponseError = new ServiceResponse(
			TestConstants.API_ERROR_STATUS_CODE,
			TestConstants.API_ERROR_STATUS_CONTENT);

		String validContactRequest =
			ApplicationUtilities.createEntityJsonString(
				TestConstants.VALID_CONTACT_REQUEST);

		Mockito.when(
			_iditwsClient.createContact(validContactRequest)
		).thenReturn(
			serviceResponseError
		);
		Mockito.when(
			_iditwsClient.updateContact(validContactRequest)
		).thenReturn(
			serviceResponseError
		);

		String validEmailRequest = ApplicationUtilities.createEntityJsonString(
			TestConstants.VALID_EMAIL_REQUEST);

		Mockito.when(
			_iditwsClient.validateEmail(validEmailRequest)
		).thenReturn(
			serviceResponseError
		);

		String validPhoneNumberRequest =
			ApplicationUtilities.createEntityJsonString(
				TestConstants.VALID_PHONE_NUMBER_REQUEST);

		Mockito.when(
			_iditwsClient.validatePhone(validPhoneNumberRequest)
		).thenReturn(
			serviceResponseError
		);

		Mockito.when(
				_iditwsClient.getContact(TestConstants.VALID_GET_CONTACT_REQUEST)
		).thenReturn(
				serviceResponseError
		);
	}

	private void _mockApiException()
		throws JsonProcessingException, ServiceInvocationException {

		String validContactRequest =
			ApplicationUtilities.createEntityJsonString(
				TestConstants.VALID_CONTACT_REQUEST);

		Mockito.when(
			_iditwsClient.createContact(validContactRequest)
		).thenThrow(
			TestConstants.API_SERVICE_INVOCATION_EXCEPTION
		);
		Mockito.when(
			_iditwsClient.updateContact(validContactRequest)
		).thenThrow(
			TestConstants.API_SERVICE_INVOCATION_EXCEPTION
		);

		String validEmailRequest = ApplicationUtilities.createEntityJsonString(
			TestConstants.VALID_EMAIL_REQUEST);

		Mockito.when(
			_iditwsClient.validateEmail(validEmailRequest)
		).thenThrow(
			TestConstants.API_SERVICE_INVOCATION_EXCEPTION
		);

		String validPhoneNumberRequest =
			ApplicationUtilities.createEntityJsonString(
				TestConstants.VALID_PHONE_NUMBER_REQUEST);

		Mockito.when(
			_iditwsClient.validatePhone(validPhoneNumberRequest)
		).thenThrow(
			TestConstants.API_SERVICE_INVOCATION_EXCEPTION
		);

		Mockito.when(
				_iditwsClient.getContact(TestConstants.VALID_GET_CONTACT_REQUEST)
		).thenThrow(
				TestConstants.API_SERVICE_INVOCATION_EXCEPTION
		);
	}

	private void _mockApiSuccess()
		throws JsonProcessingException, ServiceInvocationException {

		ServiceResponse serviceResponseSuccess = new ServiceResponse(
			TestConstants.API_SUCCESS_STATUS_CODE,
			TestConstants.API_SUCCESS_STATUS_CONTENT);

		String validContactRequest =
			ApplicationUtilities.createEntityJsonString(
				TestConstants.VALID_CONTACT_REQUEST);

		Mockito.when(
			_iditwsClient.createContact(validContactRequest)
		).thenReturn(
			serviceResponseSuccess
		);
		Mockito.when(
			_iditwsClient.updateContact(validContactRequest)
		).thenReturn(
			serviceResponseSuccess
		);

		String validEmailRequest = ApplicationUtilities.createEntityJsonString(
			TestConstants.VALID_EMAIL_REQUEST);

		Mockito.when(
			_iditwsClient.validateEmail(validEmailRequest)
		).thenReturn(
			serviceResponseSuccess
		);

		String validPhoneNumberRequest =
			ApplicationUtilities.createEntityJsonString(
				TestConstants.VALID_PHONE_NUMBER_REQUEST);

		Mockito.when(
			_iditwsClient.validatePhone(validPhoneNumberRequest)
		).thenReturn(
			serviceResponseSuccess
		);

		Mockito.when(
				_iditwsClient.getContact(TestConstants.VALID_GET_CONTACT_REQUEST)
		).thenReturn(
				serviceResponseSuccess
		);
	}

	private final ContactApplication _contactApplication =
		new ContactApplication();

	@Mock
	private IDITWSClient _iditwsClient;

}
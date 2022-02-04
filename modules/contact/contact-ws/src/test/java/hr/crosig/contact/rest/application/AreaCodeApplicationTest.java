package hr.crosig.contact.rest.application;

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
	fullyQualifiedNames = "hr/crosig/contact/rest/application/AreaCodeApplication"
)
@RunWith(PowerMockRunner.class)
public class AreaCodeApplicationTest {

	@Test
	public void getAreaCodes_ApiError() throws ServiceInvocationException {
		_mockApiError();

		Response response = _areaCodeApplication.getAreaCodes();
		Response expectedResponse = ApplicationUtilities.handleErrorResponse(
			TestConstants.API_ERROR_STATUS_CODE,
			TestConstants.API_ERROR_STATUS_CONTENT);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void getAreaCodes_ApiException() throws ServiceInvocationException {
		_mockApiException();

		Response response = _areaCodeApplication.getAreaCodes();
		Response expectedResponse = ApplicationUtilities.handleErrorResponse(
			TestConstants.API_SERVICE_INVOCATION_EXCEPTION);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void getAreaCodes_ApiSuccess() throws ServiceInvocationException {
		_mockApiSuccess();

		Response response = _areaCodeApplication.getAreaCodes();
		Response expectedResponse = ApplicationUtilities.handleSuccessResponse(
			TestConstants.API_SUCCESS_STATUS_CONTENT);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Before
	public void setUp() {
		_injectMocks();
	}

	private void _injectMocks() {
		Whitebox.setInternalState(
			_areaCodeApplication, "_iditwsClient", _iditwsClient);
	}

	private void _mockApiError() throws ServiceInvocationException {
		ServiceResponse serviceResponseError = new ServiceResponse(
			TestConstants.API_ERROR_STATUS_CODE,
			TestConstants.API_ERROR_STATUS_CONTENT);

		Mockito.when(
			_iditwsClient.getAreaCodes()
		).thenReturn(
			serviceResponseError
		);
	}

	private void _mockApiException() throws ServiceInvocationException {
		Mockito.when(
			_iditwsClient.getAreaCodes()
		).thenThrow(
			TestConstants.API_SERVICE_INVOCATION_EXCEPTION
		);
	}

	private void _mockApiSuccess() throws ServiceInvocationException {
		ServiceResponse serviceResponseSuccess = new ServiceResponse(
			TestConstants.API_SUCCESS_STATUS_CODE,
			TestConstants.API_SUCCESS_STATUS_CONTENT);

		Mockito.when(
			_iditwsClient.getAreaCodes()
		).thenReturn(
			serviceResponseSuccess
		);
	}

	private final AreaCodeApplication _areaCodeApplication =
		new AreaCodeApplication();

	@Mock
	private IDITWSClient _iditwsClient;

}
package hr.crosig.contact.rest.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.common.ws.response.ServiceResponse;
import hr.crosig.common.ws.util.ApplicationUtilities;
import hr.crosig.contact.rest.application.utils.TestConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import javax.ws.rs.core.Response;
import java.util.Arrays;

/**
 * @author marcelo.mazurky
 */
@PrepareForTest(
	fullyQualifiedNames = "hr/crosig/contact/rest/application/SearchApplication"
)
@RunWith(PowerMockRunner.class)
public class SearchApplicationTest {

	@Test
	public void search_ApiError()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiError();

		Response response = _searchApplication.search(
			TestConstants.VALID_SEARCH_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleErrorResponse(
			TestConstants.API_ERROR_STATUS_CODE,
			TestConstants.API_ERROR_STATUS_CONTENT);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void search_ApiException()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiException();

		Response response = _searchApplication.search(
			TestConstants.VALID_SEARCH_REQUEST);
		Response expectedResponse = ApplicationUtilities.handleErrorResponse(
			TestConstants.API_SERVICE_INVOCATION_EXCEPTION);

		Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
		Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
	}

	@Test
	public void search_ApiSuccess()
		throws JsonProcessingException, ServiceInvocationException {

		_mockApiSuccess();

		Response response = _searchApplication.search(
			TestConstants.VALID_SEARCH_REQUEST);
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
			_searchApplication, "_iditwsClient", _iditwsClient);
	}

	private void _mockApiError()
		throws JsonProcessingException, ServiceInvocationException {

		ServiceResponse serviceResponseError = new ServiceResponse(
			TestConstants.API_ERROR_STATUS_CODE,
			TestConstants.API_ERROR_STATUS_CONTENT);

		String validsearchRequest = ApplicationUtilities.createEntityJsonString(
			Arrays.asList(TestConstants.VALID_SEARCH_REQUEST));

		Mockito.when(
			_iditwsClient.search(validsearchRequest)
		).thenReturn(
			serviceResponseError
		);
	}

	private void _mockApiException()
		throws JsonProcessingException, ServiceInvocationException {

		String validsearchRequest = ApplicationUtilities.createEntityJsonString(
			Arrays.asList(TestConstants.VALID_SEARCH_REQUEST));

		Mockito.when(
			_iditwsClient.search(validsearchRequest)
		).thenThrow(
			TestConstants.API_SERVICE_INVOCATION_EXCEPTION
		);
	}

	private void _mockApiSuccess()
		throws JsonProcessingException, ServiceInvocationException {

		ServiceResponse serviceResponseSuccess = new ServiceResponse(
			TestConstants.API_SUCCESS_STATUS_CODE,
			TestConstants.API_SUCCESS_STATUS_CONTENT);

		String validsearchRequest = ApplicationUtilities.createEntityJsonString(
			Arrays.asList(TestConstants.VALID_SEARCH_REQUEST));

		Mockito.when(
			_iditwsClient.search(validsearchRequest)
		).thenReturn(
			serviceResponseSuccess
		);
	}

	@Mock
	private IDITWSClient _iditwsClient;

	private final SearchApplication _searchApplication =
		new SearchApplication();

}
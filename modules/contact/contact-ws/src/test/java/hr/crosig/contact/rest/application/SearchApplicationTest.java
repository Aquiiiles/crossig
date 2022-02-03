package hr.crosig.contact.rest.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.common.ws.response.ServiceResponse;
import hr.crosig.contact.rest.application.utils.ApplicationUtilities;
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

    @Before
    public void setUp() {
        _injectMocks();
    }

    private void _injectMocks() {
        Whitebox.setInternalState(_searchApplication, "_iditwsClient", _iditwsClient);
    }

    private void _mockApiSuccess() throws ServiceInvocationException, JsonProcessingException {
        ServiceResponse serviceResponseSuccess = new ServiceResponse(TestConstants.API_SUCCESS_STATUS_CODE, TestConstants.API_SUCCESS_STATUS_CONTENT);

        String validsearchRequest = ApplicationUtilities.createEntityJsonString(Arrays.asList(TestConstants.VALID_SEARCH_REQUEST));
        Mockito.when(_iditwsClient.search(validsearchRequest)).thenReturn(serviceResponseSuccess);
    }
    private void _mockApiError() throws ServiceInvocationException, JsonProcessingException {
        ServiceResponse serviceResponseError = new ServiceResponse(TestConstants.API_ERROR_STATUS_CODE, TestConstants.API_ERROR_STATUS_CONTENT);

        String validsearchRequest = ApplicationUtilities.createEntityJsonString(Arrays.asList(TestConstants.VALID_SEARCH_REQUEST));
        Mockito.when(_iditwsClient.search(validsearchRequest)).thenReturn(serviceResponseError);
    }
    private void _mockApiException() throws ServiceInvocationException, JsonProcessingException {
        String validsearchRequest = ApplicationUtilities.createEntityJsonString(Arrays.asList(TestConstants.VALID_SEARCH_REQUEST));
        Mockito.when(_iditwsClient.search(validsearchRequest)).thenThrow(TestConstants.API_SERVICE_INVOCATION_EXCEPTION);
    }

    @Test
    public void search_ApiSuccess() throws ServiceInvocationException, JsonProcessingException {
        _mockApiSuccess();

        Response response = _searchApplication.search(TestConstants.VALID_SEARCH_REQUEST);
        Response expectedResponse = ApplicationUtilities.handleSuccessResponse(TestConstants.API_SUCCESS_STATUS_CONTENT);

        Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
        Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
    }

    @Test
    public void search_ApiError() throws ServiceInvocationException, JsonProcessingException {
        _mockApiError();

        Response response = _searchApplication.search(TestConstants.VALID_SEARCH_REQUEST);
        Response expectedResponse = ApplicationUtilities.handleErrorResponse(TestConstants.API_ERROR_STATUS_CODE, TestConstants.API_ERROR_STATUS_CONTENT);

        Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
        Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
    }

    @Test
    public void search_ApiException() throws ServiceInvocationException, JsonProcessingException {
        _mockApiException();

        Response response = _searchApplication.search(TestConstants.VALID_SEARCH_REQUEST);
        Response expectedResponse = ApplicationUtilities.handleErrorResponse(TestConstants.API_SERVICE_INVOCATION_EXCEPTION);

        Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
        Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
    }

    private final SearchApplication _searchApplication = new SearchApplication();
    @Mock
    private IDITWSClient _iditwsClient;
}

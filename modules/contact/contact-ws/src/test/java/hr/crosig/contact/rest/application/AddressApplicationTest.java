package hr.crosig.contact.rest.application;

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

/**
 * @author marcelo.mazurky
 */
@PrepareForTest(
        fullyQualifiedNames = "hr/crosig/contact/rest/application/AddressApplication"
)
@RunWith(PowerMockRunner.class)
public class AddressApplicationTest {

    @Before
    public void setUp() {
        _injectMocks();
    }

    private void _injectMocks() {
        Whitebox.setInternalState(_addressApplication, "_iditwsClient", _iditwsClient);
    }

    private void _mockApiSuccess() throws ServiceInvocationException {
        ServiceResponse serviceResponseSuccess = new ServiceResponse(TestConstants.API_SUCCESS_STATUS_CODE, TestConstants.API_SUCCESS_STATUS_CONTENT);
        Mockito.when(_iditwsClient.getCities()).thenReturn(serviceResponseSuccess);
        Mockito.when(_iditwsClient.getStreetsByCity(TestConstants.VALID_CITY_ID)).thenReturn(serviceResponseSuccess);
    }
    private void _mockApiError() throws ServiceInvocationException {
        ServiceResponse serviceResponseError = new ServiceResponse(TestConstants.API_ERROR_STATUS_CODE, TestConstants.API_ERROR_STATUS_CONTENT);
        Mockito.when(_iditwsClient.getCities()).thenReturn(serviceResponseError);
        Mockito.when(_iditwsClient.getStreetsByCity(TestConstants.VALID_CITY_ID)).thenReturn(serviceResponseError);
    }
    private void _mockApiException() throws ServiceInvocationException {
        Mockito.when(_iditwsClient.getCities()).thenThrow(TestConstants.API_SERVICE_INVOCATION_EXCEPTION);
        Mockito.when(_iditwsClient.getStreetsByCity(TestConstants.VALID_CITY_ID)).thenThrow(TestConstants.API_SERVICE_INVOCATION_EXCEPTION);
    }

    @Test
    public void getCities_ApiSuccess() throws ServiceInvocationException {
        _mockApiSuccess();

        Response response = _addressApplication.getCities();
        Response expectedResponse = ApplicationUtilities.handleSuccessResponse(TestConstants.API_SUCCESS_STATUS_CONTENT);

        Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
        Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
    }

    @Test
    public void getCities_ApiError() throws ServiceInvocationException {
        _mockApiError();

        Response response = _addressApplication.getCities();
        Response expectedResponse = ApplicationUtilities.handleErrorResponse(TestConstants.API_ERROR_STATUS_CODE, TestConstants.API_ERROR_STATUS_CONTENT);

        Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
        Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
    }

    @Test
    public void getCities_ApiException() throws ServiceInvocationException {
        _mockApiException();

        Response response = _addressApplication.getCities();
        Response expectedResponse = ApplicationUtilities.handleErrorResponse(TestConstants.API_SERVICE_INVOCATION_EXCEPTION);

        Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
        Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
    }

    @Test
    public void getStreetsByCity_ApiSuccess() throws ServiceInvocationException {
        _mockApiSuccess();

        Response response = _addressApplication.getStreetsByCity(TestConstants.VALID_CITY_ID);
        Response expectedResponse = ApplicationUtilities.handleSuccessResponse(TestConstants.API_SUCCESS_STATUS_CONTENT);

        Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
        Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
    }

    @Test
    public void getStreetsByCity_ApiError() throws ServiceInvocationException {
        _mockApiError();

        Response response = _addressApplication.getStreetsByCity(TestConstants.VALID_CITY_ID);
        Response expectedResponse = ApplicationUtilities.handleErrorResponse(TestConstants.API_ERROR_STATUS_CODE, TestConstants.API_ERROR_STATUS_CONTENT);

        Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
        Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
    }

    @Test
    public void getStreetsByCity_ApiException() throws ServiceInvocationException {
        _mockApiException();

        Response response = _addressApplication.getStreetsByCity(TestConstants.VALID_CITY_ID);
        Response expectedResponse = ApplicationUtilities.handleErrorResponse(TestConstants.API_SERVICE_INVOCATION_EXCEPTION);

        Assert.assertEquals(expectedResponse.getStatus(), response.getStatus());
        Assert.assertEquals(expectedResponse.getEntity(), response.getEntity());
    }

    private final AddressApplication _addressApplication = new AddressApplication();
    @Mock
    private IDITWSClient _iditwsClient;
}

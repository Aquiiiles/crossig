package hr.crosig.contact.rest.application;

import hr.crosig.contact.exception.CityException;
import hr.crosig.contact.exception.StreetException;
import hr.crosig.contact.rest.application.utils.TestConstants;
import hr.crosig.contact.service.CityLocalService;
import hr.crosig.contact.service.StreetLocalService;
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

	@Test
	public void getCities_ApiError() throws CityException, StreetException {
		_mockApiError();

		Response response = _addressApplication.getCities(TestConstants.VALID_CITY_NAME);

		Assert.assertEquals(TestConstants.API_ERROR_STATUS_CODE, response.getStatus());
		Assert.assertEquals(TestConstants.API_ERROR_STATUS_CONTENT, response.getEntity());
	}

	@Test
	public void getCities_ApiException() throws CityException, StreetException {
		_mockApiException();

		Response response = _addressApplication.getCities(TestConstants.VALID_CITY_NAME);

		Assert.assertEquals(TestConstants.API_BAD_REQUEST_STATUS_CODE, response.getStatus());
		Assert.assertEquals(TestConstants.API_BAD_REQUEST_STATUS_CONTENT, response.getEntity());
	}

	@Test
	public void getCities_ApiSuccess() throws CityException, StreetException {
		_mockApiSuccess();

		Response response = _addressApplication.getCities(TestConstants.VALID_CITY_NAME);

		Assert.assertEquals(TestConstants.API_SUCCESS_STATUS_CODE, response.getStatus());
		Assert.assertEquals(TestConstants.validCity, response.getEntity());
	}

	@Test
	public void getStreetsByCity_ApiError() throws CityException, StreetException {
		_mockApiError();

		Response response = _addressApplication.getStreetsByCity(
			TestConstants.VALID_CITY_ID, TestConstants.VALID_STREET_NAME);

		Assert.assertEquals(TestConstants.API_ERROR_STATUS_CODE, response.getStatus());
		Assert.assertEquals(TestConstants.API_ERROR_STATUS_CONTENT, response.getEntity());
	}

	@Test
	public void getStreetsByCity_ApiException()
			throws CityException, StreetException {

		_mockApiException();

		Response response = _addressApplication.getStreetsByCity(
			TestConstants.VALID_CITY_ID, TestConstants.VALID_STREET_NAME);

		Assert.assertEquals(TestConstants.API_BAD_REQUEST_STATUS_CODE, response.getStatus());
		Assert.assertEquals(TestConstants.API_BAD_REQUEST_STATUS_CONTENT, response.getEntity());
	}

	@Test
	public void getStreetsByCity_ApiSuccess()
			throws CityException, StreetException {

		_mockApiSuccess();

		Response response = _addressApplication.getStreetsByCity(
			TestConstants.VALID_CITY_ID, TestConstants.VALID_STREET_NAME);


		Assert.assertEquals(TestConstants.API_SUCCESS_STATUS_CODE, response.getStatus());
		Assert.assertEquals(TestConstants.validStreet, response.getEntity());
	}

	@Before
	public void setUp() {
		_injectMocks();
	}

	private void _injectMocks() {
		Whitebox.setInternalState(
			_addressApplication, "_cityLocalService", _cityLocalService);
		Whitebox.setInternalState(
				_addressApplication, "_streetLocalService", _streetLocalService);
	}

	private void _mockApiError() throws CityException, StreetException {
		Mockito.when(
			_cityLocalService.searchCitiesNamesByName(TestConstants.VALID_CITY_NAME)
		).thenThrow(
			new RuntimeException(TestConstants.API_ERROR_STATUS_CONTENT)
		);
		Mockito.when(
				_streetLocalService.searchStreetsNamesByNameAndCityId(TestConstants.VALID_STREET_NAME, TestConstants.VALID_CITY_ID)
		).thenThrow(
			new RuntimeException(TestConstants.API_ERROR_STATUS_CONTENT)
		);
	}

	private void _mockApiException() throws StreetException, CityException {
		Mockito.when(
				_cityLocalService.searchCitiesNamesByName(TestConstants.VALID_CITY_NAME)
		).thenThrow(
			new CityException(TestConstants.API_BAD_REQUEST_STATUS_CONTENT)
		);
		Mockito.when(
				_streetLocalService.searchStreetsNamesByNameAndCityId(TestConstants.VALID_STREET_NAME, TestConstants.VALID_CITY_ID)
		).thenThrow(
			new StreetException(TestConstants.API_BAD_REQUEST_STATUS_CONTENT)
		);
	}

	private void _mockApiSuccess() throws CityException, StreetException {
		Mockito.when(
				_cityLocalService.searchCitiesNamesByName(TestConstants.VALID_CITY_NAME)
		).thenReturn(
			TestConstants.validCity
		);
		Mockito.when(
				_streetLocalService.searchStreetsNamesByNameAndCityId(TestConstants.VALID_STREET_NAME, TestConstants.VALID_CITY_ID)
		).thenReturn(
			TestConstants.validStreet
		);
	}

	private final AddressApplication _addressApplication =
		new AddressApplication();

	@Mock
	private CityLocalService _cityLocalService;

	@Mock
	private StreetLocalService _streetLocalService;

}
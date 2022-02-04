package hr.crosig.contact.service.impl;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.contact.constants.CityConstants;
import hr.crosig.contact.constants.StreetConstants;
import hr.crosig.contact.dto.CityDTO;
import hr.crosig.contact.dto.StreetDTO;
import hr.crosig.contact.service.CityLocalService;
import hr.crosig.contact.service.IndexManagementLocalService;
import hr.crosig.contact.service.StreetLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author victor.catanante
 */
@Component(immediate = true, service = IndexManagementLocalService.class)
public class IndexManagementLocalServiceImpl
	implements IndexManagementLocalService {

	@Override
	public void clearAllIndicesCache() {
		_cityLocalService.deleteAllCities();

		_streetLocalService.deleteAllStreets();

		_log.info("Cleared all cities and streets");
	}

	@Override
	public void clearCityByName(String cityName) {
		_cityLocalService.deleteCityByName(cityName);
	}

	@Override
	public void populateAllIndices() {
		List<CityDTO> cities = populateCities();

		populateStreets(cities);
	}

	protected List<CityDTO> populateCities() {
		try {
			String response = _iditwsClient.getCities().getContent();

			List<CityDTO> cities = _parseIDITCityResponse(response);

			_cityLocalService.addCities(cities);

			_log.info("Added " + cities.size() + " cities");

			return cities;
		}
		catch (ServiceInvocationException e) {
			_log.error("Error trying to get cities", e);

			return null;
		}
	}

	protected void populateStreets(List<CityDTO> cities) {
		cities.forEach(
			city -> {
				try {
					String response = _iditwsClient.getStreetsByCityId(
						city.getCityId()).getContent();

					List<StreetDTO> streets = _parseIDITStreetResponse(
						response, city.getCityId());

					_streetLocalService.addStreets(streets);

					_log.info("Added " + streets.size() + " streets");
				}
				catch (ServiceInvocationException e) {
					_log.error(
						"Error trying to get streets from cityId: " +
							city.getCityId(),
						e);
				}
			});
	}

	private CityDTO _parseCityDTO(JSONObject jsonObject) {
		CityDTO cityDTO = new CityDTO();

		cityDTO.setCityId(
			jsonObject.getLong(CityConstants.JSON_KEY_FOR_CITY_ID));
		cityDTO.setZipCode(
			jsonObject.getString(CityConstants.JSON_KEY_FOR_ZIP_CODE));
		cityDTO.setBoxNumber(
			jsonObject.getString(CityConstants.JSON_KEY_FOR_BOX_NUMBER));
		cityDTO.setCityName(
			jsonObject.getString(CityConstants.JSON_KEY_FOR_CITY_NAME));
		cityDTO.setPostName(
			jsonObject.getString(CityConstants.JSON_KEY_FOR_POST_NAME));

		return cityDTO;
	}

	private List<CityDTO> _parseIDITCityResponse(String response) {
		Function<JSONObject, CityDTO> mapper = this::_parseCityDTO;

		return _parseIDITResponse(response, mapper);
	}

	private <T> List<T> _parseIDITResponse(
		String response, Function<JSONObject, T> mapper) {

		List<T> objects = new ArrayList<>();

		try {
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(response);

			for (int i = 0; i < jsonArray.length(); i++) {
				objects.add(mapper.apply(jsonArray.getJSONObject(i)));
			}
		}
		catch (JSONException jsonException) {
			_log.error(jsonException);
		}

		return objects;
	}

	private List<StreetDTO> _parseIDITStreetResponse(
		String response, long cityId) {

		Function<JSONObject, StreetDTO> mapper = streetJSON -> _parseStreetDTO(
			streetJSON, cityId);

		return _parseIDITResponse(response, mapper);
	}

	private StreetDTO _parseStreetDTO(JSONObject jsonObject, long cityId) {
		StreetDTO streetDTO = new StreetDTO();

		streetDTO.setStreetId(
			jsonObject.getLong(StreetConstants.JSON_KEY_FOR_STREET_ID));
		streetDTO.setStreetName(
			jsonObject.getString(StreetConstants.JSON_KEY_FOR_STREET_NAME));
		streetDTO.setCityId(cityId);

		return streetDTO;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		IndexManagementLocalServiceImpl.class);

	@Reference
	private CityLocalService _cityLocalService;

	@Reference
	private IDITWSClient _iditwsClient;

	@Reference
	private StreetLocalService _streetLocalService;

}
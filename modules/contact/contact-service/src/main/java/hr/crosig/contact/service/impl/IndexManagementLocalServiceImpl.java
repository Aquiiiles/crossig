package hr.crosig.contact.service.impl;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import hr.crosig.contact.dto.CityAndStreetMockDTO;
import hr.crosig.contact.dto.CityDTO;
import hr.crosig.contact.dto.StreetDTO;
import hr.crosig.contact.scheduler.enums.IndexType;
import hr.crosig.contact.service.CityLocalService;
import hr.crosig.contact.service.IndexManagementLocalService;
import hr.crosig.contact.service.StreetLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Arrays;
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
		Arrays.stream(
			IndexType.values()
		).forEach(
			indexType -> clearIndexCache(indexType.getName())
		);
	}

	@Override
	public void clearIndexCache(String index) {
		if (index.equalsIgnoreCase(IndexType.CITY.getName())) {
			_cityLocalService.deleteAllCities();

			_log.info("Cleared all cities");
		}
		else if (index.equalsIgnoreCase(IndexType.STREET.getName())) {
			_streetLocalService.deleteAllStreets();

			_log.info("Cleared all streets");
		}
	}

	@Override
	public void populateAllIndices() {
		List<CityDTO> cities = populateCities();

		populateStreets(cities);
	}

	protected List<CityDTO> populateCities() {

		// TODO String response = _iditwsClient.getCities();

		String response = CityAndStreetMockDTO.iditwsGetCitiesResponse;

		List<CityDTO> cities = _parseIDITCityResponse(response);

		_cityLocalService.addOrUpdateCities(cities);

		_log.info("Added " + cities.size() + " cities");

		return cities;
	}

	protected void populateStreets(List<CityDTO> cities) {
		cities.forEach(
			city -> {
				//			String response = _iditwsClient.getStreetsByCity(cityDTO.getCityId());

				String response = CityAndStreetMockDTO.iditwsGetStreetsByCity;

				List<StreetDTO> streets = _parseIDITStreetResponse(
					response, city.getCityId());

				_streetLocalService.addOrUpdateStreets(streets);

				_log.info("Added " + streets.size() + " streets");
			});
	}

	private CityDTO _parseCityDTO(JSONObject jsonObject) {
		CityDTO cityDTO = new CityDTO();

		cityDTO.setCityId(jsonObject.getLong("id"));
		cityDTO.setZipCode(jsonObject.getString("zipCode"));
		cityDTO.setBoxNumber(jsonObject.getString("boxNumber"));
		cityDTO.setCityName(jsonObject.getString("cityName"));
		cityDTO.setPostName(jsonObject.getString("postName"));

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

		streetDTO.setStreetId(jsonObject.getLong("id"));
		streetDTO.setStreetName(jsonObject.getString("desc"));
		streetDTO.setCityId(cityId);

		return streetDTO;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		IndexManagementLocalServiceImpl.class);

	@Reference
	private CityLocalService _cityLocalService;

	@Reference
	private StreetLocalService _streetLocalService;

}
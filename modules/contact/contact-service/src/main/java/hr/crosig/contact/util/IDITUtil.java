package hr.crosig.contact.util;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import hr.crosig.contact.constants.CityConstants;
import hr.crosig.contact.constants.StreetConstants;
import hr.crosig.contact.dto.CityDTO;
import hr.crosig.contact.dto.StreetDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Guilherme Kfouri
 */
public class IDITUtil {

	public static List<CityDTO> parseIDITCityResponse(String response) {
		Function<JSONObject, CityDTO> mapper = IDITUtil::_parseCityDTO;

		return _parseIDITResponse(response, mapper);
	}

	public static List<StreetDTO> parseIDITStreetResponse(
		String response, long cityId) {

		Function<JSONObject, StreetDTO> mapper = streetJSON -> _parseStreetDTO(
			streetJSON, cityId);

		return _parseIDITResponse(response, mapper);
	}

	private static CityDTO _parseCityDTO(JSONObject jsonObject) {
		CityDTO cityDTO = new CityDTO();

		cityDTO.setExternalCityId(
			jsonObject.getLong(CityConstants.JSON_KEY_FOR_EXTERNAL_CITY_ID));
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

	private static <T> List<T> _parseIDITResponse(
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

	private static StreetDTO _parseStreetDTO(
		JSONObject jsonObject, long cityId) {

		StreetDTO streetDTO = new StreetDTO();

		streetDTO.setStreetId(
			jsonObject.getLong(StreetConstants.JSON_KEY_FOR_STREET_ID));
		streetDTO.setStreetName(
			jsonObject.getString(StreetConstants.JSON_KEY_FOR_STREET_NAME));
		streetDTO.setCityId(cityId);

		return streetDTO;
	}

	private static final Log _log = LogFactoryUtil.getLog(IDITUtil.class);

}
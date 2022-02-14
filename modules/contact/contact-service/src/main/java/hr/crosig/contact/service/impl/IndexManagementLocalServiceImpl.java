package hr.crosig.contact.service.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.background.task.service.BackgroundTaskLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PortalUtil;
import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.contact.constants.CityConstants;
import hr.crosig.contact.dto.CityDTO;
import hr.crosig.contact.scheduler.constants.SchedulerConstants;
import hr.crosig.contact.service.CityLocalService;
import hr.crosig.contact.service.IndexManagementLocalService;
import hr.crosig.contact.service.StreetLocalService;
import hr.crosig.contact.service.backgroundtask.CityUpdateBackgroundTaskExecutor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author victor.catanante
 */
@Component(immediate = true, service = IndexManagementLocalService.class)
public class IndexManagementLocalServiceImpl
	implements IndexManagementLocalService {

	@Override
	public void clearAllIndicesCache() throws PortalException {
		_cityLocalService.deleteAllCities();

		_streetLocalService.deleteAllStreets();

		_log.info("Cleared all cities and streets");
	}

	@Override
	public void clearCityByName(String cityName) throws PortalException {
		_cityLocalService.deleteCitiesByName(cityName);
	}

	@Override
	public void clearStreets() throws PortalException {
		_streetLocalService.deleteAllStreets();

		_log.info("Cleared all streets");
	}

	@Override
	public void populateAllIndices() {
		List<CityDTO> cities = populateCities();

		populateStreets(cities);
	}

	protected List<CityDTO> populateCities() {
		try {
			String response = _iditwsClient.getCities(
			).getContent();

			List<CityDTO> cities = _parseIDITCityResponse(response);

			cities = _cityLocalService.addCities(cities);

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
					Map<String, Serializable> contextMap = new HashMap<>();

					contextMap.put("cityId", city.getCityId());
					contextMap.put("cityName", city.getCityName());

					_backgroundTaskLocalService.addBackgroundTask(
							_getAdminUserId(), CompanyConstants.SYSTEM, StringPool.BLANK,
							CityUpdateBackgroundTaskExecutor.class.getName(), contextMap,
							new ServiceContext());
				} catch (PortalException e) {
					e.printStackTrace();
				}
			});
	}

	private long _getAdminUserId() {
		final long companyId = PortalUtil.getDefaultCompanyId();

		try {
			return _userLocalService.getUser(
					_userLocalService.getDefaultUserId(companyId)
			).getUserId();
		}
		catch (PortalException portalException) {
			_log.error(
					SchedulerConstants.SCHEDULER_FAILED_WHEN_TRIGGERED,
					portalException);
		}
		return 0L;
	}

	private CityDTO _parseCityDTO(JSONObject jsonObject) {
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

	private static final Log _log = LogFactoryUtil.getLog(
		IndexManagementLocalServiceImpl.class);

	@Reference
	private BackgroundTaskLocalService _backgroundTaskLocalService;

	@Reference
	private CityLocalService _cityLocalService;

	@Reference
	private IDITWSClient _iditwsClient;

	@Reference
	private StreetLocalService _streetLocalService;

	@Reference
	private UserLocalService _userLocalService;

}
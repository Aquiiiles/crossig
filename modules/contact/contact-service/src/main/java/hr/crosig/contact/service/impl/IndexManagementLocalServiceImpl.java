package hr.crosig.contact.service.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.background.task.service.BackgroundTaskLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PortalUtil;
import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.contact.dto.CityDTO;
import hr.crosig.contact.scheduler.constants.SchedulerConstants;
import hr.crosig.contact.service.CityLocalService;
import hr.crosig.contact.service.IndexManagementLocalService;
import hr.crosig.contact.service.StreetLocalService;
import hr.crosig.contact.service.backgroundtask.CityUpdateBackgroundTaskExecutor;
import hr.crosig.contact.util.IDITUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

			List<CityDTO> cities = IDITUtil.parseIDITCityResponse(response);

			cities = _cityLocalService.addCities(cities);

			_log.info("Added " + cities.size() + " cities");

			return cities;
		}
		catch (ServiceInvocationException serviceInvocationException) {
			_log.error(
				"Error trying to get cities", serviceInvocationException);

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
						_getAdminUserId(), CompanyConstants.SYSTEM,
						StringPool.BLANK,
						CityUpdateBackgroundTaskExecutor.class.getName(),
						contextMap, new ServiceContext());
				}
				catch (PortalException portalException) {
					_log.error(portalException);
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
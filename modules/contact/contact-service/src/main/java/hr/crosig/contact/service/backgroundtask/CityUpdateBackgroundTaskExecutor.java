package hr.crosig.contact.service.backgroundtask;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.contact.dto.StreetDTO;
import hr.crosig.contact.service.StreetLocalService;
import hr.crosig.contact.util.IDITUtil;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * @author Guilherme Kfouri
 */
public class CityUpdateBackgroundTaskExecutor
	extends BaseBackgroundTaskExecutor {

	public CityUpdateBackgroundTaskExecutor(
		IDITWSClient iditwsClient, StreetLocalService streetLocalService) {

		_iditwsClient = iditwsClient;
		_streetLocalService = streetLocalService;
	}

	@Override
	public BackgroundTaskExecutor clone() {
		return new CityUpdateBackgroundTaskExecutor(
			_iditwsClient, _streetLocalService);
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask)
		throws Exception {

		Map<String, Serializable> taskContextMap =
			backgroundTask.getTaskContextMap();

		long cityId = (long)taskContextMap.get("cityId");

		String cityName = (String)taskContextMap.get("cityName");

		_log.info("Starting creation of " + cityName + "'s streets");

		String response = _iditwsClient.getStreetsByCityId(
			cityId
		).getContent();

		List<StreetDTO> streets = IDITUtil.parseIDITStreetResponse(
			response, cityId);

		_streetLocalService.addStreets(streets);

		_log.info("Added " + streets.size() + " streets for city: " + cityName);

		return BackgroundTaskResult.SUCCESS;
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(
		BackgroundTask backgroundTask) {

		return null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CityUpdateBackgroundTaskExecutor.class);

	private final IDITWSClient _iditwsClient;
	private final StreetLocalService _streetLocalService;

}
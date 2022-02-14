package hr.crosig.contact.service.backgroundtask;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.contact.constants.StreetConstants;
import hr.crosig.contact.dto.StreetDTO;
import hr.crosig.contact.service.StreetLocalService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CityUpdateBackgroundTaskExecutor extends BaseBackgroundTaskExecutor {

    public CityUpdateBackgroundTaskExecutor(IDITWSClient iditwsClient, StreetLocalService streetLocalService) {
        _iditwsClient = iditwsClient;
        _streetLocalService = streetLocalService;
    }

    @Override
    public BackgroundTaskExecutor clone() {
        return new CityUpdateBackgroundTaskExecutor(_iditwsClient, _streetLocalService);
    }

    @Override
    public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {

        Map<String, Serializable> taskContextMap = backgroundTask.getTaskContextMap();

        long cityId = (long) taskContextMap.get("cityId");
        String cityName = (String) taskContextMap.get("cityName");

        _log.info("Starting creation of " + cityName + "'s streets");

        String response = _iditwsClient.getStreetsByCityId(
                cityId
        ).getContent();

        List<StreetDTO> streets = _parseIDITStreetResponse(
                response, cityId);

        _streetLocalService.addStreets(streets);

        _log.info("Added " + streets.size() + " streets for city: " + cityName);

        return BackgroundTaskResult.SUCCESS;
    }

    @Override
    public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
        return null;
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

    private static final Log _log = LogFactoryUtil.getLog(CityUpdateBackgroundTaskExecutor.class);

    private final IDITWSClient _iditwsClient;

    private final StreetLocalService _streetLocalService;

}

package hr.crosig.sample.data.generator.web.util;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import hr.crosig.sample.data.generator.web.dto.UserDTO;
import hr.crosig.sample.data.generator.web.enums.UserAttributeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marcelo.mazurky
 */
public class UserDTOUtilities {

	/**
	 * Gets a User DTO List from Json String
	 *
	 * @param json
	 * @return
	 */
	public static List<UserDTO> getUserDTOListFromJSONString(String json) {
		List<UserDTO> userDTOList = new ArrayList<>();

		try {
			if (ActionUtilities.isJsonArray(json)) {
				List<LinkedTreeMap<String, Object>> userMapList =
					new Gson().fromJson(json, List.class);

				userMapList.forEach(
					userMap -> userDTOList.add(_getUserDTOFromMap(userMap)));
			}
			else {
				LinkedTreeMap<String, Object> userMap = new Gson().fromJson(
					json, LinkedTreeMap.class);

				userDTOList.add(_getUserDTOFromMap(userMap));
			}
		}
		catch (Exception exception) {
			_log.error(exception);
		}

		return userDTOList;
	}

	private static UserDTO _getUserDTOFromMap(
		LinkedTreeMap<String, Object> userMap) {

		try {
			UserDTO userDTO = new UserDTO();

			userMap.forEach(
				(key, value) -> {
					if (UserAttributeEnum.attributeExists(key)) {
						userDTO.setUserAttributeValue(
							UserAttributeEnum.valueOf(key),
							String.valueOf(value));
					}
				});

			return userDTO;
		}
		catch (Exception exception) {
			_log.error(exception);

			return null;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UserDTOUtilities.class);

}
package hr.crosig.sample.data.generator.web.dto;

import hr.crosig.sample.data.generator.web.enums.UserAttributeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author marcelo.mazurky
 */
public class UserDTO {

	// map created to handle the JSON array

	/**
	 * Gets the User Attribute's value
	 * @param userAttribute
	 * @return
	 */
	public String getUserAttributeValue(UserAttributeEnum userAttribute) {
		if (_userMap.containsKey(userAttribute) &&
			(_userMap.get(userAttribute) != null)) {

			return _userMap.get(userAttribute);
		}

		return null;
	}

	/**
	 * Sets the User Attribute's value
	 * @param userAttribute
	 * @param value
	 */
	public void setUserAttributeValue(
		UserAttributeEnum userAttribute, String value) {

		_userMap.put(userAttribute, value);
	}

	private Map<UserAttributeEnum, String> _userMap = new HashMap<>();

}
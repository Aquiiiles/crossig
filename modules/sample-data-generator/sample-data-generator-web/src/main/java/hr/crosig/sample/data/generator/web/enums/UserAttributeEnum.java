package hr.crosig.sample.data.generator.web.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author marcelo.mazurky
 */
public enum UserAttributeEnum {

	EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, PASSWORD, USER_GROUP_NAME;

	public static boolean attributeExists(String attribute) {
		return _nameToValueMap.containsKey(attribute);
	}

	private static final Map<String, UserAttributeEnum> _nameToValueMap =
		new HashMap<>();

	static {
		for (UserAttributeEnum value : EnumSet.allOf(UserAttributeEnum.class)) {
			_nameToValueMap.put(value.name(), value);
		}
	}

}
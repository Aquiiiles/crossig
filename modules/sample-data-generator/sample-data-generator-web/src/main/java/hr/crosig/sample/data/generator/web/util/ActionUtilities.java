package hr.crosig.sample.data.generator.web.util;

/**
 * @author marcelo.mazurky
 */
public class ActionUtilities {

	/**
	 * Validates if the JSON is an array of elements
	 *
	 * @param json
	 * @return
	 */
	public static boolean isJsonArray(String json) {
		return json.startsWith("[");
	}

}
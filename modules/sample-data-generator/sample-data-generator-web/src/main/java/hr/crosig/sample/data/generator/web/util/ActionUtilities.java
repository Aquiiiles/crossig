package hr.crosig.sample.data.generator.web.util;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

/**
 * @author marcelo.mazurky
 */
public class ActionUtilities {
    /**
     * Gets a Map List from JSON String
     * @param json
     * @return
     */
    public static List<Map> getMapListFromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, List.class);
    }

    /**
     * Gets a Map from JSON String
     * @param json
     * @return
     */
    public static Map getMapFromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Map.class);
    }

    /**
     * Validates if the JSON is a list of elements
     * @param json
     * @return
     */
    public static boolean isJsonList(String json) {
        return json.startsWith("[");
    }

    /**
     * Retrieves a String value from a Map
     * @param key
     * @param map
     * @return
     */
    public static String retrieveStringFromMap(String key, Map map) {
        return map != null && map.containsKey(key) ? String.valueOf(map.get(key)) : null;
    }

}

package hr.crosig.common.mock.idit;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringUtil;

import hr.crosig.common.ws.RestAPIServiceInvoker;
import hr.crosig.common.ws.ServiceProvider;
import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.common.ws.response.ServiceResponse;

import java.net.URL;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Leonardo Miyagi
 */
@Component(
	immediate = true, property = {"source=MOCK", "serviceProvider=IDIT"},
	service = RestAPIServiceInvoker.class
)
public class RestAPIInvokerIDITMock implements RestAPIServiceInvoker {

	@Activate
	public void activate() throws Exception {
		_responseMap = new HashMap<>();

		_initializeResponseMap();
	}

	@Override
	public ServiceResponse get(ServiceProvider provider, String path)
		throws ServiceInvocationException {

		JSONObject response = _responseMap.get(path);

		if (response == null) {
			throw new ServiceInvocationException(
				"No response found for " + path);
		}

		return new ServiceResponse(200, response.toJSONString());
	}

	@Override
	public ServiceResponse post(
			ServiceProvider provider, String path, String payload)
		throws ServiceInvocationException {

		return null;
	}

	@Override
	public ServiceResponse put(
			ServiceProvider provider, String path, String payload)
		throws ServiceInvocationException {

		return null;
	}

	private void _initializeResponseMap() throws Exception {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		URL entry = bundle.getEntry(_RESPONSES_PATH + "responses.json");

		String fileContent = StringUtil.read(entry.openStream());

		JSONArray resonsesJSONArray = JSONFactoryUtil.createJSONArray(
			fileContent);

		resonsesJSONArray.iterator(
		).forEachRemaining(
			objJSON -> {
				JSONObject response = (JSONObject)objJSON;

				String path = response.getString("path");
				JSONObject content = response.getJSONObject("content");

				_responseMap.put(path, content);
			}
		);
	}

	private static final String _RESPONSES_PATH = "responses/";

	private Map<String, JSONObject> _responseMap;

}
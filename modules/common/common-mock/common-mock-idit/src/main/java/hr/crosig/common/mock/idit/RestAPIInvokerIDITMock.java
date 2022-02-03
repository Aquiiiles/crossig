package hr.crosig.common.mock.idit;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;

import hr.crosig.common.ws.RestAPIServiceInvoker;
import hr.crosig.common.ws.ServiceProvider;
import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.common.ws.response.ServiceResponse;

import java.net.URL;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Component;

/**
 * @author Leonardo Miyagi
 */
@Component(
	immediate = true, property = {"source=MOCK", "serviceProvider=IDIT"},
	service = RestAPIServiceInvoker.class
)
public class RestAPIInvokerIDITMock implements RestAPIServiceInvoker {

	@Override
	public ServiceResponse get(ServiceProvider provider, String path)
		throws ServiceInvocationException {

		try {
			return new ServiceResponse(200, _getResponse("get", path));
		}
		catch (Exception exception) {
			throw new ServiceInvocationException(
				"Error getting mock for " + path, exception);
		}
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

	private String _getResponse(String operation, String path)
		throws Exception {

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		String pathWithoutQuery = path;

		int lastIndexOf = path.lastIndexOf(StringPool.QUESTION);

		if (lastIndexOf > 0) {
			pathWithoutQuery = path.substring(0, lastIndexOf);
		}

		StringBundler sb = new StringBundler();

		sb.append(_RESPONSES_PATH);
		sb.append(operation);
		sb.append(
			pathWithoutQuery.replace(StringPool.SLASH, StringPool.UNDERLINE));
		sb.append(_JSON_EXTENSION);

		URL entry = bundle.getEntry(sb.toString());

		return StringUtil.read(entry.openStream());
	}

	private static final String _JSON_EXTENSION = ".json";

	private static final String _RESPONSES_PATH = "responses/";

}
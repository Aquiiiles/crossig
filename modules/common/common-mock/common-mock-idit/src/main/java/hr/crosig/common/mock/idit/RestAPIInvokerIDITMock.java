package hr.crosig.common.mock.idit;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;

import hr.crosig.common.mock.idit.util.MockConstants;
import hr.crosig.common.mock.idit.util.MockUtilities;
import hr.crosig.common.ws.RestAPIServiceInvoker;
import hr.crosig.common.ws.ServiceProviderType;
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
	public ServiceResponse get(ServiceProviderType provider, String path)
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
			ServiceProviderType provider, String path, String payload)
		throws ServiceInvocationException {

		try {
			return new ServiceResponse(200, _getResponse("post", path));
		}
		catch (Exception exception) {
			throw new ServiceInvocationException(
				"Error getting mock for " + path, exception);
		}
	}

	@Override
	public ServiceResponse put(
			ServiceProviderType provider, String path, String payload)
		throws ServiceInvocationException {

		try {
			return new ServiceResponse(200, _getResponse("put", path));
		}
		catch (Exception exception) {
			throw new ServiceInvocationException(
				"Error getting mock for " + path, exception);
		}
	}

	private String _getMockPath(String operation, String path) {
		String pathWithoutQuery = path;

		int lastIndexOf = path.lastIndexOf(StringPool.QUESTION);

		if (lastIndexOf > 0) {
			pathWithoutQuery = path.substring(0, lastIndexOf);
		}

		pathWithoutQuery = pathWithoutQuery.replace(
			StringPool.SLASH, StringPool.UNDERLINE);

		String pathFormatted = operation + pathWithoutQuery;

		StringBundler sb = new StringBundler();

		sb.append(MockConstants.RESPONSES_PATH);
		sb.append(
			MockUtilities.mockFileExists(pathFormatted) ? pathFormatted :
				MockUtilities.searchMockFileWithPathParam(pathFormatted));
		sb.append(MockConstants.JSON_EXTENSION);

		return sb.toString();
	}

	private String _getResponse(String operation, String path)
		throws Exception {

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		URL entry = bundle.getEntry(_getMockPath(operation, path));

		return StringUtil.read(entry.openStream());
	}

}
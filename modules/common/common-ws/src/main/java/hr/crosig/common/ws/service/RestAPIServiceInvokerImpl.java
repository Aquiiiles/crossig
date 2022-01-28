package hr.crosig.common.ws.service;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;

import hr.crosig.common.configuration.AuthType;
import hr.crosig.common.ws.RestAPIServiceInvoker;
import hr.crosig.common.ws.ServiceConnectionProvider;
import hr.crosig.common.ws.ServiceProvider;
import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.common.ws.oauth.OAuthToken;
import hr.crosig.common.ws.oauth.OAuthTokenProvider;
import hr.crosig.common.ws.response.ServiceResponse;
import hr.crosig.common.ws.service.registrator.ServiceRegistrator;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Leonardo Miyagi
 */
@Component(immediate = true, service = RestAPIServiceInvoker.class)
public class RestAPIServiceInvokerImpl implements RestAPIServiceInvoker {

	@Override
	public ServiceResponse get(ServiceProvider provider, String path)
		throws ServiceInvocationException {

		Http.Options options = _setupServiceCall(provider, path, null);

		options.setPost(false);

		return _invokeService(options);
	}

	@Override
	public ServiceResponse post(
			ServiceProvider provider, String path, String payload)
		throws ServiceInvocationException {

		Http.Options options = _setupServiceCall(provider, path, payload);

		options.setPost(true);

		return _invokeService(options);
	}

	@Override
	public ServiceResponse put(
			ServiceProvider provider, String path, String payload)
		throws ServiceInvocationException {

		Http.Options options = _setupServiceCall(provider, path, payload);

		options.setPut(true);

		return _invokeService(options);
	}

	private ServiceResponse _invokeService(Http.Options options)
		throws ServiceInvocationException {

		try {
			String responseContent = HttpUtil.URLtoString(options);

			Http.Response response = options.getResponse();

			return new ServiceResponse(
				response.getResponseCode(), responseContent);
		}
		catch (IOException ioException) {
			throw new ServiceInvocationException(
				"Error calling service " + options.getLocation(), ioException);
		}
	}

	private void _setEndpoint(
		Http.Options options, String path, ServiceConnectionProvider provider) {

		StringBundler sb = new StringBundler(3);

		sb.append(provider.getHost());
		sb.append(path);

		options.setLocation(sb.toString());
	}

	private void _setHeaders(
			Http.Options options, ServiceConnectionProvider provider)
		throws ServiceInvocationException {

		options.addHeader("Accept", "*/*");
		options.addHeader(
			"Content-Type", ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED);

		if (AuthType.BASIC.getType(
			).equals(
				provider.getAuthType()
			)) {

			options.addHeader(
				"Authorization", "Basic " + provider.getAccessToken());
		}

		if (AuthType.OAUTH.getType(
			).equals(
				provider.getAuthType()
			)) {

			OAuthToken token = _oAuthTokenProvider.getToken(provider);

			options.addHeader(
				"Authorization", String.format("Bearer %s", token.getToken()));
		}
	}

	private Http.Options _setupServiceCall(
			ServiceProvider provider, String path, String payload)
		throws ServiceInvocationException {

		ServiceConnectionProvider connectionProvider =
			_serviceRegistrator.getConnectionProvider(provider);

		Http.Options options = new Http.Options();

		_setHeaders(options, connectionProvider);

		_setEndpoint(options, path, connectionProvider);

		if (Validator.isNotNull(payload)) {
			options.setBody(
				payload, ContentTypes.APPLICATION_JSON, StringPool.UTF8);
		}

		return options;
	}

	@Reference
	private OAuthTokenProvider _oAuthTokenProvider;

	@Reference
	private ServiceRegistrator _serviceRegistrator;

}
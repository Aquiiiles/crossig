package hr.crosig.common.ws.oauth;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.Validator;

import hr.crosig.common.configuration.OAuthGrantType;
import hr.crosig.common.ws.ServiceConnectionProvider;
import hr.crosig.common.ws.ServiceProvider;
import hr.crosig.common.ws.exception.ServiceInvocationException;

import java.io.IOException;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Leonardo Miyagi
 */
@Component(immediate = true, service = OAuthTokenProvider.class)
public class OAuthTokenProvider {

	@Activate
	public void activate(Map<Object, Object> properties) {
		_tokens = new HashMap<>();
	}

	public OAuthToken getToken(ServiceConnectionProvider connectionProvider)
		throws ServiceInvocationException {

		if (_tokens.containsKey(connectionProvider.getProvider())) {
			OAuthToken oAuthToken = _tokens.get(
				connectionProvider.getProvider());

			if (oAuthToken.isValid()) {
				return oAuthToken;
			}
		}

		return _getToken(connectionProvider);
	}

	private Http.Options _buildOptions(
		ServiceConnectionProvider connectionProvider) {

		Http.Options options = new Http.Options();

		options.addHeader("Accept", "*/*");
		options.addHeader(
			"Content-Type", ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED);
		options.setPost(true);

		String tokenQuery =
			"?grant_type=client_credentials&client_id=%s&client_secret=%s";

		String tokenParameters = String.format(
			tokenQuery, connectionProvider.getOAuth2ClientId(),
			connectionProvider.getOAuth2ClientSecret());

		options.setLocation(
			connectionProvider.getOauth2TokenURL() + tokenParameters);

		return options;
	}

	private Date _getExpirationTime() {
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.SECOND, _TOKEN_EXPIRATION_IN_SECONDS);

		return calendar.getTime();
	}

	private OAuthToken _getToken(ServiceConnectionProvider connectionProvider)
		throws ServiceInvocationException {

		if (!OAuthGrantType.CLIENT_CREDENTIALS.equals(
				connectionProvider.getOAuth2GrantType())) {

			throw new ServiceInvocationException(
				"OAuth token flow not implemented for " +
					connectionProvider.getOAuth2GrantType(
					).name());
		}

		Http.Options options = _buildOptions(connectionProvider);

		try {
			String responseContent = HttpUtil.URLtoString(options);

			Http.Response response = options.getResponse();

			if (response.getResponseCode() != 200) {
				throw new ServiceInvocationException(
					"Could not get an oauth token");
			}

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
				responseContent);

			String token = jsonObject.getString("access_token");

			if (Validator.isNull(token)) {
				throw new ServiceInvocationException(
					"Could not get an oauth token. Response " +
						responseContent);
			}

			OAuthToken oAuthToken = new OAuthToken(token, _getExpirationTime());

			_tokens.put(connectionProvider.getProvider(), oAuthToken);

			return oAuthToken;
		}
		catch (IOException | JSONException exception) {
			throw new ServiceInvocationException(
				"Could not get an Oauth token", exception);
		}
	}

	private static final int _TOKEN_EXPIRATION_IN_SECONDS = 600;

	private Map<ServiceProvider, OAuthToken> _tokens;

}
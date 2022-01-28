package hr.crosig.common.ws.client;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import hr.crosig.common.ws.ServiceConnectionProvider;
import hr.crosig.common.ws.ServiceProvider;
import hr.crosig.common.ws.oauth.OAuthGrantType;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Leonardo Miyagi
 */
@Component(
	configurationPid = LiferayConnectionConfiguration.LIFERAY_CONNECTION,
	immediate = true
)
public class LiferayServiceConnectionProvider
	implements ServiceConnectionProvider {

	@Activate
	public void activate(Map<Object, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(
			LiferayConnectionConfiguration.class, properties);
	}

	@Override
	public String getAccessToken() {
		return _configuration.getAccessToken();
	}

	@Override
	public String getAuthType() {
		return _configuration.getAuthType();
	}

	@Override
	public String getHost() {
		return _configuration.getHost();
	}

	@Override
	public String getOAuth2ClientId() {
		return _configuration.getOAuthClientId();
	}

	@Override
	public String getOAuth2ClientSecret() {
		return _configuration.getOAuthClientSecret();
	}

	@Override
	public OAuthGrantType getOAuth2GrantType() {
		return OAuthGrantType.CLIENT_CREDENTIALS;
	}

	@Override
	public String getOauth2TokenURL() {
		return "http://localhost:8080/o/oauth2/token";
	}

	@Override
	public ServiceProvider getProvider() {
		return ServiceProvider.LIFERAY;
	}

	private volatile LiferayConnectionConfiguration _configuration;

}
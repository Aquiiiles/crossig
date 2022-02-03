package hr.crosig.common.ws.client;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import hr.crosig.common.configuration.LiferayConnectionConfiguration;
import hr.crosig.common.configuration.OAuthGrantType;
import hr.crosig.common.configuration.ServiceSource;
import hr.crosig.common.ws.ServiceConnectionProvider;
import hr.crosig.common.ws.ServiceProviderType;

import java.util.Map;

import hr.crosig.common.ws.ServiceRegistrator;
import hr.crosig.common.ws.service.registrator.ServiceRegistratorImpl;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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

		_serviceRegistrator.addService(this);
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
		return _configuration.getOauth2TokenURL();
	}

	@Override
	public ServiceProviderType getProvider() {
		return ServiceProviderType.LIFERAY;
	}

	@Override
	public ServiceSource getSource() {
		return ServiceSource.EXTERNAL;
	}

	private volatile LiferayConnectionConfiguration _configuration;

	@Reference
	private ServiceRegistrator _serviceRegistrator;

}
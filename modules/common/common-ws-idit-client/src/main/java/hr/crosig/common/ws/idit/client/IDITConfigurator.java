package hr.crosig.common.ws.idit.client;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import hr.crosig.common.configuration.AuthType;
import hr.crosig.common.configuration.IDITConfiguration;
import hr.crosig.common.configuration.OAuthGrantType;
import hr.crosig.common.configuration.ServiceSource;
import hr.crosig.common.ws.ServiceConnectionProvider;
import hr.crosig.common.ws.ServiceProvider;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author david.martini
 */
@Component(
	configurationPid = IDITConfiguration.IDIT_CONFIGURATION_ID,
	immediate = true, service = ServiceConnectionProvider.class
)
public class IDITConfigurator implements ServiceConnectionProvider {

	@Activate
	@Modified
	public void activate(Map<String, Object> properties) {
		_iditConfiguration = ConfigurableUtil.createConfigurable(
			IDITConfiguration.class, properties);
	}

	@Override
	public String getAccessToken() {
		return _iditConfiguration.accessToken();
	}

	@Override
	public String getAuthType() {
		return AuthType.valueOf(
			_iditConfiguration.authenticationType().toUpperCase()
		).getType();
	}

	@Override
	public String getHost() {
		return _iditConfiguration.hostURL();
	}

	@Override
	public String getOAuth2ClientId() {
		return _iditConfiguration.oAuth2ClientID();
	}

	@Override
	public String getOAuth2ClientSecret() {
		return _iditConfiguration.oAuth2ClientSecret();
	}

	@Override
	public OAuthGrantType getOAuth2GrantType() {
		return OAuthGrantType.valueOf(_iditConfiguration.getOAuth2GrantType());
	}

	@Override
	public String getOauth2TokenURL() {
		return _iditConfiguration.getOauth2TokenURL();
	}

	@Override
	public ServiceProvider getProvider() {
		return ServiceProvider.IDIT;
	}

	@Override
	public ServiceSource getSource() {
		return ServiceSource.valueOf(_iditConfiguration.getSource());
	}

	private volatile IDITConfiguration _iditConfiguration;

}
package hr.crosig.common.ws.idit.client;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import com.liferay.portal.kernel.util.ContentTypes;
import hr.crosig.common.configuration.AuthType;
import hr.crosig.common.configuration.IDITConfiguration;
import hr.crosig.common.configuration.OAuthGrantType;
import hr.crosig.common.configuration.ServiceSource;
import hr.crosig.common.ws.ServiceConnectionProvider;
import hr.crosig.common.ws.ServiceProviderType;

import java.util.HashMap;
import java.util.Map;

import hr.crosig.common.ws.ServiceRegistrator;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

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

		_serviceRegistrator.addService(this);
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
	public Map<String, String> getCustomHeaders() {

		Map<String, String> headers = new HashMap<>();

		headers.put(_USER_NAME, _iditConfiguration.headerUserName());
		headers.put(_PASSWORD, _iditConfiguration.headerPassword());
		headers.put("Content-Type", ContentTypes.APPLICATION_JSON);

		return headers;
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
	public ServiceProviderType getProvider() {
		return ServiceProviderType.IDIT;
	}

	@Override
	public ServiceSource getSource() {
		return ServiceSource.valueOf(_iditConfiguration.getSource());
	}

	private static final String _USER_NAME = "userName";
	private static final String _PASSWORD = "password";

	private volatile IDITConfiguration _iditConfiguration;

	@Reference
	private ServiceRegistrator _serviceRegistrator;

}
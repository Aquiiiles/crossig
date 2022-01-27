package hr.crosig.common.configuration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author david.martini
 */
@Component(
	configurationPid = IDITConfiguration.IDIT_CONFIGURATION_ID,
	immediate = true, service = IDITConfigurator.class
)
public class IDITConfigurator {

	@Activate
	@Modified
	public void activate(Map<String, Object> properties) {
		_iditConfiguration = ConfigurableUtil.createConfigurable(
			IDITConfiguration.class, properties);
	}

	public String getAccessToken(Map<String, Object> accessToken) {
		return String.valueOf(
			accessToken.get(_iditConfiguration.accessToken()));
	}

	public String getHostURL(Map<String, Object> hostURL) {
		return String.valueOf(hostURL.get(_iditConfiguration.hostURL()));
	}

	public IDITAuthenticationType getIDITAuthenticationType() {
		String authenticationType = _iditConfiguration.authenticationType();

		return IDITAuthenticationType.valueOf(authenticationType);
	}

	public String getOAuthClientID(Map<String, Object> oAuthClientID) {
		return String.valueOf(
			oAuthClientID.get(_iditConfiguration.oAuth2ClientID()));
	}

	public String getOAuthClientSecret(Map<String, Object> oAuthClientSecret) {
		return String.valueOf(
			oAuthClientSecret.get(_iditConfiguration.oAuth2ClientSecret()));
	}

	private volatile IDITConfiguration _iditConfiguration;

}
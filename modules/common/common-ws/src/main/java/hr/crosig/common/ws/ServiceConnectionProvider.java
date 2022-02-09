package hr.crosig.common.ws;

import hr.crosig.common.configuration.OAuthGrantType;
import hr.crosig.common.configuration.ServiceSource;

import java.util.Map;

/**
 * @author Leonardo Miyagi
 */
public interface ServiceConnectionProvider {

	public String getAccessToken();

	public String getAuthType();

	public Map<String, String> getCustomHeaders();

	public String getHost();

	public String getOAuth2ClientId();

	public String getOAuth2ClientSecret();

	public OAuthGrantType getOAuth2GrantType();

	public String getOauth2TokenURL();

	public ServiceProviderType getProvider();

	public ServiceSource getSource();

}
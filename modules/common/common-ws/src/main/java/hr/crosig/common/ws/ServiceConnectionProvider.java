package hr.crosig.common.ws;

import hr.crosig.common.ws.oauth.OAuthGrantType;

/**
 * @author Leonardo Miyagi
 */
public interface ServiceConnectionProvider {

	public String getAccessToken();

	public String getAuthType();

	public String getHost();

	public String getOAuth2ClientId();

	public String getOAuth2ClientSecret();

	public OAuthGrantType getOAuth2GrantType();

	public String getOauth2TokenURL();

	public ServiceProvider getProvider();

}
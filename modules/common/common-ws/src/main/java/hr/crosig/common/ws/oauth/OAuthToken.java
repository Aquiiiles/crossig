package hr.crosig.common.ws.oauth;

import java.util.Date;

/**
 * @author Leonardo Miyagi
 */
public class OAuthToken {

	public OAuthToken(String token, Date expiration) {
		_token = token;
		_expiration = expiration;
	}

	public Date getExpiration() {
		return _expiration;
	}

	public String getToken() {
		return _token;
	}

	public boolean isValid() {
		Date now = new Date();

		return now.before(_expiration);
	}

	private Date _expiration;
	private String _token;

}
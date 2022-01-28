package hr.crosig.common.configuration;

/**
 * @author david.martini
 */
public enum IDITAuthenticationType {

	BASIC("Basic"), OAUTH2("OAuth2");

	public String getDescription() {
		return _description;
	}

	private IDITAuthenticationType(String description) {
		_description = description;
	}

	private String _description;

}
package hr.crosig.common.configuration;

/**
 * @author Leonardo Miyagi
 */
public enum AuthType {

	BASIC("Basic"), CUSTOM("Custom"), GUEST("Guest"), OAUTH("OAuth");

	AuthType(String type) {
		_type = type;
	}

	public String getType() {
		return _type;
	}

	private final String _type;

}
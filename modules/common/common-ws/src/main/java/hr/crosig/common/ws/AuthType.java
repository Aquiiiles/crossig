package hr.crosig.common.ws;

/**
 * @author Leonardo Miyagi
 */
public enum AuthType {

	BASIC("Basic"), OAUTH("OAuth");

	AuthType(String type) {
		_type = type;
	}

	public String getType() {
		return _type;
	}

	private final String _type;

}
package hr.crosig.contact.scheduler.enums;

/**
 * @author victor.catanante
 */
public enum IndexType {

	CITY("city"), STREET("street");

	public String getName() {
		return _name;
	}

	IndexType(String name) {
		_name = name;
	}

	private final String _name;

}
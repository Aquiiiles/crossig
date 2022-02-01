package hr.crosig.contact.scheduler.enums;

/**
 * @author victor.catanante
 */
public enum IndexType {

	CITY_STREET("cityAndStreet");

	public String getName() {
		return _name;
	}

	IndexType(String name) {
		_name = name;
	}

	private final String _name;

}
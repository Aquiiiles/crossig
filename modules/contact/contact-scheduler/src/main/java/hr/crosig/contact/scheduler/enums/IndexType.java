package hr.crosig.contact.scheduler.enums;

/**
 * @author victor.catanante
 */
public enum IndexType {
    CITY("city"),
    STREET("street");

    private final String _name;

    IndexType(String name) {
        this._name = name;
    }

    public String getName() {
        return _name;
    }
}

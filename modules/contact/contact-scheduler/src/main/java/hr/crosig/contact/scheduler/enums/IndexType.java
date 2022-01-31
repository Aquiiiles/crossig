package hr.crosig.contact.scheduler.enums;

/**
 * @author victor.catanante
 */
public enum IndexType {
    CITY("city"),
    STREET("street");

    private String name;

    IndexType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

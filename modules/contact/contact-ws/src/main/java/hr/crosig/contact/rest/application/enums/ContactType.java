package hr.crosig.contact.rest.application.enums;

public enum ContactType {
    INDIVIDUAL(0, "Individual"),
    SELF_EMPLOYED(1, "Self-Employed"),
    LEGAL_ENTITY(2, "Legal Entity");

    private final int value;
    private final String type;

    ContactType(int value, String type) {
        this.value = value;
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }
}

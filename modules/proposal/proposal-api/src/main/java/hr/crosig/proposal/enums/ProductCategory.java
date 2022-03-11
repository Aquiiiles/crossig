package hr.crosig.proposal.enums;

/**
 * @author Guilherme Kfouri
 */
public enum ProductCategory {

	VESSEL("Vessel"),
	MOTOR("Motor");

	public String getTitle() {
		return title;
	}

	ProductCategory(String title) {
		this.title = title;
	}

	private final String title;

}
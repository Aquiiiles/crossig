package hr.crosig.proposal.enums;

/**
 * @author Guilherme Kfouri
 */
public enum ProductCategory {

	MOTOR("Motor"), VESSEL("Vessel");

	public String getTitle() {
		return _title;
	}

	ProductCategory(String title) {
		_title = title;
	}

	private final String _title;

}
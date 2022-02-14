package hr.crosig.proposal.rest.application.enums;

/**
 * @author victor.catanante
 */
public enum InsuredRole {

	INSURED("Insured"), PAYER("Payer"), POLICY_HOLDER("Policy Holder");

	public String getTitle() {
		return _title;
	}

	InsuredRole(String title) {
		_title = title;
	}

	private final String _title;

}
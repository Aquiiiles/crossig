package hr.crosig.proposal.dto;

/**
 * @author Guilherme Kfouri
 */
public class ProposalContactDTO {

	public String getContactExtNumber() {
		return _contactExtNumber;
	}

	public String getInsuredRoles() {
		return _insuredRoles;
	}

	public void setContactExtNumber(String contactExtNumber) {
		_contactExtNumber = contactExtNumber;
	}

	public void setInsuredRoles(String insuredRoles) {
		_insuredRoles = insuredRoles;
	}

	private String _contactExtNumber;
	private String _insuredRoles;

}
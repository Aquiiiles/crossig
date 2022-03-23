package hr.crosig.proposal.dto;

import java.io.Serializable;

/**
 * @author david.martini
 */
public class InsuredRoleDTO implements Serializable {

	public InsuredRoleDTO(
		long insuredRoleId, String title, String name, String externalId) {

		_insuredRoleId = insuredRoleId;
		_title = title;
		_name = name;
		_externalId = externalId;
	}

	public String getExternalId() {
		return _externalId;
	}

	public long getInsuredRoleId() {
		return _insuredRoleId;
	}

	public String getName() {
		return _name;
	}

	public String getTitle() {
		return _title;
	}

	public void setExternalId(String externalId) {
		_externalId = externalId;
	}

	public void setInsuredRoleId(long insuredRoleId) {
		_insuredRoleId = insuredRoleId;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setTitle(String title) {
		_title = title;
	}

	private String _externalId;
	private long _insuredRoleId;
	private String _name;
	private String _title;

}
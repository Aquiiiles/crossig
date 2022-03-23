package hr.crosig.proposal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import hr.crosig.proposal.constants.ProposalConstants;

import java.util.Date;

/**
 * @author Guilherme Kfouri
 */
public class ProposalContactDTO {

	public long getCompanyId() {
		return _companyId;
	}

	public String getContactExtNumber() {
		return _contactExtNumber;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public String getInsuredRoles() {
		return _insuredRoles;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public long getProposalContactId() {
		return _proposalContactId;
	}

	public long getProposalId() {
		return _proposalId;
	}

	public long getUserId() {
		return _userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public void setContactExtNumber(String contactExtNumber) {
		_contactExtNumber = contactExtNumber;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public void setInsuredRoles(String insuredRoles) {
		_insuredRoles = insuredRoles;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public void setProposalContactId(long proposalContactId) {
		_proposalContactId = proposalContactId;
	}

	public void setProposalId(long proposalId) {
		_proposalId = proposalId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	private long _companyId;
	private String _contactExtNumber;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date _createDate;

	private String _insuredRoles;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date _modifiedDate;

	private long _proposalContactId;
	private long _proposalId;
	private long _userId;
	private String _userName;

}
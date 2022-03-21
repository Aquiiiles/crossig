package hr.crosig.proposal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import hr.crosig.proposal.constants.ProposalConstants;

import java.util.Date;

/**
 * @author Guilherme Kfouri
 */
public class ProposalContactDTO {

	public long getCompanyId() {
		return companyId;
	}

	public String getContactExtNumber() {
		return contactExtNumber;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getInsuredRoles() {
		return insuredRoles;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public long getProposalContactId() {
		return proposalContactId;
	}

	public long getProposalId() {
		return proposalId;
	}

	public long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public void setContactExtNumber(String contactExtNumber) {
		this.contactExtNumber = contactExtNumber;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setInsuredRoles(String insuredRoles) {
		this.insuredRoles = insuredRoles;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setProposalContactId(long proposalContactId) {
		this.proposalContactId = proposalContactId;
	}

	public void setProposalId(long proposalId) {
		this.proposalId = proposalId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private long companyId;
	private String contactExtNumber;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date createDate;

	private String insuredRoles;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date modifiedDate;

	private long proposalContactId;
	private long proposalId;
	private long userId;
	private String userName;

}
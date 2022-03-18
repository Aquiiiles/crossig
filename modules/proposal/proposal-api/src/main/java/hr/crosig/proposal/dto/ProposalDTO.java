package hr.crosig.proposal.dto;

import java.util.Date;

/**
 * @author Guilherme Kfouri
 */
public class ProposalDTO {

	public long getAgentUserId() {
		return agentUserId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getExternalProposalNumber() {
		return externalProposalNumber;
	}

	public String getInsuredObjectExtNumber() {
		return insuredObjectExtNumber;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public String getOrigin() {
		return origin;
	}

	public String getPolicyHolderExtNumber() {
		return policyHolderExtNumber;
	}

	public long getProposalId() {
		return proposalId;
	}

	public String getStatus() {
		return status;
	}

	public long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setAgentUserId(long agentUserId) {
		this.agentUserId = agentUserId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setExternalProposalNumber(String externalProposalNumber) {
		this.externalProposalNumber = externalProposalNumber;
	}

	public void setInsuredObjectExtNumber(String insuredObjectExtNumber) {
		this.insuredObjectExtNumber = insuredObjectExtNumber;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setPolicyHolderExtNumber(String policyHolderExtNumber) {
		this.policyHolderExtNumber = policyHolderExtNumber;
	}

	public void setProposalId(long proposalId) {
		this.proposalId = proposalId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private long agentUserId;
	private long companyId;
	private Date createDate;
	private String externalProposalNumber;
	private String insuredObjectExtNumber;
	private Date lastUpdate;
	private Date modifiedDate;
	private String origin;
	private String policyHolderExtNumber;
	private long proposalId;
	private String status;
	private long userId;
	private String userName;

}
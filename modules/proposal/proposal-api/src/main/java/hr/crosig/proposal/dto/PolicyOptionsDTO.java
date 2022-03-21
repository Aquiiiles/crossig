package hr.crosig.proposal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import hr.crosig.proposal.constants.ProposalConstants;

import java.util.Date;

/**
 * @author Guilherme Kfouri
 */
public class PolicyOptionsDTO {

	public String getCommunicationMethod() {
		return communicationMethod;
	}

	public long getCompanyId() {
		return companyId;
	}

	public Date getContractEndDate() {
		return contractEndDate;
	}

	public String getContractPeriod() {
		return contractPeriod;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getCurrency() {
		return currency;
	}

	public int getDurationYear() {
		return durationYear;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public Date getPolicyEndDate() {
		return policyEndDate;
	}

	public int getPolicyNumberDays() {
		return policyNumberDays;
	}

	public long getPolicyOptionsId() {
		return policyOptionsId;
	}

	public Date getPolicyStartDate() {
		return policyStartDate;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public String getProductExtNumber() {
		return productExtNumber;
	}

	public long getProposalId() {
		return proposalId;
	}

	public Date getTermsDate() {
		return termsDate;
	}

	public long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setCommunicationMethod(String communicationMethod) {
		this.communicationMethod = communicationMethod;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setDurationYear(int durationYear) {
		this.durationYear = durationYear;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setPolicyEndDate(Date policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	public void setPolicyNumberDays(int policyNumberDays) {
		this.policyNumberDays = policyNumberDays;
	}

	public void setPolicyOptionsId(long policyOptionsId) {
		this.policyOptionsId = policyOptionsId;
	}

	public void setPolicyStartDate(Date policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public void setProductExtNumber(String productExtNumber) {
		this.productExtNumber = productExtNumber;
	}

	public void setProposalId(long proposalId) {
		this.proposalId = proposalId;
	}

	public void setTermsDate(Date termsDate) {
		this.termsDate = termsDate;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String communicationMethod;
	private long companyId;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date contractEndDate;

	private String contractPeriod;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date contractStartDate;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date createDate;

	private String currency;
	private int durationYear;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date issueDate;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date modifiedDate;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date policyEndDate;

	private int policyNumberDays;
	private long policyOptionsId;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date policyStartDate;

	private String productCategory;
	private String productExtNumber;
	private long proposalId;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date termsDate;

	private long userId;
	private String userName;

}
package hr.crosig.proposal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import hr.crosig.proposal.constants.ProposalConstants;

import java.util.Date;

/**
 * @author Guilherme Kfouri
 */
public class PolicyOptionsDTO {

	public String getCommunicationMethod() {
		return _communicationMethod;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public Date getContractEndDate() {
		return _contractEndDate;
	}

	public String getContractPeriod() {
		return _contractPeriod;
	}

	public Date getContractStartDate() {
		return _contractStartDate;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public String getCurrency() {
		return _currency;
	}

	public int getDurationYear() {
		return _durationYear;
	}

	public Date getIssueDate() {
		return _issueDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public Date getPolicyEndDate() {
		return _policyEndDate;
	}

	public int getPolicyNumberDays() {
		return _policyNumberDays;
	}

	public long getPolicyOptionsId() {
		return _policyOptionsId;
	}

	public Date getPolicyStartDate() {
		return _policyStartDate;
	}

	public String getProductCategory() {
		return _productCategory;
	}

	public String getProductExtNumber() {
		return _productExtNumber;
	}

	public long getProposalId() {
		return _proposalId;
	}

	public Date getTermsDate() {
		return _termsDate;
	}

	public long getUserId() {
		return _userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setCommunicationMethod(String communicationMethod) {
		_communicationMethod = communicationMethod;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public void setContractEndDate(Date contractEndDate) {
		_contractEndDate = contractEndDate;
	}

	public void setContractPeriod(String contractPeriod) {
		_contractPeriod = contractPeriod;
	}

	public void setContractStartDate(Date contractStartDate) {
		_contractStartDate = contractStartDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public void setDurationYear(int durationYear) {
		_durationYear = durationYear;
	}

	public void setIssueDate(Date issueDate) {
		_issueDate = issueDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public void setPolicyEndDate(Date policyEndDate) {
		_policyEndDate = policyEndDate;
	}

	public void setPolicyNumberDays(int policyNumberDays) {
		_policyNumberDays = policyNumberDays;
	}

	public void setPolicyOptionsId(long policyOptionsId) {
		_policyOptionsId = policyOptionsId;
	}

	public void setPolicyStartDate(Date policyStartDate) {
		_policyStartDate = policyStartDate;
	}

	public void setProductCategory(String productCategory) {
		_productCategory = productCategory;
	}

	public void setProductExtNumber(String productExtNumber) {
		_productExtNumber = productExtNumber;
	}

	public void setProposalId(long proposalId) {
		_proposalId = proposalId;
	}

	public void setTermsDate(Date termsDate) {
		_termsDate = termsDate;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	private String _communicationMethod;
	private long _companyId;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date _contractEndDate;

	private String _contractPeriod;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date _contractStartDate;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date _createDate;

	private String _currency;
	private int _durationYear;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date _issueDate;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date _modifiedDate;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date _policyEndDate;

	private int _policyNumberDays;
	private long _policyOptionsId;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date _policyStartDate;

	private String _productCategory;
	private String _productExtNumber;
	private long _proposalId;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date _termsDate;

	private long _userId;
	private String _userName;

}
package hr.crosig.proposal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import hr.crosig.proposal.constants.ProposalConstants;

import java.util.Date;

/**
 * @author Guilherme Kfouri
 */
public class PolicyCoverageOptionDTO {

	public long getCompanyId() {
		return _companyId;
	}

	public String getCoverageOptionsName() {
		return _coverageOptionsName;
	}

	public String getCoverageOptionsValue() {
		return _coverageOptionsValue;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public long getPolicyCoverageOptionId() {
		return _policyCoverageOptionId;
	}

	public long getProposalId() {
		return _proposalId;
	}

	public String getType() {
		return _type;
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

	public void setCoverageOptionsName(String coverageOptionsName) {
		_coverageOptionsName = coverageOptionsName;
	}

	public void setCoverageOptionsValue(String coverageOptionsValue) {
		_coverageOptionsValue = coverageOptionsValue;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public void setPolicyCoverageOptionId(long policyCoverageOptionId) {
		_policyCoverageOptionId = policyCoverageOptionId;
	}

	public void setProposalId(long proposalId) {
		_proposalId = proposalId;
	}

	public void setType(String type) {
		_type = type;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	private long _companyId;
	private String _coverageOptionsName;
	private String _coverageOptionsValue;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date _createDate;

	@JsonFormat(
		pattern = ProposalConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date _modifiedDate;

	private long _policyCoverageOptionId;
	private long _proposalId;
	private String _type;
	private long _userId;
	private String _userName;

}
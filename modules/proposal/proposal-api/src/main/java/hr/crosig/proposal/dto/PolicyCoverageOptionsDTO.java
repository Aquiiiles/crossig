package hr.crosig.proposal.dto;

import java.util.Date;

/**
 * @author Guilherme Kfouri
 */
public class PolicyCoverageOptionsDTO {

	public long getCompanyId() {
		return companyId;
	}

	public String getCoverageOptionsName() {
		return coverageOptionsName;
	}

	public String getCoverageOptionsValue() {
		return coverageOptionsValue;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public long getPolicyCoverageOptionId() {
		return policyCoverageOptionId;
	}

	public String getType() {
		return type;
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

	public void setCoverageOptionsName(String coverageOptionsName) {
		this.coverageOptionsName = coverageOptionsName;
	}

	public void setCoverageOptionsValue(String coverageOptionsValue) {
		this.coverageOptionsValue = coverageOptionsValue;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setPolicyCoverageOptionId(long policyCoverageOptionId) {
		this.policyCoverageOptionId = policyCoverageOptionId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private long companyId;
	private String coverageOptionsName;
	private String coverageOptionsValue;
	private Date createDate;
	private Date modifiedDate;
	private long policyCoverageOptionId;
	private String type;
	private long userId;
	private String userName;

}
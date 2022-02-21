package hr.crosig.contact.dto;

import javax.validation.constraints.Size;

/**
 * @author david.martini
 */
public class SubscriptionDTO {

	public String getBrandCompanyCode() {
		return brandCompanyCode;
	}

	public String getSubsidiaryNumber() {
		return subsidiaryNumber;
	}

	public void setSubsidiaryNumber(String subsidiaryNumber) {
		this.subsidiaryNumber = subsidiaryNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public SubscriptionStatusDTO getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public SubscriptionTypeDTO getSubscriptionType() {
		return subscriptionType;
	}

	public void setBrandCompanyCode(String brandCompanyCode) {
		this.brandCompanyCode = brandCompanyCode;
	}

	public void setSubscriptionStatus(
		SubscriptionStatusDTO subscriptionStatus) {

		this.subscriptionStatus = subscriptionStatus;
	}

	public void setSubscriptionType(SubscriptionTypeDTO subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	@Size(max = 100, min = 1)
	private String brandCompanyCode;
	private String companyName;
	private String subsidiaryNumber;
	private SubscriptionStatusDTO subscriptionStatus;
	private SubscriptionTypeDTO subscriptionType;

}
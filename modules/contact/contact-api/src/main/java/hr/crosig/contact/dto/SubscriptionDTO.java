package hr.crosig.contact.dto;


import javax.validation.constraints.Size;

/**
 * @author david.martini
 */
public class SubscriptionDTO {

    private SubscriptionTypeDTO subscriptionType;
    @Size(min = 1,max = 100)
    private String brandCompanyCode;
    private SubscriptionStatusDTO subscriptionStatus;

    public SubscriptionTypeDTO getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionTypeDTO subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getBrandCompanyCode() {
        return brandCompanyCode;
    }

    public void setBrandCompanyCode(String brandCompanyCode) {
        this.brandCompanyCode = brandCompanyCode;
    }

    public SubscriptionStatusDTO getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(SubscriptionStatusDTO subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }
}

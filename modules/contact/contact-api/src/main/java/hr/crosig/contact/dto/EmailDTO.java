package hr.crosig.contact.dto;

import javax.validation.constraints.Pattern;

/**
 * @author david.martini
 */
public class EmailDTO {

    private EmailTypeDTO emailType;
    private boolean isPreferredDeliveryAddress;
    @Pattern(regexp = "/^[a-z0-9.]+@[a-z0-9]+.[a-z]+.([a-z]+)?$/i")
    private String email;

    public EmailTypeDTO getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailTypeDTO emailType) {
        this.emailType = emailType;
    }

    public boolean isPreferredDeliveryAddress() {
        return isPreferredDeliveryAddress;
    }

    public void setPreferredDeliveryAddress(boolean preferredDeliveryAddress) {
        isPreferredDeliveryAddress = preferredDeliveryAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
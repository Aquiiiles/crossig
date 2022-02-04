package hr.crosig.contact.dto;

import javax.validation.constraints.Pattern;

/**
 * @author david.martini
 */
public class EmailDTO {

	public String getEmail() {
		return email;
	}

	public EmailTypeDTO getEmailType() {
		return emailType;
	}

	public boolean isPreferredDeliveryAddress() {
		return isPreferredDeliveryAddress;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmailType(EmailTypeDTO emailType) {
		this.emailType = emailType;
	}

	public void setPreferredDeliveryAddress(boolean preferredDeliveryAddress) {
		isPreferredDeliveryAddress = preferredDeliveryAddress;
	}

	@Pattern(regexp = "/^[a-z0-9.]+@[a-z0-9]+.[a-z]+.([a-z]+)?$/i")
	private String email;

	private EmailTypeDTO emailType;
	private boolean isPreferredDeliveryAddress;

}
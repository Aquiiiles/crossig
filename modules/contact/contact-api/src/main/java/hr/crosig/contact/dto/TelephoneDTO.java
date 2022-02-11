package hr.crosig.contact.dto;

import javax.validation.constraints.Pattern;

/**
 * @author david.martini
 */
public class TelephoneDTO {

	public CountryDialCodeDTO getCountryDialCode() {
		return countryDialCode;
	}

	public boolean getIsPreferredDeliveryAddress() {
		return isPreferredDeliveryAddress;
	}

	public String getTelephoneExtension() {
		return telephoneExtension;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public String getTelephonePrefix() {
		return telephonePrefix;
	}

	public TelephoneTypeDTO getTelephoneType() {
		return telephoneType;
	}

	public void setCountryDialCode(CountryDialCodeDTO countryDialCode) {
		this.countryDialCode = countryDialCode;
	}

	public void setIsPreferredDeliveryAddress(
		boolean isPreferredDeliveryAddress) {

		this.isPreferredDeliveryAddress = isPreferredDeliveryAddress;
	}

	public void setTelephoneExtension(String telephoneExtension) {
		this.telephoneExtension = telephoneExtension;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public void setTelephonePrefix(String telephonePrefix) {
		this.telephonePrefix = telephonePrefix;
	}

	public void setTelephoneType(TelephoneTypeDTO telephoneType) {
		this.telephoneType = telephoneType;
	}

	private CountryDialCodeDTO countryDialCode;
	private boolean isPreferredDeliveryAddress;
	private String telephoneExtension;

	@Pattern(regexp = "/^[+][(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s./0-9]$")
	private String telephoneNumber;

	private String telephonePrefix;
	private TelephoneTypeDTO telephoneType;

}
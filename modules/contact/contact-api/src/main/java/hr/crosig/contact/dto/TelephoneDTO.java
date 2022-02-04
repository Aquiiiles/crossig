package hr.crosig.contact.dto;

import javax.validation.constraints.Pattern;

/**
 * @author david.martini
 */
public class TelephoneDTO {

	public CountryDialCodeDTO getCountryDialCodeDTO() {
		return countryDialCodeDTO;
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

	public TelephoneTypeDTO getTelephoneTypeDTO() {
		return telephoneTypeDTO;
	}

	public boolean isPreferredDeliveryAddress() {
		return isPreferredDeliveryAddress;
	}

	public void setCountryDialCodeDTO(CountryDialCodeDTO countryDialCodeDTO) {
		this.countryDialCodeDTO = countryDialCodeDTO;
	}

	public void setPreferredDeliveryAddress(boolean preferredDeliveryAddress) {
		isPreferredDeliveryAddress = preferredDeliveryAddress;
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

	public void setTelephoneTypeDTO(TelephoneTypeDTO telephoneTypeDTO) {
		this.telephoneTypeDTO = telephoneTypeDTO;
	}

	private CountryDialCodeDTO countryDialCodeDTO;
	private boolean isPreferredDeliveryAddress;
	private String telephoneExtension;

	@Pattern(regexp = "/^[+][(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s./0-9]$")
	private String telephoneNumber;

	private String telephonePrefix;
	private TelephoneTypeDTO telephoneTypeDTO;

}
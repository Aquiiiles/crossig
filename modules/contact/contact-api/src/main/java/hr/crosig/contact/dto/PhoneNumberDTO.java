package hr.crosig.contact.dto;

import java.io.Serializable;

public class PhoneNumberDTO implements Serializable {

	public String getBrand() {
		return brand;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public Long getIfsId() {
		return ifsId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPhoneNumberTypeExternalCode() {
		return phoneNumberTypeExternalCode;
	}

	public Long getPhoneNumberTypeId() {
		return phoneNumberTypeId;
	}

	public String getUsername() {
		return username;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setIfsId(Long ifsId) {
		this.ifsId = ifsId;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPhoneNumberTypeExternalCode(
		String phoneNumberTypeExternalCode) {

		this.phoneNumberTypeExternalCode = phoneNumberTypeExternalCode;
	}

	public void setPhoneNumberTypeId(Long phoneNumberTypeId) {
		this.phoneNumberTypeId = phoneNumberTypeId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String brand;
	private String countryCode;
	private Long ifsId;
	private String phoneNumber;
	private String phoneNumberTypeExternalCode;
	private Long phoneNumberTypeId;
	private String username;

}
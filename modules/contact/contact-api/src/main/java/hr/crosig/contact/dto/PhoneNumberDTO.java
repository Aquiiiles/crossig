package hr.crosig.contact.dto;

import java.io.Serializable;

/**
 * @author Guilherme Kfouri
 */
public class PhoneNumberDTO implements Serializable {

	public String getBrand() {
		return _brand;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public Long getIfsId() {
		return _ifsId;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public String getPhoneNumberTypeExternalCode() {
		return _phoneNumberTypeExternalCode;
	}

	public Long getPhoneNumberTypeId() {
		return _phoneNumberTypeId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setBrand(String brand) {
		_brand = brand;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	public void setIfsId(Long ifsId) {
		_ifsId = ifsId;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public void setPhoneNumberTypeExternalCode(
		String phoneNumberTypeExternalCode) {

		_phoneNumberTypeExternalCode = phoneNumberTypeExternalCode;
	}

	public void setPhoneNumberTypeId(Long phoneNumberTypeId) {
		_phoneNumberTypeId = phoneNumberTypeId;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	private String _brand;
	private String _countryCode;
	private Long _ifsId;
	private String _phoneNumber;
	private String _phoneNumberTypeExternalCode;
	private Long _phoneNumberTypeId;
	private String _userName;

}
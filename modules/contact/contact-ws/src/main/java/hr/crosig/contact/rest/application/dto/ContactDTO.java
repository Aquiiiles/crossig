package hr.crosig.contact.rest.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import hr.crosig.contact.rest.application.enums.ContactType;
import hr.crosig.contact.rest.application.utils.ContactApplicationConstants;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class ContactDTO implements Serializable {

	public String getCity() {
		return city;
	}

	public String getCompanyName() {
		return companyName;
	}

	public ContactType getContactType() {
		return contactType;
	}

	public String getCountry() {
		return country;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getDispatchCity() {
		return dispatchCity;
	}

	public String getDispatchCountry() {
		return dispatchCountry;
	}

	public int getDispatchHouseNumber() {
		return dispatchHouseNumber;
	}

	public String getDispatchPostalCode() {
		return dispatchPostalCode;
	}

	public String getDispatchStreetAddress() {
		return dispatchStreetAddress;
	}

	public List<String> getEmails() {
		return emails;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public long getOib() {
		return oib;
	}

	public List<PhoneNumberDTO> getPhoneNumbers() {
		return phoneNumbers;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public boolean isForeignerStatus() {
		return foreignerStatus;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setDispatchCity(String dispatchCity) {
		this.dispatchCity = dispatchCity;
	}

	public void setDispatchCountry(String dispatchCountry) {
		this.dispatchCountry = dispatchCountry;
	}

	public void setDispatchHouseNumber(int dispatchHouseNumber) {
		this.dispatchHouseNumber = dispatchHouseNumber;
	}

	public void setDispatchPostalCode(String dispatchPostalCode) {
		this.dispatchPostalCode = dispatchPostalCode;
	}

	public void setDispatchStreetAddress(String dispatchStreetAddress) {
		this.dispatchStreetAddress = dispatchStreetAddress;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setForeignerStatus(boolean foreignerStatus) {
		this.foreignerStatus = foreignerStatus;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setOib(long oib) {
		this.oib = oib;
	}

	public void setPhoneNumbers(List<PhoneNumberDTO> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	private String city;
	private String companyName;
	private ContactType contactType;
	private String country;

	@JsonFormat(
		pattern = ContactApplicationConstants.DATE_FORMAT,
		shape = JsonFormat.Shape.STRING
	)
	private Date dateOfBirth;

	private String dispatchCity;
	private String dispatchCountry;
	private int dispatchHouseNumber;
	private String dispatchPostalCode;
	private String dispatchStreetAddress;
	private List<String> emails;
	private String firstName;
	private boolean foreignerStatus;
	private int houseNumber;
	private String lastName;
	private long oib;
	private List<PhoneNumberDTO> phoneNumbers;
	private String postalCode;
	private String streetAddress;

}
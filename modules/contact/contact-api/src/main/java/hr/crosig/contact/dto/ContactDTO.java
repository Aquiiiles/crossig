package hr.crosig.contact.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import hr.crosig.contact.constants.ContactConstants;
import hr.crosig.contact.enums.ContactType;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * @author Guilherme Kfouri
 */
public class ContactDTO implements Serializable {

	public String getCity() {
		return _city;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public ContactType getContactType() {
		return _contactType;
	}

	public String getCountry() {
		return _country;
	}

	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	public String getDispatchCity() {
		return _dispatchCity;
	}

	public String getDispatchCountry() {
		return _dispatchCountry;
	}

	public int getDispatchHouseNumber() {
		return _dispatchHouseNumber;
	}

	public String getDispatchPostalCode() {
		return _dispatchPostalCode;
	}

	public String getDispatchStreetAddress() {
		return _dispatchStreetAddress;
	}

	public List<String> getEmails() {
		return _emails;
	}

	public String getFirstName() {
		return _firstName;
	}

	public int getHouseNumber() {
		return _houseNumber;
	}

	public String getLastName() {
		return _lastName;
	}

	public long getOib() {
		return _oib;
	}

	public List<PhoneNumberDTO> getPhoneNumbers() {
		return _phoneNumbers;
	}

	public String getPostalCode() {
		return _postalCode;
	}

	public String getStreetAddress() {
		return _streetAddress;
	}

	public boolean isForeignerStatus() {
		return _foreignerStatus;
	}

	public void setCity(String city) {
		_city = city;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	public void setContactType(ContactType contactType) {
		_contactType = contactType;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	public void setDispatchCity(String dispatchCity) {
		_dispatchCity = dispatchCity;
	}

	public void setDispatchCountry(String dispatchCountry) {
		_dispatchCountry = dispatchCountry;
	}

	public void setDispatchHouseNumber(int dispatchHouseNumber) {
		_dispatchHouseNumber = dispatchHouseNumber;
	}

	public void setDispatchPostalCode(String dispatchPostalCode) {
		_dispatchPostalCode = dispatchPostalCode;
	}

	public void setDispatchStreetAddress(String dispatchStreetAddress) {
		_dispatchStreetAddress = dispatchStreetAddress;
	}

	public void setEmails(List<String> emails) {
		_emails = emails;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public void setForeignerStatus(boolean foreignerStatus) {
		_foreignerStatus = foreignerStatus;
	}

	public void setHouseNumber(int houseNumber) {
		_houseNumber = houseNumber;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public void setOib(long oib) {
		_oib = oib;
	}

	public void setPhoneNumbers(List<PhoneNumberDTO> phoneNumbers) {
		_phoneNumbers = phoneNumbers;
	}

	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;
	}

	public void setStreetAddress(String streetAddress) {
		_streetAddress = streetAddress;
	}

	private String _city;
	private String _companyName;
	private ContactType _contactType;
	private String _country;

	@JsonFormat(
		pattern = ContactConstants.DATE_FORMAT, shape = JsonFormat.Shape.STRING
	)
	private Date _dateOfBirth;

	private String _dispatchCity;
	private String _dispatchCountry;
	private int _dispatchHouseNumber;
	private String _dispatchPostalCode;
	private String _dispatchStreetAddress;
	private List<String> _emails;
	private String _firstName;
	private boolean _foreignerStatus;
	private int _houseNumber;
	private String _lastName;
	private long _oib;
	private List<PhoneNumberDTO> _phoneNumbers;
	private String _postalCode;
	private String _streetAddress;

}
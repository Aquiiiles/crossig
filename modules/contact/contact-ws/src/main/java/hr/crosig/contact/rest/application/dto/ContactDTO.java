package hr.crosig.contact.rest.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hr.crosig.contact.rest.application.enums.ContactType;
import hr.crosig.contact.rest.application.utils.ContactApplicationConstants;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ContactDTO implements Serializable {
    private ContactType contactType;
    private String firstName;
    private String lastName;
    private String companyName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ContactApplicationConstants.DATE_FORMAT)
    private Date dateOfBirth;
    private long oib;
    private boolean foreignerStatus;
    private String country;
    private String city;
    private String postalCode;
    private String streetAddress;
    private int houseNumber;
    private String dispatchCountry;
    private String dispatchCity;
    private String dispatchPostalCode;
    private String dispatchStreetAddress;
    private int dispatchHouseNumber;
    private List<String> emails;
    private List<PhoneNumberDTO> phoneNumbers;

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getOib() {
        return oib;
    }

    public void setOib(long oib) {
        this.oib = oib;
    }

    public boolean isForeignerStatus() {
        return foreignerStatus;
    }

    public void setForeignerStatus(boolean foreignerStatus) {
        this.foreignerStatus = foreignerStatus;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getDispatchCountry() {
        return dispatchCountry;
    }

    public void setDispatchCountry(String dispatchCountry) {
        this.dispatchCountry = dispatchCountry;
    }

    public String getDispatchCity() {
        return dispatchCity;
    }

    public void setDispatchCity(String dispatchCity) {
        this.dispatchCity = dispatchCity;
    }

    public String getDispatchPostalCode() {
        return dispatchPostalCode;
    }

    public void setDispatchPostalCode(String dispatchPostalCode) {
        this.dispatchPostalCode = dispatchPostalCode;
    }

    public String getDispatchStreetAddress() {
        return dispatchStreetAddress;
    }

    public void setDispatchStreetAddress(String dispatchStreetAddress) {
        this.dispatchStreetAddress = dispatchStreetAddress;
    }

    public int getDispatchHouseNumber() {
        return dispatchHouseNumber;
    }

    public void setDispatchHouseNumber(int dispatchHouseNumber) {
        this.dispatchHouseNumber = dispatchHouseNumber;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<PhoneNumberDTO> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumberDTO> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}

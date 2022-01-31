package hr.crosig.contact.rest.application.dto;

import java.io.Serializable;

public class PhoneNumberDTO implements Serializable {

    private Long ifsId;
    private String countryCode;
    private String phoneNumber;
    private Long phoneNumberTypeId;
    private String phoneNumberTypeExternalCode;
    private String brand;
    private String username;

    public Long getIfsId() {
        return ifsId;
    }

    public void setIfsId(Long ifsId) {
        this.ifsId = ifsId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getPhoneNumberTypeId() {
        return phoneNumberTypeId;
    }

    public void setPhoneNumberTypeId(Long phoneNumberTypeId) {
        this.phoneNumberTypeId = phoneNumberTypeId;
    }

    public String getPhoneNumberTypeExternalCode() {
        return phoneNumberTypeExternalCode;
    }

    public void setPhoneNumberTypeExternalCode(String phoneNumberTypeExternalCode) {
        this.phoneNumberTypeExternalCode = phoneNumberTypeExternalCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

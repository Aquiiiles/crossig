package hr.crosig.contact.dto;

import javax.validation.constraints.Pattern;

public class TelephoneDTO {


    @Pattern(regexp = "/^[+][(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s./0-9]$")
    private String telephoneNumber;
    private String telephoneExtension;
    private TelephoneTypeDTO telephoneTypeDTO;
    private String telephonePrefix;
    private CountryDialCodeDTO countryDialCodeDTO;
    private boolean isPreferredDeliveryAddress;

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneExtension() {
        return telephoneExtension;
    }

    public void setTelephoneExtension(String telephoneExtension) {
        this.telephoneExtension = telephoneExtension;
    }

    public TelephoneTypeDTO getTelephoneTypeDTO() {
        return telephoneTypeDTO;
    }

    public void setTelephoneTypeDTO(TelephoneTypeDTO telephoneTypeDTO) {
        this.telephoneTypeDTO = telephoneTypeDTO;
    }

    public String getTelephonePrefix() {
        return telephonePrefix;
    }

    public void setTelephonePrefix(String telephonePrefix) {
        this.telephonePrefix = telephonePrefix;
    }

    public CountryDialCodeDTO getCountryDialCodeDTO() {
        return countryDialCodeDTO;
    }

    public void setCountryDialCodeDTO(CountryDialCodeDTO countryDialCodeDTO) {
        this.countryDialCodeDTO = countryDialCodeDTO;
    }

    public boolean isPreferredDeliveryAddress() {
        return isPreferredDeliveryAddress;
    }

    public void setPreferredDeliveryAddress(boolean preferredDeliveryAddress) {
        isPreferredDeliveryAddress = preferredDeliveryAddress;
    }
}

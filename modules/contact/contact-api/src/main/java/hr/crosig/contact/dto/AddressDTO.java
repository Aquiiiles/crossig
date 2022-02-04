package hr.crosig.contact.dto;

import javax.validation.constraints.Size;

/**
 * @author david.martini
 */
public class AddressDTO {
    private String zipCode;
    private ContactDTO country;
    private String pob;
    private String districtName;
    private String apartmentNr;
    private AddressTypeDTO addressType;
    private String regionName;
    private String entranceNr;
    private String blockNr;
    private String buildingName;
    private String streetName;
    @Size(min = 1,max = 100)
    private String cityName;
    private String provinceName;
    private String houseNr;
    private boolean isPreferredDeliveryAddress;
    private String countyName;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public ContactDTO getCountry() {
        return country;
    }

    public void setCountry(ContactDTO country) {
        this.country = country;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getApartmentNr() {
        return apartmentNr;
    }

    public void setApartmentNr(String apartmentNr) {
        this.apartmentNr = apartmentNr;
    }

    public AddressTypeDTO getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressTypeDTO addressType) {
        this.addressType = addressType;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getEntranceNr() {
        return entranceNr;
    }

    public void setEntranceNr(String entranceNr) {
        this.entranceNr = entranceNr;
    }

    public String getBlockNr() {
        return blockNr;
    }

    public void setBlockNr(String blockNr) {
        this.blockNr = blockNr;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(String houseNr) {
        this.houseNr = houseNr;
    }

    public boolean isPreferredDeliveryAddress() {
        return isPreferredDeliveryAddress;
    }

    public void setPreferredDeliveryAddress(boolean preferredDeliveryAddress) {
        isPreferredDeliveryAddress = preferredDeliveryAddress;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
}

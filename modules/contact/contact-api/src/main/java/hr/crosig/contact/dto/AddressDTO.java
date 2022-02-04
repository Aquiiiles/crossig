package hr.crosig.contact.dto;

import javax.validation.constraints.Size;

/**
 * @author david.martini
 */
public class AddressDTO {

	public AddressTypeDTO getAddressType() {
		return addressType;
	}

	public String getApartmentNr() {
		return apartmentNr;
	}

	public String getBlockNr() {
		return blockNr;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public String getCityName() {
		return cityName;
	}

	public ContactDTO getCountry() {
		return country;
	}

	public String getCountyName() {
		return countyName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public String getEntranceNr() {
		return entranceNr;
	}

	public String getHouseNr() {
		return houseNr;
	}

	public String getPob() {
		return pob;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public String getRegionName() {
		return regionName;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public boolean isPreferredDeliveryAddress() {
		return isPreferredDeliveryAddress;
	}

	public void setAddressType(AddressTypeDTO addressType) {
		this.addressType = addressType;
	}

	public void setApartmentNr(String apartmentNr) {
		this.apartmentNr = apartmentNr;
	}

	public void setBlockNr(String blockNr) {
		this.blockNr = blockNr;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setCountry(ContactDTO country) {
		this.country = country;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public void setEntranceNr(String entranceNr) {
		this.entranceNr = entranceNr;
	}

	public void setHouseNr(String houseNr) {
		this.houseNr = houseNr;
	}

	public void setPob(String pob) {
		this.pob = pob;
	}

	public void setPreferredDeliveryAddress(boolean preferredDeliveryAddress) {
		isPreferredDeliveryAddress = preferredDeliveryAddress;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	private AddressTypeDTO addressType;
	private String apartmentNr;
	private String blockNr;
	private String buildingName;

	@Size(max = 100, min = 1)
	private String cityName;

	private ContactDTO country;
	private String countyName;
	private String districtName;
	private String entranceNr;
	private String houseNr;
	private boolean isPreferredDeliveryAddress;
	private String pob;
	private String provinceName;
	private String regionName;
	private String streetName;
	private String zipCode;

}
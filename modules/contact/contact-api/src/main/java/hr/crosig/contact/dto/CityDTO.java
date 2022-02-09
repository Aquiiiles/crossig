package hr.crosig.contact.dto;

/**
 * @author Guilherme Kfouri
 */
public class CityDTO {

	public String getBoxNumber() {
		return boxNumber;
	}

	public long getCityId() {
		return cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public long getExternalCityId() {
		return externalCityId;
	}

	public String getPostName() {
		return postName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setExternalCityId(long externalCityId) {
		this.externalCityId = externalCityId;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	private String boxNumber;
	private long cityId;
	private String cityName;
	private long externalCityId;
	private String postName;
	private String zipCode;

}
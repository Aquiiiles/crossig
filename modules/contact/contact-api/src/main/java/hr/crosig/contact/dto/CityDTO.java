package hr.crosig.contact.dto;

/**
 * @author Guilherme Kfouri
 */
public class CityDTO {

	public String getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public long getExternalCityId() {
		return externalCityId;
	}

	public void setExternalCityId(long externalCityId) {
		this.externalCityId = externalCityId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getZipCode() {
		return zipCode;
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
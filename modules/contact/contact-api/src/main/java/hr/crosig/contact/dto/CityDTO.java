package hr.crosig.contact.dto;

/**
 * @author Guilherme Kfouri
 */
public class CityDTO {

	public String getBoxNumber() {
		return _boxNumber;
	}

	public long getCityId() {
		return _cityId;
	}

	public String getCityName() {
		return _cityName;
	}

	public String getPostName() {
		return _postName;
	}

	public String getZipCode() {
		return _zipCode;
	}

	public void setBoxNumber(String boxNumber) {
		_boxNumber = boxNumber;
	}

	public void setCityId(long cityId) {
		_cityId = cityId;
	}

	public void setCityName(String cityName) {
		_cityName = cityName;
	}

	public void setPostName(String postName) {
		_postName = postName;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	private String _boxNumber;
	private long _cityId;
	private String _cityName;
	private String _postName;
	private String _zipCode;

}
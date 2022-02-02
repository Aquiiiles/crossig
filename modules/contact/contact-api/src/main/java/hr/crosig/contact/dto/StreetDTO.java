package hr.crosig.contact.dto;

/**
 * @author Guilherme Kfouri
 */
public class StreetDTO {

	public long getCityId() {
		return _cityId;
	}

	public long getStreetId() {
		return _streetId;
	}

	public String getStreetName() {
		return _streetName;
	}

	public void setCityId(long cityId) {
		_cityId = cityId;
	}

	public void setStreetId(long streetId) {
		_streetId = streetId;
	}

	public void setStreetName(String streetName) {
		_streetName = streetName;
	}

	private long _cityId;
	private long _streetId;
	private String _streetName;

}
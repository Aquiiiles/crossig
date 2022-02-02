package hr.crosig.contact.dto;

/**
 * @author Guilherme Kfouri
 */
public class StreetDTO {

    private long streetId;
    private String streetName;
    private long cityId;

    public long getStreetId() {
        return streetId;
    }

    public void setStreetId(long streetId) {
        this.streetId = streetId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

}
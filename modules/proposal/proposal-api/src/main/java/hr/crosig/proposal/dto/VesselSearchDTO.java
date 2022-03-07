package hr.crosig.proposal.dto;

public class VesselSearchDTO {

    public String getFleetName() {
        return fleetName;
    }

    public String getNib() {
        return nib;
    }

    public String getRegistrationMark() {
        return registrationMark;
    }

    public String getVesselName() {
        return vesselName;
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }

    public void setNib(String nib) {
        this.nib = nib;
    }

    public void setRegistrationMark(String registrationMark) {
        this.registrationMark = registrationMark;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }

    private String fleetName;
    private String nib;
    private String registrationMark;
    private String vesselName;
    private String vesselType;

}
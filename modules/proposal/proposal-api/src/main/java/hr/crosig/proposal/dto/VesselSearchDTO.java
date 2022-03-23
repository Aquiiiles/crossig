package hr.crosig.proposal.dto;

/**
 * @author Guilherme Kfouri
 */
public class VesselSearchDTO {

	public String getFleetName() {
		return _fleetName;
	}

	public String getNib() {
		return _nib;
	}

	public String getRegistrationMark() {
		return _registrationMark;
	}

	public String getVesselName() {
		return _vesselName;
	}

	public String getVesselType() {
		return _vesselType;
	}

	public void setFleetName(String fleetName) {
		_fleetName = fleetName;
	}

	public void setNib(String nib) {
		_nib = nib;
	}

	public void setRegistrationMark(String registrationMark) {
		_registrationMark = registrationMark;
	}

	public void setVesselName(String vesselName) {
		_vesselName = vesselName;
	}

	public void setVesselType(String vesselType) {
		_vesselType = vesselType;
	}

	private String _fleetName;
	private String _nib;
	private String _registrationMark;
	private String _vesselName;
	private String _vesselType;

}
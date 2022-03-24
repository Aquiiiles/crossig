package hr.crosig.proposal.dto;

/**
 * @author Guilherme Kfouri
 */
public class PolicyCoverageOptionDTO {

	public String getCoverageOptionsName() {
		return _coverageOptionsName;
	}

	public String getCoverageOptionsValue() {
		return _coverageOptionsValue;
	}

	public String getType() {
		return _type;
	}

	public void setCoverageOptionsName(String coverageOptionsName) {
		_coverageOptionsName = coverageOptionsName;
	}

	public void setCoverageOptionsValue(String coverageOptionsValue) {
		_coverageOptionsValue = coverageOptionsValue;
	}

	public void setType(String type) {
		_type = type;
	}

	private String _coverageOptionsName;
	private String _coverageOptionsValue;
	private String _type;

}
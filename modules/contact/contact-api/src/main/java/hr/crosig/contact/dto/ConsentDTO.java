package hr.crosig.contact.dto;

/**
 * @author david.martini
 */
public class ConsentDTO {

	public ConsentTypeDTO getConsentType() {
		return consentType;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setConsentType(ConsentTypeDTO consentType) {
		this.consentType = consentType;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	private ConsentTypeDTO consentType;
	private String endDate;
	private String remarks;
	private String startDate;

}
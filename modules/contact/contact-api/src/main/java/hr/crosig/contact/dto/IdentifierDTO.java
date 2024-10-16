package hr.crosig.contact.dto;

/**
 * @author david.martini
 */
public class IdentifierDTO {

	public CountryDTO getCountry() {
		return country;
	}

	public IdTypeDTO getIdType() {
		return idType;
	}

	public String getIdValue() {
		return idValue;
	}

	public String getIssueDate() {
		return issueDate;
	}

	//verificar se é localDateTIme ou String.
	public String getIssuePlace() {
		return issuePlace;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setCountry(CountryDTO country) {
		this.country = country;
	}

	public void setIdType(IdTypeDTO idType) {
		this.idType = idType;
	}

	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public void setIssuePlace(String issuePlace) {
		this.issuePlace = issuePlace;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	private CountryDTO country;
	private IdTypeDTO idType;
	private String idValue;
	private String issueDate;
	private String issuePlace;
	private String serialNumber;

}
package hr.crosig.contact.dto;

import java.time.LocalDateTime;

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

	public LocalDateTime getIssueDate() {
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

	public void setIssueDate(LocalDateTime issueDate) {
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
	private LocalDateTime issueDate;
	private String issuePlace;
	private String serialNumber;

}
package hr.crosig.contact.dto;

import java.time.LocalDateTime;

/**
 * @author david.martini
 */
public class IdentifierDTO {

    private CountryDTO country;
    private String serialNumber;
    private IdTypeDTO idType;
    private String idValue;

    //verificar se é localDateTIme ou String.
    private LocalDateTime issueDate;
    private String issuePlace;

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public IdTypeDTO getIdType() {
        return idType;
    }

    public void setIdType(IdTypeDTO idType) {
        this.idType = idType;
    }

    public String getIdValue() {
        return idValue;
    }

    public void setIdValue(String idValue) {
        this.idValue = idValue;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssuePlace() {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }
}

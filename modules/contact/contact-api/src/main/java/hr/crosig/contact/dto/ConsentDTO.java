package hr.crosig.contact.dto;

import java.time.LocalDateTime;

/**
 * @author david.martini
 */
public class ConsentDTO {

    private String endDate;
    private ConsentTypeDTO consentType;
    private String startDate;
    private String remarks;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ConsentTypeDTO getConsentType() {
        return consentType;
    }

    public void setConsentType(ConsentTypeDTO consentType) {
        this.consentType = consentType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

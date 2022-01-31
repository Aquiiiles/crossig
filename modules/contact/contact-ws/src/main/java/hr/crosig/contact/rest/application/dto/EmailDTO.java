package hr.crosig.contact.rest.application.dto;

import java.io.Serializable;

public class EmailDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long ifsId;
    private String email;
    private Long emailTypeId;
    private String emailTypeExternalCode;
    private String brand;
    private String userName;

    public Long getIfsId() {
        return ifsId;
    }

    public void setIfsId(Long ifsId) {
        this.ifsId = ifsId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getEmailTypeId() {
        return emailTypeId;
    }

    public void setEmailTypeId(Long emailTypeId) {
        this.emailTypeId = emailTypeId;
    }

    public String getEmailTypeExternalCode() {
        return emailTypeExternalCode;
    }

    public void setEmailTypeExternalCode(String emailTypeExternalCode) {
        this.emailTypeExternalCode = emailTypeExternalCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
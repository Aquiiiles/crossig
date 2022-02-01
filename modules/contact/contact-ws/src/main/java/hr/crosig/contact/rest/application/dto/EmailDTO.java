package hr.crosig.contact.rest.application.dto;

import java.io.Serializable;

public class EmailDTO implements Serializable {

	public String getBrand() {
		return brand;
	}

	public String getEmail() {
		return email;
	}

	public String getEmailTypeExternalCode() {
		return emailTypeExternalCode;
	}

	public Long getEmailTypeId() {
		return emailTypeId;
	}

	public Long getIfsId() {
		return ifsId;
	}

	public String getUserName() {
		return userName;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmailTypeExternalCode(String emailTypeExternalCode) {
		this.emailTypeExternalCode = emailTypeExternalCode;
	}

	public void setEmailTypeId(Long emailTypeId) {
		this.emailTypeId = emailTypeId;
	}

	public void setIfsId(Long ifsId) {
		this.ifsId = ifsId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private static final long serialVersionUID = 1L;

	private String brand;
	private String email;
	private String emailTypeExternalCode;
	private Long emailTypeId;
	private Long ifsId;
	private String userName;

}
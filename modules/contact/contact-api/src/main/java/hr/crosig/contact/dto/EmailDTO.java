package hr.crosig.contact.dto;

import java.io.Serializable;

/**
 * @author Guilherme Kfouri
 */
public class EmailDTO implements Serializable {

	public String getBrand() {
		return _brand;
	}

	public String getEmail() {
		return _email;
	}

	public String getEmailTypeExternalCode() {
		return _emailTypeExternalCode;
	}

	public Long getEmailTypeId() {
		return _emailTypeId;
	}

	public Long getIfsId() {
		return _ifsId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setBrand(String brand) {
		_brand = brand;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public void setEmailTypeExternalCode(String emailTypeExternalCode) {
		_emailTypeExternalCode = emailTypeExternalCode;
	}

	public void setEmailTypeId(Long emailTypeId) {
		_emailTypeId = emailTypeId;
	}

	public void setIfsId(Long ifsId) {
		_ifsId = ifsId;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	private static final long serialVersionUID = 1L;

	private String _brand;
	private String _email;
	private String _emailTypeExternalCode;
	private Long _emailTypeId;
	private Long _ifsId;
	private String _userName;

}
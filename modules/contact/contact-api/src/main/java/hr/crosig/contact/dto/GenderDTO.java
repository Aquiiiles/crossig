package hr.crosig.contact.dto;

/**
 * @author david.martini
 */
public class GenderDTO {

	public String getDesc() {
		return desc;
	}

	public String getExtCode() {
		return extCode;
	}

	public Integer getId() {
		return id;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setExtCode(String extCode) {
		this.extCode = extCode;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String desc;
	private String extCode;
	private Integer id;

}
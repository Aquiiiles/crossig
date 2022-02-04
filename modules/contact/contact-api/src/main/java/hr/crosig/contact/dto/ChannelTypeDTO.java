package hr.crosig.contact.dto;

/**
 * @author david.martini
 */
public class ChannelTypeDTO {
    private String extCode;
    private Integer id;
    private String desc;

    public String getExtCode() {
        return extCode;
    }

    public void setExtCode(String extCode) {
        this.extCode = extCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

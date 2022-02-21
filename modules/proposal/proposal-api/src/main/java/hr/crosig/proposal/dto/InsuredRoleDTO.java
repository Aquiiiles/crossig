package hr.crosig.proposal.dto;

import java.io.Serializable;

/**
 * @author david.martini
 */
public class InsuredRoleDTO implements Serializable {

    public InsuredRoleDTO(long insuredRoleId, String title, String name, String externalId) {
        this.insuredRoleId = insuredRoleId;
        this.title = title;
        this.name = name;
        this.externalId = externalId;
    }

    public long getInsuredRoleId() {
        return insuredRoleId;
    }

    public void setInsuredRoleId(long insuredRoleId) {
        this.insuredRoleId = insuredRoleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    private long insuredRoleId;
    private String title;
    private String name;
    private String externalId;

}

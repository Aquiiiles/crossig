package hr.crosig.proposal.dto;

import java.io.Serializable;

/**
 * @author victor.catanante
 */
public class CoveragePlanDTO implements Serializable {

    private Long coveragePlanId;
    private String name;
    private String description;
    private String category;

    public Long getCoveragePlanId() {
        return coveragePlanId;
    }

    public void setCoveragePlanId(Long coveragePlanId) {
        this.coveragePlanId = coveragePlanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
package hr.crosig.proposal.dto;

import java.io.Serializable;

/**
 * @author victor.catanante
 */
public class CoveragePlanDTO implements Serializable {

	public String getCategory() {
		return category;
	}

	public Long getCoveragePlanId() {
		return coveragePlanId;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCoveragePlanId(Long coveragePlanId) {
		this.coveragePlanId = coveragePlanId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String category;
	private Long coveragePlanId;
	private String description;
	private String name;

}
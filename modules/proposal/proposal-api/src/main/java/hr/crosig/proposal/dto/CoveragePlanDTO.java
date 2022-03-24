package hr.crosig.proposal.dto;

import java.io.Serializable;

/**
 * @author victor.catanante
 */
public class CoveragePlanDTO implements Serializable {

	public String getCategory() {
		return _category;
	}

	public Long getCoveragePlanId() {
		return _coveragePlanId;
	}

	public String getDescription() {
		return _description;
	}

	public String getName() {
		return _name;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public void setCoveragePlanId(Long coveragePlanId) {
		_coveragePlanId = coveragePlanId;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void setName(String name) {
		_name = name;
	}

	private String _category;
	private Long _coveragePlanId;
	private String _description;
	private String _name;

}
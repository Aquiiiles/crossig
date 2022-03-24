package hr.crosig.proposal.dto;

import java.io.Serializable;

/**
 * @author Guilherme Kfouri
 */
public class ProductDTO implements Serializable {

	public ProductDTO(
		boolean active, String category, String description, long productId,
		String name, long externalId) {

		_active = active;
		_category = category;
		_description = description;
		_productId = productId;
		_name = name;
		_externalId = externalId;
	}

	public String getCategory() {
		return _category;
	}

	public String getDescription() {
		return _description;
	}

	public long getExternalId() {
		return _externalId;
	}

	public String getName() {
		return _name;
	}

	public long getProductId() {
		return _productId;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void setExternalId(long externalId) {
		_externalId = externalId;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	private boolean _active;
	private String _category;
	private String _description;
	private long _externalId;
	private String _name;
	private long _productId;

}
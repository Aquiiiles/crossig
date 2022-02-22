package hr.crosig.proposal.dto;

import java.io.Serializable;

/**
 * @author Guilherme Kfouri
 */
public class ProductDTO implements Serializable {

	public ProductDTO(
		boolean active, String category, String description, long productId,
		String name, long externalId) {

		this.active = active;
		this.category = category;
		this.description = description;
		this.productId = productId;
		this.name = name;
		this.externalId = externalId;
	}

	public String getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public long getExternalId() {
		return externalId;
	}

	public String getName() {
		return name;
	}

	public long getProductId() {
		return productId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExternalId(long externalId) {
		this.externalId = externalId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	private boolean active;
	private String category;
	private String description;
	private long externalId;
	private String name;
	private long productId;

}
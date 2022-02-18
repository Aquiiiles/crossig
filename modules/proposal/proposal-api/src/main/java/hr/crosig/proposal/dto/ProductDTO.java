package hr.crosig.proposal.dto;

import java.io.Serializable;

/**
 * @author Guilherme Kfouri
 */
public class ProductDTO implements Serializable {

	public ProductDTO(long productId, String name, long externalId) {
		this.productId = productId;
		this.name = name;
		this.externalId = externalId;
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

	public void setExternalId(long externalId) {
		this.externalId = externalId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	private long externalId;
	private String name;
	private long productId;

}
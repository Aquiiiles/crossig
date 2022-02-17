/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package hr.crosig.proposal.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Product}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Product
 * @generated
 */
public class ProductWrapper
	extends BaseModelWrapper<Product>
	implements ModelWrapper<Product>, Product {

	public ProductWrapper(Product product) {
		super(product);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("productId", getProductId());
		attributes.put("name", getName());
		attributes.put("externalId", getExternalId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long externalId = (Long)attributes.get("externalId");

		if (externalId != null) {
			setExternalId(externalId);
		}
	}

	/**
	 * Returns the external ID of this product.
	 *
	 * @return the external ID of this product
	 */
	@Override
	public long getExternalId() {
		return model.getExternalId();
	}

	/**
	 * Returns the name of this product.
	 *
	 * @return the name of this product
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this product.
	 *
	 * @return the primary key of this product
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product ID of this product.
	 *
	 * @return the product ID of this product
	 */
	@Override
	public long getProductId() {
		return model.getProductId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the external ID of this product.
	 *
	 * @param externalId the external ID of this product
	 */
	@Override
	public void setExternalId(long externalId) {
		model.setExternalId(externalId);
	}

	/**
	 * Sets the name of this product.
	 *
	 * @param name the name of this product
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this product.
	 *
	 * @param primaryKey the primary key of this product
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product ID of this product.
	 *
	 * @param productId the product ID of this product
	 */
	@Override
	public void setProductId(long productId) {
		model.setProductId(productId);
	}

	@Override
	protected ProductWrapper wrap(Product product) {
		return new ProductWrapper(product);
	}

}
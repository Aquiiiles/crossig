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
 * This class is a wrapper for {@link ProductRole}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductRole
 * @generated
 */
public class ProductRoleWrapper
	extends BaseModelWrapper<ProductRole>
	implements ModelWrapper<ProductRole>, ProductRole {

	public ProductRoleWrapper(ProductRole productRole) {
		super(productRole);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("productRoleId", getProductRoleId());
		attributes.put("productId", getProductId());
		attributes.put("roleId", getRoleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long productRoleId = (Long)attributes.get("productRoleId");

		if (productRoleId != null) {
			setProductRoleId(productRoleId);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}
	}

	/**
	 * Returns the primary key of this product role.
	 *
	 * @return the primary key of this product role
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product ID of this product role.
	 *
	 * @return the product ID of this product role
	 */
	@Override
	public long getProductId() {
		return model.getProductId();
	}

	/**
	 * Returns the product role ID of this product role.
	 *
	 * @return the product role ID of this product role
	 */
	@Override
	public long getProductRoleId() {
		return model.getProductRoleId();
	}

	/**
	 * Returns the role ID of this product role.
	 *
	 * @return the role ID of this product role
	 */
	@Override
	public long getRoleId() {
		return model.getRoleId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this product role.
	 *
	 * @param primaryKey the primary key of this product role
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product ID of this product role.
	 *
	 * @param productId the product ID of this product role
	 */
	@Override
	public void setProductId(long productId) {
		model.setProductId(productId);
	}

	/**
	 * Sets the product role ID of this product role.
	 *
	 * @param productRoleId the product role ID of this product role
	 */
	@Override
	public void setProductRoleId(long productRoleId) {
		model.setProductRoleId(productRoleId);
	}

	/**
	 * Sets the role ID of this product role.
	 *
	 * @param roleId the role ID of this product role
	 */
	@Override
	public void setRoleId(long roleId) {
		model.setRoleId(roleId);
	}

	@Override
	protected ProductRoleWrapper wrap(ProductRole productRole) {
		return new ProductRoleWrapper(productRole);
	}

}
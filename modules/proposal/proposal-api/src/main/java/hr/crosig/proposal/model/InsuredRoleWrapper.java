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
 * This class is a wrapper for {@link InsuredRole}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InsuredRole
 * @generated
 */
public class InsuredRoleWrapper
	extends BaseModelWrapper<InsuredRole>
	implements InsuredRole, ModelWrapper<InsuredRole> {

	public InsuredRoleWrapper(InsuredRole insuredRole) {
		super(insuredRole);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("InsuredRoleId", getInsuredRoleId());
		attributes.put("title", getTitle());
		attributes.put("name", getName());
		attributes.put("externalId", getExternalId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long InsuredRoleId = (Long)attributes.get("InsuredRoleId");

		if (InsuredRoleId != null) {
			setInsuredRoleId(InsuredRoleId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String externalId = (String)attributes.get("externalId");

		if (externalId != null) {
			setExternalId(externalId);
		}
	}

	/**
	 * Returns the external ID of this insured role.
	 *
	 * @return the external ID of this insured role
	 */
	@Override
	public String getExternalId() {
		return model.getExternalId();
	}

	/**
	 * Returns the insured role ID of this insured role.
	 *
	 * @return the insured role ID of this insured role
	 */
	@Override
	public long getInsuredRoleId() {
		return model.getInsuredRoleId();
	}

	/**
	 * Returns the name of this insured role.
	 *
	 * @return the name of this insured role
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this insured role.
	 *
	 * @return the primary key of this insured role
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this insured role.
	 *
	 * @return the title of this insured role
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the external ID of this insured role.
	 *
	 * @param externalId the external ID of this insured role
	 */
	@Override
	public void setExternalId(String externalId) {
		model.setExternalId(externalId);
	}

	/**
	 * Sets the insured role ID of this insured role.
	 *
	 * @param InsuredRoleId the insured role ID of this insured role
	 */
	@Override
	public void setInsuredRoleId(long InsuredRoleId) {
		model.setInsuredRoleId(InsuredRoleId);
	}

	/**
	 * Sets the name of this insured role.
	 *
	 * @param name the name of this insured role
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this insured role.
	 *
	 * @param primaryKey the primary key of this insured role
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this insured role.
	 *
	 * @param title the title of this insured role
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	@Override
	protected InsuredRoleWrapper wrap(InsuredRole insuredRole) {
		return new InsuredRoleWrapper(insuredRole);
	}

}
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

package hr.crosig.contact.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Street}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Street
 * @generated
 */
public class StreetWrapper
	extends BaseModelWrapper<Street> implements ModelWrapper<Street>, Street {

	public StreetWrapper(Street street) {
		super(street);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("streetId", getStreetId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalId", getExternalId());
		attributes.put("name", getName());
		attributes.put("cityId", getCityId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long streetId = (Long)attributes.get("streetId");

		if (streetId != null) {
			setStreetId(streetId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long externalId = (Long)attributes.get("externalId");

		if (externalId != null) {
			setExternalId(externalId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long cityId = (Long)attributes.get("cityId");

		if (cityId != null) {
			setCityId(cityId);
		}
	}

	/**
	 * Returns the city ID of this street.
	 *
	 * @return the city ID of this street
	 */
	@Override
	public long getCityId() {
		return model.getCityId();
	}

	/**
	 * Returns the company ID of this street.
	 *
	 * @return the company ID of this street
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this street.
	 *
	 * @return the create date of this street
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external ID of this street.
	 *
	 * @return the external ID of this street
	 */
	@Override
	public long getExternalId() {
		return model.getExternalId();
	}

	/**
	 * Returns the modified date of this street.
	 *
	 * @return the modified date of this street
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this street.
	 *
	 * @return the name of this street
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this street.
	 *
	 * @return the primary key of this street
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the street ID of this street.
	 *
	 * @return the street ID of this street
	 */
	@Override
	public long getStreetId() {
		return model.getStreetId();
	}

	/**
	 * Returns the user ID of this street.
	 *
	 * @return the user ID of this street
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this street.
	 *
	 * @return the user name of this street
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this street.
	 *
	 * @return the user uuid of this street
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the city ID of this street.
	 *
	 * @param cityId the city ID of this street
	 */
	@Override
	public void setCityId(long cityId) {
		model.setCityId(cityId);
	}

	/**
	 * Sets the company ID of this street.
	 *
	 * @param companyId the company ID of this street
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this street.
	 *
	 * @param createDate the create date of this street
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external ID of this street.
	 *
	 * @param externalId the external ID of this street
	 */
	@Override
	public void setExternalId(long externalId) {
		model.setExternalId(externalId);
	}

	/**
	 * Sets the modified date of this street.
	 *
	 * @param modifiedDate the modified date of this street
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this street.
	 *
	 * @param name the name of this street
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this street.
	 *
	 * @param primaryKey the primary key of this street
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the street ID of this street.
	 *
	 * @param streetId the street ID of this street
	 */
	@Override
	public void setStreetId(long streetId) {
		model.setStreetId(streetId);
	}

	/**
	 * Sets the user ID of this street.
	 *
	 * @param userId the user ID of this street
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this street.
	 *
	 * @param userName the user name of this street
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this street.
	 *
	 * @param userUuid the user uuid of this street
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected StreetWrapper wrap(Street street) {
		return new StreetWrapper(street);
	}

}
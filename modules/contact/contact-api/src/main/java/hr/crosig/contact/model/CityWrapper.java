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
 * This class is a wrapper for {@link City}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see City
 * @generated
 */
public class CityWrapper
	extends BaseModelWrapper<City> implements City, ModelWrapper<City> {

	public CityWrapper(City city) {
		super(city);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cityId", getCityId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalId", getExternalId());
		attributes.put("name", getName());
		attributes.put("zipCode", getZipCode());
		attributes.put("boxNumber", getBoxNumber());
		attributes.put("postName", getPostName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cityId = (Long)attributes.get("cityId");

		if (cityId != null) {
			setCityId(cityId);
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

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		String boxNumber = (String)attributes.get("boxNumber");

		if (boxNumber != null) {
			setBoxNumber(boxNumber);
		}

		String postName = (String)attributes.get("postName");

		if (postName != null) {
			setPostName(postName);
		}
	}

	/**
	 * Returns the box number of this city.
	 *
	 * @return the box number of this city
	 */
	@Override
	public String getBoxNumber() {
		return model.getBoxNumber();
	}

	/**
	 * Returns the city ID of this city.
	 *
	 * @return the city ID of this city
	 */
	@Override
	public long getCityId() {
		return model.getCityId();
	}

	/**
	 * Returns the company ID of this city.
	 *
	 * @return the company ID of this city
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this city.
	 *
	 * @return the create date of this city
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external ID of this city.
	 *
	 * @return the external ID of this city
	 */
	@Override
	public long getExternalId() {
		return model.getExternalId();
	}

	/**
	 * Returns the modified date of this city.
	 *
	 * @return the modified date of this city
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this city.
	 *
	 * @return the name of this city
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the post name of this city.
	 *
	 * @return the post name of this city
	 */
	@Override
	public String getPostName() {
		return model.getPostName();
	}

	/**
	 * Returns the primary key of this city.
	 *
	 * @return the primary key of this city
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this city.
	 *
	 * @return the user ID of this city
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this city.
	 *
	 * @return the user name of this city
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this city.
	 *
	 * @return the user uuid of this city
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the zip code of this city.
	 *
	 * @return the zip code of this city
	 */
	@Override
	public String getZipCode() {
		return model.getZipCode();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the box number of this city.
	 *
	 * @param boxNumber the box number of this city
	 */
	@Override
	public void setBoxNumber(String boxNumber) {
		model.setBoxNumber(boxNumber);
	}

	/**
	 * Sets the city ID of this city.
	 *
	 * @param cityId the city ID of this city
	 */
	@Override
	public void setCityId(long cityId) {
		model.setCityId(cityId);
	}

	/**
	 * Sets the company ID of this city.
	 *
	 * @param companyId the company ID of this city
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this city.
	 *
	 * @param createDate the create date of this city
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external ID of this city.
	 *
	 * @param externalId the external ID of this city
	 */
	@Override
	public void setExternalId(long externalId) {
		model.setExternalId(externalId);
	}

	/**
	 * Sets the modified date of this city.
	 *
	 * @param modifiedDate the modified date of this city
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this city.
	 *
	 * @param name the name of this city
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the post name of this city.
	 *
	 * @param postName the post name of this city
	 */
	@Override
	public void setPostName(String postName) {
		model.setPostName(postName);
	}

	/**
	 * Sets the primary key of this city.
	 *
	 * @param primaryKey the primary key of this city
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this city.
	 *
	 * @param userId the user ID of this city
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this city.
	 *
	 * @param userName the user name of this city
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this city.
	 *
	 * @param userUuid the user uuid of this city
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the zip code of this city.
	 *
	 * @param zipCode the zip code of this city
	 */
	@Override
	public void setZipCode(String zipCode) {
		model.setZipCode(zipCode);
	}

	@Override
	protected CityWrapper wrap(City city) {
		return new CityWrapper(city);
	}

}
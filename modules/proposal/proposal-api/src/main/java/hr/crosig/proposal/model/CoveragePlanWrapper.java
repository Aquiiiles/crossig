/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CoveragePlan}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CoveragePlan
 * @generated
 */
public class CoveragePlanWrapper
	extends BaseModelWrapper<CoveragePlan>
	implements CoveragePlan, ModelWrapper<CoveragePlan> {

	public CoveragePlanWrapper(CoveragePlan coveragePlan) {
		super(coveragePlan);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("coveragePlanId", getCoveragePlanId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("category", getCategory());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long coveragePlanId = (Long)attributes.get("coveragePlanId");

		if (coveragePlanId != null) {
			setCoveragePlanId(coveragePlanId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}
	}

	@Override
	public CoveragePlan cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the category of this coverage plan.
	 *
	 * @return the category of this coverage plan
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the company ID of this coverage plan.
	 *
	 * @return the company ID of this coverage plan
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the coverage plan ID of this coverage plan.
	 *
	 * @return the coverage plan ID of this coverage plan
	 */
	@Override
	public long getCoveragePlanId() {
		return model.getCoveragePlanId();
	}

	/**
	 * Returns the create date of this coverage plan.
	 *
	 * @return the create date of this coverage plan
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this coverage plan.
	 *
	 * @return the description of this coverage plan
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the modified date of this coverage plan.
	 *
	 * @return the modified date of this coverage plan
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this coverage plan.
	 *
	 * @return the name of this coverage plan
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this coverage plan.
	 *
	 * @return the primary key of this coverage plan
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this coverage plan.
	 *
	 * @return the user ID of this coverage plan
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this coverage plan.
	 *
	 * @return the user name of this coverage plan
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this coverage plan.
	 *
	 * @return the user uuid of this coverage plan
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
	 * Sets the category of this coverage plan.
	 *
	 * @param category the category of this coverage plan
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the company ID of this coverage plan.
	 *
	 * @param companyId the company ID of this coverage plan
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the coverage plan ID of this coverage plan.
	 *
	 * @param coveragePlanId the coverage plan ID of this coverage plan
	 */
	@Override
	public void setCoveragePlanId(long coveragePlanId) {
		model.setCoveragePlanId(coveragePlanId);
	}

	/**
	 * Sets the create date of this coverage plan.
	 *
	 * @param createDate the create date of this coverage plan
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this coverage plan.
	 *
	 * @param description the description of this coverage plan
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the modified date of this coverage plan.
	 *
	 * @param modifiedDate the modified date of this coverage plan
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this coverage plan.
	 *
	 * @param name the name of this coverage plan
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this coverage plan.
	 *
	 * @param primaryKey the primary key of this coverage plan
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this coverage plan.
	 *
	 * @param userId the user ID of this coverage plan
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this coverage plan.
	 *
	 * @param userName the user name of this coverage plan
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this coverage plan.
	 *
	 * @param userUuid the user uuid of this coverage plan
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected CoveragePlanWrapper wrap(CoveragePlan coveragePlan) {
		return new CoveragePlanWrapper(coveragePlan);
	}

}
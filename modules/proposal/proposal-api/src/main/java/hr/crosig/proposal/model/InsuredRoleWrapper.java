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
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
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

	@Override
	public InsuredRole cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this insured role.
	 *
	 * @return the company ID of this insured role
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this insured role.
	 *
	 * @return the create date of this insured role
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
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
	 * Returns the modified date of this insured role.
	 *
	 * @return the modified date of this insured role
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
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

	/**
	 * Returns the user ID of this insured role.
	 *
	 * @return the user ID of this insured role
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this insured role.
	 *
	 * @return the user name of this insured role
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this insured role.
	 *
	 * @return the user uuid of this insured role
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
	 * Sets the company ID of this insured role.
	 *
	 * @param companyId the company ID of this insured role
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this insured role.
	 *
	 * @param createDate the create date of this insured role
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
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
	 * Sets the modified date of this insured role.
	 *
	 * @param modifiedDate the modified date of this insured role
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
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

	/**
	 * Sets the user ID of this insured role.
	 *
	 * @param userId the user ID of this insured role
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this insured role.
	 *
	 * @param userName the user name of this insured role
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this insured role.
	 *
	 * @param userUuid the user uuid of this insured role
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
	protected InsuredRoleWrapper wrap(InsuredRole insuredRole) {
		return new InsuredRoleWrapper(insuredRole);
	}

}
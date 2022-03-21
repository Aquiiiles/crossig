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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PolicyCoverageOpt}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCoverageOpt
 * @generated
 */
public class PolicyCoverageOptWrapper
	extends BaseModelWrapper<PolicyCoverageOpt>
	implements ModelWrapper<PolicyCoverageOpt>, PolicyCoverageOpt {

	public PolicyCoverageOptWrapper(PolicyCoverageOpt policyCoverageOpt) {
		super(policyCoverageOpt);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("policyCoverageOptionId", getPolicyCoverageOptionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("proposalId", getProposalId());
		attributes.put("coverageOptionsName", getCoverageOptionsName());
		attributes.put("coverageOptionsValue", getCoverageOptionsValue());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long policyCoverageOptionId = (Long)attributes.get(
			"policyCoverageOptionId");

		if (policyCoverageOptionId != null) {
			setPolicyCoverageOptionId(policyCoverageOptionId);
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

		Long proposalId = (Long)attributes.get("proposalId");

		if (proposalId != null) {
			setProposalId(proposalId);
		}

		String coverageOptionsName = (String)attributes.get(
			"coverageOptionsName");

		if (coverageOptionsName != null) {
			setCoverageOptionsName(coverageOptionsName);
		}

		String coverageOptionsValue = (String)attributes.get(
			"coverageOptionsValue");

		if (coverageOptionsValue != null) {
			setCoverageOptionsValue(coverageOptionsValue);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	 * Returns the company ID of this policy coverage opt.
	 *
	 * @return the company ID of this policy coverage opt
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the coverage options name of this policy coverage opt.
	 *
	 * @return the coverage options name of this policy coverage opt
	 */
	@Override
	public String getCoverageOptionsName() {
		return model.getCoverageOptionsName();
	}

	/**
	 * Returns the coverage options value of this policy coverage opt.
	 *
	 * @return the coverage options value of this policy coverage opt
	 */
	@Override
	public String getCoverageOptionsValue() {
		return model.getCoverageOptionsValue();
	}

	/**
	 * Returns the create date of this policy coverage opt.
	 *
	 * @return the create date of this policy coverage opt
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the modified date of this policy coverage opt.
	 *
	 * @return the modified date of this policy coverage opt
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the policy coverage option ID of this policy coverage opt.
	 *
	 * @return the policy coverage option ID of this policy coverage opt
	 */
	@Override
	public long getPolicyCoverageOptionId() {
		return model.getPolicyCoverageOptionId();
	}

	/**
	 * Returns the primary key of this policy coverage opt.
	 *
	 * @return the primary key of this policy coverage opt
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the proposal ID of this policy coverage opt.
	 *
	 * @return the proposal ID of this policy coverage opt
	 */
	@Override
	public long getProposalId() {
		return model.getProposalId();
	}

	/**
	 * Returns the type of this policy coverage opt.
	 *
	 * @return the type of this policy coverage opt
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this policy coverage opt.
	 *
	 * @return the user ID of this policy coverage opt
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this policy coverage opt.
	 *
	 * @return the user name of this policy coverage opt
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this policy coverage opt.
	 *
	 * @return the user uuid of this policy coverage opt
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
	 * Sets the company ID of this policy coverage opt.
	 *
	 * @param companyId the company ID of this policy coverage opt
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the coverage options name of this policy coverage opt.
	 *
	 * @param coverageOptionsName the coverage options name of this policy coverage opt
	 */
	@Override
	public void setCoverageOptionsName(String coverageOptionsName) {
		model.setCoverageOptionsName(coverageOptionsName);
	}

	/**
	 * Sets the coverage options value of this policy coverage opt.
	 *
	 * @param coverageOptionsValue the coverage options value of this policy coverage opt
	 */
	@Override
	public void setCoverageOptionsValue(String coverageOptionsValue) {
		model.setCoverageOptionsValue(coverageOptionsValue);
	}

	/**
	 * Sets the create date of this policy coverage opt.
	 *
	 * @param createDate the create date of this policy coverage opt
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this policy coverage opt.
	 *
	 * @param modifiedDate the modified date of this policy coverage opt
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the policy coverage option ID of this policy coverage opt.
	 *
	 * @param policyCoverageOptionId the policy coverage option ID of this policy coverage opt
	 */
	@Override
	public void setPolicyCoverageOptionId(long policyCoverageOptionId) {
		model.setPolicyCoverageOptionId(policyCoverageOptionId);
	}

	/**
	 * Sets the primary key of this policy coverage opt.
	 *
	 * @param primaryKey the primary key of this policy coverage opt
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the proposal ID of this policy coverage opt.
	 *
	 * @param proposalId the proposal ID of this policy coverage opt
	 */
	@Override
	public void setProposalId(long proposalId) {
		model.setProposalId(proposalId);
	}

	/**
	 * Sets the type of this policy coverage opt.
	 *
	 * @param type the type of this policy coverage opt
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this policy coverage opt.
	 *
	 * @param userId the user ID of this policy coverage opt
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this policy coverage opt.
	 *
	 * @param userName the user name of this policy coverage opt
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this policy coverage opt.
	 *
	 * @param userUuid the user uuid of this policy coverage opt
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PolicyCoverageOptWrapper wrap(
		PolicyCoverageOpt policyCoverageOpt) {

		return new PolicyCoverageOptWrapper(policyCoverageOpt);
	}

}
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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CoveragePlan service. Represents a row in the &quot;AP_Proposal_CoveragePlan&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>hr.crosig.proposal.model.impl.CoveragePlanModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>hr.crosig.proposal.model.impl.CoveragePlanImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CoveragePlan
 * @generated
 */
@ProviderType
public interface CoveragePlanModel
	extends AuditedModel, BaseModel<CoveragePlan>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a coverage plan model instance should use the {@link CoveragePlan} interface instead.
	 */

	/**
	 * Returns the primary key of this coverage plan.
	 *
	 * @return the primary key of this coverage plan
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this coverage plan.
	 *
	 * @param primaryKey the primary key of this coverage plan
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the coverage plan ID of this coverage plan.
	 *
	 * @return the coverage plan ID of this coverage plan
	 */
	public long getCoveragePlanId();

	/**
	 * Sets the coverage plan ID of this coverage plan.
	 *
	 * @param coveragePlanId the coverage plan ID of this coverage plan
	 */
	public void setCoveragePlanId(long coveragePlanId);

	/**
	 * Returns the company ID of this coverage plan.
	 *
	 * @return the company ID of this coverage plan
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this coverage plan.
	 *
	 * @param companyId the company ID of this coverage plan
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this coverage plan.
	 *
	 * @return the user ID of this coverage plan
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this coverage plan.
	 *
	 * @param userId the user ID of this coverage plan
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this coverage plan.
	 *
	 * @return the user uuid of this coverage plan
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this coverage plan.
	 *
	 * @param userUuid the user uuid of this coverage plan
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this coverage plan.
	 *
	 * @return the user name of this coverage plan
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this coverage plan.
	 *
	 * @param userName the user name of this coverage plan
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this coverage plan.
	 *
	 * @return the create date of this coverage plan
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this coverage plan.
	 *
	 * @param createDate the create date of this coverage plan
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this coverage plan.
	 *
	 * @return the modified date of this coverage plan
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this coverage plan.
	 *
	 * @param modifiedDate the modified date of this coverage plan
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this coverage plan.
	 *
	 * @return the name of this coverage plan
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this coverage plan.
	 *
	 * @param name the name of this coverage plan
	 */
	public void setName(String name);

	/**
	 * Returns the description of this coverage plan.
	 *
	 * @return the description of this coverage plan
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this coverage plan.
	 *
	 * @param description the description of this coverage plan
	 */
	public void setDescription(String description);

	/**
	 * Returns the category of this coverage plan.
	 *
	 * @return the category of this coverage plan
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this coverage plan.
	 *
	 * @param category the category of this coverage plan
	 */
	public void setCategory(String category);

}
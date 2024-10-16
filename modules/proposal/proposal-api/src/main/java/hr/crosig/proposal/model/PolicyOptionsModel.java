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
 * The base model interface for the PolicyOptions service. Represents a row in the &quot;AP_Proposal_PolicyOptions&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>hr.crosig.proposal.model.impl.PolicyOptionsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>hr.crosig.proposal.model.impl.PolicyOptionsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyOptions
 * @generated
 */
@ProviderType
public interface PolicyOptionsModel
	extends AuditedModel, BaseModel<PolicyOptions>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a policy options model instance should use the {@link PolicyOptions} interface instead.
	 */

	/**
	 * Returns the primary key of this policy options.
	 *
	 * @return the primary key of this policy options
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this policy options.
	 *
	 * @param primaryKey the primary key of this policy options
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the policy options ID of this policy options.
	 *
	 * @return the policy options ID of this policy options
	 */
	public long getPolicyOptionsId();

	/**
	 * Sets the policy options ID of this policy options.
	 *
	 * @param policyOptionsId the policy options ID of this policy options
	 */
	public void setPolicyOptionsId(long policyOptionsId);

	/**
	 * Returns the company ID of this policy options.
	 *
	 * @return the company ID of this policy options
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this policy options.
	 *
	 * @param companyId the company ID of this policy options
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this policy options.
	 *
	 * @return the user ID of this policy options
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this policy options.
	 *
	 * @param userId the user ID of this policy options
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this policy options.
	 *
	 * @return the user uuid of this policy options
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this policy options.
	 *
	 * @param userUuid the user uuid of this policy options
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this policy options.
	 *
	 * @return the user name of this policy options
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this policy options.
	 *
	 * @param userName the user name of this policy options
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this policy options.
	 *
	 * @return the create date of this policy options
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this policy options.
	 *
	 * @param createDate the create date of this policy options
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this policy options.
	 *
	 * @return the modified date of this policy options
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this policy options.
	 *
	 * @param modifiedDate the modified date of this policy options
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the proposal ID of this policy options.
	 *
	 * @return the proposal ID of this policy options
	 */
	public long getProposalId();

	/**
	 * Sets the proposal ID of this policy options.
	 *
	 * @param proposalId the proposal ID of this policy options
	 */
	public void setProposalId(long proposalId);

	/**
	 * Returns the currency of this policy options.
	 *
	 * @return the currency of this policy options
	 */
	@AutoEscape
	public String getCurrency();

	/**
	 * Sets the currency of this policy options.
	 *
	 * @param currency the currency of this policy options
	 */
	public void setCurrency(String currency);

	/**
	 * Returns the terms date of this policy options.
	 *
	 * @return the terms date of this policy options
	 */
	public Date getTermsDate();

	/**
	 * Sets the terms date of this policy options.
	 *
	 * @param termsDate the terms date of this policy options
	 */
	public void setTermsDate(Date termsDate);

	/**
	 * Returns the product category of this policy options.
	 *
	 * @return the product category of this policy options
	 */
	@AutoEscape
	public String getProductCategory();

	/**
	 * Sets the product category of this policy options.
	 *
	 * @param productCategory the product category of this policy options
	 */
	public void setProductCategory(String productCategory);

	/**
	 * Returns the product ext number of this policy options.
	 *
	 * @return the product ext number of this policy options
	 */
	@AutoEscape
	public String getProductExtNumber();

	/**
	 * Sets the product ext number of this policy options.
	 *
	 * @param productExtNumber the product ext number of this policy options
	 */
	public void setProductExtNumber(String productExtNumber);

	/**
	 * Returns the issue date of this policy options.
	 *
	 * @return the issue date of this policy options
	 */
	public Date getIssueDate();

	/**
	 * Sets the issue date of this policy options.
	 *
	 * @param issueDate the issue date of this policy options
	 */
	public void setIssueDate(Date issueDate);

	/**
	 * Returns the contract start date of this policy options.
	 *
	 * @return the contract start date of this policy options
	 */
	public Date getContractStartDate();

	/**
	 * Sets the contract start date of this policy options.
	 *
	 * @param contractStartDate the contract start date of this policy options
	 */
	public void setContractStartDate(Date contractStartDate);

	/**
	 * Returns the contract end date of this policy options.
	 *
	 * @return the contract end date of this policy options
	 */
	public Date getContractEndDate();

	/**
	 * Sets the contract end date of this policy options.
	 *
	 * @param contractEndDate the contract end date of this policy options
	 */
	public void setContractEndDate(Date contractEndDate);

	/**
	 * Returns the contract period of this policy options.
	 *
	 * @return the contract period of this policy options
	 */
	@AutoEscape
	public String getContractPeriod();

	/**
	 * Sets the contract period of this policy options.
	 *
	 * @param contractPeriod the contract period of this policy options
	 */
	public void setContractPeriod(String contractPeriod);

	/**
	 * Returns the duration year of this policy options.
	 *
	 * @return the duration year of this policy options
	 */
	public int getDurationYear();

	/**
	 * Sets the duration year of this policy options.
	 *
	 * @param durationYear the duration year of this policy options
	 */
	public void setDurationYear(int durationYear);

	/**
	 * Returns the policy start date of this policy options.
	 *
	 * @return the policy start date of this policy options
	 */
	public Date getPolicyStartDate();

	/**
	 * Sets the policy start date of this policy options.
	 *
	 * @param policyStartDate the policy start date of this policy options
	 */
	public void setPolicyStartDate(Date policyStartDate);

	/**
	 * Returns the policy end date of this policy options.
	 *
	 * @return the policy end date of this policy options
	 */
	public Date getPolicyEndDate();

	/**
	 * Sets the policy end date of this policy options.
	 *
	 * @param policyEndDate the policy end date of this policy options
	 */
	public void setPolicyEndDate(Date policyEndDate);

	/**
	 * Returns the policy number days of this policy options.
	 *
	 * @return the policy number days of this policy options
	 */
	public int getPolicyNumberDays();

	/**
	 * Sets the policy number days of this policy options.
	 *
	 * @param policyNumberDays the policy number days of this policy options
	 */
	public void setPolicyNumberDays(int policyNumberDays);

	/**
	 * Returns the communication method of this policy options.
	 *
	 * @return the communication method of this policy options
	 */
	@AutoEscape
	public String getCommunicationMethod();

	/**
	 * Sets the communication method of this policy options.
	 *
	 * @param communicationMethod the communication method of this policy options
	 */
	public void setCommunicationMethod(String communicationMethod);

}
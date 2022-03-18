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
 * This class is a wrapper for {@link PolicyOptions}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyOptions
 * @generated
 */
public class PolicyOptionsWrapper
	extends BaseModelWrapper<PolicyOptions>
	implements ModelWrapper<PolicyOptions>, PolicyOptions {

	public PolicyOptionsWrapper(PolicyOptions policyOptions) {
		super(policyOptions);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("policyOptionsId", getPolicyOptionsId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("proposalId", getProposalId());
		attributes.put("currency", getCurrency());
		attributes.put("termsDate", getTermsDate());
		attributes.put("productCategory", getProductCategory());
		attributes.put("productExtNumber", getProductExtNumber());
		attributes.put("issueDate", getIssueDate());
		attributes.put("contractStartDate", getContractStartDate());
		attributes.put("contractEndDate", getContractEndDate());
		attributes.put("contractPeriod", getContractPeriod());
		attributes.put("durationYear", getDurationYear());
		attributes.put("policyStartDate", getPolicyStartDate());
		attributes.put("policyEndDate", getPolicyEndDate());
		attributes.put("policyNumberDays", getPolicyNumberDays());
		attributes.put("communicationMethod", getCommunicationMethod());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long policyOptionsId = (Long)attributes.get("policyOptionsId");

		if (policyOptionsId != null) {
			setPolicyOptionsId(policyOptionsId);
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

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Date termsDate = (Date)attributes.get("termsDate");

		if (termsDate != null) {
			setTermsDate(termsDate);
		}

		String productCategory = (String)attributes.get("productCategory");

		if (productCategory != null) {
			setProductCategory(productCategory);
		}

		String productExtNumber = (String)attributes.get("productExtNumber");

		if (productExtNumber != null) {
			setProductExtNumber(productExtNumber);
		}

		Date issueDate = (Date)attributes.get("issueDate");

		if (issueDate != null) {
			setIssueDate(issueDate);
		}

		Date contractStartDate = (Date)attributes.get("contractStartDate");

		if (contractStartDate != null) {
			setContractStartDate(contractStartDate);
		}

		Date contractEndDate = (Date)attributes.get("contractEndDate");

		if (contractEndDate != null) {
			setContractEndDate(contractEndDate);
		}

		String contractPeriod = (String)attributes.get("contractPeriod");

		if (contractPeriod != null) {
			setContractPeriod(contractPeriod);
		}

		Integer durationYear = (Integer)attributes.get("durationYear");

		if (durationYear != null) {
			setDurationYear(durationYear);
		}

		Date policyStartDate = (Date)attributes.get("policyStartDate");

		if (policyStartDate != null) {
			setPolicyStartDate(policyStartDate);
		}

		Date policyEndDate = (Date)attributes.get("policyEndDate");

		if (policyEndDate != null) {
			setPolicyEndDate(policyEndDate);
		}

		Integer policyNumberDays = (Integer)attributes.get("policyNumberDays");

		if (policyNumberDays != null) {
			setPolicyNumberDays(policyNumberDays);
		}

		String communicationMethod = (String)attributes.get(
			"communicationMethod");

		if (communicationMethod != null) {
			setCommunicationMethod(communicationMethod);
		}
	}

	/**
	 * Returns the communication method of this policy options.
	 *
	 * @return the communication method of this policy options
	 */
	@Override
	public String getCommunicationMethod() {
		return model.getCommunicationMethod();
	}

	/**
	 * Returns the company ID of this policy options.
	 *
	 * @return the company ID of this policy options
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contract end date of this policy options.
	 *
	 * @return the contract end date of this policy options
	 */
	@Override
	public Date getContractEndDate() {
		return model.getContractEndDate();
	}

	/**
	 * Returns the contract period of this policy options.
	 *
	 * @return the contract period of this policy options
	 */
	@Override
	public String getContractPeriod() {
		return model.getContractPeriod();
	}

	/**
	 * Returns the contract start date of this policy options.
	 *
	 * @return the contract start date of this policy options
	 */
	@Override
	public Date getContractStartDate() {
		return model.getContractStartDate();
	}

	/**
	 * Returns the create date of this policy options.
	 *
	 * @return the create date of this policy options
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currency of this policy options.
	 *
	 * @return the currency of this policy options
	 */
	@Override
	public String getCurrency() {
		return model.getCurrency();
	}

	/**
	 * Returns the duration year of this policy options.
	 *
	 * @return the duration year of this policy options
	 */
	@Override
	public int getDurationYear() {
		return model.getDurationYear();
	}

	/**
	 * Returns the issue date of this policy options.
	 *
	 * @return the issue date of this policy options
	 */
	@Override
	public Date getIssueDate() {
		return model.getIssueDate();
	}

	/**
	 * Returns the modified date of this policy options.
	 *
	 * @return the modified date of this policy options
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the policy end date of this policy options.
	 *
	 * @return the policy end date of this policy options
	 */
	@Override
	public Date getPolicyEndDate() {
		return model.getPolicyEndDate();
	}

	/**
	 * Returns the policy number days of this policy options.
	 *
	 * @return the policy number days of this policy options
	 */
	@Override
	public int getPolicyNumberDays() {
		return model.getPolicyNumberDays();
	}

	/**
	 * Returns the policy options ID of this policy options.
	 *
	 * @return the policy options ID of this policy options
	 */
	@Override
	public long getPolicyOptionsId() {
		return model.getPolicyOptionsId();
	}

	/**
	 * Returns the policy start date of this policy options.
	 *
	 * @return the policy start date of this policy options
	 */
	@Override
	public Date getPolicyStartDate() {
		return model.getPolicyStartDate();
	}

	/**
	 * Returns the primary key of this policy options.
	 *
	 * @return the primary key of this policy options
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product category of this policy options.
	 *
	 * @return the product category of this policy options
	 */
	@Override
	public String getProductCategory() {
		return model.getProductCategory();
	}

	/**
	 * Returns the product ext number of this policy options.
	 *
	 * @return the product ext number of this policy options
	 */
	@Override
	public String getProductExtNumber() {
		return model.getProductExtNumber();
	}

	/**
	 * Returns the proposal ID of this policy options.
	 *
	 * @return the proposal ID of this policy options
	 */
	@Override
	public long getProposalId() {
		return model.getProposalId();
	}

	/**
	 * Returns the terms date of this policy options.
	 *
	 * @return the terms date of this policy options
	 */
	@Override
	public Date getTermsDate() {
		return model.getTermsDate();
	}

	/**
	 * Returns the user ID of this policy options.
	 *
	 * @return the user ID of this policy options
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this policy options.
	 *
	 * @return the user name of this policy options
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this policy options.
	 *
	 * @return the user uuid of this policy options
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
	 * Sets the communication method of this policy options.
	 *
	 * @param communicationMethod the communication method of this policy options
	 */
	@Override
	public void setCommunicationMethod(String communicationMethod) {
		model.setCommunicationMethod(communicationMethod);
	}

	/**
	 * Sets the company ID of this policy options.
	 *
	 * @param companyId the company ID of this policy options
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contract end date of this policy options.
	 *
	 * @param contractEndDate the contract end date of this policy options
	 */
	@Override
	public void setContractEndDate(Date contractEndDate) {
		model.setContractEndDate(contractEndDate);
	}

	/**
	 * Sets the contract period of this policy options.
	 *
	 * @param contractPeriod the contract period of this policy options
	 */
	@Override
	public void setContractPeriod(String contractPeriod) {
		model.setContractPeriod(contractPeriod);
	}

	/**
	 * Sets the contract start date of this policy options.
	 *
	 * @param contractStartDate the contract start date of this policy options
	 */
	@Override
	public void setContractStartDate(Date contractStartDate) {
		model.setContractStartDate(contractStartDate);
	}

	/**
	 * Sets the create date of this policy options.
	 *
	 * @param createDate the create date of this policy options
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currency of this policy options.
	 *
	 * @param currency the currency of this policy options
	 */
	@Override
	public void setCurrency(String currency) {
		model.setCurrency(currency);
	}

	/**
	 * Sets the duration year of this policy options.
	 *
	 * @param durationYear the duration year of this policy options
	 */
	@Override
	public void setDurationYear(int durationYear) {
		model.setDurationYear(durationYear);
	}

	/**
	 * Sets the issue date of this policy options.
	 *
	 * @param issueDate the issue date of this policy options
	 */
	@Override
	public void setIssueDate(Date issueDate) {
		model.setIssueDate(issueDate);
	}

	/**
	 * Sets the modified date of this policy options.
	 *
	 * @param modifiedDate the modified date of this policy options
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the policy end date of this policy options.
	 *
	 * @param policyEndDate the policy end date of this policy options
	 */
	@Override
	public void setPolicyEndDate(Date policyEndDate) {
		model.setPolicyEndDate(policyEndDate);
	}

	/**
	 * Sets the policy number days of this policy options.
	 *
	 * @param policyNumberDays the policy number days of this policy options
	 */
	@Override
	public void setPolicyNumberDays(int policyNumberDays) {
		model.setPolicyNumberDays(policyNumberDays);
	}

	/**
	 * Sets the policy options ID of this policy options.
	 *
	 * @param policyOptionsId the policy options ID of this policy options
	 */
	@Override
	public void setPolicyOptionsId(long policyOptionsId) {
		model.setPolicyOptionsId(policyOptionsId);
	}

	/**
	 * Sets the policy start date of this policy options.
	 *
	 * @param policyStartDate the policy start date of this policy options
	 */
	@Override
	public void setPolicyStartDate(Date policyStartDate) {
		model.setPolicyStartDate(policyStartDate);
	}

	/**
	 * Sets the primary key of this policy options.
	 *
	 * @param primaryKey the primary key of this policy options
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product category of this policy options.
	 *
	 * @param productCategory the product category of this policy options
	 */
	@Override
	public void setProductCategory(String productCategory) {
		model.setProductCategory(productCategory);
	}

	/**
	 * Sets the product ext number of this policy options.
	 *
	 * @param productExtNumber the product ext number of this policy options
	 */
	@Override
	public void setProductExtNumber(String productExtNumber) {
		model.setProductExtNumber(productExtNumber);
	}

	/**
	 * Sets the proposal ID of this policy options.
	 *
	 * @param proposalId the proposal ID of this policy options
	 */
	@Override
	public void setProposalId(long proposalId) {
		model.setProposalId(proposalId);
	}

	/**
	 * Sets the terms date of this policy options.
	 *
	 * @param termsDate the terms date of this policy options
	 */
	@Override
	public void setTermsDate(Date termsDate) {
		model.setTermsDate(termsDate);
	}

	/**
	 * Sets the user ID of this policy options.
	 *
	 * @param userId the user ID of this policy options
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this policy options.
	 *
	 * @param userName the user name of this policy options
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this policy options.
	 *
	 * @param userUuid the user uuid of this policy options
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PolicyOptionsWrapper wrap(PolicyOptions policyOptions) {
		return new PolicyOptionsWrapper(policyOptions);
	}

}
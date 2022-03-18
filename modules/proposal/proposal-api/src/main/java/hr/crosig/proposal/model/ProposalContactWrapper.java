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
 * This class is a wrapper for {@link ProposalContact}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalContact
 * @generated
 */
public class ProposalContactWrapper
	extends BaseModelWrapper<ProposalContact>
	implements ModelWrapper<ProposalContact>, ProposalContact {

	public ProposalContactWrapper(ProposalContact proposalContact) {
		super(proposalContact);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("proposalContactId", getProposalContactId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("proposalId", getProposalId());
		attributes.put("contactExtNumber", getContactExtNumber());
		attributes.put("insuredRoles", getInsuredRoles());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long proposalContactId = (Long)attributes.get("proposalContactId");

		if (proposalContactId != null) {
			setProposalContactId(proposalContactId);
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

		String contactExtNumber = (String)attributes.get("contactExtNumber");

		if (contactExtNumber != null) {
			setContactExtNumber(contactExtNumber);
		}

		String insuredRoles = (String)attributes.get("insuredRoles");

		if (insuredRoles != null) {
			setInsuredRoles(insuredRoles);
		}
	}

	/**
	 * Returns the company ID of this proposal contact.
	 *
	 * @return the company ID of this proposal contact
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact ext number of this proposal contact.
	 *
	 * @return the contact ext number of this proposal contact
	 */
	@Override
	public String getContactExtNumber() {
		return model.getContactExtNumber();
	}

	/**
	 * Returns the create date of this proposal contact.
	 *
	 * @return the create date of this proposal contact
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the insured roles of this proposal contact.
	 *
	 * @return the insured roles of this proposal contact
	 */
	@Override
	public String getInsuredRoles() {
		return model.getInsuredRoles();
	}

	/**
	 * Returns the modified date of this proposal contact.
	 *
	 * @return the modified date of this proposal contact
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this proposal contact.
	 *
	 * @return the primary key of this proposal contact
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the proposal contact ID of this proposal contact.
	 *
	 * @return the proposal contact ID of this proposal contact
	 */
	@Override
	public long getProposalContactId() {
		return model.getProposalContactId();
	}

	/**
	 * Returns the proposal ID of this proposal contact.
	 *
	 * @return the proposal ID of this proposal contact
	 */
	@Override
	public long getProposalId() {
		return model.getProposalId();
	}

	/**
	 * Returns the user ID of this proposal contact.
	 *
	 * @return the user ID of this proposal contact
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this proposal contact.
	 *
	 * @return the user name of this proposal contact
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this proposal contact.
	 *
	 * @return the user uuid of this proposal contact
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
	 * Sets the company ID of this proposal contact.
	 *
	 * @param companyId the company ID of this proposal contact
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact ext number of this proposal contact.
	 *
	 * @param contactExtNumber the contact ext number of this proposal contact
	 */
	@Override
	public void setContactExtNumber(String contactExtNumber) {
		model.setContactExtNumber(contactExtNumber);
	}

	/**
	 * Sets the create date of this proposal contact.
	 *
	 * @param createDate the create date of this proposal contact
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the insured roles of this proposal contact.
	 *
	 * @param insuredRoles the insured roles of this proposal contact
	 */
	@Override
	public void setInsuredRoles(String insuredRoles) {
		model.setInsuredRoles(insuredRoles);
	}

	/**
	 * Sets the modified date of this proposal contact.
	 *
	 * @param modifiedDate the modified date of this proposal contact
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this proposal contact.
	 *
	 * @param primaryKey the primary key of this proposal contact
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the proposal contact ID of this proposal contact.
	 *
	 * @param proposalContactId the proposal contact ID of this proposal contact
	 */
	@Override
	public void setProposalContactId(long proposalContactId) {
		model.setProposalContactId(proposalContactId);
	}

	/**
	 * Sets the proposal ID of this proposal contact.
	 *
	 * @param proposalId the proposal ID of this proposal contact
	 */
	@Override
	public void setProposalId(long proposalId) {
		model.setProposalId(proposalId);
	}

	/**
	 * Sets the user ID of this proposal contact.
	 *
	 * @param userId the user ID of this proposal contact
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this proposal contact.
	 *
	 * @param userName the user name of this proposal contact
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this proposal contact.
	 *
	 * @param userUuid the user uuid of this proposal contact
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ProposalContactWrapper wrap(ProposalContact proposalContact) {
		return new ProposalContactWrapper(proposalContact);
	}

}
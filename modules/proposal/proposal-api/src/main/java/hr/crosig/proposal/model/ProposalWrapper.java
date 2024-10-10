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
 * This class is a wrapper for {@link Proposal}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Proposal
 * @generated
 */
public class ProposalWrapper
	extends BaseModelWrapper<Proposal>
	implements ModelWrapper<Proposal>, Proposal {

	public ProposalWrapper(Proposal proposal) {
		super(proposal);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("proposalId", getProposalId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalProposalNumber", getExternalProposalNumber());
		attributes.put("lastUpdate", getLastUpdate());
		attributes.put("origin", getOrigin());
		attributes.put("agentUserId", getAgentUserId());
		attributes.put("policyHolderExtNumber", getPolicyHolderExtNumber());
		attributes.put("insuredObjectExtNumber", getInsuredObjectExtNumber());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long proposalId = (Long)attributes.get("proposalId");

		if (proposalId != null) {
			setProposalId(proposalId);
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

		String externalProposalNumber = (String)attributes.get(
			"externalProposalNumber");

		if (externalProposalNumber != null) {
			setExternalProposalNumber(externalProposalNumber);
		}

		Date lastUpdate = (Date)attributes.get("lastUpdate");

		if (lastUpdate != null) {
			setLastUpdate(lastUpdate);
		}

		String origin = (String)attributes.get("origin");

		if (origin != null) {
			setOrigin(origin);
		}

		Long agentUserId = (Long)attributes.get("agentUserId");

		if (agentUserId != null) {
			setAgentUserId(agentUserId);
		}

		String policyHolderExtNumber = (String)attributes.get(
			"policyHolderExtNumber");

		if (policyHolderExtNumber != null) {
			setPolicyHolderExtNumber(policyHolderExtNumber);
		}

		String insuredObjectExtNumber = (String)attributes.get(
			"insuredObjectExtNumber");

		if (insuredObjectExtNumber != null) {
			setInsuredObjectExtNumber(insuredObjectExtNumber);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Proposal cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the agent user ID of this proposal.
	 *
	 * @return the agent user ID of this proposal
	 */
	@Override
	public long getAgentUserId() {
		return model.getAgentUserId();
	}

	/**
	 * Returns the agent user uuid of this proposal.
	 *
	 * @return the agent user uuid of this proposal
	 */
	@Override
	public String getAgentUserUuid() {
		return model.getAgentUserUuid();
	}

	/**
	 * Returns the company ID of this proposal.
	 *
	 * @return the company ID of this proposal
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this proposal.
	 *
	 * @return the create date of this proposal
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external proposal number of this proposal.
	 *
	 * @return the external proposal number of this proposal
	 */
	@Override
	public String getExternalProposalNumber() {
		return model.getExternalProposalNumber();
	}

	/**
	 * Returns the insured object ext number of this proposal.
	 *
	 * @return the insured object ext number of this proposal
	 */
	@Override
	public String getInsuredObjectExtNumber() {
		return model.getInsuredObjectExtNumber();
	}

	/**
	 * Returns the last update of this proposal.
	 *
	 * @return the last update of this proposal
	 */
	@Override
	public Date getLastUpdate() {
		return model.getLastUpdate();
	}

	/**
	 * Returns the modified date of this proposal.
	 *
	 * @return the modified date of this proposal
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the origin of this proposal.
	 *
	 * @return the origin of this proposal
	 */
	@Override
	public String getOrigin() {
		return model.getOrigin();
	}

	/**
	 * Returns the policy holder ext number of this proposal.
	 *
	 * @return the policy holder ext number of this proposal
	 */
	@Override
	public String getPolicyHolderExtNumber() {
		return model.getPolicyHolderExtNumber();
	}

	/**
	 * Returns the primary key of this proposal.
	 *
	 * @return the primary key of this proposal
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the proposal ID of this proposal.
	 *
	 * @return the proposal ID of this proposal
	 */
	@Override
	public long getProposalId() {
		return model.getProposalId();
	}

	/**
	 * Returns the status of this proposal.
	 *
	 * @return the status of this proposal
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this proposal.
	 *
	 * @return the user ID of this proposal
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this proposal.
	 *
	 * @return the user name of this proposal
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this proposal.
	 *
	 * @return the user uuid of this proposal
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
	 * Sets the agent user ID of this proposal.
	 *
	 * @param agentUserId the agent user ID of this proposal
	 */
	@Override
	public void setAgentUserId(long agentUserId) {
		model.setAgentUserId(agentUserId);
	}

	/**
	 * Sets the agent user uuid of this proposal.
	 *
	 * @param agentUserUuid the agent user uuid of this proposal
	 */
	@Override
	public void setAgentUserUuid(String agentUserUuid) {
		model.setAgentUserUuid(agentUserUuid);
	}

	/**
	 * Sets the company ID of this proposal.
	 *
	 * @param companyId the company ID of this proposal
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this proposal.
	 *
	 * @param createDate the create date of this proposal
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external proposal number of this proposal.
	 *
	 * @param externalProposalNumber the external proposal number of this proposal
	 */
	@Override
	public void setExternalProposalNumber(String externalProposalNumber) {
		model.setExternalProposalNumber(externalProposalNumber);
	}

	/**
	 * Sets the insured object ext number of this proposal.
	 *
	 * @param insuredObjectExtNumber the insured object ext number of this proposal
	 */
	@Override
	public void setInsuredObjectExtNumber(String insuredObjectExtNumber) {
		model.setInsuredObjectExtNumber(insuredObjectExtNumber);
	}

	/**
	 * Sets the last update of this proposal.
	 *
	 * @param lastUpdate the last update of this proposal
	 */
	@Override
	public void setLastUpdate(Date lastUpdate) {
		model.setLastUpdate(lastUpdate);
	}

	/**
	 * Sets the modified date of this proposal.
	 *
	 * @param modifiedDate the modified date of this proposal
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the origin of this proposal.
	 *
	 * @param origin the origin of this proposal
	 */
	@Override
	public void setOrigin(String origin) {
		model.setOrigin(origin);
	}

	/**
	 * Sets the policy holder ext number of this proposal.
	 *
	 * @param policyHolderExtNumber the policy holder ext number of this proposal
	 */
	@Override
	public void setPolicyHolderExtNumber(String policyHolderExtNumber) {
		model.setPolicyHolderExtNumber(policyHolderExtNumber);
	}

	/**
	 * Sets the primary key of this proposal.
	 *
	 * @param primaryKey the primary key of this proposal
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the proposal ID of this proposal.
	 *
	 * @param proposalId the proposal ID of this proposal
	 */
	@Override
	public void setProposalId(long proposalId) {
		model.setProposalId(proposalId);
	}

	/**
	 * Sets the status of this proposal.
	 *
	 * @param status the status of this proposal
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this proposal.
	 *
	 * @param userId the user ID of this proposal
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this proposal.
	 *
	 * @param userName the user name of this proposal
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this proposal.
	 *
	 * @param userUuid the user uuid of this proposal
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
	protected ProposalWrapper wrap(Proposal proposal) {
		return new ProposalWrapper(proposal);
	}

}
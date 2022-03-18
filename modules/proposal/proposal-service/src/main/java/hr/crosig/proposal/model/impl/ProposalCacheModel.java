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

package hr.crosig.proposal.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import hr.crosig.proposal.model.Proposal;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Proposal in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProposalCacheModel
	implements CacheModel<Proposal>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProposalCacheModel)) {
			return false;
		}

		ProposalCacheModel proposalCacheModel = (ProposalCacheModel)object;

		if (proposalId == proposalCacheModel.proposalId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, proposalId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{proposalId=");
		sb.append(proposalId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", externalProposalNumber=");
		sb.append(externalProposalNumber);
		sb.append(", lastUpdate=");
		sb.append(lastUpdate);
		sb.append(", origin=");
		sb.append(origin);
		sb.append(", agentUserId=");
		sb.append(agentUserId);
		sb.append(", policyHolderExtNumber=");
		sb.append(policyHolderExtNumber);
		sb.append(", insuredObjectExtNumber=");
		sb.append(insuredObjectExtNumber);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Proposal toEntityModel() {
		ProposalImpl proposalImpl = new ProposalImpl();

		proposalImpl.setProposalId(proposalId);
		proposalImpl.setCompanyId(companyId);
		proposalImpl.setUserId(userId);

		if (userName == null) {
			proposalImpl.setUserName("");
		}
		else {
			proposalImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			proposalImpl.setCreateDate(null);
		}
		else {
			proposalImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			proposalImpl.setModifiedDate(null);
		}
		else {
			proposalImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (externalProposalNumber == null) {
			proposalImpl.setExternalProposalNumber("");
		}
		else {
			proposalImpl.setExternalProposalNumber(externalProposalNumber);
		}

		if (lastUpdate == Long.MIN_VALUE) {
			proposalImpl.setLastUpdate(null);
		}
		else {
			proposalImpl.setLastUpdate(new Date(lastUpdate));
		}

		if (origin == null) {
			proposalImpl.setOrigin("");
		}
		else {
			proposalImpl.setOrigin(origin);
		}

		proposalImpl.setAgentUserId(agentUserId);

		if (policyHolderExtNumber == null) {
			proposalImpl.setPolicyHolderExtNumber("");
		}
		else {
			proposalImpl.setPolicyHolderExtNumber(policyHolderExtNumber);
		}

		if (insuredObjectExtNumber == null) {
			proposalImpl.setInsuredObjectExtNumber("");
		}
		else {
			proposalImpl.setInsuredObjectExtNumber(insuredObjectExtNumber);
		}

		if (status == null) {
			proposalImpl.setStatus("");
		}
		else {
			proposalImpl.setStatus(status);
		}

		proposalImpl.resetOriginalValues();

		return proposalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		proposalId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		externalProposalNumber = objectInput.readUTF();
		lastUpdate = objectInput.readLong();
		origin = objectInput.readUTF();

		agentUserId = objectInput.readLong();
		policyHolderExtNumber = objectInput.readUTF();
		insuredObjectExtNumber = objectInput.readUTF();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(proposalId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (externalProposalNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalProposalNumber);
		}

		objectOutput.writeLong(lastUpdate);

		if (origin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(origin);
		}

		objectOutput.writeLong(agentUserId);

		if (policyHolderExtNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyHolderExtNumber);
		}

		if (insuredObjectExtNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredObjectExtNumber);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long proposalId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String externalProposalNumber;
	public long lastUpdate;
	public String origin;
	public long agentUserId;
	public String policyHolderExtNumber;
	public String insuredObjectExtNumber;
	public String status;

}
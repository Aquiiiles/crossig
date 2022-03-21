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

import hr.crosig.proposal.model.PolicyCoverageOpt;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PolicyCoverageOpt in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PolicyCoverageOptCacheModel
	implements CacheModel<PolicyCoverageOpt>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolicyCoverageOptCacheModel)) {
			return false;
		}

		PolicyCoverageOptCacheModel policyCoverageOptCacheModel =
			(PolicyCoverageOptCacheModel)object;

		if (policyCoverageOptionId ==
				policyCoverageOptCacheModel.policyCoverageOptionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, policyCoverageOptionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{policyCoverageOptionId=");
		sb.append(policyCoverageOptionId);
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
		sb.append(", proposalId=");
		sb.append(proposalId);
		sb.append(", coverageOptionsName=");
		sb.append(coverageOptionsName);
		sb.append(", coverageOptionsValue=");
		sb.append(coverageOptionsValue);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PolicyCoverageOpt toEntityModel() {
		PolicyCoverageOptImpl policyCoverageOptImpl =
			new PolicyCoverageOptImpl();

		policyCoverageOptImpl.setPolicyCoverageOptionId(policyCoverageOptionId);
		policyCoverageOptImpl.setCompanyId(companyId);
		policyCoverageOptImpl.setUserId(userId);

		if (userName == null) {
			policyCoverageOptImpl.setUserName("");
		}
		else {
			policyCoverageOptImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			policyCoverageOptImpl.setCreateDate(null);
		}
		else {
			policyCoverageOptImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			policyCoverageOptImpl.setModifiedDate(null);
		}
		else {
			policyCoverageOptImpl.setModifiedDate(new Date(modifiedDate));
		}

		policyCoverageOptImpl.setProposalId(proposalId);

		if (coverageOptionsName == null) {
			policyCoverageOptImpl.setCoverageOptionsName("");
		}
		else {
			policyCoverageOptImpl.setCoverageOptionsName(coverageOptionsName);
		}

		if (coverageOptionsValue == null) {
			policyCoverageOptImpl.setCoverageOptionsValue("");
		}
		else {
			policyCoverageOptImpl.setCoverageOptionsValue(coverageOptionsValue);
		}

		if (type == null) {
			policyCoverageOptImpl.setType("");
		}
		else {
			policyCoverageOptImpl.setType(type);
		}

		policyCoverageOptImpl.resetOriginalValues();

		return policyCoverageOptImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		policyCoverageOptionId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		proposalId = objectInput.readLong();
		coverageOptionsName = objectInput.readUTF();
		coverageOptionsValue = objectInput.readUTF();
		type = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(policyCoverageOptionId);

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

		objectOutput.writeLong(proposalId);

		if (coverageOptionsName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverageOptionsName);
		}

		if (coverageOptionsValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coverageOptionsValue);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}
	}

	public long policyCoverageOptionId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long proposalId;
	public String coverageOptionsName;
	public String coverageOptionsValue;
	public String type;

}
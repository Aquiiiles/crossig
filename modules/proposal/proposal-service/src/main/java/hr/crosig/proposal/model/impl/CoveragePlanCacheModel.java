/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import hr.crosig.proposal.model.CoveragePlan;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CoveragePlan in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CoveragePlanCacheModel
	implements CacheModel<CoveragePlan>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CoveragePlanCacheModel)) {
			return false;
		}

		CoveragePlanCacheModel coveragePlanCacheModel =
			(CoveragePlanCacheModel)object;

		if (coveragePlanId == coveragePlanCacheModel.coveragePlanId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, coveragePlanId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{coveragePlanId=");
		sb.append(coveragePlanId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", category=");
		sb.append(category);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CoveragePlan toEntityModel() {
		CoveragePlanImpl coveragePlanImpl = new CoveragePlanImpl();

		coveragePlanImpl.setCoveragePlanId(coveragePlanId);
		coveragePlanImpl.setCompanyId(companyId);
		coveragePlanImpl.setUserId(userId);

		if (userName == null) {
			coveragePlanImpl.setUserName("");
		}
		else {
			coveragePlanImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			coveragePlanImpl.setCreateDate(null);
		}
		else {
			coveragePlanImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			coveragePlanImpl.setModifiedDate(null);
		}
		else {
			coveragePlanImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			coveragePlanImpl.setName("");
		}
		else {
			coveragePlanImpl.setName(name);
		}

		if (description == null) {
			coveragePlanImpl.setDescription("");
		}
		else {
			coveragePlanImpl.setDescription(description);
		}

		if (category == null) {
			coveragePlanImpl.setCategory("");
		}
		else {
			coveragePlanImpl.setCategory(category);
		}

		coveragePlanImpl.resetOriginalValues();

		return coveragePlanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		coveragePlanId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		category = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(coveragePlanId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (category == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(category);
		}
	}

	public long coveragePlanId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public String category;

}
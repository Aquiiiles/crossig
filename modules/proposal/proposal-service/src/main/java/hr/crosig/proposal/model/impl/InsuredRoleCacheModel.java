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

import hr.crosig.proposal.model.InsuredRole;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing InsuredRole in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class InsuredRoleCacheModel
	implements CacheModel<InsuredRole>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof InsuredRoleCacheModel)) {
			return false;
		}

		InsuredRoleCacheModel insuredRoleCacheModel =
			(InsuredRoleCacheModel)object;

		if (InsuredRoleId == insuredRoleCacheModel.InsuredRoleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, InsuredRoleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{InsuredRoleId=");
		sb.append(InsuredRoleId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", name=");
		sb.append(name);
		sb.append(", externalId=");
		sb.append(externalId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InsuredRole toEntityModel() {
		InsuredRoleImpl insuredRoleImpl = new InsuredRoleImpl();

		insuredRoleImpl.setInsuredRoleId(InsuredRoleId);
		insuredRoleImpl.setCompanyId(companyId);
		insuredRoleImpl.setUserId(userId);

		if (userName == null) {
			insuredRoleImpl.setUserName("");
		}
		else {
			insuredRoleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			insuredRoleImpl.setCreateDate(null);
		}
		else {
			insuredRoleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			insuredRoleImpl.setModifiedDate(null);
		}
		else {
			insuredRoleImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			insuredRoleImpl.setTitle("");
		}
		else {
			insuredRoleImpl.setTitle(title);
		}

		if (name == null) {
			insuredRoleImpl.setName("");
		}
		else {
			insuredRoleImpl.setName(name);
		}

		if (externalId == null) {
			insuredRoleImpl.setExternalId("");
		}
		else {
			insuredRoleImpl.setExternalId(externalId);
		}

		insuredRoleImpl.resetOriginalValues();

		return insuredRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		InsuredRoleId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		name = objectInput.readUTF();
		externalId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(InsuredRoleId);

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

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (externalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalId);
		}
	}

	public long InsuredRoleId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String name;
	public String externalId;

}
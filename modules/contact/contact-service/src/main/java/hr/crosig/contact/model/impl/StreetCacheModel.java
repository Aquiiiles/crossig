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

package hr.crosig.contact.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import hr.crosig.contact.model.Street;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Street in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StreetCacheModel implements CacheModel<Street>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StreetCacheModel)) {
			return false;
		}

		StreetCacheModel streetCacheModel = (StreetCacheModel)object;

		if (streetId == streetCacheModel.streetId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, streetId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{streetId=");
		sb.append(streetId);
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
		sb.append(", cityId=");
		sb.append(cityId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Street toEntityModel() {
		StreetImpl streetImpl = new StreetImpl();

		streetImpl.setStreetId(streetId);
		streetImpl.setCompanyId(companyId);
		streetImpl.setUserId(userId);

		if (userName == null) {
			streetImpl.setUserName("");
		}
		else {
			streetImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			streetImpl.setCreateDate(null);
		}
		else {
			streetImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			streetImpl.setModifiedDate(null);
		}
		else {
			streetImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			streetImpl.setName("");
		}
		else {
			streetImpl.setName(name);
		}

		streetImpl.setCityId(cityId);

		streetImpl.resetOriginalValues();

		return streetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		streetId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		cityId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(streetId);

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

		objectOutput.writeLong(cityId);
	}

	public long streetId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long cityId;

}
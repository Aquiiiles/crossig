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

import hr.crosig.contact.model.City;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing City in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CityCacheModel implements CacheModel<City>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CityCacheModel)) {
			return false;
		}

		CityCacheModel cityCacheModel = (CityCacheModel)object;

		if (cityId == cityCacheModel.cityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{cityId=");
		sb.append(cityId);
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
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", boxNumber=");
		sb.append(boxNumber);
		sb.append(", postName=");
		sb.append(postName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public City toEntityModel() {
		CityImpl cityImpl = new CityImpl();

		cityImpl.setCityId(cityId);
		cityImpl.setCompanyId(companyId);
		cityImpl.setUserId(userId);

		if (userName == null) {
			cityImpl.setUserName("");
		}
		else {
			cityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cityImpl.setCreateDate(null);
		}
		else {
			cityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cityImpl.setModifiedDate(null);
		}
		else {
			cityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			cityImpl.setName("");
		}
		else {
			cityImpl.setName(name);
		}

		if (zipCode == null) {
			cityImpl.setZipCode("");
		}
		else {
			cityImpl.setZipCode(zipCode);
		}

		if (boxNumber == null) {
			cityImpl.setBoxNumber("");
		}
		else {
			cityImpl.setBoxNumber(boxNumber);
		}

		if (postName == null) {
			cityImpl.setPostName("");
		}
		else {
			cityImpl.setPostName(postName);
		}

		cityImpl.resetOriginalValues();

		return cityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cityId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		zipCode = objectInput.readUTF();
		boxNumber = objectInput.readUTF();
		postName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(cityId);

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

		if (zipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zipCode);
		}

		if (boxNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(boxNumber);
		}

		if (postName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postName);
		}
	}

	public long cityId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String zipCode;
	public String boxNumber;
	public String postName;

}
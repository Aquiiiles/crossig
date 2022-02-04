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

package hr.crosig.contact.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class StreetSoap implements Serializable {

	public static StreetSoap toSoapModel(Street model) {
		StreetSoap soapModel = new StreetSoap();

		soapModel.setStreetId(model.getStreetId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalId(model.getExternalId());
		soapModel.setName(model.getName());
		soapModel.setCityId(model.getCityId());

		return soapModel;
	}

	public static StreetSoap[] toSoapModels(Street[] models) {
		StreetSoap[] soapModels = new StreetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StreetSoap[][] toSoapModels(Street[][] models) {
		StreetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StreetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StreetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StreetSoap[] toSoapModels(List<Street> models) {
		List<StreetSoap> soapModels = new ArrayList<StreetSoap>(models.size());

		for (Street model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StreetSoap[soapModels.size()]);
	}

	public StreetSoap() {
	}

	public long getPrimaryKey() {
		return _streetId;
	}

	public void setPrimaryKey(long pk) {
		setStreetId(pk);
	}

	public long getStreetId() {
		return _streetId;
	}

	public void setStreetId(long streetId) {
		_streetId = streetId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getExternalId() {
		return _externalId;
	}

	public void setExternalId(long externalId) {
		_externalId = externalId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getCityId() {
		return _cityId;
	}

	public void setCityId(long cityId) {
		_cityId = cityId;
	}

	private long _streetId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _externalId;
	private String _name;
	private long _cityId;

}
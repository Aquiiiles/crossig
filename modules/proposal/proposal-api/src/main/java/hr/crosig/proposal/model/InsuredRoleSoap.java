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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class InsuredRoleSoap implements Serializable {

	public static InsuredRoleSoap toSoapModel(InsuredRole model) {
		InsuredRoleSoap soapModel = new InsuredRoleSoap();

		soapModel.setInsuredRoleId(model.getInsuredRoleId());
		soapModel.setTitle(model.getTitle());
		soapModel.setName(model.getName());
		soapModel.setExternalId(model.getExternalId());

		return soapModel;
	}

	public static InsuredRoleSoap[] toSoapModels(InsuredRole[] models) {
		InsuredRoleSoap[] soapModels = new InsuredRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InsuredRoleSoap[][] toSoapModels(InsuredRole[][] models) {
		InsuredRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InsuredRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InsuredRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InsuredRoleSoap[] toSoapModels(List<InsuredRole> models) {
		List<InsuredRoleSoap> soapModels = new ArrayList<InsuredRoleSoap>(
			models.size());

		for (InsuredRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InsuredRoleSoap[soapModels.size()]);
	}

	public InsuredRoleSoap() {
	}

	public long getPrimaryKey() {
		return _InsuredRoleId;
	}

	public void setPrimaryKey(long pk) {
		setInsuredRoleId(pk);
	}

	public long getInsuredRoleId() {
		return _InsuredRoleId;
	}

	public void setInsuredRoleId(long InsuredRoleId) {
		_InsuredRoleId = InsuredRoleId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getExternalId() {
		return _externalId;
	}

	public void setExternalId(String externalId) {
		_externalId = externalId;
	}

	private long _InsuredRoleId;
	private String _title;
	private String _name;
	private String _externalId;

}
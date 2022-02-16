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
public class ProductRoleSoap implements Serializable {

	public static ProductRoleSoap toSoapModel(ProductRole model) {
		ProductRoleSoap soapModel = new ProductRoleSoap();

		soapModel.setProductRoleId(model.getProductRoleId());
		soapModel.setProductId(model.getProductId());
		soapModel.setRoleId(model.getRoleId());

		return soapModel;
	}

	public static ProductRoleSoap[] toSoapModels(ProductRole[] models) {
		ProductRoleSoap[] soapModels = new ProductRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductRoleSoap[][] toSoapModels(ProductRole[][] models) {
		ProductRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductRoleSoap[] toSoapModels(List<ProductRole> models) {
		List<ProductRoleSoap> soapModels = new ArrayList<ProductRoleSoap>(
			models.size());

		for (ProductRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductRoleSoap[soapModels.size()]);
	}

	public ProductRoleSoap() {
	}

	public long getPrimaryKey() {
		return _productRoleId;
	}

	public void setPrimaryKey(long pk) {
		setProductRoleId(pk);
	}

	public long getProductRoleId() {
		return _productRoleId;
	}

	public void setProductRoleId(long productRoleId) {
		_productRoleId = productRoleId;
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	private long _productRoleId;
	private long _productId;
	private long _roleId;

}
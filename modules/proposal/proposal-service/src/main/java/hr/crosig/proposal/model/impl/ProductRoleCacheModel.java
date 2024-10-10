/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import hr.crosig.proposal.model.ProductRole;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductRole in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductRoleCacheModel
	implements CacheModel<ProductRole>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductRoleCacheModel)) {
			return false;
		}

		ProductRoleCacheModel productRoleCacheModel =
			(ProductRoleCacheModel)object;

		if (productRoleId == productRoleCacheModel.productRoleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productRoleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{productRoleId=");
		sb.append(productRoleId);
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
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductRole toEntityModel() {
		ProductRoleImpl productRoleImpl = new ProductRoleImpl();

		productRoleImpl.setProductRoleId(productRoleId);
		productRoleImpl.setCompanyId(companyId);
		productRoleImpl.setUserId(userId);

		if (userName == null) {
			productRoleImpl.setUserName("");
		}
		else {
			productRoleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			productRoleImpl.setCreateDate(null);
		}
		else {
			productRoleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productRoleImpl.setModifiedDate(null);
		}
		else {
			productRoleImpl.setModifiedDate(new Date(modifiedDate));
		}

		productRoleImpl.setProductId(productId);
		productRoleImpl.setRoleId(roleId);

		productRoleImpl.resetOriginalValues();

		return productRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		productRoleId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		productId = objectInput.readLong();

		roleId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(productRoleId);

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

		objectOutput.writeLong(productId);

		objectOutput.writeLong(roleId);
	}

	public long productRoleId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long productId;
	public long roleId;

}
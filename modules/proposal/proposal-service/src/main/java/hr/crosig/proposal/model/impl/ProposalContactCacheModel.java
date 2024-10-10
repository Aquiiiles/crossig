/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import hr.crosig.proposal.model.ProposalContact;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProposalContact in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProposalContactCacheModel
	implements CacheModel<ProposalContact>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProposalContactCacheModel)) {
			return false;
		}

		ProposalContactCacheModel proposalContactCacheModel =
			(ProposalContactCacheModel)object;

		if (proposalContactId == proposalContactCacheModel.proposalContactId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, proposalContactId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{proposalContactId=");
		sb.append(proposalContactId);
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
		sb.append(", contactExtNumber=");
		sb.append(contactExtNumber);
		sb.append(", insuredRoles=");
		sb.append(insuredRoles);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProposalContact toEntityModel() {
		ProposalContactImpl proposalContactImpl = new ProposalContactImpl();

		proposalContactImpl.setProposalContactId(proposalContactId);
		proposalContactImpl.setCompanyId(companyId);
		proposalContactImpl.setUserId(userId);

		if (userName == null) {
			proposalContactImpl.setUserName("");
		}
		else {
			proposalContactImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			proposalContactImpl.setCreateDate(null);
		}
		else {
			proposalContactImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			proposalContactImpl.setModifiedDate(null);
		}
		else {
			proposalContactImpl.setModifiedDate(new Date(modifiedDate));
		}

		proposalContactImpl.setProposalId(proposalId);

		if (contactExtNumber == null) {
			proposalContactImpl.setContactExtNumber("");
		}
		else {
			proposalContactImpl.setContactExtNumber(contactExtNumber);
		}

		if (insuredRoles == null) {
			proposalContactImpl.setInsuredRoles("");
		}
		else {
			proposalContactImpl.setInsuredRoles(insuredRoles);
		}

		proposalContactImpl.resetOriginalValues();

		return proposalContactImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		proposalContactId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		proposalId = objectInput.readLong();
		contactExtNumber = objectInput.readUTF();
		insuredRoles = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(proposalContactId);

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

		if (contactExtNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactExtNumber);
		}

		if (insuredRoles == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuredRoles);
		}
	}

	public long proposalContactId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long proposalId;
	public String contactExtNumber;
	public String insuredRoles;

}
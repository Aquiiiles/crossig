/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import hr.crosig.proposal.model.PolicyOptions;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PolicyOptions in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PolicyOptionsCacheModel
	implements CacheModel<PolicyOptions>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolicyOptionsCacheModel)) {
			return false;
		}

		PolicyOptionsCacheModel policyOptionsCacheModel =
			(PolicyOptionsCacheModel)object;

		if (policyOptionsId == policyOptionsCacheModel.policyOptionsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, policyOptionsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{policyOptionsId=");
		sb.append(policyOptionsId);
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
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", termsDate=");
		sb.append(termsDate);
		sb.append(", productCategory=");
		sb.append(productCategory);
		sb.append(", productExtNumber=");
		sb.append(productExtNumber);
		sb.append(", issueDate=");
		sb.append(issueDate);
		sb.append(", contractStartDate=");
		sb.append(contractStartDate);
		sb.append(", contractEndDate=");
		sb.append(contractEndDate);
		sb.append(", contractPeriod=");
		sb.append(contractPeriod);
		sb.append(", durationYear=");
		sb.append(durationYear);
		sb.append(", policyStartDate=");
		sb.append(policyStartDate);
		sb.append(", policyEndDate=");
		sb.append(policyEndDate);
		sb.append(", policyNumberDays=");
		sb.append(policyNumberDays);
		sb.append(", communicationMethod=");
		sb.append(communicationMethod);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PolicyOptions toEntityModel() {
		PolicyOptionsImpl policyOptionsImpl = new PolicyOptionsImpl();

		policyOptionsImpl.setPolicyOptionsId(policyOptionsId);
		policyOptionsImpl.setCompanyId(companyId);
		policyOptionsImpl.setUserId(userId);

		if (userName == null) {
			policyOptionsImpl.setUserName("");
		}
		else {
			policyOptionsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			policyOptionsImpl.setCreateDate(null);
		}
		else {
			policyOptionsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			policyOptionsImpl.setModifiedDate(null);
		}
		else {
			policyOptionsImpl.setModifiedDate(new Date(modifiedDate));
		}

		policyOptionsImpl.setProposalId(proposalId);

		if (currency == null) {
			policyOptionsImpl.setCurrency("");
		}
		else {
			policyOptionsImpl.setCurrency(currency);
		}

		if (termsDate == Long.MIN_VALUE) {
			policyOptionsImpl.setTermsDate(null);
		}
		else {
			policyOptionsImpl.setTermsDate(new Date(termsDate));
		}

		if (productCategory == null) {
			policyOptionsImpl.setProductCategory("");
		}
		else {
			policyOptionsImpl.setProductCategory(productCategory);
		}

		if (productExtNumber == null) {
			policyOptionsImpl.setProductExtNumber("");
		}
		else {
			policyOptionsImpl.setProductExtNumber(productExtNumber);
		}

		if (issueDate == Long.MIN_VALUE) {
			policyOptionsImpl.setIssueDate(null);
		}
		else {
			policyOptionsImpl.setIssueDate(new Date(issueDate));
		}

		if (contractStartDate == Long.MIN_VALUE) {
			policyOptionsImpl.setContractStartDate(null);
		}
		else {
			policyOptionsImpl.setContractStartDate(new Date(contractStartDate));
		}

		if (contractEndDate == Long.MIN_VALUE) {
			policyOptionsImpl.setContractEndDate(null);
		}
		else {
			policyOptionsImpl.setContractEndDate(new Date(contractEndDate));
		}

		if (contractPeriod == null) {
			policyOptionsImpl.setContractPeriod("");
		}
		else {
			policyOptionsImpl.setContractPeriod(contractPeriod);
		}

		policyOptionsImpl.setDurationYear(durationYear);

		if (policyStartDate == Long.MIN_VALUE) {
			policyOptionsImpl.setPolicyStartDate(null);
		}
		else {
			policyOptionsImpl.setPolicyStartDate(new Date(policyStartDate));
		}

		if (policyEndDate == Long.MIN_VALUE) {
			policyOptionsImpl.setPolicyEndDate(null);
		}
		else {
			policyOptionsImpl.setPolicyEndDate(new Date(policyEndDate));
		}

		policyOptionsImpl.setPolicyNumberDays(policyNumberDays);

		if (communicationMethod == null) {
			policyOptionsImpl.setCommunicationMethod("");
		}
		else {
			policyOptionsImpl.setCommunicationMethod(communicationMethod);
		}

		policyOptionsImpl.resetOriginalValues();

		return policyOptionsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		policyOptionsId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		proposalId = objectInput.readLong();
		currency = objectInput.readUTF();
		termsDate = objectInput.readLong();
		productCategory = objectInput.readUTF();
		productExtNumber = objectInput.readUTF();
		issueDate = objectInput.readLong();
		contractStartDate = objectInput.readLong();
		contractEndDate = objectInput.readLong();
		contractPeriod = objectInput.readUTF();

		durationYear = objectInput.readInt();
		policyStartDate = objectInput.readLong();
		policyEndDate = objectInput.readLong();

		policyNumberDays = objectInput.readInt();
		communicationMethod = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(policyOptionsId);

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

		if (currency == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeLong(termsDate);

		if (productCategory == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productCategory);
		}

		if (productExtNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productExtNumber);
		}

		objectOutput.writeLong(issueDate);
		objectOutput.writeLong(contractStartDate);
		objectOutput.writeLong(contractEndDate);

		if (contractPeriod == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contractPeriod);
		}

		objectOutput.writeInt(durationYear);
		objectOutput.writeLong(policyStartDate);
		objectOutput.writeLong(policyEndDate);

		objectOutput.writeInt(policyNumberDays);

		if (communicationMethod == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(communicationMethod);
		}
	}

	public long policyOptionsId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long proposalId;
	public String currency;
	public long termsDate;
	public String productCategory;
	public String productExtNumber;
	public long issueDate;
	public long contractStartDate;
	public long contractEndDate;
	public String contractPeriod;
	public int durationYear;
	public long policyStartDate;
	public long policyEndDate;
	public int policyNumberDays;
	public String communicationMethod;

}
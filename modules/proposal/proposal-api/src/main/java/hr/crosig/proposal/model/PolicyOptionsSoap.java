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
public class PolicyOptionsSoap implements Serializable {

	public static PolicyOptionsSoap toSoapModel(PolicyOptions model) {
		PolicyOptionsSoap soapModel = new PolicyOptionsSoap();

		soapModel.setPolicyOptionsId(model.getPolicyOptionsId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProposalId(model.getProposalId());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setTermsDate(model.getTermsDate());
		soapModel.setProductCategory(model.getProductCategory());
		soapModel.setProductExtNumber(model.getProductExtNumber());
		soapModel.setIssueDate(model.getIssueDate());
		soapModel.setContractStartDate(model.getContractStartDate());
		soapModel.setContractEndDate(model.getContractEndDate());
		soapModel.setContractPeriod(model.getContractPeriod());
		soapModel.setDurationYear(model.getDurationYear());
		soapModel.setPolicyStartDate(model.getPolicyStartDate());
		soapModel.setPolicyEndDate(model.getPolicyEndDate());
		soapModel.setPolicyNumberDays(model.getPolicyNumberDays());
		soapModel.setCommunicationMethod(model.getCommunicationMethod());

		return soapModel;
	}

	public static PolicyOptionsSoap[] toSoapModels(PolicyOptions[] models) {
		PolicyOptionsSoap[] soapModels = new PolicyOptionsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PolicyOptionsSoap[][] toSoapModels(PolicyOptions[][] models) {
		PolicyOptionsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PolicyOptionsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PolicyOptionsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PolicyOptionsSoap[] toSoapModels(List<PolicyOptions> models) {
		List<PolicyOptionsSoap> soapModels = new ArrayList<PolicyOptionsSoap>(
			models.size());

		for (PolicyOptions model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PolicyOptionsSoap[soapModels.size()]);
	}

	public PolicyOptionsSoap() {
	}

	public long getPrimaryKey() {
		return _policyOptionsId;
	}

	public void setPrimaryKey(long pk) {
		setPolicyOptionsId(pk);
	}

	public long getPolicyOptionsId() {
		return _policyOptionsId;
	}

	public void setPolicyOptionsId(long policyOptionsId) {
		_policyOptionsId = policyOptionsId;
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

	public long getProposalId() {
		return _proposalId;
	}

	public void setProposalId(long proposalId) {
		_proposalId = proposalId;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public Date getTermsDate() {
		return _termsDate;
	}

	public void setTermsDate(Date termsDate) {
		_termsDate = termsDate;
	}

	public String getProductCategory() {
		return _productCategory;
	}

	public void setProductCategory(String productCategory) {
		_productCategory = productCategory;
	}

	public String getProductExtNumber() {
		return _productExtNumber;
	}

	public void setProductExtNumber(String productExtNumber) {
		_productExtNumber = productExtNumber;
	}

	public Date getIssueDate() {
		return _issueDate;
	}

	public void setIssueDate(Date issueDate) {
		_issueDate = issueDate;
	}

	public Date getContractStartDate() {
		return _contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		_contractStartDate = contractStartDate;
	}

	public Date getContractEndDate() {
		return _contractEndDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		_contractEndDate = contractEndDate;
	}

	public String getContractPeriod() {
		return _contractPeriod;
	}

	public void setContractPeriod(String contractPeriod) {
		_contractPeriod = contractPeriod;
	}

	public int getDurationYear() {
		return _durationYear;
	}

	public void setDurationYear(int durationYear) {
		_durationYear = durationYear;
	}

	public Date getPolicyStartDate() {
		return _policyStartDate;
	}

	public void setPolicyStartDate(Date policyStartDate) {
		_policyStartDate = policyStartDate;
	}

	public Date getPolicyEndDate() {
		return _policyEndDate;
	}

	public void setPolicyEndDate(Date policyEndDate) {
		_policyEndDate = policyEndDate;
	}

	public int getPolicyNumberDays() {
		return _policyNumberDays;
	}

	public void setPolicyNumberDays(int policyNumberDays) {
		_policyNumberDays = policyNumberDays;
	}

	public String getCommunicationMethod() {
		return _communicationMethod;
	}

	public void setCommunicationMethod(String communicationMethod) {
		_communicationMethod = communicationMethod;
	}

	private long _policyOptionsId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _proposalId;
	private String _currency;
	private Date _termsDate;
	private String _productCategory;
	private String _productExtNumber;
	private Date _issueDate;
	private Date _contractStartDate;
	private Date _contractEndDate;
	private String _contractPeriod;
	private int _durationYear;
	private Date _policyStartDate;
	private Date _policyEndDate;
	private int _policyNumberDays;
	private String _communicationMethod;

}
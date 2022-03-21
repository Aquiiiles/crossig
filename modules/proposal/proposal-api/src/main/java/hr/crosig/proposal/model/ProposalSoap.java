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
public class ProposalSoap implements Serializable {

	public static ProposalSoap toSoapModel(Proposal model) {
		ProposalSoap soapModel = new ProposalSoap();

		soapModel.setProposalId(model.getProposalId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setExternalProposalNumber(model.getExternalProposalNumber());
		soapModel.setLastUpdate(model.getLastUpdate());
		soapModel.setOrigin(model.getOrigin());
		soapModel.setAgentUserId(model.getAgentUserId());
		soapModel.setPolicyHolderExtNumber(model.getPolicyHolderExtNumber());
		soapModel.setInsuredObjectExtNumber(model.getInsuredObjectExtNumber());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ProposalSoap[] toSoapModels(Proposal[] models) {
		ProposalSoap[] soapModels = new ProposalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProposalSoap[][] toSoapModels(Proposal[][] models) {
		ProposalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProposalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProposalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProposalSoap[] toSoapModels(List<Proposal> models) {
		List<ProposalSoap> soapModels = new ArrayList<ProposalSoap>(
			models.size());

		for (Proposal model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProposalSoap[soapModels.size()]);
	}

	public ProposalSoap() {
	}

	public long getPrimaryKey() {
		return _proposalId;
	}

	public void setPrimaryKey(long pk) {
		setProposalId(pk);
	}

	public long getProposalId() {
		return _proposalId;
	}

	public void setProposalId(long proposalId) {
		_proposalId = proposalId;
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

	public String getExternalProposalNumber() {
		return _externalProposalNumber;
	}

	public void setExternalProposalNumber(String externalProposalNumber) {
		_externalProposalNumber = externalProposalNumber;
	}

	public Date getLastUpdate() {
		return _lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		_lastUpdate = lastUpdate;
	}

	public String getOrigin() {
		return _origin;
	}

	public void setOrigin(String origin) {
		_origin = origin;
	}

	public long getAgentUserId() {
		return _agentUserId;
	}

	public void setAgentUserId(long agentUserId) {
		_agentUserId = agentUserId;
	}

	public String getPolicyHolderExtNumber() {
		return _policyHolderExtNumber;
	}

	public void setPolicyHolderExtNumber(String policyHolderExtNumber) {
		_policyHolderExtNumber = policyHolderExtNumber;
	}

	public String getInsuredObjectExtNumber() {
		return _insuredObjectExtNumber;
	}

	public void setInsuredObjectExtNumber(String insuredObjectExtNumber) {
		_insuredObjectExtNumber = insuredObjectExtNumber;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private long _proposalId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _externalProposalNumber;
	private Date _lastUpdate;
	private String _origin;
	private long _agentUserId;
	private String _policyHolderExtNumber;
	private String _insuredObjectExtNumber;
	private String _status;

}
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
public class ProposalContactSoap implements Serializable {

	public static ProposalContactSoap toSoapModel(ProposalContact model) {
		ProposalContactSoap soapModel = new ProposalContactSoap();

		soapModel.setProposalContactId(model.getProposalContactId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProposalId(model.getProposalId());
		soapModel.setContactExtNumber(model.getContactExtNumber());
		soapModel.setInsuredRoles(model.getInsuredRoles());

		return soapModel;
	}

	public static ProposalContactSoap[] toSoapModels(ProposalContact[] models) {
		ProposalContactSoap[] soapModels =
			new ProposalContactSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProposalContactSoap[][] toSoapModels(
		ProposalContact[][] models) {

		ProposalContactSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ProposalContactSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProposalContactSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProposalContactSoap[] toSoapModels(
		List<ProposalContact> models) {

		List<ProposalContactSoap> soapModels =
			new ArrayList<ProposalContactSoap>(models.size());

		for (ProposalContact model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProposalContactSoap[soapModels.size()]);
	}

	public ProposalContactSoap() {
	}

	public long getPrimaryKey() {
		return _proposalContactId;
	}

	public void setPrimaryKey(long pk) {
		setProposalContactId(pk);
	}

	public long getProposalContactId() {
		return _proposalContactId;
	}

	public void setProposalContactId(long proposalContactId) {
		_proposalContactId = proposalContactId;
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

	public String getContactExtNumber() {
		return _contactExtNumber;
	}

	public void setContactExtNumber(String contactExtNumber) {
		_contactExtNumber = contactExtNumber;
	}

	public String getInsuredRoles() {
		return _insuredRoles;
	}

	public void setInsuredRoles(String insuredRoles) {
		_insuredRoles = insuredRoles;
	}

	private long _proposalContactId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _proposalId;
	private String _contactExtNumber;
	private String _insuredRoles;

}
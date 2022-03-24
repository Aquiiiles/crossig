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

package hr.crosig.proposal.service.impl;

import com.liferay.portal.aop.AopService;

import hr.crosig.proposal.dto.ProposalContactDTO;
import hr.crosig.proposal.model.Proposal;
import hr.crosig.proposal.model.ProposalContact;
import hr.crosig.proposal.service.base.ProposalContactLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=hr.crosig.proposal.model.ProposalContact",
	service = AopService.class
)
public class ProposalContactLocalServiceImpl
	extends ProposalContactLocalServiceBaseImpl {

	public ProposalContactDTO createProposalContact(
		ProposalContactDTO proposalContactDTO, Proposal proposal) {

		long proposalContactId = counterLocalService.increment(
			ProposalContact.class.getName());

		ProposalContact proposalContact = proposalContactPersistence.create(
			proposalContactId);

		proposalContact.setCreateDate(new Date());
		proposalContact.setUserId(proposal.getUserId());
		proposalContact.setUserName(proposal.getUserName());
		proposalContact.setCompanyId(proposal.getCompanyId());
		proposalContact.setProposalId(proposal.getProposalId());

		proposalContact = _updateProposalContact(
			proposalContactDTO, proposalContact);

		return _mapToDTO(proposalContact);
	}

	public void deleteAllByProposalId(long proposalId) {
		proposalContactPersistence.removeByProposalId(proposalId);
	}

	public List<ProposalContactDTO> getProposalContacts(long proposalId) {
		return proposalContactPersistence.findByProposalId(
			proposalId
		).stream(
		).map(
			this::_mapToDTO
		).collect(
			Collectors.toList()
		);
	}

	private ProposalContactDTO _mapToDTO(ProposalContact proposalContact) {
		ProposalContactDTO proposalContactDTO = new ProposalContactDTO();

		proposalContactDTO.setContactExtNumber(
			proposalContact.getContactExtNumber());
		proposalContactDTO.setInsuredRoles(proposalContact.getInsuredRoles());

		return proposalContactDTO;
	}

	private ProposalContact _updateProposalContact(
		ProposalContactDTO proposalContactDTO,
		ProposalContact proposalContact) {

		proposalContact.setContactExtNumber(
			proposalContactDTO.getContactExtNumber());
		proposalContact.setInsuredRoles(proposalContactDTO.getInsuredRoles());
		proposalContact.setModifiedDate(new Date());

		return proposalContactPersistence.update(proposalContact);
	}

}
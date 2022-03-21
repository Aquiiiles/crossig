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
import com.liferay.portal.kernel.exception.PortalException;

import hr.crosig.proposal.dto.ProposalContactDTO;
import hr.crosig.proposal.model.ProposalContact;
import hr.crosig.proposal.service.base.ProposalContactLocalServiceBaseImpl;

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
		ProposalContactDTO proposalContactDTO) {

		long proposalContactId = counterLocalService.increment(
			ProposalContact.class.getName());

		ProposalContact proposalContact = proposalContactPersistence.create(
			proposalContactId);

		proposalContact = _updateProposalContact(
			proposalContactDTO, proposalContact);

		return _mapToDTO(proposalContact);
	}

	public ProposalContactDTO updateProposalContact(
			ProposalContactDTO proposalContactDTO)
		throws PortalException {

		ProposalContact proposalContact =
			proposalContactLocalService.getProposalContact(
				proposalContactDTO.getProposalContactId());

		proposalContact = _updateProposalContact(
			proposalContactDTO, proposalContact);

		return _mapToDTO(proposalContact);
	}

	private ProposalContactDTO _mapToDTO(ProposalContact proposalContact) {
		ProposalContactDTO proposalContactDTO = new ProposalContactDTO();

		proposalContactDTO.setCompanyId(proposalContact.getCompanyId());
		proposalContactDTO.setContactExtNumber(
			proposalContact.getContactExtNumber());
		proposalContactDTO.setCreateDate(proposalContact.getCreateDate());
		proposalContactDTO.setInsuredRoles(proposalContact.getInsuredRoles());
		proposalContactDTO.setModifiedDate(proposalContact.getModifiedDate());
		proposalContactDTO.setProposalContactId(
			proposalContact.getProposalContactId());
		proposalContactDTO.setProposalId(proposalContact.getProposalId());
		proposalContactDTO.setUserId(proposalContact.getUserId());
		proposalContactDTO.setUserName(proposalContact.getUserName());

		return proposalContactDTO;
	}

	private ProposalContact _updateProposalContact(
		ProposalContactDTO proposalContactDTO,
		ProposalContact proposalContact) {

		proposalContact.setContactExtNumber(
			proposalContactDTO.getContactExtNumber());
		proposalContact.setInsuredRoles(proposalContactDTO.getInsuredRoles());
		proposalContact.setProposalId(proposalContactDTO.getProposalId());

		return proposalContactPersistence.update(proposalContact);
	}

}
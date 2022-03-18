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

import hr.crosig.proposal.dto.ProposalDTO;
import hr.crosig.proposal.model.Proposal;
import hr.crosig.proposal.service.base.ProposalLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=hr.crosig.proposal.model.Proposal",
	service = AopService.class
)
public class ProposalLocalServiceImpl extends ProposalLocalServiceBaseImpl {

	public ProposalDTO createProposal(ProposalDTO proposalDTO) {
		long proposalId = counterLocalService.increment(
			Proposal.class.getName());

		Proposal proposal = proposalPersistence.create(proposalId);

		proposal = _updateProposal(proposalDTO, proposal);

		return _mapToDTO(proposal);
	}

	public ProposalDTO updateProposal(ProposalDTO proposalDTO) {
		Proposal proposal = proposalPersistence.fetchByPrimaryKey(
			proposalDTO.getProposalId());

		proposal = _updateProposal(proposalDTO, proposal);

		return _mapToDTO(proposal);
	}

	private ProposalDTO _mapToDTO(Proposal proposal) {
		ProposalDTO proposalDTO = new ProposalDTO();

		proposalDTO.setAgentUserId(proposal.getAgentUserId());
		proposalDTO.setCompanyId(proposal.getCompanyId());
		proposalDTO.setCreateDate(proposal.getCreateDate());
		proposalDTO.setExternalProposalNumber(
			proposal.getExternalProposalNumber());
		proposalDTO.setInsuredObjectExtNumber(
			proposal.getInsuredObjectExtNumber());
		proposalDTO.setLastUpdate(proposal.getLastUpdate());
		proposalDTO.setModifiedDate(proposal.getModifiedDate());
		proposalDTO.setOrigin(proposal.getOrigin());
		proposalDTO.setPolicyHolderExtNumber(
			proposal.getPolicyHolderExtNumber());
		proposalDTO.setProposalId(proposal.getProposalId());
		proposalDTO.setStatus(proposal.getStatus());
		proposalDTO.setUserId(proposal.getUserId());
		proposalDTO.setUserName(proposal.getUserName());

		return proposalDTO;
	}

	private Proposal _updateProposal(
		ProposalDTO proposalDTO, Proposal proposal) {

		proposal.setExternalProposalNumber(
			proposalDTO.getExternalProposalNumber());
		proposal.setLastUpdate(proposalDTO.getLastUpdate());
		proposal.setOrigin(proposalDTO.getOrigin());
		proposal.setAgentUserId(proposalDTO.getAgentUserId());
		proposal.setPolicyHolderExtNumber(
			proposalDTO.getPolicyHolderExtNumber());
		proposal.setInsuredObjectExtNumber(
			proposalDTO.getInsuredObjectExtNumber());
		proposal.setStatus(proposalDTO.getStatus());

		return proposalPersistence.update(proposal);
	}

}
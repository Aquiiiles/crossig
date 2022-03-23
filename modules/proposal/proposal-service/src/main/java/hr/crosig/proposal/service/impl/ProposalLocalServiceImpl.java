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

import hr.crosig.proposal.dto.PolicyCoverageOptionDTO;
import hr.crosig.proposal.dto.PolicyOptionsDTO;
import hr.crosig.proposal.dto.ProposalContactDTO;
import hr.crosig.proposal.dto.ProposalDTO;
import hr.crosig.proposal.exception.NoSuchPolicyOptionsException;
import hr.crosig.proposal.model.Proposal;
import hr.crosig.proposal.service.PolicyCoverageOptLocalService;
import hr.crosig.proposal.service.PolicyOptionsLocalService;
import hr.crosig.proposal.service.ProposalContactLocalService;
import hr.crosig.proposal.service.base.ProposalLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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

		return _createRelatedEntities(proposalDTO, proposal);
	}

	public List<ProposalDTO> getAgentProposals(long agentUserId) {
		return proposalPersistence.findByAgentUserId(
			agentUserId
		).stream(
		).map(
			proposal -> getProposalDTO(proposal.getProposalId())
		).collect(
			Collectors.toList()
		);
	}

	public ProposalDTO getProposalDTO(long proposalId) {
		List<PolicyCoverageOptionDTO> proposalCoverageOptions =
			_policyCoverageOptLocalService.getProposalCoverageOptions(
				proposalId);
		PolicyOptionsDTO proposalPolicyOptions =
			_policyOptionsLocalService.getProposalPolicyOptions(proposalId);
		List<ProposalContactDTO> proposalContacts =
			_proposalContactLocalService.getProposalContacts(proposalId);

		return _mapToDTO(
			proposalLocalService.fetchProposal(proposalId),
			proposalCoverageOptions, proposalPolicyOptions, proposalContacts);
	}

	public ProposalDTO updateProposal(long proposalId, ProposalDTO proposalDTO)
		throws PortalException {

		Proposal proposal = proposalLocalService.getProposal(proposalId);

		proposal = _updateProposal(proposalDTO, proposal);

		_removeRelatedEntities(proposalId);

		return _createRelatedEntities(proposalDTO, proposal);
	}

	private List<PolicyCoverageOptionDTO> _createPolicyCoverageOptions(
		List<PolicyCoverageOptionDTO> policyCoverageOptions, long proposalId) {

		List<PolicyCoverageOptionDTO> updatedPolicyCoverageOptions =
			new ArrayList<>();

		policyCoverageOptions.forEach(
			policyCoverageOption -> {
				policyCoverageOption.setProposalId(proposalId);

				updatedPolicyCoverageOptions.add(
					_policyCoverageOptLocalService.createPolicyCoverageOpt(
						policyCoverageOption));
			});

		return updatedPolicyCoverageOptions;
	}

	private PolicyOptionsDTO _createPolicyOptions(
		PolicyOptionsDTO policyOptionsDTO, long proposalId) {

		policyOptionsDTO.setProposalId(proposalId);

		return _policyOptionsLocalService.createPolicyOptions(policyOptionsDTO);
	}

	private List<ProposalContactDTO> _createProposalContacts(
		List<ProposalContactDTO> proposalContacts, long proposalId) {

		List<ProposalContactDTO> updatedProposalContacts = new ArrayList<>();

		proposalContacts.forEach(
			proposalContact -> {
				proposalContact.setProposalId(proposalId);

				updatedProposalContacts.add(
					_proposalContactLocalService.createProposalContact(
						proposalContact));
			});

		return updatedProposalContacts;
	}

	private ProposalDTO _createRelatedEntities(
		ProposalDTO proposalDTO, Proposal proposal) {

		List<PolicyCoverageOptionDTO> policyCoverageOptions =
			_createPolicyCoverageOptions(
				proposalDTO.getPolicyCoverageOptions(),
				proposal.getProposalId());
		PolicyOptionsDTO policyOptions = _createPolicyOptions(
			proposalDTO.getPolicyOptions(), proposal.getProposalId());
		List<ProposalContactDTO> proposalContacts = _createProposalContacts(
			proposalDTO.getProposalContacts(), proposal.getProposalId());

		return _mapToDTO(
			proposal, policyCoverageOptions, policyOptions, proposalContacts);
	}

	private ProposalDTO _mapToDTO(
		Proposal proposal, List<PolicyCoverageOptionDTO> policyCoverageOptions,
		PolicyOptionsDTO policyOptions,
		List<ProposalContactDTO> proposalContacts) {

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
		proposalDTO.setPolicyCoverageOptions(policyCoverageOptions);
		proposalDTO.setPolicyOptions(policyOptions);
		proposalDTO.setProposalContacts(proposalContacts);

		return proposalDTO;
	}

	private void _removeRelatedEntities(long proposalId)
		throws NoSuchPolicyOptionsException {

		_policyCoverageOptLocalService.deleteAllByProposalId(proposalId);
		_policyOptionsLocalService.deleteAllByProposalId(proposalId);
		_proposalContactLocalService.deleteAllByProposalId(proposalId);
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

	@Reference
	private PolicyCoverageOptLocalService _policyCoverageOptLocalService;

	@Reference
	private PolicyOptionsLocalService _policyOptionsLocalService;

	@Reference
	private ProposalContactLocalService _proposalContactLocalService;

}
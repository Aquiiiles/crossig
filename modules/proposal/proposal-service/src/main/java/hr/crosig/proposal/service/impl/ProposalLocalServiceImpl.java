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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import hr.crosig.proposal.dto.PolicyCoverageOptionDTO;
import hr.crosig.proposal.dto.PolicyOptionsDTO;
import hr.crosig.proposal.dto.ProposalContactDTO;
import hr.crosig.proposal.dto.ProposalDTO;
import hr.crosig.proposal.model.Proposal;
import hr.crosig.proposal.service.PolicyCoverageOptLocalService;
import hr.crosig.proposal.service.PolicyOptionsLocalService;
import hr.crosig.proposal.service.ProposalContactLocalService;
import hr.crosig.proposal.service.base.ProposalLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

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

		_createPolicyCoverageOptions(proposalDTO.getPolicyCoverageOptions());
		_createPolicyOptions(proposalDTO.getPolicyOptions());
		_createProposalContact(proposalDTO.getProposalContacts());

		return _mapToDTO(proposal);
	}

	public ProposalDTO updateProposal(
		long proposalId, ProposalDTO proposalDTO) throws PortalException {

		Proposal proposal = proposalLocalService.getProposal(proposalId);

		proposal = _updateProposal(proposalDTO, proposal);

		_updatePolicyCoverageOptions(proposalDTO.getPolicyCoverageOptions());
		_updatePolicyOptions(proposalDTO.getPolicyOptions());
		_updateProposalContact(proposalDTO.getProposalContacts());

		return _mapToDTO(proposal);
	}

	private void _createPolicyCoverageOptions(
		List<PolicyCoverageOptionDTO> policyCoverageOptions) {

		policyCoverageOptions.forEach(
			policyCoverageOption ->
				_policyCoverageOptLocalService.createPolicyCoverageOpt(
					policyCoverageOption));
	}

	private void _createPolicyOptions(
		List<PolicyOptionsDTO> policyOptionsDTOS) {

		policyOptionsDTOS.forEach(
			policyOptions -> _policyOptionsLocalService.createPolicyOptions(
				policyOptions));
	}

	private void _createProposalContact(
		List<ProposalContactDTO> proposalContacts) {

		proposalContacts.forEach(
			proposalContact ->
				_proposalContactLocalService.createProposalContact(
					proposalContact));
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

	private void _updatePolicyCoverageOptions(
		List<PolicyCoverageOptionDTO> policyCoverageOptions) {

		policyCoverageOptions.forEach(
			policyCoverageOption ->
			{
				try {
					_policyCoverageOptLocalService.updatePolicyCoverageOpt(
						policyCoverageOption);
				} catch (PortalException portalException) {
					_log.info(portalException.getMessage());
				}

			});
	}

	private void _updatePolicyOptions(
		List<PolicyOptionsDTO> policyOptionsDTOS) {

		policyOptionsDTOS.forEach(
			policyOptions -> {
				try {
					_policyOptionsLocalService.updatePolicyOptions(
						policyOptions);
				} catch (PortalException portalException) {
					_log.info(portalException.getMessage());
				}
			});
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

	private void _updateProposalContact(
		List<ProposalContactDTO> proposalContacts) {

		proposalContacts.forEach(
			proposalContact ->
			{
				try {
					_proposalContactLocalService.updateProposalContact(
						proposalContact);
				} catch (PortalException portalException) {
					_log.info(portalException.getMessage());
				}
			});
	}

	private static final Log _log = LogFactoryUtil.getLog(
			ProductLocalServiceImpl.class);

	@Reference
	private PolicyCoverageOptLocalService _policyCoverageOptLocalService;

	@Reference
	private PolicyOptionsLocalService _policyOptionsLocalService;

	@Reference
	private ProposalContactLocalService _proposalContactLocalService;

}
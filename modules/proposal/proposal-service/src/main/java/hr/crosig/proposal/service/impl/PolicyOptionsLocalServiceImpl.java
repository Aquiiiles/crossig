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

import hr.crosig.proposal.dto.PolicyOptionsDTO;
import hr.crosig.proposal.model.PolicyOptions;
import hr.crosig.proposal.service.base.PolicyOptionsLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=hr.crosig.policyOptions.model.PolicyOptions",
	service = AopService.class
)
public class PolicyOptionsLocalServiceImpl
	extends PolicyOptionsLocalServiceBaseImpl {

	public PolicyOptionsDTO createPolicyOptions(
		PolicyOptionsDTO policyOptionsDTO) {

		long policyOptionsId = counterLocalService.increment(
			PolicyOptions.class.getName());

		PolicyOptions policyOptions = policyOptionsPersistence.create(
			policyOptionsId);

		policyOptions = _updatePolicyOptions(policyOptionsDTO, policyOptions);

		return _mapToDTO(policyOptions);
	}

	public void deleteAllByProposalId(long proposalId) {
		policyOptionsPersistence.removeByProposalId(proposalId);
	}

	public PolicyOptionsDTO updatePolicyOptions(
			PolicyOptionsDTO policyOptionsDTO)
		throws PortalException {

		PolicyOptions policyOptions =
			policyOptionsLocalService.getPolicyOptions(
				policyOptionsDTO.getPolicyOptionsId());

		policyOptions = _updatePolicyOptions(policyOptionsDTO, policyOptions);

		return _mapToDTO(policyOptions);
	}

	private PolicyOptionsDTO _mapToDTO(PolicyOptions policyOptions) {
		PolicyOptionsDTO policyOptionsDTO = new PolicyOptionsDTO();

		policyOptionsDTO.setCommunicationMethod(
			policyOptions.getCommunicationMethod());
		policyOptionsDTO.setCompanyId(policyOptions.getCompanyId());
		policyOptionsDTO.setContractEndDate(policyOptions.getContractEndDate());
		policyOptionsDTO.setContractPeriod(policyOptions.getContractPeriod());
		policyOptionsDTO.setContractStartDate(
			policyOptions.getContractStartDate());
		policyOptionsDTO.setCreateDate(policyOptions.getCreateDate());
		policyOptionsDTO.setCurrency(policyOptions.getCurrency());
		policyOptionsDTO.setDurationYear(policyOptions.getDurationYear());
		policyOptionsDTO.setIssueDate(policyOptions.getIssueDate());
		policyOptionsDTO.setModifiedDate(policyOptions.getModifiedDate());
		policyOptionsDTO.setPolicyEndDate(policyOptions.getPolicyEndDate());
		policyOptionsDTO.setPolicyNumberDays(
			policyOptions.getPolicyNumberDays());
		policyOptionsDTO.setPolicyOptionsId(policyOptions.getPolicyOptionsId());
		policyOptionsDTO.setPolicyStartDate(policyOptions.getPolicyStartDate());
		policyOptionsDTO.setProductCategory(policyOptions.getProductCategory());
		policyOptionsDTO.setProductExtNumber(
			policyOptions.getProductExtNumber());
		policyOptionsDTO.setProposalId(policyOptions.getProposalId());
		policyOptionsDTO.setTermsDate(policyOptions.getTermsDate());
		policyOptionsDTO.setUserId(policyOptions.getUserId());
		policyOptionsDTO.setUserName(policyOptions.getUserName());

		return policyOptionsDTO;
	}

	private PolicyOptions _updatePolicyOptions(
		PolicyOptionsDTO policyOptionsDTO, PolicyOptions policyOptions) {

		policyOptions.setCommunicationMethod(
			policyOptionsDTO.getCommunicationMethod());
		policyOptions.setContractEndDate(policyOptionsDTO.getContractEndDate());
		policyOptions.setContractPeriod(policyOptionsDTO.getContractPeriod());
		policyOptions.setContractStartDate(
			policyOptionsDTO.getContractStartDate());
		policyOptions.setCurrency(policyOptionsDTO.getCurrency());
		policyOptions.setDurationYear(policyOptionsDTO.getDurationYear());
		policyOptions.setIssueDate(policyOptionsDTO.getIssueDate());
		policyOptions.setPolicyEndDate(policyOptionsDTO.getPolicyEndDate());
		policyOptions.setPolicyNumberDays(
			policyOptionsDTO.getPolicyNumberDays());
		policyOptions.setPolicyStartDate(policyOptionsDTO.getPolicyStartDate());
		policyOptions.setProductCategory(policyOptionsDTO.getProductCategory());
		policyOptions.setProductExtNumber(
			policyOptionsDTO.getProductExtNumber());
		policyOptions.setProposalId(policyOptionsDTO.getProposalId());
		policyOptions.setTermsDate(policyOptionsDTO.getTermsDate());

		return policyOptionsPersistence.update(policyOptions);
	}

}
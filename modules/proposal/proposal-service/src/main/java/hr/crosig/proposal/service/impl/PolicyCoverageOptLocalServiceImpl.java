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

import hr.crosig.proposal.dto.PolicyCoverageOptionDTO;
import hr.crosig.proposal.model.PolicyCoverageOpt;
import hr.crosig.proposal.model.Proposal;
import hr.crosig.proposal.service.base.PolicyCoverageOptLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=hr.crosig.proposal.model.PolicyCoverageCoverageOpt",
	service = AopService.class
)
public class PolicyCoverageOptLocalServiceImpl
	extends PolicyCoverageOptLocalServiceBaseImpl {

	public PolicyCoverageOptionDTO createPolicyCoverageOpt(
		PolicyCoverageOptionDTO policyCoverageOptDTO, Proposal proposal) {

		long policyCoverageOptId = counterLocalService.increment(
			PolicyCoverageOpt.class.getName());

		PolicyCoverageOpt policyCoverageOpt =
			policyCoverageOptPersistence.create(policyCoverageOptId);

		policyCoverageOpt.setCreateDate(new Date());
		policyCoverageOpt.setUserId(proposal.getUserId());
		policyCoverageOpt.setUserName(proposal.getUserName());
		policyCoverageOpt.setCompanyId(proposal.getCompanyId());
		policyCoverageOpt.setProposalId(proposal.getProposalId());

		policyCoverageOpt = _updatePolicyCoverageOpt(
			policyCoverageOptDTO, policyCoverageOpt);

		return _mapToDTO(policyCoverageOpt);
	}

	public void deleteAllByProposalId(long proposalId) {
		policyCoverageOptPersistence.removeByProposalId(proposalId);
	}

	public List<PolicyCoverageOptionDTO> getProposalCoverageOptions(
		long proposalId) {

		return policyCoverageOptPersistence.findByProposalId(
			proposalId
		).stream(
		).map(
			this::_mapToDTO
		).collect(
			Collectors.toList()
		);
	}

	private PolicyCoverageOptionDTO _mapToDTO(
		PolicyCoverageOpt policyCoverageOpt) {

		PolicyCoverageOptionDTO policyCoverageOptDTO =
			new PolicyCoverageOptionDTO();

		policyCoverageOptDTO.setCoverageOptionsName(
			policyCoverageOpt.getCoverageOptionsName());
		policyCoverageOptDTO.setCoverageOptionsValue(
			policyCoverageOpt.getCoverageOptionsValue());
		policyCoverageOptDTO.setType(policyCoverageOpt.getType());

		return policyCoverageOptDTO;
	}

	private PolicyCoverageOpt _updatePolicyCoverageOpt(
		PolicyCoverageOptionDTO policyCoverageOptDTO,
		PolicyCoverageOpt policyCoverageOpt) {

		policyCoverageOpt.setCoverageOptionsName(
			policyCoverageOptDTO.getCoverageOptionsName());
		policyCoverageOpt.setCoverageOptionsValue(
			policyCoverageOptDTO.getCoverageOptionsValue());
		policyCoverageOpt.setType(policyCoverageOptDTO.getType());
		policyCoverageOpt.setModifiedDate(new Date());

		return policyCoverageOptPersistence.update(policyCoverageOpt);
	}

}
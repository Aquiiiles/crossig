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

import hr.crosig.proposal.dto.CoveragePlanDTO;
import hr.crosig.proposal.model.CoveragePlan;
import hr.crosig.proposal.service.base.CoveragePlanLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=hr.crosig.proposal.model.CoveragePlan",
	service = AopService.class
)
public class CoveragePlanLocalServiceImpl
	extends CoveragePlanLocalServiceBaseImpl {

	public CoveragePlan addCoveragePlan(String name, String category, String description) throws PortalException {
		CoveragePlan coveragePlan = getCoveragePlanByName(name);

		if (!Objects.isNull(coveragePlan)) {
			_log.info("CoveragePlan with name: " + name + " already exists.");

			return coveragePlan;
		}

		coveragePlan = coveragePlanLocalService.createCoveragePlan(
				counterLocalService.increment(CoveragePlan.class.getName()));

		coveragePlan.setName(name);
		coveragePlan.setCategory(category);
		coveragePlan.setDescription(description);

		return updateCoveragePlan(coveragePlan);
	}

	public CoveragePlan getCoveragePlanByName(String name) {
		return coveragePlanPersistence.fetchByName(name);
	}

	public List<CoveragePlanDTO>  getCoveragePlansByCategory(String category) {
		return coveragePlanPersistence.findByCategory(category).stream().map(coveragePlan -> _mapToCoveragePlanDTO(coveragePlan)).collect(Collectors.toList());
	}

	private CoveragePlanDTO _mapToCoveragePlanDTO(CoveragePlan coveragePlan) {
		CoveragePlanDTO coveragePlanDTO = new CoveragePlanDTO();

		coveragePlanDTO.setCoveragePlanId(coveragePlan.getCoveragePlanId());
		coveragePlanDTO.setName(coveragePlan.getName());
		coveragePlanDTO.setDescription(coveragePlan.getDescription());
		coveragePlanDTO.setCategory(coveragePlan.getCategory());

		return coveragePlanDTO;
	}

	private static final Log _log = LogFactoryUtil.getLog(
			CoveragePlanLocalServiceImpl.class);
}
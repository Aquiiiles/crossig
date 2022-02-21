/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package hr.crosig.proposal.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalService;
import hr.crosig.proposal.dto.InsuredRoleDTO;
import hr.crosig.proposal.exception.NoSuchInsuredRoleException;
import hr.crosig.proposal.model.InsuredRole;
import hr.crosig.proposal.service.InsuredRoleLocalService;
import hr.crosig.proposal.service.base.InsuredRoleLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=hr.crosig.proposal.model.InsuredRole",
        service = AopService.class
)
public class InsuredRoleLocalServiceImpl
        extends InsuredRoleLocalServiceBaseImpl {


    public List<InsuredRoleDTO> getAllInsuredRole() {
        List<InsuredRole> insuredRoles = insuredRolePersistence.findAll();

        return insuredRoles.stream().map(this::mapToInsuredRoleDTO).collect(Collectors.toList());

    }

    private InsuredRoleDTO mapToInsuredRoleDTO(InsuredRole insuredRole) {
        return new InsuredRoleDTO(insuredRole.getInsuredRoleId(), insuredRole.getTitle(), insuredRole.getName(), insuredRole.getExternalId());
    }
}
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

import hr.crosig.proposal.model.Product;
import hr.crosig.proposal.model.ProductRole;
import hr.crosig.proposal.service.base.ProductLocalServiceBaseImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author David Martini
 */
@Component(
	property = "model.class.name=hr.crosig.proposal.model.Product",
	service = AopService.class
)
public class ProductLocalServiceImpl extends ProductLocalServiceBaseImpl {

	public List<Product> getProductsByUserId(long userId) {
		List<Role> userRoles = _roleLocalService.getUserRoles(userId);

		return userRoles.stream(
		).map(
			role -> getProductsByRoleId(role.getRoleId())
		).flatMap(
			Collection::stream
		).collect(
			Collectors.toList()
		);
	}

	protected List<Product> getProductsByRoleId(long roleId) {
		List<ProductRole> list = productRolePersistence.findByRoleId(roleId);

		return list.stream(
		).map(
			productRole -> productLocalService.fetchProduct(
				productRole.getProductId())
		).collect(
			Collectors.toList()
		);
	}

	@Reference
	private RoleLocalService _roleLocalService;

}
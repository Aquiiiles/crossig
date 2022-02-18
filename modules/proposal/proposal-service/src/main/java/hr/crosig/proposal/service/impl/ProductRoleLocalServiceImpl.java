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

import hr.crosig.proposal.model.ProductRole;
import hr.crosig.proposal.service.base.ProductRoleLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Guilherme Kfouri
 */
@Component(
	property = "model.class.name=hr.crosig.proposal.model.ProductRole",
	service = AopService.class
)
public class ProductRoleLocalServiceImpl
	extends ProductRoleLocalServiceBaseImpl {

	public void addProductRole(long productId, long roleId) {
		ProductRole productRole = productRoleLocalService.createProductRole(
			counterLocalService.increment(ProductRole.class.getName()));

		productRole.setProductId(productId);
		productRole.setRoleId(roleId);

		productRoleLocalService.updateProductRole(productRole);
	}

}
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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalService;

import hr.crosig.proposal.dto.ProductDTO;
import hr.crosig.proposal.model.Product;
import hr.crosig.proposal.model.ProductRole;
import hr.crosig.proposal.service.base.ProductLocalServiceBaseImpl;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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

	public Product addProduct(
		String name, long externalId, boolean active, String description,
		String category) {

		Product product = productLocalService.getProductByName(name);

		if (!Objects.isNull(product)) {
			_log.info("Product with name: " + name + " already exists");

			return product;
		}

		product = productLocalService.createProduct(
			counterLocalService.increment(Product.class.getName()));

		product.setName(name);
		product.setExternalId(externalId);
		product.setActive(active);
		product.setDescription(description);
		product.setCategory(category);

		return productLocalService.updateProduct(product);
	}

	public Product getProductByName(String name) {
		return productPersistence.fetchByName(name);
	}

	public List<ProductDTO> getProductsByUserId(long userId) {
		List<Role> userRoles = _roleLocalService.getUserRoles(userId);

		Set<Long> productIds = userRoles.stream(
		).map(
			userRole -> getProductIdsByRoleId(userRole.getRoleId())
		).flatMap(
			Collection::stream
		).collect(
			Collectors.toSet()
		);

		return productIds.stream(
		).map(
			this::_getProductIfActive
		).filter(
			product -> !Objects.isNull(product)
		).collect(
			Collectors.toList()
		);
	}

	protected List<Long> getProductIdsByRoleId(long roleId) {
		List<ProductRole> list = productRolePersistence.findByRoleId(roleId);

		return list.stream(
		).map(
			ProductRole::getProductId
		).collect(
			Collectors.toList()
		);
	}

	private ProductDTO _getProductIfActive(long productId) {
		Product product = productLocalService.fetchProduct(productId);

		return _mapToProductDTO(product);
	}

	private ProductDTO _mapToProductDTO(Product product) {
		return new ProductDTO(
			product.getActive(), product.getCategory(),
			product.getDescription(), product.getProductId(), product.getName(),
			product.getExternalId());
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ProductLocalServiceImpl.class);

	@Reference
	private RoleLocalService _roleLocalService;

}
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

package hr.crosig.proposal.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductRoleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductRoleLocalService
 * @generated
 */
public class ProductRoleLocalServiceWrapper
	implements ProductRoleLocalService,
			   ServiceWrapper<ProductRoleLocalService> {

	public ProductRoleLocalServiceWrapper(
		ProductRoleLocalService productRoleLocalService) {

		_productRoleLocalService = productRoleLocalService;
	}

	/**
	 * Adds the product role to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productRole the product role
	 * @return the product role that was added
	 */
	@Override
	public hr.crosig.proposal.model.ProductRole addProductRole(
		hr.crosig.proposal.model.ProductRole productRole) {

		return _productRoleLocalService.addProductRole(productRole);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productRoleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new product role with the primary key. Does not add the product role to the database.
	 *
	 * @param productRoleId the primary key for the new product role
	 * @return the new product role
	 */
	@Override
	public hr.crosig.proposal.model.ProductRole createProductRole(
		long productRoleId) {

		return _productRoleLocalService.createProductRole(productRoleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productRoleLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the product role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productRoleId the primary key of the product role
	 * @return the product role that was removed
	 * @throws PortalException if a product role with the primary key could not be found
	 */
	@Override
	public hr.crosig.proposal.model.ProductRole deleteProductRole(
			long productRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productRoleLocalService.deleteProductRole(productRoleId);
	}

	/**
	 * Deletes the product role from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productRole the product role
	 * @return the product role that was removed
	 */
	@Override
	public hr.crosig.proposal.model.ProductRole deleteProductRole(
		hr.crosig.proposal.model.ProductRole productRole) {

		return _productRoleLocalService.deleteProductRole(productRole);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productRoleLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productRoleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _productRoleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _productRoleLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productRoleLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _productRoleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public hr.crosig.proposal.model.ProductRole fetchProductRole(
		long productRoleId) {

		return _productRoleLocalService.fetchProductRole(productRoleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productRoleLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productRoleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productRoleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productRoleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product role with the primary key.
	 *
	 * @param productRoleId the primary key of the product role
	 * @return the product role
	 * @throws PortalException if a product role with the primary key could not be found
	 */
	@Override
	public hr.crosig.proposal.model.ProductRole getProductRole(
			long productRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productRoleLocalService.getProductRole(productRoleId);
	}

	/**
	 * Returns a range of all the product roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product roles
	 * @param end the upper bound of the range of product roles (not inclusive)
	 * @return the range of product roles
	 */
	@Override
	public java.util.List<hr.crosig.proposal.model.ProductRole> getProductRoles(
		int start, int end) {

		return _productRoleLocalService.getProductRoles(start, end);
	}

	/**
	 * Returns the number of product roles.
	 *
	 * @return the number of product roles
	 */
	@Override
	public int getProductRolesCount() {
		return _productRoleLocalService.getProductRolesCount();
	}

	/**
	 * Updates the product role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productRole the product role
	 * @return the product role that was updated
	 */
	@Override
	public hr.crosig.proposal.model.ProductRole updateProductRole(
		hr.crosig.proposal.model.ProductRole productRole) {

		return _productRoleLocalService.updateProductRole(productRole);
	}

	@Override
	public ProductRoleLocalService getWrappedService() {
		return _productRoleLocalService;
	}

	@Override
	public void setWrappedService(
		ProductRoleLocalService productRoleLocalService) {

		_productRoleLocalService = productRoleLocalService;
	}

	private ProductRoleLocalService _productRoleLocalService;

}
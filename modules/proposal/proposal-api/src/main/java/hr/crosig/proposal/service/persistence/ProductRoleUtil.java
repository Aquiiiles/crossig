/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import hr.crosig.proposal.model.ProductRole;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the product role service. This utility wraps <code>hr.crosig.proposal.service.persistence.impl.ProductRolePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductRolePersistence
 * @generated
 */
public class ProductRoleUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ProductRole productRole) {
		getPersistence().clearCache(productRole);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ProductRole> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductRole> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductRole update(ProductRole productRole) {
		return getPersistence().update(productRole);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductRole update(
		ProductRole productRole, ServiceContext serviceContext) {

		return getPersistence().update(productRole, serviceContext);
	}

	/**
	 * Returns all the product roles where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the matching product roles
	 */
	public static List<ProductRole> findByRoleId(long roleId) {
		return getPersistence().findByRoleId(roleId);
	}

	/**
	 * Returns a range of all the product roles where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of product roles
	 * @param end the upper bound of the range of product roles (not inclusive)
	 * @return the range of matching product roles
	 */
	public static List<ProductRole> findByRoleId(
		long roleId, int start, int end) {

		return getPersistence().findByRoleId(roleId, start, end);
	}

	/**
	 * Returns an ordered range of all the product roles where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of product roles
	 * @param end the upper bound of the range of product roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product roles
	 */
	public static List<ProductRole> findByRoleId(
		long roleId, int start, int end,
		OrderByComparator<ProductRole> orderByComparator) {

		return getPersistence().findByRoleId(
			roleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product roles where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of product roles
	 * @param end the upper bound of the range of product roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product roles
	 */
	public static List<ProductRole> findByRoleId(
		long roleId, int start, int end,
		OrderByComparator<ProductRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRoleId(
			roleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product role in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product role
	 * @throws NoSuchProductRoleException if a matching product role could not be found
	 */
	public static ProductRole findByRoleId_First(
			long roleId, OrderByComparator<ProductRole> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchProductRoleException {

		return getPersistence().findByRoleId_First(roleId, orderByComparator);
	}

	/**
	 * Returns the first product role in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product role, or <code>null</code> if a matching product role could not be found
	 */
	public static ProductRole fetchByRoleId_First(
		long roleId, OrderByComparator<ProductRole> orderByComparator) {

		return getPersistence().fetchByRoleId_First(roleId, orderByComparator);
	}

	/**
	 * Returns the last product role in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product role
	 * @throws NoSuchProductRoleException if a matching product role could not be found
	 */
	public static ProductRole findByRoleId_Last(
			long roleId, OrderByComparator<ProductRole> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchProductRoleException {

		return getPersistence().findByRoleId_Last(roleId, orderByComparator);
	}

	/**
	 * Returns the last product role in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product role, or <code>null</code> if a matching product role could not be found
	 */
	public static ProductRole fetchByRoleId_Last(
		long roleId, OrderByComparator<ProductRole> orderByComparator) {

		return getPersistence().fetchByRoleId_Last(roleId, orderByComparator);
	}

	/**
	 * Returns the product roles before and after the current product role in the ordered set where roleId = &#63;.
	 *
	 * @param productRoleId the primary key of the current product role
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product role
	 * @throws NoSuchProductRoleException if a product role with the primary key could not be found
	 */
	public static ProductRole[] findByRoleId_PrevAndNext(
			long productRoleId, long roleId,
			OrderByComparator<ProductRole> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchProductRoleException {

		return getPersistence().findByRoleId_PrevAndNext(
			productRoleId, roleId, orderByComparator);
	}

	/**
	 * Removes all the product roles where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 */
	public static void removeByRoleId(long roleId) {
		getPersistence().removeByRoleId(roleId);
	}

	/**
	 * Returns the number of product roles where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching product roles
	 */
	public static int countByRoleId(long roleId) {
		return getPersistence().countByRoleId(roleId);
	}

	/**
	 * Caches the product role in the entity cache if it is enabled.
	 *
	 * @param productRole the product role
	 */
	public static void cacheResult(ProductRole productRole) {
		getPersistence().cacheResult(productRole);
	}

	/**
	 * Caches the product roles in the entity cache if it is enabled.
	 *
	 * @param productRoles the product roles
	 */
	public static void cacheResult(List<ProductRole> productRoles) {
		getPersistence().cacheResult(productRoles);
	}

	/**
	 * Creates a new product role with the primary key. Does not add the product role to the database.
	 *
	 * @param productRoleId the primary key for the new product role
	 * @return the new product role
	 */
	public static ProductRole create(long productRoleId) {
		return getPersistence().create(productRoleId);
	}

	/**
	 * Removes the product role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productRoleId the primary key of the product role
	 * @return the product role that was removed
	 * @throws NoSuchProductRoleException if a product role with the primary key could not be found
	 */
	public static ProductRole remove(long productRoleId)
		throws hr.crosig.proposal.exception.NoSuchProductRoleException {

		return getPersistence().remove(productRoleId);
	}

	public static ProductRole updateImpl(ProductRole productRole) {
		return getPersistence().updateImpl(productRole);
	}

	/**
	 * Returns the product role with the primary key or throws a <code>NoSuchProductRoleException</code> if it could not be found.
	 *
	 * @param productRoleId the primary key of the product role
	 * @return the product role
	 * @throws NoSuchProductRoleException if a product role with the primary key could not be found
	 */
	public static ProductRole findByPrimaryKey(long productRoleId)
		throws hr.crosig.proposal.exception.NoSuchProductRoleException {

		return getPersistence().findByPrimaryKey(productRoleId);
	}

	/**
	 * Returns the product role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productRoleId the primary key of the product role
	 * @return the product role, or <code>null</code> if a product role with the primary key could not be found
	 */
	public static ProductRole fetchByPrimaryKey(long productRoleId) {
		return getPersistence().fetchByPrimaryKey(productRoleId);
	}

	/**
	 * Returns all the product roles.
	 *
	 * @return the product roles
	 */
	public static List<ProductRole> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product roles
	 * @param end the upper bound of the range of product roles (not inclusive)
	 * @return the range of product roles
	 */
	public static List<ProductRole> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product roles
	 * @param end the upper bound of the range of product roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product roles
	 */
	public static List<ProductRole> findAll(
		int start, int end, OrderByComparator<ProductRole> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product roles
	 * @param end the upper bound of the range of product roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product roles
	 */
	public static List<ProductRole> findAll(
		int start, int end, OrderByComparator<ProductRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product roles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product roles.
	 *
	 * @return the number of product roles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductRolePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ProductRolePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ProductRolePersistence _persistence;

}
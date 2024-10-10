/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import hr.crosig.proposal.model.InsuredRole;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the insured role service. This utility wraps <code>hr.crosig.proposal.service.persistence.impl.InsuredRolePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InsuredRolePersistence
 * @generated
 */
public class InsuredRoleUtil {

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
	public static void clearCache(InsuredRole insuredRole) {
		getPersistence().clearCache(insuredRole);
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
	public static Map<Serializable, InsuredRole> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<InsuredRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InsuredRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InsuredRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<InsuredRole> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static InsuredRole update(InsuredRole insuredRole) {
		return getPersistence().update(insuredRole);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static InsuredRole update(
		InsuredRole insuredRole, ServiceContext serviceContext) {

		return getPersistence().update(insuredRole, serviceContext);
	}

	/**
	 * Returns the insured role where InsuredRoleId = &#63; or throws a <code>NoSuchInsuredRoleException</code> if it could not be found.
	 *
	 * @param InsuredRoleId the insured role ID
	 * @return the matching insured role
	 * @throws NoSuchInsuredRoleException if a matching insured role could not be found
	 */
	public static InsuredRole findByInsuredRoleId(long InsuredRoleId)
		throws hr.crosig.proposal.exception.NoSuchInsuredRoleException {

		return getPersistence().findByInsuredRoleId(InsuredRoleId);
	}

	/**
	 * Returns the insured role where InsuredRoleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param InsuredRoleId the insured role ID
	 * @return the matching insured role, or <code>null</code> if a matching insured role could not be found
	 */
	public static InsuredRole fetchByInsuredRoleId(long InsuredRoleId) {
		return getPersistence().fetchByInsuredRoleId(InsuredRoleId);
	}

	/**
	 * Returns the insured role where InsuredRoleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param InsuredRoleId the insured role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching insured role, or <code>null</code> if a matching insured role could not be found
	 */
	public static InsuredRole fetchByInsuredRoleId(
		long InsuredRoleId, boolean useFinderCache) {

		return getPersistence().fetchByInsuredRoleId(
			InsuredRoleId, useFinderCache);
	}

	/**
	 * Removes the insured role where InsuredRoleId = &#63; from the database.
	 *
	 * @param InsuredRoleId the insured role ID
	 * @return the insured role that was removed
	 */
	public static InsuredRole removeByInsuredRoleId(long InsuredRoleId)
		throws hr.crosig.proposal.exception.NoSuchInsuredRoleException {

		return getPersistence().removeByInsuredRoleId(InsuredRoleId);
	}

	/**
	 * Returns the number of insured roles where InsuredRoleId = &#63;.
	 *
	 * @param InsuredRoleId the insured role ID
	 * @return the number of matching insured roles
	 */
	public static int countByInsuredRoleId(long InsuredRoleId) {
		return getPersistence().countByInsuredRoleId(InsuredRoleId);
	}

	/**
	 * Caches the insured role in the entity cache if it is enabled.
	 *
	 * @param insuredRole the insured role
	 */
	public static void cacheResult(InsuredRole insuredRole) {
		getPersistence().cacheResult(insuredRole);
	}

	/**
	 * Caches the insured roles in the entity cache if it is enabled.
	 *
	 * @param insuredRoles the insured roles
	 */
	public static void cacheResult(List<InsuredRole> insuredRoles) {
		getPersistence().cacheResult(insuredRoles);
	}

	/**
	 * Creates a new insured role with the primary key. Does not add the insured role to the database.
	 *
	 * @param InsuredRoleId the primary key for the new insured role
	 * @return the new insured role
	 */
	public static InsuredRole create(long InsuredRoleId) {
		return getPersistence().create(InsuredRoleId);
	}

	/**
	 * Removes the insured role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param InsuredRoleId the primary key of the insured role
	 * @return the insured role that was removed
	 * @throws NoSuchInsuredRoleException if a insured role with the primary key could not be found
	 */
	public static InsuredRole remove(long InsuredRoleId)
		throws hr.crosig.proposal.exception.NoSuchInsuredRoleException {

		return getPersistence().remove(InsuredRoleId);
	}

	public static InsuredRole updateImpl(InsuredRole insuredRole) {
		return getPersistence().updateImpl(insuredRole);
	}

	/**
	 * Returns the insured role with the primary key or throws a <code>NoSuchInsuredRoleException</code> if it could not be found.
	 *
	 * @param InsuredRoleId the primary key of the insured role
	 * @return the insured role
	 * @throws NoSuchInsuredRoleException if a insured role with the primary key could not be found
	 */
	public static InsuredRole findByPrimaryKey(long InsuredRoleId)
		throws hr.crosig.proposal.exception.NoSuchInsuredRoleException {

		return getPersistence().findByPrimaryKey(InsuredRoleId);
	}

	/**
	 * Returns the insured role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param InsuredRoleId the primary key of the insured role
	 * @return the insured role, or <code>null</code> if a insured role with the primary key could not be found
	 */
	public static InsuredRole fetchByPrimaryKey(long InsuredRoleId) {
		return getPersistence().fetchByPrimaryKey(InsuredRoleId);
	}

	/**
	 * Returns all the insured roles.
	 *
	 * @return the insured roles
	 */
	public static List<InsuredRole> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the insured roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InsuredRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insured roles
	 * @param end the upper bound of the range of insured roles (not inclusive)
	 * @return the range of insured roles
	 */
	public static List<InsuredRole> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the insured roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InsuredRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insured roles
	 * @param end the upper bound of the range of insured roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of insured roles
	 */
	public static List<InsuredRole> findAll(
		int start, int end, OrderByComparator<InsuredRole> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the insured roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InsuredRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insured roles
	 * @param end the upper bound of the range of insured roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of insured roles
	 */
	public static List<InsuredRole> findAll(
		int start, int end, OrderByComparator<InsuredRole> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the insured roles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of insured roles.
	 *
	 * @return the number of insured roles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static InsuredRolePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(InsuredRolePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile InsuredRolePersistence _persistence;

}
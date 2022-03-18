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

package hr.crosig.proposal.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import hr.crosig.proposal.model.PolicyCoverageOption;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the policy coverage option service. This utility wraps <code>hr.crosig.proposal.service.persistence.impl.PolicyCoverageOptionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCoverageOptionPersistence
 * @generated
 */
public class PolicyCoverageOptionUtil {

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
	public static void clearCache(PolicyCoverageOption policyCoverageOption) {
		getPersistence().clearCache(policyCoverageOption);
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
	public static Map<Serializable, PolicyCoverageOption> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PolicyCoverageOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PolicyCoverageOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PolicyCoverageOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PolicyCoverageOption> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PolicyCoverageOption update(
		PolicyCoverageOption policyCoverageOption) {

		return getPersistence().update(policyCoverageOption);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PolicyCoverageOption update(
		PolicyCoverageOption policyCoverageOption,
		ServiceContext serviceContext) {

		return getPersistence().update(policyCoverageOption, serviceContext);
	}

	/**
	 * Caches the policy coverage option in the entity cache if it is enabled.
	 *
	 * @param policyCoverageOption the policy coverage option
	 */
	public static void cacheResult(PolicyCoverageOption policyCoverageOption) {
		getPersistence().cacheResult(policyCoverageOption);
	}

	/**
	 * Caches the policy coverage options in the entity cache if it is enabled.
	 *
	 * @param policyCoverageOptions the policy coverage options
	 */
	public static void cacheResult(
		List<PolicyCoverageOption> policyCoverageOptions) {

		getPersistence().cacheResult(policyCoverageOptions);
	}

	/**
	 * Creates a new policy coverage option with the primary key. Does not add the policy coverage option to the database.
	 *
	 * @param policyCoverageOptionId the primary key for the new policy coverage option
	 * @return the new policy coverage option
	 */
	public static PolicyCoverageOption create(long policyCoverageOptionId) {
		return getPersistence().create(policyCoverageOptionId);
	}

	/**
	 * Removes the policy coverage option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage option
	 * @return the policy coverage option that was removed
	 * @throws NoSuchPolicyCoverageOptionException if a policy coverage option with the primary key could not be found
	 */
	public static PolicyCoverageOption remove(long policyCoverageOptionId)
		throws hr.crosig.proposal.exception.
			NoSuchPolicyCoverageOptionException {

		return getPersistence().remove(policyCoverageOptionId);
	}

	public static PolicyCoverageOption updateImpl(
		PolicyCoverageOption policyCoverageOption) {

		return getPersistence().updateImpl(policyCoverageOption);
	}

	/**
	 * Returns the policy coverage option with the primary key or throws a <code>NoSuchPolicyCoverageOptionException</code> if it could not be found.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage option
	 * @return the policy coverage option
	 * @throws NoSuchPolicyCoverageOptionException if a policy coverage option with the primary key could not be found
	 */
	public static PolicyCoverageOption findByPrimaryKey(
			long policyCoverageOptionId)
		throws hr.crosig.proposal.exception.
			NoSuchPolicyCoverageOptionException {

		return getPersistence().findByPrimaryKey(policyCoverageOptionId);
	}

	/**
	 * Returns the policy coverage option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage option
	 * @return the policy coverage option, or <code>null</code> if a policy coverage option with the primary key could not be found
	 */
	public static PolicyCoverageOption fetchByPrimaryKey(
		long policyCoverageOptionId) {

		return getPersistence().fetchByPrimaryKey(policyCoverageOptionId);
	}

	/**
	 * Returns all the policy coverage options.
	 *
	 * @return the policy coverage options
	 */
	public static List<PolicyCoverageOption> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the policy coverage options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy coverage options
	 * @param end the upper bound of the range of policy coverage options (not inclusive)
	 * @return the range of policy coverage options
	 */
	public static List<PolicyCoverageOption> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the policy coverage options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy coverage options
	 * @param end the upper bound of the range of policy coverage options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy coverage options
	 */
	public static List<PolicyCoverageOption> findAll(
		int start, int end,
		OrderByComparator<PolicyCoverageOption> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy coverage options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy coverage options
	 * @param end the upper bound of the range of policy coverage options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy coverage options
	 */
	public static List<PolicyCoverageOption> findAll(
		int start, int end,
		OrderByComparator<PolicyCoverageOption> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the policy coverage options from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of policy coverage options.
	 *
	 * @return the number of policy coverage options
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PolicyCoverageOptionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PolicyCoverageOptionPersistence _persistence;

}
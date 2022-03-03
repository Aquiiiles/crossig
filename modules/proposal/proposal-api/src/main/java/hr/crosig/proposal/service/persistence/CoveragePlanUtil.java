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

import hr.crosig.proposal.model.CoveragePlan;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the coverage plan service. This utility wraps <code>hr.crosig.proposal.service.persistence.impl.CoveragePlanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CoveragePlanPersistence
 * @generated
 */
public class CoveragePlanUtil {

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
	public static void clearCache(CoveragePlan coveragePlan) {
		getPersistence().clearCache(coveragePlan);
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
	public static Map<Serializable, CoveragePlan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CoveragePlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CoveragePlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CoveragePlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CoveragePlan> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CoveragePlan update(CoveragePlan coveragePlan) {
		return getPersistence().update(coveragePlan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CoveragePlan update(
		CoveragePlan coveragePlan, ServiceContext serviceContext) {

		return getPersistence().update(coveragePlan, serviceContext);
	}

	/**
	 * Returns all the coverage plans where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching coverage plans
	 */
	public static List<CoveragePlan> findByCategory(String category) {
		return getPersistence().findByCategory(category);
	}

	/**
	 * Returns a range of all the coverage plans where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of coverage plans
	 * @param end the upper bound of the range of coverage plans (not inclusive)
	 * @return the range of matching coverage plans
	 */
	public static List<CoveragePlan> findByCategory(
		String category, int start, int end) {

		return getPersistence().findByCategory(category, start, end);
	}

	/**
	 * Returns an ordered range of all the coverage plans where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of coverage plans
	 * @param end the upper bound of the range of coverage plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coverage plans
	 */
	public static List<CoveragePlan> findByCategory(
		String category, int start, int end,
		OrderByComparator<CoveragePlan> orderByComparator) {

		return getPersistence().findByCategory(
			category, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the coverage plans where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of coverage plans
	 * @param end the upper bound of the range of coverage plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching coverage plans
	 */
	public static List<CoveragePlan> findByCategory(
		String category, int start, int end,
		OrderByComparator<CoveragePlan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCategory(
			category, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first coverage plan in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coverage plan
	 * @throws NoSuchCoveragePlanException if a matching coverage plan could not be found
	 */
	public static CoveragePlan findByCategory_First(
			String category, OrderByComparator<CoveragePlan> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchCoveragePlanException {

		return getPersistence().findByCategory_First(
			category, orderByComparator);
	}

	/**
	 * Returns the first coverage plan in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coverage plan, or <code>null</code> if a matching coverage plan could not be found
	 */
	public static CoveragePlan fetchByCategory_First(
		String category, OrderByComparator<CoveragePlan> orderByComparator) {

		return getPersistence().fetchByCategory_First(
			category, orderByComparator);
	}

	/**
	 * Returns the last coverage plan in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coverage plan
	 * @throws NoSuchCoveragePlanException if a matching coverage plan could not be found
	 */
	public static CoveragePlan findByCategory_Last(
			String category, OrderByComparator<CoveragePlan> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchCoveragePlanException {

		return getPersistence().findByCategory_Last(
			category, orderByComparator);
	}

	/**
	 * Returns the last coverage plan in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coverage plan, or <code>null</code> if a matching coverage plan could not be found
	 */
	public static CoveragePlan fetchByCategory_Last(
		String category, OrderByComparator<CoveragePlan> orderByComparator) {

		return getPersistence().fetchByCategory_Last(
			category, orderByComparator);
	}

	/**
	 * Returns the coverage plans before and after the current coverage plan in the ordered set where category = &#63;.
	 *
	 * @param coveragePlanId the primary key of the current coverage plan
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coverage plan
	 * @throws NoSuchCoveragePlanException if a coverage plan with the primary key could not be found
	 */
	public static CoveragePlan[] findByCategory_PrevAndNext(
			long coveragePlanId, String category,
			OrderByComparator<CoveragePlan> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchCoveragePlanException {

		return getPersistence().findByCategory_PrevAndNext(
			coveragePlanId, category, orderByComparator);
	}

	/**
	 * Removes all the coverage plans where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	public static void removeByCategory(String category) {
		getPersistence().removeByCategory(category);
	}

	/**
	 * Returns the number of coverage plans where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching coverage plans
	 */
	public static int countByCategory(String category) {
		return getPersistence().countByCategory(category);
	}

	/**
	 * Returns the coverage plan where name = &#63; or throws a <code>NoSuchCoveragePlanException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching coverage plan
	 * @throws NoSuchCoveragePlanException if a matching coverage plan could not be found
	 */
	public static CoveragePlan findByName(String name)
		throws hr.crosig.proposal.exception.NoSuchCoveragePlanException {

		return getPersistence().findByName(name);
	}

	/**
	 * Returns the coverage plan where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching coverage plan, or <code>null</code> if a matching coverage plan could not be found
	 */
	public static CoveragePlan fetchByName(String name) {
		return getPersistence().fetchByName(name);
	}

	/**
	 * Returns the coverage plan where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching coverage plan, or <code>null</code> if a matching coverage plan could not be found
	 */
	public static CoveragePlan fetchByName(
		String name, boolean useFinderCache) {

		return getPersistence().fetchByName(name, useFinderCache);
	}

	/**
	 * Removes the coverage plan where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the coverage plan that was removed
	 */
	public static CoveragePlan removeByName(String name)
		throws hr.crosig.proposal.exception.NoSuchCoveragePlanException {

		return getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of coverage plans where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching coverage plans
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the coverage plan in the entity cache if it is enabled.
	 *
	 * @param coveragePlan the coverage plan
	 */
	public static void cacheResult(CoveragePlan coveragePlan) {
		getPersistence().cacheResult(coveragePlan);
	}

	/**
	 * Caches the coverage plans in the entity cache if it is enabled.
	 *
	 * @param coveragePlans the coverage plans
	 */
	public static void cacheResult(List<CoveragePlan> coveragePlans) {
		getPersistence().cacheResult(coveragePlans);
	}

	/**
	 * Creates a new coverage plan with the primary key. Does not add the coverage plan to the database.
	 *
	 * @param coveragePlanId the primary key for the new coverage plan
	 * @return the new coverage plan
	 */
	public static CoveragePlan create(long coveragePlanId) {
		return getPersistence().create(coveragePlanId);
	}

	/**
	 * Removes the coverage plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coveragePlanId the primary key of the coverage plan
	 * @return the coverage plan that was removed
	 * @throws NoSuchCoveragePlanException if a coverage plan with the primary key could not be found
	 */
	public static CoveragePlan remove(long coveragePlanId)
		throws hr.crosig.proposal.exception.NoSuchCoveragePlanException {

		return getPersistence().remove(coveragePlanId);
	}

	public static CoveragePlan updateImpl(CoveragePlan coveragePlan) {
		return getPersistence().updateImpl(coveragePlan);
	}

	/**
	 * Returns the coverage plan with the primary key or throws a <code>NoSuchCoveragePlanException</code> if it could not be found.
	 *
	 * @param coveragePlanId the primary key of the coverage plan
	 * @return the coverage plan
	 * @throws NoSuchCoveragePlanException if a coverage plan with the primary key could not be found
	 */
	public static CoveragePlan findByPrimaryKey(long coveragePlanId)
		throws hr.crosig.proposal.exception.NoSuchCoveragePlanException {

		return getPersistence().findByPrimaryKey(coveragePlanId);
	}

	/**
	 * Returns the coverage plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coveragePlanId the primary key of the coverage plan
	 * @return the coverage plan, or <code>null</code> if a coverage plan with the primary key could not be found
	 */
	public static CoveragePlan fetchByPrimaryKey(long coveragePlanId) {
		return getPersistence().fetchByPrimaryKey(coveragePlanId);
	}

	/**
	 * Returns all the coverage plans.
	 *
	 * @return the coverage plans
	 */
	public static List<CoveragePlan> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the coverage plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coverage plans
	 * @param end the upper bound of the range of coverage plans (not inclusive)
	 * @return the range of coverage plans
	 */
	public static List<CoveragePlan> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the coverage plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coverage plans
	 * @param end the upper bound of the range of coverage plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of coverage plans
	 */
	public static List<CoveragePlan> findAll(
		int start, int end, OrderByComparator<CoveragePlan> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the coverage plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coverage plans
	 * @param end the upper bound of the range of coverage plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of coverage plans
	 */
	public static List<CoveragePlan> findAll(
		int start, int end, OrderByComparator<CoveragePlan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the coverage plans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of coverage plans.
	 *
	 * @return the number of coverage plans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CoveragePlanPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CoveragePlanPersistence _persistence;

}
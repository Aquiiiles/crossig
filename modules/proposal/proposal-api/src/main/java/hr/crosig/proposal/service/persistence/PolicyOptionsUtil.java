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

import hr.crosig.proposal.model.PolicyOptions;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the policy options service. This utility wraps <code>hr.crosig.proposal.service.persistence.impl.PolicyOptionsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyOptionsPersistence
 * @generated
 */
public class PolicyOptionsUtil {

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
	public static void clearCache(PolicyOptions policyOptions) {
		getPersistence().clearCache(policyOptions);
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
	public static Map<Serializable, PolicyOptions> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PolicyOptions> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PolicyOptions> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PolicyOptions> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PolicyOptions> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PolicyOptions update(PolicyOptions policyOptions) {
		return getPersistence().update(policyOptions);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PolicyOptions update(
		PolicyOptions policyOptions, ServiceContext serviceContext) {

		return getPersistence().update(policyOptions, serviceContext);
	}

	/**
	 * Returns all the policy optionses where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the matching policy optionses
	 */
	public static List<PolicyOptions> findByProposalId(long proposalId) {
		return getPersistence().findByProposalId(proposalId);
	}

	/**
	 * Returns a range of all the policy optionses where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyOptionsModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of policy optionses
	 * @param end the upper bound of the range of policy optionses (not inclusive)
	 * @return the range of matching policy optionses
	 */
	public static List<PolicyOptions> findByProposalId(
		long proposalId, int start, int end) {

		return getPersistence().findByProposalId(proposalId, start, end);
	}

	/**
	 * Returns an ordered range of all the policy optionses where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyOptionsModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of policy optionses
	 * @param end the upper bound of the range of policy optionses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy optionses
	 */
	public static List<PolicyOptions> findByProposalId(
		long proposalId, int start, int end,
		OrderByComparator<PolicyOptions> orderByComparator) {

		return getPersistence().findByProposalId(
			proposalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy optionses where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyOptionsModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of policy optionses
	 * @param end the upper bound of the range of policy optionses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy optionses
	 */
	public static List<PolicyOptions> findByProposalId(
		long proposalId, int start, int end,
		OrderByComparator<PolicyOptions> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProposalId(
			proposalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy options in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy options
	 * @throws NoSuchPolicyOptionsException if a matching policy options could not be found
	 */
	public static PolicyOptions findByProposalId_First(
			long proposalId, OrderByComparator<PolicyOptions> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchPolicyOptionsException {

		return getPersistence().findByProposalId_First(
			proposalId, orderByComparator);
	}

	/**
	 * Returns the first policy options in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy options, or <code>null</code> if a matching policy options could not be found
	 */
	public static PolicyOptions fetchByProposalId_First(
		long proposalId, OrderByComparator<PolicyOptions> orderByComparator) {

		return getPersistence().fetchByProposalId_First(
			proposalId, orderByComparator);
	}

	/**
	 * Returns the last policy options in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy options
	 * @throws NoSuchPolicyOptionsException if a matching policy options could not be found
	 */
	public static PolicyOptions findByProposalId_Last(
			long proposalId, OrderByComparator<PolicyOptions> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchPolicyOptionsException {

		return getPersistence().findByProposalId_Last(
			proposalId, orderByComparator);
	}

	/**
	 * Returns the last policy options in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy options, or <code>null</code> if a matching policy options could not be found
	 */
	public static PolicyOptions fetchByProposalId_Last(
		long proposalId, OrderByComparator<PolicyOptions> orderByComparator) {

		return getPersistence().fetchByProposalId_Last(
			proposalId, orderByComparator);
	}

	/**
	 * Returns the policy optionses before and after the current policy options in the ordered set where proposalId = &#63;.
	 *
	 * @param policyOptionsId the primary key of the current policy options
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy options
	 * @throws NoSuchPolicyOptionsException if a policy options with the primary key could not be found
	 */
	public static PolicyOptions[] findByProposalId_PrevAndNext(
			long policyOptionsId, long proposalId,
			OrderByComparator<PolicyOptions> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchPolicyOptionsException {

		return getPersistence().findByProposalId_PrevAndNext(
			policyOptionsId, proposalId, orderByComparator);
	}

	/**
	 * Removes all the policy optionses where proposalId = &#63; from the database.
	 *
	 * @param proposalId the proposal ID
	 */
	public static void removeByProposalId(long proposalId) {
		getPersistence().removeByProposalId(proposalId);
	}

	/**
	 * Returns the number of policy optionses where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the number of matching policy optionses
	 */
	public static int countByProposalId(long proposalId) {
		return getPersistence().countByProposalId(proposalId);
	}

	/**
	 * Caches the policy options in the entity cache if it is enabled.
	 *
	 * @param policyOptions the policy options
	 */
	public static void cacheResult(PolicyOptions policyOptions) {
		getPersistence().cacheResult(policyOptions);
	}

	/**
	 * Caches the policy optionses in the entity cache if it is enabled.
	 *
	 * @param policyOptionses the policy optionses
	 */
	public static void cacheResult(List<PolicyOptions> policyOptionses) {
		getPersistence().cacheResult(policyOptionses);
	}

	/**
	 * Creates a new policy options with the primary key. Does not add the policy options to the database.
	 *
	 * @param policyOptionsId the primary key for the new policy options
	 * @return the new policy options
	 */
	public static PolicyOptions create(long policyOptionsId) {
		return getPersistence().create(policyOptionsId);
	}

	/**
	 * Removes the policy options with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyOptionsId the primary key of the policy options
	 * @return the policy options that was removed
	 * @throws NoSuchPolicyOptionsException if a policy options with the primary key could not be found
	 */
	public static PolicyOptions remove(long policyOptionsId)
		throws hr.crosig.proposal.exception.NoSuchPolicyOptionsException {

		return getPersistence().remove(policyOptionsId);
	}

	public static PolicyOptions updateImpl(PolicyOptions policyOptions) {
		return getPersistence().updateImpl(policyOptions);
	}

	/**
	 * Returns the policy options with the primary key or throws a <code>NoSuchPolicyOptionsException</code> if it could not be found.
	 *
	 * @param policyOptionsId the primary key of the policy options
	 * @return the policy options
	 * @throws NoSuchPolicyOptionsException if a policy options with the primary key could not be found
	 */
	public static PolicyOptions findByPrimaryKey(long policyOptionsId)
		throws hr.crosig.proposal.exception.NoSuchPolicyOptionsException {

		return getPersistence().findByPrimaryKey(policyOptionsId);
	}

	/**
	 * Returns the policy options with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyOptionsId the primary key of the policy options
	 * @return the policy options, or <code>null</code> if a policy options with the primary key could not be found
	 */
	public static PolicyOptions fetchByPrimaryKey(long policyOptionsId) {
		return getPersistence().fetchByPrimaryKey(policyOptionsId);
	}

	/**
	 * Returns all the policy optionses.
	 *
	 * @return the policy optionses
	 */
	public static List<PolicyOptions> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the policy optionses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyOptionsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy optionses
	 * @param end the upper bound of the range of policy optionses (not inclusive)
	 * @return the range of policy optionses
	 */
	public static List<PolicyOptions> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the policy optionses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyOptionsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy optionses
	 * @param end the upper bound of the range of policy optionses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy optionses
	 */
	public static List<PolicyOptions> findAll(
		int start, int end,
		OrderByComparator<PolicyOptions> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy optionses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyOptionsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy optionses
	 * @param end the upper bound of the range of policy optionses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy optionses
	 */
	public static List<PolicyOptions> findAll(
		int start, int end, OrderByComparator<PolicyOptions> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the policy optionses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of policy optionses.
	 *
	 * @return the number of policy optionses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PolicyOptionsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PolicyOptionsPersistence _persistence;

}
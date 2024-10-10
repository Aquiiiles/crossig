/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import hr.crosig.proposal.model.PolicyCoverageOpt;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the policy coverage opt service. This utility wraps <code>hr.crosig.proposal.service.persistence.impl.PolicyCoverageOptPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCoverageOptPersistence
 * @generated
 */
public class PolicyCoverageOptUtil {

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
	public static void clearCache(PolicyCoverageOpt policyCoverageOpt) {
		getPersistence().clearCache(policyCoverageOpt);
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
	public static Map<Serializable, PolicyCoverageOpt> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PolicyCoverageOpt> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PolicyCoverageOpt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PolicyCoverageOpt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PolicyCoverageOpt> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PolicyCoverageOpt update(
		PolicyCoverageOpt policyCoverageOpt) {

		return getPersistence().update(policyCoverageOpt);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PolicyCoverageOpt update(
		PolicyCoverageOpt policyCoverageOpt, ServiceContext serviceContext) {

		return getPersistence().update(policyCoverageOpt, serviceContext);
	}

	/**
	 * Returns all the policy coverage opts where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the matching policy coverage opts
	 */
	public static List<PolicyCoverageOpt> findByProposalId(long proposalId) {
		return getPersistence().findByProposalId(proposalId);
	}

	/**
	 * Returns a range of all the policy coverage opts where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of policy coverage opts
	 * @param end the upper bound of the range of policy coverage opts (not inclusive)
	 * @return the range of matching policy coverage opts
	 */
	public static List<PolicyCoverageOpt> findByProposalId(
		long proposalId, int start, int end) {

		return getPersistence().findByProposalId(proposalId, start, end);
	}

	/**
	 * Returns an ordered range of all the policy coverage opts where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of policy coverage opts
	 * @param end the upper bound of the range of policy coverage opts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy coverage opts
	 */
	public static List<PolicyCoverageOpt> findByProposalId(
		long proposalId, int start, int end,
		OrderByComparator<PolicyCoverageOpt> orderByComparator) {

		return getPersistence().findByProposalId(
			proposalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy coverage opts where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of policy coverage opts
	 * @param end the upper bound of the range of policy coverage opts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy coverage opts
	 */
	public static List<PolicyCoverageOpt> findByProposalId(
		long proposalId, int start, int end,
		OrderByComparator<PolicyCoverageOpt> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProposalId(
			proposalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy coverage opt in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy coverage opt
	 * @throws NoSuchPolicyCoverageOptException if a matching policy coverage opt could not be found
	 */
	public static PolicyCoverageOpt findByProposalId_First(
			long proposalId,
			OrderByComparator<PolicyCoverageOpt> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchPolicyCoverageOptException {

		return getPersistence().findByProposalId_First(
			proposalId, orderByComparator);
	}

	/**
	 * Returns the first policy coverage opt in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy coverage opt, or <code>null</code> if a matching policy coverage opt could not be found
	 */
	public static PolicyCoverageOpt fetchByProposalId_First(
		long proposalId,
		OrderByComparator<PolicyCoverageOpt> orderByComparator) {

		return getPersistence().fetchByProposalId_First(
			proposalId, orderByComparator);
	}

	/**
	 * Returns the last policy coverage opt in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy coverage opt
	 * @throws NoSuchPolicyCoverageOptException if a matching policy coverage opt could not be found
	 */
	public static PolicyCoverageOpt findByProposalId_Last(
			long proposalId,
			OrderByComparator<PolicyCoverageOpt> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchPolicyCoverageOptException {

		return getPersistence().findByProposalId_Last(
			proposalId, orderByComparator);
	}

	/**
	 * Returns the last policy coverage opt in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy coverage opt, or <code>null</code> if a matching policy coverage opt could not be found
	 */
	public static PolicyCoverageOpt fetchByProposalId_Last(
		long proposalId,
		OrderByComparator<PolicyCoverageOpt> orderByComparator) {

		return getPersistence().fetchByProposalId_Last(
			proposalId, orderByComparator);
	}

	/**
	 * Returns the policy coverage opts before and after the current policy coverage opt in the ordered set where proposalId = &#63;.
	 *
	 * @param policyCoverageOptionId the primary key of the current policy coverage opt
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy coverage opt
	 * @throws NoSuchPolicyCoverageOptException if a policy coverage opt with the primary key could not be found
	 */
	public static PolicyCoverageOpt[] findByProposalId_PrevAndNext(
			long policyCoverageOptionId, long proposalId,
			OrderByComparator<PolicyCoverageOpt> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchPolicyCoverageOptException {

		return getPersistence().findByProposalId_PrevAndNext(
			policyCoverageOptionId, proposalId, orderByComparator);
	}

	/**
	 * Removes all the policy coverage opts where proposalId = &#63; from the database.
	 *
	 * @param proposalId the proposal ID
	 */
	public static void removeByProposalId(long proposalId) {
		getPersistence().removeByProposalId(proposalId);
	}

	/**
	 * Returns the number of policy coverage opts where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the number of matching policy coverage opts
	 */
	public static int countByProposalId(long proposalId) {
		return getPersistence().countByProposalId(proposalId);
	}

	/**
	 * Caches the policy coverage opt in the entity cache if it is enabled.
	 *
	 * @param policyCoverageOpt the policy coverage opt
	 */
	public static void cacheResult(PolicyCoverageOpt policyCoverageOpt) {
		getPersistence().cacheResult(policyCoverageOpt);
	}

	/**
	 * Caches the policy coverage opts in the entity cache if it is enabled.
	 *
	 * @param policyCoverageOpts the policy coverage opts
	 */
	public static void cacheResult(List<PolicyCoverageOpt> policyCoverageOpts) {
		getPersistence().cacheResult(policyCoverageOpts);
	}

	/**
	 * Creates a new policy coverage opt with the primary key. Does not add the policy coverage opt to the database.
	 *
	 * @param policyCoverageOptionId the primary key for the new policy coverage opt
	 * @return the new policy coverage opt
	 */
	public static PolicyCoverageOpt create(long policyCoverageOptionId) {
		return getPersistence().create(policyCoverageOptionId);
	}

	/**
	 * Removes the policy coverage opt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage opt
	 * @return the policy coverage opt that was removed
	 * @throws NoSuchPolicyCoverageOptException if a policy coverage opt with the primary key could not be found
	 */
	public static PolicyCoverageOpt remove(long policyCoverageOptionId)
		throws hr.crosig.proposal.exception.NoSuchPolicyCoverageOptException {

		return getPersistence().remove(policyCoverageOptionId);
	}

	public static PolicyCoverageOpt updateImpl(
		PolicyCoverageOpt policyCoverageOpt) {

		return getPersistence().updateImpl(policyCoverageOpt);
	}

	/**
	 * Returns the policy coverage opt with the primary key or throws a <code>NoSuchPolicyCoverageOptException</code> if it could not be found.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage opt
	 * @return the policy coverage opt
	 * @throws NoSuchPolicyCoverageOptException if a policy coverage opt with the primary key could not be found
	 */
	public static PolicyCoverageOpt findByPrimaryKey(
			long policyCoverageOptionId)
		throws hr.crosig.proposal.exception.NoSuchPolicyCoverageOptException {

		return getPersistence().findByPrimaryKey(policyCoverageOptionId);
	}

	/**
	 * Returns the policy coverage opt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage opt
	 * @return the policy coverage opt, or <code>null</code> if a policy coverage opt with the primary key could not be found
	 */
	public static PolicyCoverageOpt fetchByPrimaryKey(
		long policyCoverageOptionId) {

		return getPersistence().fetchByPrimaryKey(policyCoverageOptionId);
	}

	/**
	 * Returns all the policy coverage opts.
	 *
	 * @return the policy coverage opts
	 */
	public static List<PolicyCoverageOpt> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the policy coverage opts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy coverage opts
	 * @param end the upper bound of the range of policy coverage opts (not inclusive)
	 * @return the range of policy coverage opts
	 */
	public static List<PolicyCoverageOpt> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the policy coverage opts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy coverage opts
	 * @param end the upper bound of the range of policy coverage opts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy coverage opts
	 */
	public static List<PolicyCoverageOpt> findAll(
		int start, int end,
		OrderByComparator<PolicyCoverageOpt> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy coverage opts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy coverage opts
	 * @param end the upper bound of the range of policy coverage opts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy coverage opts
	 */
	public static List<PolicyCoverageOpt> findAll(
		int start, int end,
		OrderByComparator<PolicyCoverageOpt> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the policy coverage opts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of policy coverage opts.
	 *
	 * @return the number of policy coverage opts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PolicyCoverageOptPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		PolicyCoverageOptPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile PolicyCoverageOptPersistence _persistence;

}
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import hr.crosig.proposal.model.ProposalContact;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the proposal contact service. This utility wraps <code>hr.crosig.proposal.service.persistence.impl.ProposalContactPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalContactPersistence
 * @generated
 */
public class ProposalContactUtil {

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
	public static void clearCache(ProposalContact proposalContact) {
		getPersistence().clearCache(proposalContact);
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
	public static Map<Serializable, ProposalContact> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProposalContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProposalContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProposalContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProposalContact> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProposalContact update(ProposalContact proposalContact) {
		return getPersistence().update(proposalContact);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProposalContact update(
		ProposalContact proposalContact, ServiceContext serviceContext) {

		return getPersistence().update(proposalContact, serviceContext);
	}

	/**
	 * Returns all the proposal contacts where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the matching proposal contacts
	 */
	public static List<ProposalContact> findByProposalId(long proposalId) {
		return getPersistence().findByProposalId(proposalId);
	}

	/**
	 * Returns a range of all the proposal contacts where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalContactModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of proposal contacts
	 * @param end the upper bound of the range of proposal contacts (not inclusive)
	 * @return the range of matching proposal contacts
	 */
	public static List<ProposalContact> findByProposalId(
		long proposalId, int start, int end) {

		return getPersistence().findByProposalId(proposalId, start, end);
	}

	/**
	 * Returns an ordered range of all the proposal contacts where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalContactModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of proposal contacts
	 * @param end the upper bound of the range of proposal contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposal contacts
	 */
	public static List<ProposalContact> findByProposalId(
		long proposalId, int start, int end,
		OrderByComparator<ProposalContact> orderByComparator) {

		return getPersistence().findByProposalId(
			proposalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proposal contacts where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalContactModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of proposal contacts
	 * @param end the upper bound of the range of proposal contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proposal contacts
	 */
	public static List<ProposalContact> findByProposalId(
		long proposalId, int start, int end,
		OrderByComparator<ProposalContact> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProposalId(
			proposalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal contact
	 * @throws NoSuchProposalContactException if a matching proposal contact could not be found
	 */
	public static ProposalContact findByProposalId_First(
			long proposalId,
			OrderByComparator<ProposalContact> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchProposalContactException {

		return getPersistence().findByProposalId_First(
			proposalId, orderByComparator);
	}

	/**
	 * Returns the first proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal contact, or <code>null</code> if a matching proposal contact could not be found
	 */
	public static ProposalContact fetchByProposalId_First(
		long proposalId, OrderByComparator<ProposalContact> orderByComparator) {

		return getPersistence().fetchByProposalId_First(
			proposalId, orderByComparator);
	}

	/**
	 * Returns the last proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal contact
	 * @throws NoSuchProposalContactException if a matching proposal contact could not be found
	 */
	public static ProposalContact findByProposalId_Last(
			long proposalId,
			OrderByComparator<ProposalContact> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchProposalContactException {

		return getPersistence().findByProposalId_Last(
			proposalId, orderByComparator);
	}

	/**
	 * Returns the last proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal contact, or <code>null</code> if a matching proposal contact could not be found
	 */
	public static ProposalContact fetchByProposalId_Last(
		long proposalId, OrderByComparator<ProposalContact> orderByComparator) {

		return getPersistence().fetchByProposalId_Last(
			proposalId, orderByComparator);
	}

	/**
	 * Returns the proposal contacts before and after the current proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalContactId the primary key of the current proposal contact
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposal contact
	 * @throws NoSuchProposalContactException if a proposal contact with the primary key could not be found
	 */
	public static ProposalContact[] findByProposalId_PrevAndNext(
			long proposalContactId, long proposalId,
			OrderByComparator<ProposalContact> orderByComparator)
		throws hr.crosig.proposal.exception.NoSuchProposalContactException {

		return getPersistence().findByProposalId_PrevAndNext(
			proposalContactId, proposalId, orderByComparator);
	}

	/**
	 * Removes all the proposal contacts where proposalId = &#63; from the database.
	 *
	 * @param proposalId the proposal ID
	 */
	public static void removeByProposalId(long proposalId) {
		getPersistence().removeByProposalId(proposalId);
	}

	/**
	 * Returns the number of proposal contacts where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the number of matching proposal contacts
	 */
	public static int countByProposalId(long proposalId) {
		return getPersistence().countByProposalId(proposalId);
	}

	/**
	 * Caches the proposal contact in the entity cache if it is enabled.
	 *
	 * @param proposalContact the proposal contact
	 */
	public static void cacheResult(ProposalContact proposalContact) {
		getPersistence().cacheResult(proposalContact);
	}

	/**
	 * Caches the proposal contacts in the entity cache if it is enabled.
	 *
	 * @param proposalContacts the proposal contacts
	 */
	public static void cacheResult(List<ProposalContact> proposalContacts) {
		getPersistence().cacheResult(proposalContacts);
	}

	/**
	 * Creates a new proposal contact with the primary key. Does not add the proposal contact to the database.
	 *
	 * @param proposalContactId the primary key for the new proposal contact
	 * @return the new proposal contact
	 */
	public static ProposalContact create(long proposalContactId) {
		return getPersistence().create(proposalContactId);
	}

	/**
	 * Removes the proposal contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proposalContactId the primary key of the proposal contact
	 * @return the proposal contact that was removed
	 * @throws NoSuchProposalContactException if a proposal contact with the primary key could not be found
	 */
	public static ProposalContact remove(long proposalContactId)
		throws hr.crosig.proposal.exception.NoSuchProposalContactException {

		return getPersistence().remove(proposalContactId);
	}

	public static ProposalContact updateImpl(ProposalContact proposalContact) {
		return getPersistence().updateImpl(proposalContact);
	}

	/**
	 * Returns the proposal contact with the primary key or throws a <code>NoSuchProposalContactException</code> if it could not be found.
	 *
	 * @param proposalContactId the primary key of the proposal contact
	 * @return the proposal contact
	 * @throws NoSuchProposalContactException if a proposal contact with the primary key could not be found
	 */
	public static ProposalContact findByPrimaryKey(long proposalContactId)
		throws hr.crosig.proposal.exception.NoSuchProposalContactException {

		return getPersistence().findByPrimaryKey(proposalContactId);
	}

	/**
	 * Returns the proposal contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proposalContactId the primary key of the proposal contact
	 * @return the proposal contact, or <code>null</code> if a proposal contact with the primary key could not be found
	 */
	public static ProposalContact fetchByPrimaryKey(long proposalContactId) {
		return getPersistence().fetchByPrimaryKey(proposalContactId);
	}

	/**
	 * Returns all the proposal contacts.
	 *
	 * @return the proposal contacts
	 */
	public static List<ProposalContact> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the proposal contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposal contacts
	 * @param end the upper bound of the range of proposal contacts (not inclusive)
	 * @return the range of proposal contacts
	 */
	public static List<ProposalContact> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the proposal contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposal contacts
	 * @param end the upper bound of the range of proposal contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proposal contacts
	 */
	public static List<ProposalContact> findAll(
		int start, int end,
		OrderByComparator<ProposalContact> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proposal contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposal contacts
	 * @param end the upper bound of the range of proposal contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of proposal contacts
	 */
	public static List<ProposalContact> findAll(
		int start, int end,
		OrderByComparator<ProposalContact> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the proposal contacts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of proposal contacts.
	 *
	 * @return the number of proposal contacts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProposalContactPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ProposalContactPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ProposalContactPersistence _persistence;

}
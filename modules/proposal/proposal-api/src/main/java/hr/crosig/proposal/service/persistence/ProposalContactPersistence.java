/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import hr.crosig.proposal.exception.NoSuchProposalContactException;
import hr.crosig.proposal.model.ProposalContact;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the proposal contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalContactUtil
 * @generated
 */
@ProviderType
public interface ProposalContactPersistence
	extends BasePersistence<ProposalContact> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProposalContactUtil} to access the proposal contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the proposal contacts where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the matching proposal contacts
	 */
	public java.util.List<ProposalContact> findByProposalId(long proposalId);

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
	public java.util.List<ProposalContact> findByProposalId(
		long proposalId, int start, int end);

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
	public java.util.List<ProposalContact> findByProposalId(
		long proposalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProposalContact>
			orderByComparator);

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
	public java.util.List<ProposalContact> findByProposalId(
		long proposalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProposalContact>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal contact
	 * @throws NoSuchProposalContactException if a matching proposal contact could not be found
	 */
	public ProposalContact findByProposalId_First(
			long proposalId,
			com.liferay.portal.kernel.util.OrderByComparator<ProposalContact>
				orderByComparator)
		throws NoSuchProposalContactException;

	/**
	 * Returns the first proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal contact, or <code>null</code> if a matching proposal contact could not be found
	 */
	public ProposalContact fetchByProposalId_First(
		long proposalId,
		com.liferay.portal.kernel.util.OrderByComparator<ProposalContact>
			orderByComparator);

	/**
	 * Returns the last proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal contact
	 * @throws NoSuchProposalContactException if a matching proposal contact could not be found
	 */
	public ProposalContact findByProposalId_Last(
			long proposalId,
			com.liferay.portal.kernel.util.OrderByComparator<ProposalContact>
				orderByComparator)
		throws NoSuchProposalContactException;

	/**
	 * Returns the last proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal contact, or <code>null</code> if a matching proposal contact could not be found
	 */
	public ProposalContact fetchByProposalId_Last(
		long proposalId,
		com.liferay.portal.kernel.util.OrderByComparator<ProposalContact>
			orderByComparator);

	/**
	 * Returns the proposal contacts before and after the current proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalContactId the primary key of the current proposal contact
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposal contact
	 * @throws NoSuchProposalContactException if a proposal contact with the primary key could not be found
	 */
	public ProposalContact[] findByProposalId_PrevAndNext(
			long proposalContactId, long proposalId,
			com.liferay.portal.kernel.util.OrderByComparator<ProposalContact>
				orderByComparator)
		throws NoSuchProposalContactException;

	/**
	 * Removes all the proposal contacts where proposalId = &#63; from the database.
	 *
	 * @param proposalId the proposal ID
	 */
	public void removeByProposalId(long proposalId);

	/**
	 * Returns the number of proposal contacts where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the number of matching proposal contacts
	 */
	public int countByProposalId(long proposalId);

	/**
	 * Caches the proposal contact in the entity cache if it is enabled.
	 *
	 * @param proposalContact the proposal contact
	 */
	public void cacheResult(ProposalContact proposalContact);

	/**
	 * Caches the proposal contacts in the entity cache if it is enabled.
	 *
	 * @param proposalContacts the proposal contacts
	 */
	public void cacheResult(java.util.List<ProposalContact> proposalContacts);

	/**
	 * Creates a new proposal contact with the primary key. Does not add the proposal contact to the database.
	 *
	 * @param proposalContactId the primary key for the new proposal contact
	 * @return the new proposal contact
	 */
	public ProposalContact create(long proposalContactId);

	/**
	 * Removes the proposal contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proposalContactId the primary key of the proposal contact
	 * @return the proposal contact that was removed
	 * @throws NoSuchProposalContactException if a proposal contact with the primary key could not be found
	 */
	public ProposalContact remove(long proposalContactId)
		throws NoSuchProposalContactException;

	public ProposalContact updateImpl(ProposalContact proposalContact);

	/**
	 * Returns the proposal contact with the primary key or throws a <code>NoSuchProposalContactException</code> if it could not be found.
	 *
	 * @param proposalContactId the primary key of the proposal contact
	 * @return the proposal contact
	 * @throws NoSuchProposalContactException if a proposal contact with the primary key could not be found
	 */
	public ProposalContact findByPrimaryKey(long proposalContactId)
		throws NoSuchProposalContactException;

	/**
	 * Returns the proposal contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proposalContactId the primary key of the proposal contact
	 * @return the proposal contact, or <code>null</code> if a proposal contact with the primary key could not be found
	 */
	public ProposalContact fetchByPrimaryKey(long proposalContactId);

	/**
	 * Returns all the proposal contacts.
	 *
	 * @return the proposal contacts
	 */
	public java.util.List<ProposalContact> findAll();

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
	public java.util.List<ProposalContact> findAll(int start, int end);

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
	public java.util.List<ProposalContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProposalContact>
			orderByComparator);

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
	public java.util.List<ProposalContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProposalContact>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the proposal contacts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of proposal contacts.
	 *
	 * @return the number of proposal contacts
	 */
	public int countAll();

}
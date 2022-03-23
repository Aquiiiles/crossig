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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import hr.crosig.proposal.exception.NoSuchProposalException;
import hr.crosig.proposal.model.Proposal;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the proposal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalUtil
 * @generated
 */
@ProviderType
public interface ProposalPersistence extends BasePersistence<Proposal> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProposalUtil} to access the proposal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the proposals where agentUserId = &#63;.
	 *
	 * @param agentUserId the agent user ID
	 * @return the matching proposals
	 */
	public java.util.List<Proposal> findByAgentUserId(long agentUserId);

	/**
	 * Returns a range of all the proposals where agentUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalModelImpl</code>.
	 * </p>
	 *
	 * @param agentUserId the agent user ID
	 * @param start the lower bound of the range of proposals
	 * @param end the upper bound of the range of proposals (not inclusive)
	 * @return the range of matching proposals
	 */
	public java.util.List<Proposal> findByAgentUserId(
		long agentUserId, int start, int end);

	/**
	 * Returns an ordered range of all the proposals where agentUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalModelImpl</code>.
	 * </p>
	 *
	 * @param agentUserId the agent user ID
	 * @param start the lower bound of the range of proposals
	 * @param end the upper bound of the range of proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposals
	 */
	public java.util.List<Proposal> findByAgentUserId(
		long agentUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal>
			orderByComparator);

	/**
	 * Returns an ordered range of all the proposals where agentUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalModelImpl</code>.
	 * </p>
	 *
	 * @param agentUserId the agent user ID
	 * @param start the lower bound of the range of proposals
	 * @param end the upper bound of the range of proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proposals
	 */
	public java.util.List<Proposal> findByAgentUserId(
		long agentUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first proposal in the ordered set where agentUserId = &#63;.
	 *
	 * @param agentUserId the agent user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal
	 * @throws NoSuchProposalException if a matching proposal could not be found
	 */
	public Proposal findByAgentUserId_First(
			long agentUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Proposal>
				orderByComparator)
		throws NoSuchProposalException;

	/**
	 * Returns the first proposal in the ordered set where agentUserId = &#63;.
	 *
	 * @param agentUserId the agent user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal, or <code>null</code> if a matching proposal could not be found
	 */
	public Proposal fetchByAgentUserId_First(
		long agentUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal>
			orderByComparator);

	/**
	 * Returns the last proposal in the ordered set where agentUserId = &#63;.
	 *
	 * @param agentUserId the agent user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal
	 * @throws NoSuchProposalException if a matching proposal could not be found
	 */
	public Proposal findByAgentUserId_Last(
			long agentUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Proposal>
				orderByComparator)
		throws NoSuchProposalException;

	/**
	 * Returns the last proposal in the ordered set where agentUserId = &#63;.
	 *
	 * @param agentUserId the agent user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal, or <code>null</code> if a matching proposal could not be found
	 */
	public Proposal fetchByAgentUserId_Last(
		long agentUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal>
			orderByComparator);

	/**
	 * Returns the proposals before and after the current proposal in the ordered set where agentUserId = &#63;.
	 *
	 * @param proposalId the primary key of the current proposal
	 * @param agentUserId the agent user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposal
	 * @throws NoSuchProposalException if a proposal with the primary key could not be found
	 */
	public Proposal[] findByAgentUserId_PrevAndNext(
			long proposalId, long agentUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Proposal>
				orderByComparator)
		throws NoSuchProposalException;

	/**
	 * Removes all the proposals where agentUserId = &#63; from the database.
	 *
	 * @param agentUserId the agent user ID
	 */
	public void removeByAgentUserId(long agentUserId);

	/**
	 * Returns the number of proposals where agentUserId = &#63;.
	 *
	 * @param agentUserId the agent user ID
	 * @return the number of matching proposals
	 */
	public int countByAgentUserId(long agentUserId);

	/**
	 * Caches the proposal in the entity cache if it is enabled.
	 *
	 * @param proposal the proposal
	 */
	public void cacheResult(Proposal proposal);

	/**
	 * Caches the proposals in the entity cache if it is enabled.
	 *
	 * @param proposals the proposals
	 */
	public void cacheResult(java.util.List<Proposal> proposals);

	/**
	 * Creates a new proposal with the primary key. Does not add the proposal to the database.
	 *
	 * @param proposalId the primary key for the new proposal
	 * @return the new proposal
	 */
	public Proposal create(long proposalId);

	/**
	 * Removes the proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proposalId the primary key of the proposal
	 * @return the proposal that was removed
	 * @throws NoSuchProposalException if a proposal with the primary key could not be found
	 */
	public Proposal remove(long proposalId) throws NoSuchProposalException;

	public Proposal updateImpl(Proposal proposal);

	/**
	 * Returns the proposal with the primary key or throws a <code>NoSuchProposalException</code> if it could not be found.
	 *
	 * @param proposalId the primary key of the proposal
	 * @return the proposal
	 * @throws NoSuchProposalException if a proposal with the primary key could not be found
	 */
	public Proposal findByPrimaryKey(long proposalId)
		throws NoSuchProposalException;

	/**
	 * Returns the proposal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proposalId the primary key of the proposal
	 * @return the proposal, or <code>null</code> if a proposal with the primary key could not be found
	 */
	public Proposal fetchByPrimaryKey(long proposalId);

	/**
	 * Returns all the proposals.
	 *
	 * @return the proposals
	 */
	public java.util.List<Proposal> findAll();

	/**
	 * Returns a range of all the proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposals
	 * @param end the upper bound of the range of proposals (not inclusive)
	 * @return the range of proposals
	 */
	public java.util.List<Proposal> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposals
	 * @param end the upper bound of the range of proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proposals
	 */
	public java.util.List<Proposal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal>
			orderByComparator);

	/**
	 * Returns an ordered range of all the proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposals
	 * @param end the upper bound of the range of proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of proposals
	 */
	public java.util.List<Proposal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the proposals from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of proposals.
	 *
	 * @return the number of proposals
	 */
	public int countAll();

}
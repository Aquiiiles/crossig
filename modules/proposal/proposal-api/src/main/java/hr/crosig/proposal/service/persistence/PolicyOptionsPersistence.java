/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import hr.crosig.proposal.exception.NoSuchPolicyOptionsException;
import hr.crosig.proposal.model.PolicyOptions;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the policy options service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyOptionsUtil
 * @generated
 */
@ProviderType
public interface PolicyOptionsPersistence
	extends BasePersistence<PolicyOptions> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PolicyOptionsUtil} to access the policy options persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the policy options where proposalId = &#63; or throws a <code>NoSuchPolicyOptionsException</code> if it could not be found.
	 *
	 * @param proposalId the proposal ID
	 * @return the matching policy options
	 * @throws NoSuchPolicyOptionsException if a matching policy options could not be found
	 */
	public PolicyOptions findByProposalId(long proposalId)
		throws NoSuchPolicyOptionsException;

	/**
	 * Returns the policy options where proposalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param proposalId the proposal ID
	 * @return the matching policy options, or <code>null</code> if a matching policy options could not be found
	 */
	public PolicyOptions fetchByProposalId(long proposalId);

	/**
	 * Returns the policy options where proposalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param proposalId the proposal ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy options, or <code>null</code> if a matching policy options could not be found
	 */
	public PolicyOptions fetchByProposalId(
		long proposalId, boolean useFinderCache);

	/**
	 * Removes the policy options where proposalId = &#63; from the database.
	 *
	 * @param proposalId the proposal ID
	 * @return the policy options that was removed
	 */
	public PolicyOptions removeByProposalId(long proposalId)
		throws NoSuchPolicyOptionsException;

	/**
	 * Returns the number of policy optionses where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the number of matching policy optionses
	 */
	public int countByProposalId(long proposalId);

	/**
	 * Caches the policy options in the entity cache if it is enabled.
	 *
	 * @param policyOptions the policy options
	 */
	public void cacheResult(PolicyOptions policyOptions);

	/**
	 * Caches the policy optionses in the entity cache if it is enabled.
	 *
	 * @param policyOptionses the policy optionses
	 */
	public void cacheResult(java.util.List<PolicyOptions> policyOptionses);

	/**
	 * Creates a new policy options with the primary key. Does not add the policy options to the database.
	 *
	 * @param policyOptionsId the primary key for the new policy options
	 * @return the new policy options
	 */
	public PolicyOptions create(long policyOptionsId);

	/**
	 * Removes the policy options with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyOptionsId the primary key of the policy options
	 * @return the policy options that was removed
	 * @throws NoSuchPolicyOptionsException if a policy options with the primary key could not be found
	 */
	public PolicyOptions remove(long policyOptionsId)
		throws NoSuchPolicyOptionsException;

	public PolicyOptions updateImpl(PolicyOptions policyOptions);

	/**
	 * Returns the policy options with the primary key or throws a <code>NoSuchPolicyOptionsException</code> if it could not be found.
	 *
	 * @param policyOptionsId the primary key of the policy options
	 * @return the policy options
	 * @throws NoSuchPolicyOptionsException if a policy options with the primary key could not be found
	 */
	public PolicyOptions findByPrimaryKey(long policyOptionsId)
		throws NoSuchPolicyOptionsException;

	/**
	 * Returns the policy options with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyOptionsId the primary key of the policy options
	 * @return the policy options, or <code>null</code> if a policy options with the primary key could not be found
	 */
	public PolicyOptions fetchByPrimaryKey(long policyOptionsId);

	/**
	 * Returns all the policy optionses.
	 *
	 * @return the policy optionses
	 */
	public java.util.List<PolicyOptions> findAll();

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
	public java.util.List<PolicyOptions> findAll(int start, int end);

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
	public java.util.List<PolicyOptions> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyOptions>
			orderByComparator);

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
	public java.util.List<PolicyOptions> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyOptions>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the policy optionses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of policy optionses.
	 *
	 * @return the number of policy optionses
	 */
	public int countAll();

}
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

import hr.crosig.proposal.exception.NoSuchPolicyCoverageOptException;
import hr.crosig.proposal.model.PolicyCoverageOpt;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the policy coverage opt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCoverageOptUtil
 * @generated
 */
@ProviderType
public interface PolicyCoverageOptPersistence
	extends BasePersistence<PolicyCoverageOpt> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PolicyCoverageOptUtil} to access the policy coverage opt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the policy coverage opt in the entity cache if it is enabled.
	 *
	 * @param policyCoverageOpt the policy coverage opt
	 */
	public void cacheResult(PolicyCoverageOpt policyCoverageOpt);

	/**
	 * Caches the policy coverage opts in the entity cache if it is enabled.
	 *
	 * @param policyCoverageOpts the policy coverage opts
	 */
	public void cacheResult(
		java.util.List<PolicyCoverageOpt> policyCoverageOpts);

	/**
	 * Creates a new policy coverage opt with the primary key. Does not add the policy coverage opt to the database.
	 *
	 * @param policyCoverageOptionId the primary key for the new policy coverage opt
	 * @return the new policy coverage opt
	 */
	public PolicyCoverageOpt create(long policyCoverageOptionId);

	/**
	 * Removes the policy coverage opt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage opt
	 * @return the policy coverage opt that was removed
	 * @throws NoSuchPolicyCoverageOptException if a policy coverage opt with the primary key could not be found
	 */
	public PolicyCoverageOpt remove(long policyCoverageOptionId)
		throws NoSuchPolicyCoverageOptException;

	public PolicyCoverageOpt updateImpl(PolicyCoverageOpt policyCoverageOpt);

	/**
	 * Returns the policy coverage opt with the primary key or throws a <code>NoSuchPolicyCoverageOptException</code> if it could not be found.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage opt
	 * @return the policy coverage opt
	 * @throws NoSuchPolicyCoverageOptException if a policy coverage opt with the primary key could not be found
	 */
	public PolicyCoverageOpt findByPrimaryKey(long policyCoverageOptionId)
		throws NoSuchPolicyCoverageOptException;

	/**
	 * Returns the policy coverage opt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage opt
	 * @return the policy coverage opt, or <code>null</code> if a policy coverage opt with the primary key could not be found
	 */
	public PolicyCoverageOpt fetchByPrimaryKey(long policyCoverageOptionId);

	/**
	 * Returns all the policy coverage opts.
	 *
	 * @return the policy coverage opts
	 */
	public java.util.List<PolicyCoverageOpt> findAll();

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
	public java.util.List<PolicyCoverageOpt> findAll(int start, int end);

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
	public java.util.List<PolicyCoverageOpt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyCoverageOpt>
			orderByComparator);

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
	public java.util.List<PolicyCoverageOpt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyCoverageOpt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the policy coverage opts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of policy coverage opts.
	 *
	 * @return the number of policy coverage opts
	 */
	public int countAll();

}
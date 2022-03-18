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

import hr.crosig.proposal.exception.NoSuchPolicyCoverageOptionException;
import hr.crosig.proposal.model.PolicyCoverageOption;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the policy coverage option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCoverageOptionUtil
 * @generated
 */
@ProviderType
public interface PolicyCoverageOptionPersistence
	extends BasePersistence<PolicyCoverageOption> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PolicyCoverageOptionUtil} to access the policy coverage option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the policy coverage option in the entity cache if it is enabled.
	 *
	 * @param policyCoverageOption the policy coverage option
	 */
	public void cacheResult(PolicyCoverageOption policyCoverageOption);

	/**
	 * Caches the policy coverage options in the entity cache if it is enabled.
	 *
	 * @param policyCoverageOptions the policy coverage options
	 */
	public void cacheResult(
		java.util.List<PolicyCoverageOption> policyCoverageOptions);

	/**
	 * Creates a new policy coverage option with the primary key. Does not add the policy coverage option to the database.
	 *
	 * @param policyCoverageOptionId the primary key for the new policy coverage option
	 * @return the new policy coverage option
	 */
	public PolicyCoverageOption create(long policyCoverageOptionId);

	/**
	 * Removes the policy coverage option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage option
	 * @return the policy coverage option that was removed
	 * @throws NoSuchPolicyCoverageOptionException if a policy coverage option with the primary key could not be found
	 */
	public PolicyCoverageOption remove(long policyCoverageOptionId)
		throws NoSuchPolicyCoverageOptionException;

	public PolicyCoverageOption updateImpl(
		PolicyCoverageOption policyCoverageOption);

	/**
	 * Returns the policy coverage option with the primary key or throws a <code>NoSuchPolicyCoverageOptionException</code> if it could not be found.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage option
	 * @return the policy coverage option
	 * @throws NoSuchPolicyCoverageOptionException if a policy coverage option with the primary key could not be found
	 */
	public PolicyCoverageOption findByPrimaryKey(long policyCoverageOptionId)
		throws NoSuchPolicyCoverageOptionException;

	/**
	 * Returns the policy coverage option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage option
	 * @return the policy coverage option, or <code>null</code> if a policy coverage option with the primary key could not be found
	 */
	public PolicyCoverageOption fetchByPrimaryKey(long policyCoverageOptionId);

	/**
	 * Returns all the policy coverage options.
	 *
	 * @return the policy coverage options
	 */
	public java.util.List<PolicyCoverageOption> findAll();

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
	public java.util.List<PolicyCoverageOption> findAll(int start, int end);

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
	public java.util.List<PolicyCoverageOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyCoverageOption>
			orderByComparator);

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
	public java.util.List<PolicyCoverageOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyCoverageOption>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the policy coverage options from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of policy coverage options.
	 *
	 * @return the number of policy coverage options
	 */
	public int countAll();

}
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import hr.crosig.proposal.exception.NoSuchInsuredRoleException;
import hr.crosig.proposal.model.InsuredRole;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the insured role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InsuredRoleUtil
 * @generated
 */
@ProviderType
public interface InsuredRolePersistence extends BasePersistence<InsuredRole> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InsuredRoleUtil} to access the insured role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the insured role where InsuredRoleId = &#63; or throws a <code>NoSuchInsuredRoleException</code> if it could not be found.
	 *
	 * @param InsuredRoleId the insured role ID
	 * @return the matching insured role
	 * @throws NoSuchInsuredRoleException if a matching insured role could not be found
	 */
	public InsuredRole findByInsuredRoleId(long InsuredRoleId)
		throws NoSuchInsuredRoleException;

	/**
	 * Returns the insured role where InsuredRoleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param InsuredRoleId the insured role ID
	 * @return the matching insured role, or <code>null</code> if a matching insured role could not be found
	 */
	public InsuredRole fetchByInsuredRoleId(long InsuredRoleId);

	/**
	 * Returns the insured role where InsuredRoleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param InsuredRoleId the insured role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching insured role, or <code>null</code> if a matching insured role could not be found
	 */
	public InsuredRole fetchByInsuredRoleId(
		long InsuredRoleId, boolean useFinderCache);

	/**
	 * Removes the insured role where InsuredRoleId = &#63; from the database.
	 *
	 * @param InsuredRoleId the insured role ID
	 * @return the insured role that was removed
	 */
	public InsuredRole removeByInsuredRoleId(long InsuredRoleId)
		throws NoSuchInsuredRoleException;

	/**
	 * Returns the number of insured roles where InsuredRoleId = &#63;.
	 *
	 * @param InsuredRoleId the insured role ID
	 * @return the number of matching insured roles
	 */
	public int countByInsuredRoleId(long InsuredRoleId);

	/**
	 * Caches the insured role in the entity cache if it is enabled.
	 *
	 * @param insuredRole the insured role
	 */
	public void cacheResult(InsuredRole insuredRole);

	/**
	 * Caches the insured roles in the entity cache if it is enabled.
	 *
	 * @param insuredRoles the insured roles
	 */
	public void cacheResult(java.util.List<InsuredRole> insuredRoles);

	/**
	 * Creates a new insured role with the primary key. Does not add the insured role to the database.
	 *
	 * @param InsuredRoleId the primary key for the new insured role
	 * @return the new insured role
	 */
	public InsuredRole create(long InsuredRoleId);

	/**
	 * Removes the insured role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param InsuredRoleId the primary key of the insured role
	 * @return the insured role that was removed
	 * @throws NoSuchInsuredRoleException if a insured role with the primary key could not be found
	 */
	public InsuredRole remove(long InsuredRoleId)
		throws NoSuchInsuredRoleException;

	public InsuredRole updateImpl(InsuredRole insuredRole);

	/**
	 * Returns the insured role with the primary key or throws a <code>NoSuchInsuredRoleException</code> if it could not be found.
	 *
	 * @param InsuredRoleId the primary key of the insured role
	 * @return the insured role
	 * @throws NoSuchInsuredRoleException if a insured role with the primary key could not be found
	 */
	public InsuredRole findByPrimaryKey(long InsuredRoleId)
		throws NoSuchInsuredRoleException;

	/**
	 * Returns the insured role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param InsuredRoleId the primary key of the insured role
	 * @return the insured role, or <code>null</code> if a insured role with the primary key could not be found
	 */
	public InsuredRole fetchByPrimaryKey(long InsuredRoleId);

	/**
	 * Returns all the insured roles.
	 *
	 * @return the insured roles
	 */
	public java.util.List<InsuredRole> findAll();

	/**
	 * Returns a range of all the insured roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InsuredRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insured roles
	 * @param end the upper bound of the range of insured roles (not inclusive)
	 * @return the range of insured roles
	 */
	public java.util.List<InsuredRole> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the insured roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InsuredRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insured roles
	 * @param end the upper bound of the range of insured roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of insured roles
	 */
	public java.util.List<InsuredRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InsuredRole>
			orderByComparator);

	/**
	 * Returns an ordered range of all the insured roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InsuredRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insured roles
	 * @param end the upper bound of the range of insured roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of insured roles
	 */
	public java.util.List<InsuredRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InsuredRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the insured roles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of insured roles.
	 *
	 * @return the number of insured roles
	 */
	public int countAll();

}
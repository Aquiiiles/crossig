/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import hr.crosig.proposal.exception.NoSuchProductRoleException;
import hr.crosig.proposal.model.ProductRole;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductRoleUtil
 * @generated
 */
@ProviderType
public interface ProductRolePersistence extends BasePersistence<ProductRole> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductRoleUtil} to access the product role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the product roles where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the matching product roles
	 */
	public java.util.List<ProductRole> findByRoleId(long roleId);

	/**
	 * Returns a range of all the product roles where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of product roles
	 * @param end the upper bound of the range of product roles (not inclusive)
	 * @return the range of matching product roles
	 */
	public java.util.List<ProductRole> findByRoleId(
		long roleId, int start, int end);

	/**
	 * Returns an ordered range of all the product roles where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of product roles
	 * @param end the upper bound of the range of product roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product roles
	 */
	public java.util.List<ProductRole> findByRoleId(
		long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductRole>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product roles where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of product roles
	 * @param end the upper bound of the range of product roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product roles
	 */
	public java.util.List<ProductRole> findByRoleId(
		long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product role in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product role
	 * @throws NoSuchProductRoleException if a matching product role could not be found
	 */
	public ProductRole findByRoleId_First(
			long roleId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductRole>
				orderByComparator)
		throws NoSuchProductRoleException;

	/**
	 * Returns the first product role in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product role, or <code>null</code> if a matching product role could not be found
	 */
	public ProductRole fetchByRoleId_First(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductRole>
			orderByComparator);

	/**
	 * Returns the last product role in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product role
	 * @throws NoSuchProductRoleException if a matching product role could not be found
	 */
	public ProductRole findByRoleId_Last(
			long roleId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductRole>
				orderByComparator)
		throws NoSuchProductRoleException;

	/**
	 * Returns the last product role in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product role, or <code>null</code> if a matching product role could not be found
	 */
	public ProductRole fetchByRoleId_Last(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductRole>
			orderByComparator);

	/**
	 * Returns the product roles before and after the current product role in the ordered set where roleId = &#63;.
	 *
	 * @param productRoleId the primary key of the current product role
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product role
	 * @throws NoSuchProductRoleException if a product role with the primary key could not be found
	 */
	public ProductRole[] findByRoleId_PrevAndNext(
			long productRoleId, long roleId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductRole>
				orderByComparator)
		throws NoSuchProductRoleException;

	/**
	 * Removes all the product roles where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 */
	public void removeByRoleId(long roleId);

	/**
	 * Returns the number of product roles where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching product roles
	 */
	public int countByRoleId(long roleId);

	/**
	 * Caches the product role in the entity cache if it is enabled.
	 *
	 * @param productRole the product role
	 */
	public void cacheResult(ProductRole productRole);

	/**
	 * Caches the product roles in the entity cache if it is enabled.
	 *
	 * @param productRoles the product roles
	 */
	public void cacheResult(java.util.List<ProductRole> productRoles);

	/**
	 * Creates a new product role with the primary key. Does not add the product role to the database.
	 *
	 * @param productRoleId the primary key for the new product role
	 * @return the new product role
	 */
	public ProductRole create(long productRoleId);

	/**
	 * Removes the product role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productRoleId the primary key of the product role
	 * @return the product role that was removed
	 * @throws NoSuchProductRoleException if a product role with the primary key could not be found
	 */
	public ProductRole remove(long productRoleId)
		throws NoSuchProductRoleException;

	public ProductRole updateImpl(ProductRole productRole);

	/**
	 * Returns the product role with the primary key or throws a <code>NoSuchProductRoleException</code> if it could not be found.
	 *
	 * @param productRoleId the primary key of the product role
	 * @return the product role
	 * @throws NoSuchProductRoleException if a product role with the primary key could not be found
	 */
	public ProductRole findByPrimaryKey(long productRoleId)
		throws NoSuchProductRoleException;

	/**
	 * Returns the product role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productRoleId the primary key of the product role
	 * @return the product role, or <code>null</code> if a product role with the primary key could not be found
	 */
	public ProductRole fetchByPrimaryKey(long productRoleId);

	/**
	 * Returns all the product roles.
	 *
	 * @return the product roles
	 */
	public java.util.List<ProductRole> findAll();

	/**
	 * Returns a range of all the product roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product roles
	 * @param end the upper bound of the range of product roles (not inclusive)
	 * @return the range of product roles
	 */
	public java.util.List<ProductRole> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the product roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product roles
	 * @param end the upper bound of the range of product roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product roles
	 */
	public java.util.List<ProductRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductRole>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product roles
	 * @param end the upper bound of the range of product roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product roles
	 */
	public java.util.List<ProductRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product roles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product roles.
	 *
	 * @return the number of product roles
	 */
	public int countAll();

}
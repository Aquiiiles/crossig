/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import hr.crosig.proposal.exception.NoSuchCoveragePlanException;
import hr.crosig.proposal.model.CoveragePlan;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the coverage plan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CoveragePlanUtil
 * @generated
 */
@ProviderType
public interface CoveragePlanPersistence extends BasePersistence<CoveragePlan> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CoveragePlanUtil} to access the coverage plan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the coverage plan where name = &#63; or throws a <code>NoSuchCoveragePlanException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching coverage plan
	 * @throws NoSuchCoveragePlanException if a matching coverage plan could not be found
	 */
	public CoveragePlan findByName(String name)
		throws NoSuchCoveragePlanException;

	/**
	 * Returns the coverage plan where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching coverage plan, or <code>null</code> if a matching coverage plan could not be found
	 */
	public CoveragePlan fetchByName(String name);

	/**
	 * Returns the coverage plan where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching coverage plan, or <code>null</code> if a matching coverage plan could not be found
	 */
	public CoveragePlan fetchByName(String name, boolean useFinderCache);

	/**
	 * Removes the coverage plan where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the coverage plan that was removed
	 */
	public CoveragePlan removeByName(String name)
		throws NoSuchCoveragePlanException;

	/**
	 * Returns the number of coverage plans where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching coverage plans
	 */
	public int countByName(String name);

	/**
	 * Returns all the coverage plans where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching coverage plans
	 */
	public java.util.List<CoveragePlan> findByCategory(String category);

	/**
	 * Returns a range of all the coverage plans where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of coverage plans
	 * @param end the upper bound of the range of coverage plans (not inclusive)
	 * @return the range of matching coverage plans
	 */
	public java.util.List<CoveragePlan> findByCategory(
		String category, int start, int end);

	/**
	 * Returns an ordered range of all the coverage plans where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of coverage plans
	 * @param end the upper bound of the range of coverage plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coverage plans
	 */
	public java.util.List<CoveragePlan> findByCategory(
		String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CoveragePlan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the coverage plans where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of coverage plans
	 * @param end the upper bound of the range of coverage plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching coverage plans
	 */
	public java.util.List<CoveragePlan> findByCategory(
		String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CoveragePlan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first coverage plan in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coverage plan
	 * @throws NoSuchCoveragePlanException if a matching coverage plan could not be found
	 */
	public CoveragePlan findByCategory_First(
			String category,
			com.liferay.portal.kernel.util.OrderByComparator<CoveragePlan>
				orderByComparator)
		throws NoSuchCoveragePlanException;

	/**
	 * Returns the first coverage plan in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coverage plan, or <code>null</code> if a matching coverage plan could not be found
	 */
	public CoveragePlan fetchByCategory_First(
		String category,
		com.liferay.portal.kernel.util.OrderByComparator<CoveragePlan>
			orderByComparator);

	/**
	 * Returns the last coverage plan in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coverage plan
	 * @throws NoSuchCoveragePlanException if a matching coverage plan could not be found
	 */
	public CoveragePlan findByCategory_Last(
			String category,
			com.liferay.portal.kernel.util.OrderByComparator<CoveragePlan>
				orderByComparator)
		throws NoSuchCoveragePlanException;

	/**
	 * Returns the last coverage plan in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coverage plan, or <code>null</code> if a matching coverage plan could not be found
	 */
	public CoveragePlan fetchByCategory_Last(
		String category,
		com.liferay.portal.kernel.util.OrderByComparator<CoveragePlan>
			orderByComparator);

	/**
	 * Returns the coverage plans before and after the current coverage plan in the ordered set where category = &#63;.
	 *
	 * @param coveragePlanId the primary key of the current coverage plan
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coverage plan
	 * @throws NoSuchCoveragePlanException if a coverage plan with the primary key could not be found
	 */
	public CoveragePlan[] findByCategory_PrevAndNext(
			long coveragePlanId, String category,
			com.liferay.portal.kernel.util.OrderByComparator<CoveragePlan>
				orderByComparator)
		throws NoSuchCoveragePlanException;

	/**
	 * Removes all the coverage plans where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	public void removeByCategory(String category);

	/**
	 * Returns the number of coverage plans where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching coverage plans
	 */
	public int countByCategory(String category);

	/**
	 * Caches the coverage plan in the entity cache if it is enabled.
	 *
	 * @param coveragePlan the coverage plan
	 */
	public void cacheResult(CoveragePlan coveragePlan);

	/**
	 * Caches the coverage plans in the entity cache if it is enabled.
	 *
	 * @param coveragePlans the coverage plans
	 */
	public void cacheResult(java.util.List<CoveragePlan> coveragePlans);

	/**
	 * Creates a new coverage plan with the primary key. Does not add the coverage plan to the database.
	 *
	 * @param coveragePlanId the primary key for the new coverage plan
	 * @return the new coverage plan
	 */
	public CoveragePlan create(long coveragePlanId);

	/**
	 * Removes the coverage plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coveragePlanId the primary key of the coverage plan
	 * @return the coverage plan that was removed
	 * @throws NoSuchCoveragePlanException if a coverage plan with the primary key could not be found
	 */
	public CoveragePlan remove(long coveragePlanId)
		throws NoSuchCoveragePlanException;

	public CoveragePlan updateImpl(CoveragePlan coveragePlan);

	/**
	 * Returns the coverage plan with the primary key or throws a <code>NoSuchCoveragePlanException</code> if it could not be found.
	 *
	 * @param coveragePlanId the primary key of the coverage plan
	 * @return the coverage plan
	 * @throws NoSuchCoveragePlanException if a coverage plan with the primary key could not be found
	 */
	public CoveragePlan findByPrimaryKey(long coveragePlanId)
		throws NoSuchCoveragePlanException;

	/**
	 * Returns the coverage plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coveragePlanId the primary key of the coverage plan
	 * @return the coverage plan, or <code>null</code> if a coverage plan with the primary key could not be found
	 */
	public CoveragePlan fetchByPrimaryKey(long coveragePlanId);

	/**
	 * Returns all the coverage plans.
	 *
	 * @return the coverage plans
	 */
	public java.util.List<CoveragePlan> findAll();

	/**
	 * Returns a range of all the coverage plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coverage plans
	 * @param end the upper bound of the range of coverage plans (not inclusive)
	 * @return the range of coverage plans
	 */
	public java.util.List<CoveragePlan> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the coverage plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coverage plans
	 * @param end the upper bound of the range of coverage plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of coverage plans
	 */
	public java.util.List<CoveragePlan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CoveragePlan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the coverage plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coverage plans
	 * @param end the upper bound of the range of coverage plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of coverage plans
	 */
	public java.util.List<CoveragePlan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CoveragePlan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the coverage plans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of coverage plans.
	 *
	 * @return the number of coverage plans
	 */
	public int countAll();

}
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

package hr.crosig.contact.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import hr.crosig.contact.exception.NoSuchStreetException;
import hr.crosig.contact.model.Street;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the street service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StreetUtil
 * @generated
 */
@ProviderType
public interface StreetPersistence extends BasePersistence<Street> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StreetUtil} to access the street persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the street where name = &#63; or throws a <code>NoSuchStreetException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByName(String name) throws NoSuchStreetException;

	/**
	 * Returns the street where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByName(String name);

	/**
	 * Returns the street where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByName(String name, boolean useFinderCache);

	/**
	 * Removes the street where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the street that was removed
	 */
	public Street removeByName(String name) throws NoSuchStreetException;

	/**
	 * Returns the number of streets where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching streets
	 */
	public int countByName(String name);

	/**
	 * Returns all the streets where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @return the matching streets
	 */
	public java.util.List<Street> findByCityId(long cityId);

	/**
	 * Returns a range of all the streets where cityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @return the range of matching streets
	 */
	public java.util.List<Street> findByCityId(long cityId, int start, int end);

	/**
	 * Returns an ordered range of all the streets where cityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching streets
	 */
	public java.util.List<Street> findByCityId(
		long cityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Street>
			orderByComparator);

	/**
	 * Returns an ordered range of all the streets where cityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching streets
	 */
	public java.util.List<Street> findByCityId(
		long cityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Street>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first street in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByCityId_First(
			long cityId,
			com.liferay.portal.kernel.util.OrderByComparator<Street>
				orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Returns the first street in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByCityId_First(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator<Street>
			orderByComparator);

	/**
	 * Returns the last street in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByCityId_Last(
			long cityId,
			com.liferay.portal.kernel.util.OrderByComparator<Street>
				orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Returns the last street in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByCityId_Last(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator<Street>
			orderByComparator);

	/**
	 * Returns the streets before and after the current street in the ordered set where cityId = &#63;.
	 *
	 * @param streetId the primary key of the current street
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	public Street[] findByCityId_PrevAndNext(
			long streetId, long cityId,
			com.liferay.portal.kernel.util.OrderByComparator<Street>
				orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Removes all the streets where cityId = &#63; from the database.
	 *
	 * @param cityId the city ID
	 */
	public void removeByCityId(long cityId);

	/**
	 * Returns the number of streets where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @return the number of matching streets
	 */
	public int countByCityId(long cityId);

	/**
	 * Returns all the streets where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @return the matching streets
	 */
	public java.util.List<Street> findByCityId_Name(long cityId, String name);

	/**
	 * Returns a range of all the streets where cityId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @return the range of matching streets
	 */
	public java.util.List<Street> findByCityId_Name(
		long cityId, String name, int start, int end);

	/**
	 * Returns an ordered range of all the streets where cityId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching streets
	 */
	public java.util.List<Street> findByCityId_Name(
		long cityId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Street>
			orderByComparator);

	/**
	 * Returns an ordered range of all the streets where cityId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching streets
	 */
	public java.util.List<Street> findByCityId_Name(
		long cityId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Street>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first street in the ordered set where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByCityId_Name_First(
			long cityId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Street>
				orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Returns the first street in the ordered set where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByCityId_Name_First(
		long cityId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<Street>
			orderByComparator);

	/**
	 * Returns the last street in the ordered set where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	public Street findByCityId_Name_Last(
			long cityId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Street>
				orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Returns the last street in the ordered set where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	public Street fetchByCityId_Name_Last(
		long cityId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<Street>
			orderByComparator);

	/**
	 * Returns the streets before and after the current street in the ordered set where cityId = &#63; and name = &#63;.
	 *
	 * @param streetId the primary key of the current street
	 * @param cityId the city ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	public Street[] findByCityId_Name_PrevAndNext(
			long streetId, long cityId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Street>
				orderByComparator)
		throws NoSuchStreetException;

	/**
	 * Removes all the streets where cityId = &#63; and name = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 */
	public void removeByCityId_Name(long cityId, String name);

	/**
	 * Returns the number of streets where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @return the number of matching streets
	 */
	public int countByCityId_Name(long cityId, String name);

	/**
	 * Caches the street in the entity cache if it is enabled.
	 *
	 * @param street the street
	 */
	public void cacheResult(Street street);

	/**
	 * Caches the streets in the entity cache if it is enabled.
	 *
	 * @param streets the streets
	 */
	public void cacheResult(java.util.List<Street> streets);

	/**
	 * Creates a new street with the primary key. Does not add the street to the database.
	 *
	 * @param streetId the primary key for the new street
	 * @return the new street
	 */
	public Street create(long streetId);

	/**
	 * Removes the street with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param streetId the primary key of the street
	 * @return the street that was removed
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	public Street remove(long streetId) throws NoSuchStreetException;

	public Street updateImpl(Street street);

	/**
	 * Returns the street with the primary key or throws a <code>NoSuchStreetException</code> if it could not be found.
	 *
	 * @param streetId the primary key of the street
	 * @return the street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	public Street findByPrimaryKey(long streetId) throws NoSuchStreetException;

	/**
	 * Returns the street with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param streetId the primary key of the street
	 * @return the street, or <code>null</code> if a street with the primary key could not be found
	 */
	public Street fetchByPrimaryKey(long streetId);

	/**
	 * Returns all the streets.
	 *
	 * @return the streets
	 */
	public java.util.List<Street> findAll();

	/**
	 * Returns a range of all the streets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @return the range of streets
	 */
	public java.util.List<Street> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the streets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of streets
	 */
	public java.util.List<Street> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Street>
			orderByComparator);

	/**
	 * Returns an ordered range of all the streets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StreetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of streets
	 * @param end the upper bound of the range of streets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of streets
	 */
	public java.util.List<Street> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Street>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the streets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of streets.
	 *
	 * @return the number of streets
	 */
	public int countAll();

}
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

package hr.crosig.contact.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import hr.crosig.contact.exception.NoSuchStreetException;
import hr.crosig.contact.model.Street;
import hr.crosig.contact.model.impl.StreetImpl;
import hr.crosig.contact.model.impl.StreetModelImpl;
import hr.crosig.contact.service.persistence.StreetPersistence;
import hr.crosig.contact.service.persistence.StreetUtil;
import hr.crosig.contact.service.persistence.impl.constants.AP_ContactPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the street service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StreetPersistence.class)
public class StreetPersistenceImpl
	extends BasePersistenceImpl<Street> implements StreetPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StreetUtil</code> to access the street persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StreetImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns the street where name = &#63; or throws a <code>NoSuchStreetException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	@Override
	public Street findByName(String name) throws NoSuchStreetException {
		Street street = fetchByName(name);

		if (street == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchStreetException(sb.toString());
		}

		return street;
	}

	/**
	 * Returns the street where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the street where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByName(String name, boolean useFinderCache) {
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByName, finderArgs, this);
		}

		if (result instanceof Street) {
			Street street = (Street)result;

			if (!Objects.equals(name, street.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_STREET_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				List<Street> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {name};
							}

							_log.warn(
								"StreetPersistenceImpl.fetchByName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Street street = list.get(0);

					result = street;

					cacheResult(street);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Street)result;
		}
	}

	/**
	 * Removes the street where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the street that was removed
	 */
	@Override
	public Street removeByName(String name) throws NoSuchStreetException {
		Street street = findByName(name);

		return remove(street);
	}

	/**
	 * Returns the number of streets where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching streets
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STREET_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_2 = "street.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(street.name IS NULL OR street.name = '')";

	private FinderPath _finderPathWithPaginationFindByCityId;
	private FinderPath _finderPathWithoutPaginationFindByCityId;
	private FinderPath _finderPathCountByCityId;

	/**
	 * Returns all the streets where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @return the matching streets
	 */
	@Override
	public List<Street> findByCityId(long cityId) {
		return findByCityId(cityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Street> findByCityId(long cityId, int start, int end) {
		return findByCityId(cityId, start, end, null);
	}

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
	@Override
	public List<Street> findByCityId(
		long cityId, int start, int end,
		OrderByComparator<Street> orderByComparator) {

		return findByCityId(cityId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Street> findByCityId(
		long cityId, int start, int end,
		OrderByComparator<Street> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCityId;
				finderArgs = new Object[] {cityId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCityId;
			finderArgs = new Object[] {cityId, start, end, orderByComparator};
		}

		List<Street> list = null;

		if (useFinderCache) {
			list = (List<Street>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Street street : list) {
					if (cityId != street.getCityId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_STREET_WHERE);

			sb.append(_FINDER_COLUMN_CITYID_CITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StreetModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(cityId);

				list = (List<Street>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first street in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	@Override
	public Street findByCityId_First(
			long cityId, OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = fetchByCityId_First(cityId, orderByComparator);

		if (street != null) {
			return street;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cityId=");
		sb.append(cityId);

		sb.append("}");

		throw new NoSuchStreetException(sb.toString());
	}

	/**
	 * Returns the first street in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByCityId_First(
		long cityId, OrderByComparator<Street> orderByComparator) {

		List<Street> list = findByCityId(cityId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last street in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	@Override
	public Street findByCityId_Last(
			long cityId, OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = fetchByCityId_Last(cityId, orderByComparator);

		if (street != null) {
			return street;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cityId=");
		sb.append(cityId);

		sb.append("}");

		throw new NoSuchStreetException(sb.toString());
	}

	/**
	 * Returns the last street in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByCityId_Last(
		long cityId, OrderByComparator<Street> orderByComparator) {

		int count = countByCityId(cityId);

		if (count == 0) {
			return null;
		}

		List<Street> list = findByCityId(
			cityId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the streets before and after the current street in the ordered set where cityId = &#63;.
	 *
	 * @param streetId the primary key of the current street
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	@Override
	public Street[] findByCityId_PrevAndNext(
			long streetId, long cityId,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = findByPrimaryKey(streetId);

		Session session = null;

		try {
			session = openSession();

			Street[] array = new StreetImpl[3];

			array[0] = getByCityId_PrevAndNext(
				session, street, cityId, orderByComparator, true);

			array[1] = street;

			array[2] = getByCityId_PrevAndNext(
				session, street, cityId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Street getByCityId_PrevAndNext(
		Session session, Street street, long cityId,
		OrderByComparator<Street> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STREET_WHERE);

		sb.append(_FINDER_COLUMN_CITYID_CITYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(StreetModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(cityId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(street)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Street> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the streets where cityId = &#63; from the database.
	 *
	 * @param cityId the city ID
	 */
	@Override
	public void removeByCityId(long cityId) {
		for (Street street :
				findByCityId(
					cityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(street);
		}
	}

	/**
	 * Returns the number of streets where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @return the number of matching streets
	 */
	@Override
	public int countByCityId(long cityId) {
		FinderPath finderPath = _finderPathCountByCityId;

		Object[] finderArgs = new Object[] {cityId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STREET_WHERE);

			sb.append(_FINDER_COLUMN_CITYID_CITYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(cityId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CITYID_CITYID_2 =
		"street.cityId = ?";

	private FinderPath _finderPathWithPaginationFindByCityId_Name;
	private FinderPath _finderPathWithoutPaginationFindByCityId_Name;
	private FinderPath _finderPathCountByCityId_Name;

	/**
	 * Returns all the streets where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @return the matching streets
	 */
	@Override
	public List<Street> findByCityId_Name(long cityId, String name) {
		return findByCityId_Name(
			cityId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Street> findByCityId_Name(
		long cityId, String name, int start, int end) {

		return findByCityId_Name(cityId, name, start, end, null);
	}

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
	@Override
	public List<Street> findByCityId_Name(
		long cityId, String name, int start, int end,
		OrderByComparator<Street> orderByComparator) {

		return findByCityId_Name(
			cityId, name, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Street> findByCityId_Name(
		long cityId, String name, int start, int end,
		OrderByComparator<Street> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCityId_Name;
				finderArgs = new Object[] {cityId, name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCityId_Name;
			finderArgs = new Object[] {
				cityId, name, start, end, orderByComparator
			};
		}

		List<Street> list = null;

		if (useFinderCache) {
			list = (List<Street>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Street street : list) {
					if ((cityId != street.getCityId()) ||
						!name.equals(street.getName())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_STREET_WHERE);

			sb.append(_FINDER_COLUMN_CITYID_NAME_CITYID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_CITYID_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_CITYID_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StreetModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(cityId);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<Street>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first street in the ordered set where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	@Override
	public Street findByCityId_Name_First(
			long cityId, String name,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = fetchByCityId_Name_First(
			cityId, name, orderByComparator);

		if (street != null) {
			return street;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cityId=");
		sb.append(cityId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchStreetException(sb.toString());
	}

	/**
	 * Returns the first street in the ordered set where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByCityId_Name_First(
		long cityId, String name, OrderByComparator<Street> orderByComparator) {

		List<Street> list = findByCityId_Name(
			cityId, name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last street in the ordered set where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street
	 * @throws NoSuchStreetException if a matching street could not be found
	 */
	@Override
	public Street findByCityId_Name_Last(
			long cityId, String name,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		Street street = fetchByCityId_Name_Last(
			cityId, name, orderByComparator);

		if (street != null) {
			return street;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cityId=");
		sb.append(cityId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchStreetException(sb.toString());
	}

	/**
	 * Returns the last street in the ordered set where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching street, or <code>null</code> if a matching street could not be found
	 */
	@Override
	public Street fetchByCityId_Name_Last(
		long cityId, String name, OrderByComparator<Street> orderByComparator) {

		int count = countByCityId_Name(cityId, name);

		if (count == 0) {
			return null;
		}

		List<Street> list = findByCityId_Name(
			cityId, name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Street[] findByCityId_Name_PrevAndNext(
			long streetId, long cityId, String name,
			OrderByComparator<Street> orderByComparator)
		throws NoSuchStreetException {

		name = Objects.toString(name, "");

		Street street = findByPrimaryKey(streetId);

		Session session = null;

		try {
			session = openSession();

			Street[] array = new StreetImpl[3];

			array[0] = getByCityId_Name_PrevAndNext(
				session, street, cityId, name, orderByComparator, true);

			array[1] = street;

			array[2] = getByCityId_Name_PrevAndNext(
				session, street, cityId, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Street getByCityId_Name_PrevAndNext(
		Session session, Street street, long cityId, String name,
		OrderByComparator<Street> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_STREET_WHERE);

		sb.append(_FINDER_COLUMN_CITYID_NAME_CITYID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_CITYID_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_CITYID_NAME_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(StreetModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(cityId);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(street)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Street> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the streets where cityId = &#63; and name = &#63; from the database.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 */
	@Override
	public void removeByCityId_Name(long cityId, String name) {
		for (Street street :
				findByCityId_Name(
					cityId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(street);
		}
	}

	/**
	 * Returns the number of streets where cityId = &#63; and name = &#63;.
	 *
	 * @param cityId the city ID
	 * @param name the name
	 * @return the number of matching streets
	 */
	@Override
	public int countByCityId_Name(long cityId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByCityId_Name;

		Object[] finderArgs = new Object[] {cityId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_STREET_WHERE);

			sb.append(_FINDER_COLUMN_CITYID_NAME_CITYID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_CITYID_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_CITYID_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(cityId);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CITYID_NAME_CITYID_2 =
		"street.cityId = ? AND ";

	private static final String _FINDER_COLUMN_CITYID_NAME_NAME_2 =
		"street.name = ?";

	private static final String _FINDER_COLUMN_CITYID_NAME_NAME_3 =
		"(street.name IS NULL OR street.name = '')";

	public StreetPersistenceImpl() {
		setModelClass(Street.class);

		setModelImplClass(StreetImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the street in the entity cache if it is enabled.
	 *
	 * @param street the street
	 */
	@Override
	public void cacheResult(Street street) {
		entityCache.putResult(StreetImpl.class, street.getPrimaryKey(), street);

		finderCache.putResult(
			_finderPathFetchByName, new Object[] {street.getName()}, street);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the streets in the entity cache if it is enabled.
	 *
	 * @param streets the streets
	 */
	@Override
	public void cacheResult(List<Street> streets) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (streets.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Street street : streets) {
			if (entityCache.getResult(
					StreetImpl.class, street.getPrimaryKey()) == null) {

				cacheResult(street);
			}
		}
	}

	/**
	 * Clears the cache for all streets.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StreetImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the street.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Street street) {
		entityCache.removeResult(StreetImpl.class, street);
	}

	@Override
	public void clearCache(List<Street> streets) {
		for (Street street : streets) {
			entityCache.removeResult(StreetImpl.class, street);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StreetImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(StreetModelImpl streetModelImpl) {
		Object[] args = new Object[] {streetModelImpl.getName()};

		finderCache.putResult(
			_finderPathCountByName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByName, args, streetModelImpl, false);
	}

	/**
	 * Creates a new street with the primary key. Does not add the street to the database.
	 *
	 * @param streetId the primary key for the new street
	 * @return the new street
	 */
	@Override
	public Street create(long streetId) {
		Street street = new StreetImpl();

		street.setNew(true);
		street.setPrimaryKey(streetId);

		street.setCompanyId(CompanyThreadLocal.getCompanyId());

		return street;
	}

	/**
	 * Removes the street with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param streetId the primary key of the street
	 * @return the street that was removed
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	@Override
	public Street remove(long streetId) throws NoSuchStreetException {
		return remove((Serializable)streetId);
	}

	/**
	 * Removes the street with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the street
	 * @return the street that was removed
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	@Override
	public Street remove(Serializable primaryKey) throws NoSuchStreetException {
		Session session = null;

		try {
			session = openSession();

			Street street = (Street)session.get(StreetImpl.class, primaryKey);

			if (street == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStreetException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(street);
		}
		catch (NoSuchStreetException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Street removeImpl(Street street) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(street)) {
				street = (Street)session.get(
					StreetImpl.class, street.getPrimaryKeyObj());
			}

			if (street != null) {
				session.delete(street);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (street != null) {
			clearCache(street);
		}

		return street;
	}

	@Override
	public Street updateImpl(Street street) {
		boolean isNew = street.isNew();

		if (!(street instanceof StreetModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(street.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(street);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in street proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Street implementation " +
					street.getClass());
		}

		StreetModelImpl streetModelImpl = (StreetModelImpl)street;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (street.getCreateDate() == null)) {
			if (serviceContext == null) {
				street.setCreateDate(date);
			}
			else {
				street.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!streetModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				street.setModifiedDate(date);
			}
			else {
				street.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(street);
			}
			else {
				street = (Street)session.merge(street);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(StreetImpl.class, streetModelImpl, false, true);

		cacheUniqueFindersCache(streetModelImpl);

		if (isNew) {
			street.setNew(false);
		}

		street.resetOriginalValues();

		return street;
	}

	/**
	 * Returns the street with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the street
	 * @return the street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	@Override
	public Street findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStreetException {

		Street street = fetchByPrimaryKey(primaryKey);

		if (street == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStreetException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return street;
	}

	/**
	 * Returns the street with the primary key or throws a <code>NoSuchStreetException</code> if it could not be found.
	 *
	 * @param streetId the primary key of the street
	 * @return the street
	 * @throws NoSuchStreetException if a street with the primary key could not be found
	 */
	@Override
	public Street findByPrimaryKey(long streetId) throws NoSuchStreetException {
		return findByPrimaryKey((Serializable)streetId);
	}

	/**
	 * Returns the street with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param streetId the primary key of the street
	 * @return the street, or <code>null</code> if a street with the primary key could not be found
	 */
	@Override
	public Street fetchByPrimaryKey(long streetId) {
		return fetchByPrimaryKey((Serializable)streetId);
	}

	/**
	 * Returns all the streets.
	 *
	 * @return the streets
	 */
	@Override
	public List<Street> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Street> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Street> findAll(
		int start, int end, OrderByComparator<Street> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Street> findAll(
		int start, int end, OrderByComparator<Street> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Street> list = null;

		if (useFinderCache) {
			list = (List<Street>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STREET);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STREET;

				sql = sql.concat(StreetModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Street>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the streets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Street street : findAll()) {
			remove(street);
		}
	}

	/**
	 * Returns the number of streets.
	 *
	 * @return the number of streets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STREET);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "streetId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STREET;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StreetModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the street persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new StreetModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Street.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByName = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_finderPathWithPaginationFindByCityId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCityId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"cityId"}, true);

		_finderPathWithoutPaginationFindByCityId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCityId",
			new String[] {Long.class.getName()}, new String[] {"cityId"}, true);

		_finderPathCountByCityId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCityId",
			new String[] {Long.class.getName()}, new String[] {"cityId"},
			false);

		_finderPathWithPaginationFindByCityId_Name = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCityId_Name",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"cityId", "name"}, true);

		_finderPathWithoutPaginationFindByCityId_Name = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCityId_Name",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"cityId", "name"}, true);

		_finderPathCountByCityId_Name = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCityId_Name",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"cityId", "name"}, false);

		_setStreetUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setStreetUtilPersistence(null);

		entityCache.removeCache(StreetImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setStreetUtilPersistence(
		StreetPersistence streetPersistence) {

		try {
			Field field = StreetUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, streetPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = AP_ContactPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AP_ContactPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AP_ContactPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_STREET =
		"SELECT street FROM Street street";

	private static final String _SQL_SELECT_STREET_WHERE =
		"SELECT street FROM Street street WHERE ";

	private static final String _SQL_COUNT_STREET =
		"SELECT COUNT(street) FROM Street street";

	private static final String _SQL_COUNT_STREET_WHERE =
		"SELECT COUNT(street) FROM Street street WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "street.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Street exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Street exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StreetPersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class StreetModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			StreetModelImpl streetModelImpl = (StreetModelImpl)baseModel;

			long columnBitmask = streetModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(streetModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= streetModelImpl.getColumnBitmask(
						columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(StreetPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(streetModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			StreetModelImpl streetModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = streetModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = streetModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= StreetModelImpl.getColumnBitmask("name");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}
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

package hr.crosig.proposal.service.persistence.impl;

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

import hr.crosig.proposal.exception.NoSuchCoveragePlanException;
import hr.crosig.proposal.model.CoveragePlan;
import hr.crosig.proposal.model.impl.CoveragePlanImpl;
import hr.crosig.proposal.model.impl.CoveragePlanModelImpl;
import hr.crosig.proposal.service.persistence.CoveragePlanPersistence;
import hr.crosig.proposal.service.persistence.CoveragePlanUtil;
import hr.crosig.proposal.service.persistence.impl.constants.AP_ProposalPersistenceConstants;

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
 * The persistence implementation for the coverage plan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CoveragePlanPersistence.class)
public class CoveragePlanPersistenceImpl
	extends BasePersistenceImpl<CoveragePlan>
	implements CoveragePlanPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CoveragePlanUtil</code> to access the coverage plan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CoveragePlanImpl.class.getName();

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
	 * Returns the coverage plan where name = &#63; or throws a <code>NoSuchCoveragePlanException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching coverage plan
	 * @throws NoSuchCoveragePlanException if a matching coverage plan could not be found
	 */
	@Override
	public CoveragePlan findByName(String name)
		throws NoSuchCoveragePlanException {

		CoveragePlan coveragePlan = fetchByName(name);

		if (coveragePlan == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCoveragePlanException(sb.toString());
		}

		return coveragePlan;
	}

	/**
	 * Returns the coverage plan where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching coverage plan, or <code>null</code> if a matching coverage plan could not be found
	 */
	@Override
	public CoveragePlan fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the coverage plan where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching coverage plan, or <code>null</code> if a matching coverage plan could not be found
	 */
	@Override
	public CoveragePlan fetchByName(String name, boolean useFinderCache) {
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

		if (result instanceof CoveragePlan) {
			CoveragePlan coveragePlan = (CoveragePlan)result;

			if (!Objects.equals(name, coveragePlan.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_COVERAGEPLAN_WHERE);

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

				List<CoveragePlan> list = query.list();

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
								"CoveragePlanPersistenceImpl.fetchByName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CoveragePlan coveragePlan = list.get(0);

					result = coveragePlan;

					cacheResult(coveragePlan);
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
			return (CoveragePlan)result;
		}
	}

	/**
	 * Removes the coverage plan where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the coverage plan that was removed
	 */
	@Override
	public CoveragePlan removeByName(String name)
		throws NoSuchCoveragePlanException {

		CoveragePlan coveragePlan = findByName(name);

		return remove(coveragePlan);
	}

	/**
	 * Returns the number of coverage plans where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching coverage plans
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COVERAGEPLAN_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"coveragePlan.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(coveragePlan.name IS NULL OR coveragePlan.name = '')";

	public CoveragePlanPersistenceImpl() {
		setModelClass(CoveragePlan.class);

		setModelImplClass(CoveragePlanImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the coverage plan in the entity cache if it is enabled.
	 *
	 * @param coveragePlan the coverage plan
	 */
	@Override
	public void cacheResult(CoveragePlan coveragePlan) {
		entityCache.putResult(
			CoveragePlanImpl.class, coveragePlan.getPrimaryKey(), coveragePlan);

		finderCache.putResult(
			_finderPathFetchByName, new Object[] {coveragePlan.getName()},
			coveragePlan);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the coverage plans in the entity cache if it is enabled.
	 *
	 * @param coveragePlans the coverage plans
	 */
	@Override
	public void cacheResult(List<CoveragePlan> coveragePlans) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (coveragePlans.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CoveragePlan coveragePlan : coveragePlans) {
			if (entityCache.getResult(
					CoveragePlanImpl.class, coveragePlan.getPrimaryKey()) ==
						null) {

				cacheResult(coveragePlan);
			}
		}
	}

	/**
	 * Clears the cache for all coverage plans.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CoveragePlanImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the coverage plan.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CoveragePlan coveragePlan) {
		entityCache.removeResult(CoveragePlanImpl.class, coveragePlan);
	}

	@Override
	public void clearCache(List<CoveragePlan> coveragePlans) {
		for (CoveragePlan coveragePlan : coveragePlans) {
			entityCache.removeResult(CoveragePlanImpl.class, coveragePlan);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CoveragePlanImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CoveragePlanModelImpl coveragePlanModelImpl) {

		Object[] args = new Object[] {coveragePlanModelImpl.getName()};

		finderCache.putResult(
			_finderPathCountByName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByName, args, coveragePlanModelImpl, false);
	}

	/**
	 * Creates a new coverage plan with the primary key. Does not add the coverage plan to the database.
	 *
	 * @param coveragePlanId the primary key for the new coverage plan
	 * @return the new coverage plan
	 */
	@Override
	public CoveragePlan create(long coveragePlanId) {
		CoveragePlan coveragePlan = new CoveragePlanImpl();

		coveragePlan.setNew(true);
		coveragePlan.setPrimaryKey(coveragePlanId);

		coveragePlan.setCompanyId(CompanyThreadLocal.getCompanyId());

		return coveragePlan;
	}

	/**
	 * Removes the coverage plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coveragePlanId the primary key of the coverage plan
	 * @return the coverage plan that was removed
	 * @throws NoSuchCoveragePlanException if a coverage plan with the primary key could not be found
	 */
	@Override
	public CoveragePlan remove(long coveragePlanId)
		throws NoSuchCoveragePlanException {

		return remove((Serializable)coveragePlanId);
	}

	/**
	 * Removes the coverage plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the coverage plan
	 * @return the coverage plan that was removed
	 * @throws NoSuchCoveragePlanException if a coverage plan with the primary key could not be found
	 */
	@Override
	public CoveragePlan remove(Serializable primaryKey)
		throws NoSuchCoveragePlanException {

		Session session = null;

		try {
			session = openSession();

			CoveragePlan coveragePlan = (CoveragePlan)session.get(
				CoveragePlanImpl.class, primaryKey);

			if (coveragePlan == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCoveragePlanException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(coveragePlan);
		}
		catch (NoSuchCoveragePlanException noSuchEntityException) {
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
	protected CoveragePlan removeImpl(CoveragePlan coveragePlan) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(coveragePlan)) {
				coveragePlan = (CoveragePlan)session.get(
					CoveragePlanImpl.class, coveragePlan.getPrimaryKeyObj());
			}

			if (coveragePlan != null) {
				session.delete(coveragePlan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (coveragePlan != null) {
			clearCache(coveragePlan);
		}

		return coveragePlan;
	}

	@Override
	public CoveragePlan updateImpl(CoveragePlan coveragePlan) {
		boolean isNew = coveragePlan.isNew();

		if (!(coveragePlan instanceof CoveragePlanModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(coveragePlan.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					coveragePlan);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in coveragePlan proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CoveragePlan implementation " +
					coveragePlan.getClass());
		}

		CoveragePlanModelImpl coveragePlanModelImpl =
			(CoveragePlanModelImpl)coveragePlan;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (coveragePlan.getCreateDate() == null)) {
			if (serviceContext == null) {
				coveragePlan.setCreateDate(date);
			}
			else {
				coveragePlan.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!coveragePlanModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				coveragePlan.setModifiedDate(date);
			}
			else {
				coveragePlan.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(coveragePlan);
			}
			else {
				coveragePlan = (CoveragePlan)session.merge(coveragePlan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CoveragePlanImpl.class, coveragePlanModelImpl, false, true);

		cacheUniqueFindersCache(coveragePlanModelImpl);

		if (isNew) {
			coveragePlan.setNew(false);
		}

		coveragePlan.resetOriginalValues();

		return coveragePlan;
	}

	/**
	 * Returns the coverage plan with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the coverage plan
	 * @return the coverage plan
	 * @throws NoSuchCoveragePlanException if a coverage plan with the primary key could not be found
	 */
	@Override
	public CoveragePlan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCoveragePlanException {

		CoveragePlan coveragePlan = fetchByPrimaryKey(primaryKey);

		if (coveragePlan == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCoveragePlanException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return coveragePlan;
	}

	/**
	 * Returns the coverage plan with the primary key or throws a <code>NoSuchCoveragePlanException</code> if it could not be found.
	 *
	 * @param coveragePlanId the primary key of the coverage plan
	 * @return the coverage plan
	 * @throws NoSuchCoveragePlanException if a coverage plan with the primary key could not be found
	 */
	@Override
	public CoveragePlan findByPrimaryKey(long coveragePlanId)
		throws NoSuchCoveragePlanException {

		return findByPrimaryKey((Serializable)coveragePlanId);
	}

	/**
	 * Returns the coverage plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coveragePlanId the primary key of the coverage plan
	 * @return the coverage plan, or <code>null</code> if a coverage plan with the primary key could not be found
	 */
	@Override
	public CoveragePlan fetchByPrimaryKey(long coveragePlanId) {
		return fetchByPrimaryKey((Serializable)coveragePlanId);
	}

	/**
	 * Returns all the coverage plans.
	 *
	 * @return the coverage plans
	 */
	@Override
	public List<CoveragePlan> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CoveragePlan> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<CoveragePlan> findAll(
		int start, int end, OrderByComparator<CoveragePlan> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<CoveragePlan> findAll(
		int start, int end, OrderByComparator<CoveragePlan> orderByComparator,
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

		List<CoveragePlan> list = null;

		if (useFinderCache) {
			list = (List<CoveragePlan>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COVERAGEPLAN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COVERAGEPLAN;

				sql = sql.concat(CoveragePlanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CoveragePlan>)QueryUtil.list(
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
	 * Removes all the coverage plans from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CoveragePlan coveragePlan : findAll()) {
			remove(coveragePlan);
		}
	}

	/**
	 * Returns the number of coverage plans.
	 *
	 * @return the number of coverage plans
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COVERAGEPLAN);

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
		return "coveragePlanId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COVERAGEPLAN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CoveragePlanModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the coverage plan persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CoveragePlanModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CoveragePlan.class.getName()));

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

		_setCoveragePlanUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCoveragePlanUtilPersistence(null);

		entityCache.removeCache(CoveragePlanImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setCoveragePlanUtilPersistence(
		CoveragePlanPersistence coveragePlanPersistence) {

		try {
			Field field = CoveragePlanUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, coveragePlanPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = AP_ProposalPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AP_ProposalPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AP_ProposalPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_COVERAGEPLAN =
		"SELECT coveragePlan FROM CoveragePlan coveragePlan";

	private static final String _SQL_SELECT_COVERAGEPLAN_WHERE =
		"SELECT coveragePlan FROM CoveragePlan coveragePlan WHERE ";

	private static final String _SQL_COUNT_COVERAGEPLAN =
		"SELECT COUNT(coveragePlan) FROM CoveragePlan coveragePlan";

	private static final String _SQL_COUNT_COVERAGEPLAN_WHERE =
		"SELECT COUNT(coveragePlan) FROM CoveragePlan coveragePlan WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "coveragePlan.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CoveragePlan exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CoveragePlan exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CoveragePlanPersistenceImpl.class);

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

	private static class CoveragePlanModelArgumentsResolver
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

			CoveragePlanModelImpl coveragePlanModelImpl =
				(CoveragePlanModelImpl)baseModel;

			long columnBitmask = coveragePlanModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(coveragePlanModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						coveragePlanModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(coveragePlanModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			CoveragePlanModelImpl coveragePlanModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = coveragePlanModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = coveragePlanModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}
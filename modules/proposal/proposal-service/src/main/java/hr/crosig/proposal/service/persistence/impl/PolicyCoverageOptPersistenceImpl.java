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
import com.liferay.portal.kernel.util.SetUtil;

import hr.crosig.proposal.exception.NoSuchPolicyCoverageOptException;
import hr.crosig.proposal.model.PolicyCoverageOpt;
import hr.crosig.proposal.model.impl.PolicyCoverageOptImpl;
import hr.crosig.proposal.model.impl.PolicyCoverageOptModelImpl;
import hr.crosig.proposal.service.persistence.PolicyCoverageOptPersistence;
import hr.crosig.proposal.service.persistence.PolicyCoverageOptUtil;
import hr.crosig.proposal.service.persistence.impl.constants.AP_ProposalPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 * The persistence implementation for the policy coverage opt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PolicyCoverageOptPersistence.class)
public class PolicyCoverageOptPersistenceImpl
	extends BasePersistenceImpl<PolicyCoverageOpt>
	implements PolicyCoverageOptPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PolicyCoverageOptUtil</code> to access the policy coverage opt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PolicyCoverageOptImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByProposalId;
	private FinderPath _finderPathWithoutPaginationFindByProposalId;
	private FinderPath _finderPathCountByProposalId;

	/**
	 * Returns all the policy coverage opts where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the matching policy coverage opts
	 */
	@Override
	public List<PolicyCoverageOpt> findByProposalId(long proposalId) {
		return findByProposalId(
			proposalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy coverage opts where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of policy coverage opts
	 * @param end the upper bound of the range of policy coverage opts (not inclusive)
	 * @return the range of matching policy coverage opts
	 */
	@Override
	public List<PolicyCoverageOpt> findByProposalId(
		long proposalId, int start, int end) {

		return findByProposalId(proposalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy coverage opts where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of policy coverage opts
	 * @param end the upper bound of the range of policy coverage opts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy coverage opts
	 */
	@Override
	public List<PolicyCoverageOpt> findByProposalId(
		long proposalId, int start, int end,
		OrderByComparator<PolicyCoverageOpt> orderByComparator) {

		return findByProposalId(
			proposalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy coverage opts where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of policy coverage opts
	 * @param end the upper bound of the range of policy coverage opts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy coverage opts
	 */
	@Override
	public List<PolicyCoverageOpt> findByProposalId(
		long proposalId, int start, int end,
		OrderByComparator<PolicyCoverageOpt> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProposalId;
				finderArgs = new Object[] {proposalId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProposalId;
			finderArgs = new Object[] {
				proposalId, start, end, orderByComparator
			};
		}

		List<PolicyCoverageOpt> list = null;

		if (useFinderCache) {
			list = (List<PolicyCoverageOpt>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyCoverageOpt policyCoverageOpt : list) {
					if (proposalId != policyCoverageOpt.getProposalId()) {
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

			sb.append(_SQL_SELECT_POLICYCOVERAGEOPT_WHERE);

			sb.append(_FINDER_COLUMN_PROPOSALID_PROPOSALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyCoverageOptModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(proposalId);

				list = (List<PolicyCoverageOpt>)QueryUtil.list(
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
	 * Returns the first policy coverage opt in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy coverage opt
	 * @throws NoSuchPolicyCoverageOptException if a matching policy coverage opt could not be found
	 */
	@Override
	public PolicyCoverageOpt findByProposalId_First(
			long proposalId,
			OrderByComparator<PolicyCoverageOpt> orderByComparator)
		throws NoSuchPolicyCoverageOptException {

		PolicyCoverageOpt policyCoverageOpt = fetchByProposalId_First(
			proposalId, orderByComparator);

		if (policyCoverageOpt != null) {
			return policyCoverageOpt;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("proposalId=");
		sb.append(proposalId);

		sb.append("}");

		throw new NoSuchPolicyCoverageOptException(sb.toString());
	}

	/**
	 * Returns the first policy coverage opt in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy coverage opt, or <code>null</code> if a matching policy coverage opt could not be found
	 */
	@Override
	public PolicyCoverageOpt fetchByProposalId_First(
		long proposalId,
		OrderByComparator<PolicyCoverageOpt> orderByComparator) {

		List<PolicyCoverageOpt> list = findByProposalId(
			proposalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy coverage opt in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy coverage opt
	 * @throws NoSuchPolicyCoverageOptException if a matching policy coverage opt could not be found
	 */
	@Override
	public PolicyCoverageOpt findByProposalId_Last(
			long proposalId,
			OrderByComparator<PolicyCoverageOpt> orderByComparator)
		throws NoSuchPolicyCoverageOptException {

		PolicyCoverageOpt policyCoverageOpt = fetchByProposalId_Last(
			proposalId, orderByComparator);

		if (policyCoverageOpt != null) {
			return policyCoverageOpt;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("proposalId=");
		sb.append(proposalId);

		sb.append("}");

		throw new NoSuchPolicyCoverageOptException(sb.toString());
	}

	/**
	 * Returns the last policy coverage opt in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy coverage opt, or <code>null</code> if a matching policy coverage opt could not be found
	 */
	@Override
	public PolicyCoverageOpt fetchByProposalId_Last(
		long proposalId,
		OrderByComparator<PolicyCoverageOpt> orderByComparator) {

		int count = countByProposalId(proposalId);

		if (count == 0) {
			return null;
		}

		List<PolicyCoverageOpt> list = findByProposalId(
			proposalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the policy coverage opts before and after the current policy coverage opt in the ordered set where proposalId = &#63;.
	 *
	 * @param policyCoverageOptionId the primary key of the current policy coverage opt
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy coverage opt
	 * @throws NoSuchPolicyCoverageOptException if a policy coverage opt with the primary key could not be found
	 */
	@Override
	public PolicyCoverageOpt[] findByProposalId_PrevAndNext(
			long policyCoverageOptionId, long proposalId,
			OrderByComparator<PolicyCoverageOpt> orderByComparator)
		throws NoSuchPolicyCoverageOptException {

		PolicyCoverageOpt policyCoverageOpt = findByPrimaryKey(
			policyCoverageOptionId);

		Session session = null;

		try {
			session = openSession();

			PolicyCoverageOpt[] array = new PolicyCoverageOptImpl[3];

			array[0] = getByProposalId_PrevAndNext(
				session, policyCoverageOpt, proposalId, orderByComparator,
				true);

			array[1] = policyCoverageOpt;

			array[2] = getByProposalId_PrevAndNext(
				session, policyCoverageOpt, proposalId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PolicyCoverageOpt getByProposalId_PrevAndNext(
		Session session, PolicyCoverageOpt policyCoverageOpt, long proposalId,
		OrderByComparator<PolicyCoverageOpt> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_POLICYCOVERAGEOPT_WHERE);

		sb.append(_FINDER_COLUMN_PROPOSALID_PROPOSALID_2);

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
			sb.append(PolicyCoverageOptModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(proposalId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						policyCoverageOpt)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PolicyCoverageOpt> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policy coverage opts where proposalId = &#63; from the database.
	 *
	 * @param proposalId the proposal ID
	 */
	@Override
	public void removeByProposalId(long proposalId) {
		for (PolicyCoverageOpt policyCoverageOpt :
				findByProposalId(
					proposalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(policyCoverageOpt);
		}
	}

	/**
	 * Returns the number of policy coverage opts where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the number of matching policy coverage opts
	 */
	@Override
	public int countByProposalId(long proposalId) {
		FinderPath finderPath = _finderPathCountByProposalId;

		Object[] finderArgs = new Object[] {proposalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICYCOVERAGEOPT_WHERE);

			sb.append(_FINDER_COLUMN_PROPOSALID_PROPOSALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(proposalId);

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

	private static final String _FINDER_COLUMN_PROPOSALID_PROPOSALID_2 =
		"policyCoverageOpt.proposalId = ?";

	public PolicyCoverageOptPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PolicyCoverageOpt.class);

		setModelImplClass(PolicyCoverageOptImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the policy coverage opt in the entity cache if it is enabled.
	 *
	 * @param policyCoverageOpt the policy coverage opt
	 */
	@Override
	public void cacheResult(PolicyCoverageOpt policyCoverageOpt) {
		entityCache.putResult(
			PolicyCoverageOptImpl.class, policyCoverageOpt.getPrimaryKey(),
			policyCoverageOpt);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the policy coverage opts in the entity cache if it is enabled.
	 *
	 * @param policyCoverageOpts the policy coverage opts
	 */
	@Override
	public void cacheResult(List<PolicyCoverageOpt> policyCoverageOpts) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (policyCoverageOpts.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PolicyCoverageOpt policyCoverageOpt : policyCoverageOpts) {
			if (entityCache.getResult(
					PolicyCoverageOptImpl.class,
					policyCoverageOpt.getPrimaryKey()) == null) {

				cacheResult(policyCoverageOpt);
			}
		}
	}

	/**
	 * Clears the cache for all policy coverage opts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PolicyCoverageOptImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the policy coverage opt.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PolicyCoverageOpt policyCoverageOpt) {
		entityCache.removeResult(
			PolicyCoverageOptImpl.class, policyCoverageOpt);
	}

	@Override
	public void clearCache(List<PolicyCoverageOpt> policyCoverageOpts) {
		for (PolicyCoverageOpt policyCoverageOpt : policyCoverageOpts) {
			entityCache.removeResult(
				PolicyCoverageOptImpl.class, policyCoverageOpt);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PolicyCoverageOptImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new policy coverage opt with the primary key. Does not add the policy coverage opt to the database.
	 *
	 * @param policyCoverageOptionId the primary key for the new policy coverage opt
	 * @return the new policy coverage opt
	 */
	@Override
	public PolicyCoverageOpt create(long policyCoverageOptionId) {
		PolicyCoverageOpt policyCoverageOpt = new PolicyCoverageOptImpl();

		policyCoverageOpt.setNew(true);
		policyCoverageOpt.setPrimaryKey(policyCoverageOptionId);

		policyCoverageOpt.setCompanyId(CompanyThreadLocal.getCompanyId());

		return policyCoverageOpt;
	}

	/**
	 * Removes the policy coverage opt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage opt
	 * @return the policy coverage opt that was removed
	 * @throws NoSuchPolicyCoverageOptException if a policy coverage opt with the primary key could not be found
	 */
	@Override
	public PolicyCoverageOpt remove(long policyCoverageOptionId)
		throws NoSuchPolicyCoverageOptException {

		return remove((Serializable)policyCoverageOptionId);
	}

	/**
	 * Removes the policy coverage opt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the policy coverage opt
	 * @return the policy coverage opt that was removed
	 * @throws NoSuchPolicyCoverageOptException if a policy coverage opt with the primary key could not be found
	 */
	@Override
	public PolicyCoverageOpt remove(Serializable primaryKey)
		throws NoSuchPolicyCoverageOptException {

		Session session = null;

		try {
			session = openSession();

			PolicyCoverageOpt policyCoverageOpt =
				(PolicyCoverageOpt)session.get(
					PolicyCoverageOptImpl.class, primaryKey);

			if (policyCoverageOpt == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPolicyCoverageOptException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(policyCoverageOpt);
		}
		catch (NoSuchPolicyCoverageOptException noSuchEntityException) {
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
	protected PolicyCoverageOpt removeImpl(
		PolicyCoverageOpt policyCoverageOpt) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(policyCoverageOpt)) {
				policyCoverageOpt = (PolicyCoverageOpt)session.get(
					PolicyCoverageOptImpl.class,
					policyCoverageOpt.getPrimaryKeyObj());
			}

			if (policyCoverageOpt != null) {
				session.delete(policyCoverageOpt);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (policyCoverageOpt != null) {
			clearCache(policyCoverageOpt);
		}

		return policyCoverageOpt;
	}

	@Override
	public PolicyCoverageOpt updateImpl(PolicyCoverageOpt policyCoverageOpt) {
		boolean isNew = policyCoverageOpt.isNew();

		if (!(policyCoverageOpt instanceof PolicyCoverageOptModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(policyCoverageOpt.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					policyCoverageOpt);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in policyCoverageOpt proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PolicyCoverageOpt implementation " +
					policyCoverageOpt.getClass());
		}

		PolicyCoverageOptModelImpl policyCoverageOptModelImpl =
			(PolicyCoverageOptModelImpl)policyCoverageOpt;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (policyCoverageOpt.getCreateDate() == null)) {
			if (serviceContext == null) {
				policyCoverageOpt.setCreateDate(date);
			}
			else {
				policyCoverageOpt.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!policyCoverageOptModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				policyCoverageOpt.setModifiedDate(date);
			}
			else {
				policyCoverageOpt.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(policyCoverageOpt);
			}
			else {
				policyCoverageOpt = (PolicyCoverageOpt)session.merge(
					policyCoverageOpt);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PolicyCoverageOptImpl.class, policyCoverageOptModelImpl, false,
			true);

		if (isNew) {
			policyCoverageOpt.setNew(false);
		}

		policyCoverageOpt.resetOriginalValues();

		return policyCoverageOpt;
	}

	/**
	 * Returns the policy coverage opt with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the policy coverage opt
	 * @return the policy coverage opt
	 * @throws NoSuchPolicyCoverageOptException if a policy coverage opt with the primary key could not be found
	 */
	@Override
	public PolicyCoverageOpt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPolicyCoverageOptException {

		PolicyCoverageOpt policyCoverageOpt = fetchByPrimaryKey(primaryKey);

		if (policyCoverageOpt == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPolicyCoverageOptException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return policyCoverageOpt;
	}

	/**
	 * Returns the policy coverage opt with the primary key or throws a <code>NoSuchPolicyCoverageOptException</code> if it could not be found.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage opt
	 * @return the policy coverage opt
	 * @throws NoSuchPolicyCoverageOptException if a policy coverage opt with the primary key could not be found
	 */
	@Override
	public PolicyCoverageOpt findByPrimaryKey(long policyCoverageOptionId)
		throws NoSuchPolicyCoverageOptException {

		return findByPrimaryKey((Serializable)policyCoverageOptionId);
	}

	/**
	 * Returns the policy coverage opt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage opt
	 * @return the policy coverage opt, or <code>null</code> if a policy coverage opt with the primary key could not be found
	 */
	@Override
	public PolicyCoverageOpt fetchByPrimaryKey(long policyCoverageOptionId) {
		return fetchByPrimaryKey((Serializable)policyCoverageOptionId);
	}

	/**
	 * Returns all the policy coverage opts.
	 *
	 * @return the policy coverage opts
	 */
	@Override
	public List<PolicyCoverageOpt> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PolicyCoverageOpt> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<PolicyCoverageOpt> findAll(
		int start, int end,
		OrderByComparator<PolicyCoverageOpt> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<PolicyCoverageOpt> findAll(
		int start, int end,
		OrderByComparator<PolicyCoverageOpt> orderByComparator,
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

		List<PolicyCoverageOpt> list = null;

		if (useFinderCache) {
			list = (List<PolicyCoverageOpt>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POLICYCOVERAGEOPT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POLICYCOVERAGEOPT;

				sql = sql.concat(PolicyCoverageOptModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PolicyCoverageOpt>)QueryUtil.list(
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
	 * Removes all the policy coverage opts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PolicyCoverageOpt policyCoverageOpt : findAll()) {
			remove(policyCoverageOpt);
		}
	}

	/**
	 * Returns the number of policy coverage opts.
	 *
	 * @return the number of policy coverage opts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POLICYCOVERAGEOPT);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "policyCoverageOptionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POLICYCOVERAGEOPT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PolicyCoverageOptModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the policy coverage opt persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new PolicyCoverageOptModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PolicyCoverageOpt.class.getName()));

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

		_finderPathWithPaginationFindByProposalId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProposalId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"proposalId"}, true);

		_finderPathWithoutPaginationFindByProposalId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProposalId",
			new String[] {Long.class.getName()}, new String[] {"proposalId"},
			true);

		_finderPathCountByProposalId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProposalId",
			new String[] {Long.class.getName()}, new String[] {"proposalId"},
			false);

		_setPolicyCoverageOptUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPolicyCoverageOptUtilPersistence(null);

		entityCache.removeCache(PolicyCoverageOptImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPolicyCoverageOptUtilPersistence(
		PolicyCoverageOptPersistence policyCoverageOptPersistence) {

		try {
			Field field = PolicyCoverageOptUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, policyCoverageOptPersistence);
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

	private static final String _SQL_SELECT_POLICYCOVERAGEOPT =
		"SELECT policyCoverageOpt FROM PolicyCoverageOpt policyCoverageOpt";

	private static final String _SQL_SELECT_POLICYCOVERAGEOPT_WHERE =
		"SELECT policyCoverageOpt FROM PolicyCoverageOpt policyCoverageOpt WHERE ";

	private static final String _SQL_COUNT_POLICYCOVERAGEOPT =
		"SELECT COUNT(policyCoverageOpt) FROM PolicyCoverageOpt policyCoverageOpt";

	private static final String _SQL_COUNT_POLICYCOVERAGEOPT_WHERE =
		"SELECT COUNT(policyCoverageOpt) FROM PolicyCoverageOpt policyCoverageOpt WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "policyCoverageOpt.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PolicyCoverageOpt exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PolicyCoverageOpt exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyCoverageOptPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

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

	private static class PolicyCoverageOptModelArgumentsResolver
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

			PolicyCoverageOptModelImpl policyCoverageOptModelImpl =
				(PolicyCoverageOptModelImpl)baseModel;

			long columnBitmask = policyCoverageOptModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					policyCoverageOptModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						policyCoverageOptModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					policyCoverageOptModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PolicyCoverageOptModelImpl policyCoverageOptModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						policyCoverageOptModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = policyCoverageOptModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}
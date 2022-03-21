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

import hr.crosig.proposal.exception.NoSuchPolicyOptionsException;
import hr.crosig.proposal.model.PolicyOptions;
import hr.crosig.proposal.model.impl.PolicyOptionsImpl;
import hr.crosig.proposal.model.impl.PolicyOptionsModelImpl;
import hr.crosig.proposal.service.persistence.PolicyOptionsPersistence;
import hr.crosig.proposal.service.persistence.PolicyOptionsUtil;
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
 * The persistence implementation for the policy options service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PolicyOptionsPersistence.class)
public class PolicyOptionsPersistenceImpl
	extends BasePersistenceImpl<PolicyOptions>
	implements PolicyOptionsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PolicyOptionsUtil</code> to access the policy options persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PolicyOptionsImpl.class.getName();

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
	 * Returns all the policy optionses where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the matching policy optionses
	 */
	@Override
	public List<PolicyOptions> findByProposalId(long proposalId) {
		return findByProposalId(
			proposalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy optionses where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyOptionsModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of policy optionses
	 * @param end the upper bound of the range of policy optionses (not inclusive)
	 * @return the range of matching policy optionses
	 */
	@Override
	public List<PolicyOptions> findByProposalId(
		long proposalId, int start, int end) {

		return findByProposalId(proposalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy optionses where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyOptionsModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of policy optionses
	 * @param end the upper bound of the range of policy optionses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policy optionses
	 */
	@Override
	public List<PolicyOptions> findByProposalId(
		long proposalId, int start, int end,
		OrderByComparator<PolicyOptions> orderByComparator) {

		return findByProposalId(
			proposalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy optionses where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyOptionsModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of policy optionses
	 * @param end the upper bound of the range of policy optionses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policy optionses
	 */
	@Override
	public List<PolicyOptions> findByProposalId(
		long proposalId, int start, int end,
		OrderByComparator<PolicyOptions> orderByComparator,
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

		List<PolicyOptions> list = null;

		if (useFinderCache) {
			list = (List<PolicyOptions>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PolicyOptions policyOptions : list) {
					if (proposalId != policyOptions.getProposalId()) {
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

			sb.append(_SQL_SELECT_POLICYOPTIONS_WHERE);

			sb.append(_FINDER_COLUMN_PROPOSALID_PROPOSALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyOptionsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(proposalId);

				list = (List<PolicyOptions>)QueryUtil.list(
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
	 * Returns the first policy options in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy options
	 * @throws NoSuchPolicyOptionsException if a matching policy options could not be found
	 */
	@Override
	public PolicyOptions findByProposalId_First(
			long proposalId, OrderByComparator<PolicyOptions> orderByComparator)
		throws NoSuchPolicyOptionsException {

		PolicyOptions policyOptions = fetchByProposalId_First(
			proposalId, orderByComparator);

		if (policyOptions != null) {
			return policyOptions;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("proposalId=");
		sb.append(proposalId);

		sb.append("}");

		throw new NoSuchPolicyOptionsException(sb.toString());
	}

	/**
	 * Returns the first policy options in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy options, or <code>null</code> if a matching policy options could not be found
	 */
	@Override
	public PolicyOptions fetchByProposalId_First(
		long proposalId, OrderByComparator<PolicyOptions> orderByComparator) {

		List<PolicyOptions> list = findByProposalId(
			proposalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy options in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy options
	 * @throws NoSuchPolicyOptionsException if a matching policy options could not be found
	 */
	@Override
	public PolicyOptions findByProposalId_Last(
			long proposalId, OrderByComparator<PolicyOptions> orderByComparator)
		throws NoSuchPolicyOptionsException {

		PolicyOptions policyOptions = fetchByProposalId_Last(
			proposalId, orderByComparator);

		if (policyOptions != null) {
			return policyOptions;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("proposalId=");
		sb.append(proposalId);

		sb.append("}");

		throw new NoSuchPolicyOptionsException(sb.toString());
	}

	/**
	 * Returns the last policy options in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy options, or <code>null</code> if a matching policy options could not be found
	 */
	@Override
	public PolicyOptions fetchByProposalId_Last(
		long proposalId, OrderByComparator<PolicyOptions> orderByComparator) {

		int count = countByProposalId(proposalId);

		if (count == 0) {
			return null;
		}

		List<PolicyOptions> list = findByProposalId(
			proposalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the policy optionses before and after the current policy options in the ordered set where proposalId = &#63;.
	 *
	 * @param policyOptionsId the primary key of the current policy options
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy options
	 * @throws NoSuchPolicyOptionsException if a policy options with the primary key could not be found
	 */
	@Override
	public PolicyOptions[] findByProposalId_PrevAndNext(
			long policyOptionsId, long proposalId,
			OrderByComparator<PolicyOptions> orderByComparator)
		throws NoSuchPolicyOptionsException {

		PolicyOptions policyOptions = findByPrimaryKey(policyOptionsId);

		Session session = null;

		try {
			session = openSession();

			PolicyOptions[] array = new PolicyOptionsImpl[3];

			array[0] = getByProposalId_PrevAndNext(
				session, policyOptions, proposalId, orderByComparator, true);

			array[1] = policyOptions;

			array[2] = getByProposalId_PrevAndNext(
				session, policyOptions, proposalId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PolicyOptions getByProposalId_PrevAndNext(
		Session session, PolicyOptions policyOptions, long proposalId,
		OrderByComparator<PolicyOptions> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_POLICYOPTIONS_WHERE);

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
			sb.append(PolicyOptionsModelImpl.ORDER_BY_JPQL);
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
						policyOptions)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PolicyOptions> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policy optionses where proposalId = &#63; from the database.
	 *
	 * @param proposalId the proposal ID
	 */
	@Override
	public void removeByProposalId(long proposalId) {
		for (PolicyOptions policyOptions :
				findByProposalId(
					proposalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(policyOptions);
		}
	}

	/**
	 * Returns the number of policy optionses where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the number of matching policy optionses
	 */
	@Override
	public int countByProposalId(long proposalId) {
		FinderPath finderPath = _finderPathCountByProposalId;

		Object[] finderArgs = new Object[] {proposalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICYOPTIONS_WHERE);

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
		"policyOptions.proposalId = ?";

	public PolicyOptionsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("currency", "currency_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PolicyOptions.class);

		setModelImplClass(PolicyOptionsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the policy options in the entity cache if it is enabled.
	 *
	 * @param policyOptions the policy options
	 */
	@Override
	public void cacheResult(PolicyOptions policyOptions) {
		entityCache.putResult(
			PolicyOptionsImpl.class, policyOptions.getPrimaryKey(),
			policyOptions);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the policy optionses in the entity cache if it is enabled.
	 *
	 * @param policyOptionses the policy optionses
	 */
	@Override
	public void cacheResult(List<PolicyOptions> policyOptionses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (policyOptionses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PolicyOptions policyOptions : policyOptionses) {
			if (entityCache.getResult(
					PolicyOptionsImpl.class, policyOptions.getPrimaryKey()) ==
						null) {

				cacheResult(policyOptions);
			}
		}
	}

	/**
	 * Clears the cache for all policy optionses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PolicyOptionsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the policy options.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PolicyOptions policyOptions) {
		entityCache.removeResult(PolicyOptionsImpl.class, policyOptions);
	}

	@Override
	public void clearCache(List<PolicyOptions> policyOptionses) {
		for (PolicyOptions policyOptions : policyOptionses) {
			entityCache.removeResult(PolicyOptionsImpl.class, policyOptions);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PolicyOptionsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new policy options with the primary key. Does not add the policy options to the database.
	 *
	 * @param policyOptionsId the primary key for the new policy options
	 * @return the new policy options
	 */
	@Override
	public PolicyOptions create(long policyOptionsId) {
		PolicyOptions policyOptions = new PolicyOptionsImpl();

		policyOptions.setNew(true);
		policyOptions.setPrimaryKey(policyOptionsId);

		policyOptions.setCompanyId(CompanyThreadLocal.getCompanyId());

		return policyOptions;
	}

	/**
	 * Removes the policy options with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyOptionsId the primary key of the policy options
	 * @return the policy options that was removed
	 * @throws NoSuchPolicyOptionsException if a policy options with the primary key could not be found
	 */
	@Override
	public PolicyOptions remove(long policyOptionsId)
		throws NoSuchPolicyOptionsException {

		return remove((Serializable)policyOptionsId);
	}

	/**
	 * Removes the policy options with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the policy options
	 * @return the policy options that was removed
	 * @throws NoSuchPolicyOptionsException if a policy options with the primary key could not be found
	 */
	@Override
	public PolicyOptions remove(Serializable primaryKey)
		throws NoSuchPolicyOptionsException {

		Session session = null;

		try {
			session = openSession();

			PolicyOptions policyOptions = (PolicyOptions)session.get(
				PolicyOptionsImpl.class, primaryKey);

			if (policyOptions == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPolicyOptionsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(policyOptions);
		}
		catch (NoSuchPolicyOptionsException noSuchEntityException) {
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
	protected PolicyOptions removeImpl(PolicyOptions policyOptions) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(policyOptions)) {
				policyOptions = (PolicyOptions)session.get(
					PolicyOptionsImpl.class, policyOptions.getPrimaryKeyObj());
			}

			if (policyOptions != null) {
				session.delete(policyOptions);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (policyOptions != null) {
			clearCache(policyOptions);
		}

		return policyOptions;
	}

	@Override
	public PolicyOptions updateImpl(PolicyOptions policyOptions) {
		boolean isNew = policyOptions.isNew();

		if (!(policyOptions instanceof PolicyOptionsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(policyOptions.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					policyOptions);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in policyOptions proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PolicyOptions implementation " +
					policyOptions.getClass());
		}

		PolicyOptionsModelImpl policyOptionsModelImpl =
			(PolicyOptionsModelImpl)policyOptions;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (policyOptions.getCreateDate() == null)) {
			if (serviceContext == null) {
				policyOptions.setCreateDate(date);
			}
			else {
				policyOptions.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!policyOptionsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				policyOptions.setModifiedDate(date);
			}
			else {
				policyOptions.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(policyOptions);
			}
			else {
				policyOptions = (PolicyOptions)session.merge(policyOptions);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PolicyOptionsImpl.class, policyOptionsModelImpl, false, true);

		if (isNew) {
			policyOptions.setNew(false);
		}

		policyOptions.resetOriginalValues();

		return policyOptions;
	}

	/**
	 * Returns the policy options with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the policy options
	 * @return the policy options
	 * @throws NoSuchPolicyOptionsException if a policy options with the primary key could not be found
	 */
	@Override
	public PolicyOptions findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPolicyOptionsException {

		PolicyOptions policyOptions = fetchByPrimaryKey(primaryKey);

		if (policyOptions == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPolicyOptionsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return policyOptions;
	}

	/**
	 * Returns the policy options with the primary key or throws a <code>NoSuchPolicyOptionsException</code> if it could not be found.
	 *
	 * @param policyOptionsId the primary key of the policy options
	 * @return the policy options
	 * @throws NoSuchPolicyOptionsException if a policy options with the primary key could not be found
	 */
	@Override
	public PolicyOptions findByPrimaryKey(long policyOptionsId)
		throws NoSuchPolicyOptionsException {

		return findByPrimaryKey((Serializable)policyOptionsId);
	}

	/**
	 * Returns the policy options with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyOptionsId the primary key of the policy options
	 * @return the policy options, or <code>null</code> if a policy options with the primary key could not be found
	 */
	@Override
	public PolicyOptions fetchByPrimaryKey(long policyOptionsId) {
		return fetchByPrimaryKey((Serializable)policyOptionsId);
	}

	/**
	 * Returns all the policy optionses.
	 *
	 * @return the policy optionses
	 */
	@Override
	public List<PolicyOptions> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PolicyOptions> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<PolicyOptions> findAll(
		int start, int end,
		OrderByComparator<PolicyOptions> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<PolicyOptions> findAll(
		int start, int end, OrderByComparator<PolicyOptions> orderByComparator,
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

		List<PolicyOptions> list = null;

		if (useFinderCache) {
			list = (List<PolicyOptions>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POLICYOPTIONS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POLICYOPTIONS;

				sql = sql.concat(PolicyOptionsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PolicyOptions>)QueryUtil.list(
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
	 * Removes all the policy optionses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PolicyOptions policyOptions : findAll()) {
			remove(policyOptions);
		}
	}

	/**
	 * Returns the number of policy optionses.
	 *
	 * @return the number of policy optionses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POLICYOPTIONS);

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
		return "policyOptionsId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POLICYOPTIONS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PolicyOptionsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the policy options persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PolicyOptionsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PolicyOptions.class.getName()));

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

		_setPolicyOptionsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPolicyOptionsUtilPersistence(null);

		entityCache.removeCache(PolicyOptionsImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPolicyOptionsUtilPersistence(
		PolicyOptionsPersistence policyOptionsPersistence) {

		try {
			Field field = PolicyOptionsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, policyOptionsPersistence);
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

	private static final String _SQL_SELECT_POLICYOPTIONS =
		"SELECT policyOptions FROM PolicyOptions policyOptions";

	private static final String _SQL_SELECT_POLICYOPTIONS_WHERE =
		"SELECT policyOptions FROM PolicyOptions policyOptions WHERE ";

	private static final String _SQL_COUNT_POLICYOPTIONS =
		"SELECT COUNT(policyOptions) FROM PolicyOptions policyOptions";

	private static final String _SQL_COUNT_POLICYOPTIONS_WHERE =
		"SELECT COUNT(policyOptions) FROM PolicyOptions policyOptions WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "policyOptions.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PolicyOptions exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PolicyOptions exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyOptionsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"currency"});

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

	private static class PolicyOptionsModelArgumentsResolver
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

			PolicyOptionsModelImpl policyOptionsModelImpl =
				(PolicyOptionsModelImpl)baseModel;

			long columnBitmask = policyOptionsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(policyOptionsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						policyOptionsModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(policyOptionsModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PolicyOptionsModelImpl policyOptionsModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						policyOptionsModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = policyOptionsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}
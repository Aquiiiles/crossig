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

import hr.crosig.proposal.exception.NoSuchProposalException;
import hr.crosig.proposal.model.Proposal;
import hr.crosig.proposal.model.impl.ProposalImpl;
import hr.crosig.proposal.model.impl.ProposalModelImpl;
import hr.crosig.proposal.service.persistence.ProposalPersistence;
import hr.crosig.proposal.service.persistence.ProposalUtil;
import hr.crosig.proposal.service.persistence.impl.constants.AP_ProposalPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
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
 * The persistence implementation for the proposal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProposalPersistence.class)
public class ProposalPersistenceImpl
	extends BasePersistenceImpl<Proposal> implements ProposalPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProposalUtil</code> to access the proposal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProposalImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByAgentUserId;
	private FinderPath _finderPathWithoutPaginationFindByAgentUserId;
	private FinderPath _finderPathCountByAgentUserId;

	/**
	 * Returns all the proposals where agentUserId = &#63;.
	 *
	 * @param agentUserId the agent user ID
	 * @return the matching proposals
	 */
	@Override
	public List<Proposal> findByAgentUserId(long agentUserId) {
		return findByAgentUserId(
			agentUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposals where agentUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalModelImpl</code>.
	 * </p>
	 *
	 * @param agentUserId the agent user ID
	 * @param start the lower bound of the range of proposals
	 * @param end the upper bound of the range of proposals (not inclusive)
	 * @return the range of matching proposals
	 */
	@Override
	public List<Proposal> findByAgentUserId(
		long agentUserId, int start, int end) {

		return findByAgentUserId(agentUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposals where agentUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalModelImpl</code>.
	 * </p>
	 *
	 * @param agentUserId the agent user ID
	 * @param start the lower bound of the range of proposals
	 * @param end the upper bound of the range of proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposals
	 */
	@Override
	public List<Proposal> findByAgentUserId(
		long agentUserId, int start, int end,
		OrderByComparator<Proposal> orderByComparator) {

		return findByAgentUserId(
			agentUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proposals where agentUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalModelImpl</code>.
	 * </p>
	 *
	 * @param agentUserId the agent user ID
	 * @param start the lower bound of the range of proposals
	 * @param end the upper bound of the range of proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proposals
	 */
	@Override
	public List<Proposal> findByAgentUserId(
		long agentUserId, int start, int end,
		OrderByComparator<Proposal> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAgentUserId;
				finderArgs = new Object[] {agentUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAgentUserId;
			finderArgs = new Object[] {
				agentUserId, start, end, orderByComparator
			};
		}

		List<Proposal> list = null;

		if (useFinderCache) {
			list = (List<Proposal>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Proposal proposal : list) {
					if (agentUserId != proposal.getAgentUserId()) {
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

			sb.append(_SQL_SELECT_PROPOSAL_WHERE);

			sb.append(_FINDER_COLUMN_AGENTUSERID_AGENTUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProposalModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(agentUserId);

				list = (List<Proposal>)QueryUtil.list(
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
	 * Returns the first proposal in the ordered set where agentUserId = &#63;.
	 *
	 * @param agentUserId the agent user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal
	 * @throws NoSuchProposalException if a matching proposal could not be found
	 */
	@Override
	public Proposal findByAgentUserId_First(
			long agentUserId, OrderByComparator<Proposal> orderByComparator)
		throws NoSuchProposalException {

		Proposal proposal = fetchByAgentUserId_First(
			agentUserId, orderByComparator);

		if (proposal != null) {
			return proposal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("agentUserId=");
		sb.append(agentUserId);

		sb.append("}");

		throw new NoSuchProposalException(sb.toString());
	}

	/**
	 * Returns the first proposal in the ordered set where agentUserId = &#63;.
	 *
	 * @param agentUserId the agent user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal, or <code>null</code> if a matching proposal could not be found
	 */
	@Override
	public Proposal fetchByAgentUserId_First(
		long agentUserId, OrderByComparator<Proposal> orderByComparator) {

		List<Proposal> list = findByAgentUserId(
			agentUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposal in the ordered set where agentUserId = &#63;.
	 *
	 * @param agentUserId the agent user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal
	 * @throws NoSuchProposalException if a matching proposal could not be found
	 */
	@Override
	public Proposal findByAgentUserId_Last(
			long agentUserId, OrderByComparator<Proposal> orderByComparator)
		throws NoSuchProposalException {

		Proposal proposal = fetchByAgentUserId_Last(
			agentUserId, orderByComparator);

		if (proposal != null) {
			return proposal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("agentUserId=");
		sb.append(agentUserId);

		sb.append("}");

		throw new NoSuchProposalException(sb.toString());
	}

	/**
	 * Returns the last proposal in the ordered set where agentUserId = &#63;.
	 *
	 * @param agentUserId the agent user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal, or <code>null</code> if a matching proposal could not be found
	 */
	@Override
	public Proposal fetchByAgentUserId_Last(
		long agentUserId, OrderByComparator<Proposal> orderByComparator) {

		int count = countByAgentUserId(agentUserId);

		if (count == 0) {
			return null;
		}

		List<Proposal> list = findByAgentUserId(
			agentUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposals before and after the current proposal in the ordered set where agentUserId = &#63;.
	 *
	 * @param proposalId the primary key of the current proposal
	 * @param agentUserId the agent user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposal
	 * @throws NoSuchProposalException if a proposal with the primary key could not be found
	 */
	@Override
	public Proposal[] findByAgentUserId_PrevAndNext(
			long proposalId, long agentUserId,
			OrderByComparator<Proposal> orderByComparator)
		throws NoSuchProposalException {

		Proposal proposal = findByPrimaryKey(proposalId);

		Session session = null;

		try {
			session = openSession();

			Proposal[] array = new ProposalImpl[3];

			array[0] = getByAgentUserId_PrevAndNext(
				session, proposal, agentUserId, orderByComparator, true);

			array[1] = proposal;

			array[2] = getByAgentUserId_PrevAndNext(
				session, proposal, agentUserId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Proposal getByAgentUserId_PrevAndNext(
		Session session, Proposal proposal, long agentUserId,
		OrderByComparator<Proposal> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROPOSAL_WHERE);

		sb.append(_FINDER_COLUMN_AGENTUSERID_AGENTUSERID_2);

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
			sb.append(ProposalModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(agentUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(proposal)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Proposal> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the proposals where agentUserId = &#63; from the database.
	 *
	 * @param agentUserId the agent user ID
	 */
	@Override
	public void removeByAgentUserId(long agentUserId) {
		for (Proposal proposal :
				findByAgentUserId(
					agentUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(proposal);
		}
	}

	/**
	 * Returns the number of proposals where agentUserId = &#63;.
	 *
	 * @param agentUserId the agent user ID
	 * @return the number of matching proposals
	 */
	@Override
	public int countByAgentUserId(long agentUserId) {
		FinderPath finderPath = _finderPathCountByAgentUserId;

		Object[] finderArgs = new Object[] {agentUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROPOSAL_WHERE);

			sb.append(_FINDER_COLUMN_AGENTUSERID_AGENTUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(agentUserId);

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

	private static final String _FINDER_COLUMN_AGENTUSERID_AGENTUSERID_2 =
		"proposal.agentUserId = ?";

	public ProposalPersistenceImpl() {
		setModelClass(Proposal.class);

		setModelImplClass(ProposalImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the proposal in the entity cache if it is enabled.
	 *
	 * @param proposal the proposal
	 */
	@Override
	public void cacheResult(Proposal proposal) {
		entityCache.putResult(
			ProposalImpl.class, proposal.getPrimaryKey(), proposal);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the proposals in the entity cache if it is enabled.
	 *
	 * @param proposals the proposals
	 */
	@Override
	public void cacheResult(List<Proposal> proposals) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (proposals.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Proposal proposal : proposals) {
			if (entityCache.getResult(
					ProposalImpl.class, proposal.getPrimaryKey()) == null) {

				cacheResult(proposal);
			}
		}
	}

	/**
	 * Clears the cache for all proposals.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProposalImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the proposal.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Proposal proposal) {
		entityCache.removeResult(ProposalImpl.class, proposal);
	}

	@Override
	public void clearCache(List<Proposal> proposals) {
		for (Proposal proposal : proposals) {
			entityCache.removeResult(ProposalImpl.class, proposal);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProposalImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new proposal with the primary key. Does not add the proposal to the database.
	 *
	 * @param proposalId the primary key for the new proposal
	 * @return the new proposal
	 */
	@Override
	public Proposal create(long proposalId) {
		Proposal proposal = new ProposalImpl();

		proposal.setNew(true);
		proposal.setPrimaryKey(proposalId);

		proposal.setCompanyId(CompanyThreadLocal.getCompanyId());

		return proposal;
	}

	/**
	 * Removes the proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proposalId the primary key of the proposal
	 * @return the proposal that was removed
	 * @throws NoSuchProposalException if a proposal with the primary key could not be found
	 */
	@Override
	public Proposal remove(long proposalId) throws NoSuchProposalException {
		return remove((Serializable)proposalId);
	}

	/**
	 * Removes the proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the proposal
	 * @return the proposal that was removed
	 * @throws NoSuchProposalException if a proposal with the primary key could not be found
	 */
	@Override
	public Proposal remove(Serializable primaryKey)
		throws NoSuchProposalException {

		Session session = null;

		try {
			session = openSession();

			Proposal proposal = (Proposal)session.get(
				ProposalImpl.class, primaryKey);

			if (proposal == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProposalException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(proposal);
		}
		catch (NoSuchProposalException noSuchEntityException) {
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
	protected Proposal removeImpl(Proposal proposal) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(proposal)) {
				proposal = (Proposal)session.get(
					ProposalImpl.class, proposal.getPrimaryKeyObj());
			}

			if (proposal != null) {
				session.delete(proposal);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (proposal != null) {
			clearCache(proposal);
		}

		return proposal;
	}

	@Override
	public Proposal updateImpl(Proposal proposal) {
		boolean isNew = proposal.isNew();

		if (!(proposal instanceof ProposalModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(proposal.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(proposal);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in proposal proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Proposal implementation " +
					proposal.getClass());
		}

		ProposalModelImpl proposalModelImpl = (ProposalModelImpl)proposal;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (proposal.getCreateDate() == null)) {
			if (serviceContext == null) {
				proposal.setCreateDate(date);
			}
			else {
				proposal.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!proposalModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				proposal.setModifiedDate(date);
			}
			else {
				proposal.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(proposal);
			}
			else {
				proposal = (Proposal)session.merge(proposal);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProposalImpl.class, proposalModelImpl, false, true);

		if (isNew) {
			proposal.setNew(false);
		}

		proposal.resetOriginalValues();

		return proposal;
	}

	/**
	 * Returns the proposal with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the proposal
	 * @return the proposal
	 * @throws NoSuchProposalException if a proposal with the primary key could not be found
	 */
	@Override
	public Proposal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProposalException {

		Proposal proposal = fetchByPrimaryKey(primaryKey);

		if (proposal == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProposalException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return proposal;
	}

	/**
	 * Returns the proposal with the primary key or throws a <code>NoSuchProposalException</code> if it could not be found.
	 *
	 * @param proposalId the primary key of the proposal
	 * @return the proposal
	 * @throws NoSuchProposalException if a proposal with the primary key could not be found
	 */
	@Override
	public Proposal findByPrimaryKey(long proposalId)
		throws NoSuchProposalException {

		return findByPrimaryKey((Serializable)proposalId);
	}

	/**
	 * Returns the proposal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proposalId the primary key of the proposal
	 * @return the proposal, or <code>null</code> if a proposal with the primary key could not be found
	 */
	@Override
	public Proposal fetchByPrimaryKey(long proposalId) {
		return fetchByPrimaryKey((Serializable)proposalId);
	}

	/**
	 * Returns all the proposals.
	 *
	 * @return the proposals
	 */
	@Override
	public List<Proposal> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposals
	 * @param end the upper bound of the range of proposals (not inclusive)
	 * @return the range of proposals
	 */
	@Override
	public List<Proposal> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposals
	 * @param end the upper bound of the range of proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proposals
	 */
	@Override
	public List<Proposal> findAll(
		int start, int end, OrderByComparator<Proposal> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposals
	 * @param end the upper bound of the range of proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of proposals
	 */
	@Override
	public List<Proposal> findAll(
		int start, int end, OrderByComparator<Proposal> orderByComparator,
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

		List<Proposal> list = null;

		if (useFinderCache) {
			list = (List<Proposal>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROPOSAL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROPOSAL;

				sql = sql.concat(ProposalModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Proposal>)QueryUtil.list(
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
	 * Removes all the proposals from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Proposal proposal : findAll()) {
			remove(proposal);
		}
	}

	/**
	 * Returns the number of proposals.
	 *
	 * @return the number of proposals
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROPOSAL);

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
		return "proposalId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROPOSAL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProposalModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the proposal persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ProposalModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Proposal.class.getName()));

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

		_finderPathWithPaginationFindByAgentUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAgentUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"agentUserId"}, true);

		_finderPathWithoutPaginationFindByAgentUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAgentUserId",
			new String[] {Long.class.getName()}, new String[] {"agentUserId"},
			true);

		_finderPathCountByAgentUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAgentUserId",
			new String[] {Long.class.getName()}, new String[] {"agentUserId"},
			false);

		_setProposalUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProposalUtilPersistence(null);

		entityCache.removeCache(ProposalImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setProposalUtilPersistence(
		ProposalPersistence proposalPersistence) {

		try {
			Field field = ProposalUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, proposalPersistence);
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

	private static final String _SQL_SELECT_PROPOSAL =
		"SELECT proposal FROM Proposal proposal";

	private static final String _SQL_SELECT_PROPOSAL_WHERE =
		"SELECT proposal FROM Proposal proposal WHERE ";

	private static final String _SQL_COUNT_PROPOSAL =
		"SELECT COUNT(proposal) FROM Proposal proposal";

	private static final String _SQL_COUNT_PROPOSAL_WHERE =
		"SELECT COUNT(proposal) FROM Proposal proposal WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "proposal.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Proposal exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Proposal exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProposalPersistenceImpl.class);

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

	private static class ProposalModelArgumentsResolver
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

			ProposalModelImpl proposalModelImpl = (ProposalModelImpl)baseModel;

			long columnBitmask = proposalModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(proposalModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						proposalModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(proposalModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ProposalModelImpl proposalModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = proposalModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = proposalModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}
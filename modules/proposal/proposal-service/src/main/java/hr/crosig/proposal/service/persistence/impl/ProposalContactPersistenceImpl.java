/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import hr.crosig.proposal.exception.NoSuchProposalContactException;
import hr.crosig.proposal.model.ProposalContact;
import hr.crosig.proposal.model.ProposalContactTable;
import hr.crosig.proposal.model.impl.ProposalContactImpl;
import hr.crosig.proposal.model.impl.ProposalContactModelImpl;
import hr.crosig.proposal.service.persistence.ProposalContactPersistence;
import hr.crosig.proposal.service.persistence.ProposalContactUtil;
import hr.crosig.proposal.service.persistence.impl.constants.AP_ProposalPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the proposal contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProposalContactPersistence.class)
public class ProposalContactPersistenceImpl
	extends BasePersistenceImpl<ProposalContact>
	implements ProposalContactPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProposalContactUtil</code> to access the proposal contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProposalContactImpl.class.getName();

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
	 * Returns all the proposal contacts where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the matching proposal contacts
	 */
	@Override
	public List<ProposalContact> findByProposalId(long proposalId) {
		return findByProposalId(
			proposalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposal contacts where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalContactModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of proposal contacts
	 * @param end the upper bound of the range of proposal contacts (not inclusive)
	 * @return the range of matching proposal contacts
	 */
	@Override
	public List<ProposalContact> findByProposalId(
		long proposalId, int start, int end) {

		return findByProposalId(proposalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposal contacts where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalContactModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of proposal contacts
	 * @param end the upper bound of the range of proposal contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposal contacts
	 */
	@Override
	public List<ProposalContact> findByProposalId(
		long proposalId, int start, int end,
		OrderByComparator<ProposalContact> orderByComparator) {

		return findByProposalId(
			proposalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proposal contacts where proposalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalContactModelImpl</code>.
	 * </p>
	 *
	 * @param proposalId the proposal ID
	 * @param start the lower bound of the range of proposal contacts
	 * @param end the upper bound of the range of proposal contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proposal contacts
	 */
	@Override
	public List<ProposalContact> findByProposalId(
		long proposalId, int start, int end,
		OrderByComparator<ProposalContact> orderByComparator,
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

		List<ProposalContact> list = null;

		if (useFinderCache) {
			list = (List<ProposalContact>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProposalContact proposalContact : list) {
					if (proposalId != proposalContact.getProposalId()) {
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

			sb.append(_SQL_SELECT_PROPOSALCONTACT_WHERE);

			sb.append(_FINDER_COLUMN_PROPOSALID_PROPOSALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProposalContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(proposalId);

				list = (List<ProposalContact>)QueryUtil.list(
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
	 * Returns the first proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal contact
	 * @throws NoSuchProposalContactException if a matching proposal contact could not be found
	 */
	@Override
	public ProposalContact findByProposalId_First(
			long proposalId,
			OrderByComparator<ProposalContact> orderByComparator)
		throws NoSuchProposalContactException {

		ProposalContact proposalContact = fetchByProposalId_First(
			proposalId, orderByComparator);

		if (proposalContact != null) {
			return proposalContact;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("proposalId=");
		sb.append(proposalId);

		sb.append("}");

		throw new NoSuchProposalContactException(sb.toString());
	}

	/**
	 * Returns the first proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal contact, or <code>null</code> if a matching proposal contact could not be found
	 */
	@Override
	public ProposalContact fetchByProposalId_First(
		long proposalId, OrderByComparator<ProposalContact> orderByComparator) {

		List<ProposalContact> list = findByProposalId(
			proposalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal contact
	 * @throws NoSuchProposalContactException if a matching proposal contact could not be found
	 */
	@Override
	public ProposalContact findByProposalId_Last(
			long proposalId,
			OrderByComparator<ProposalContact> orderByComparator)
		throws NoSuchProposalContactException {

		ProposalContact proposalContact = fetchByProposalId_Last(
			proposalId, orderByComparator);

		if (proposalContact != null) {
			return proposalContact;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("proposalId=");
		sb.append(proposalId);

		sb.append("}");

		throw new NoSuchProposalContactException(sb.toString());
	}

	/**
	 * Returns the last proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal contact, or <code>null</code> if a matching proposal contact could not be found
	 */
	@Override
	public ProposalContact fetchByProposalId_Last(
		long proposalId, OrderByComparator<ProposalContact> orderByComparator) {

		int count = countByProposalId(proposalId);

		if (count == 0) {
			return null;
		}

		List<ProposalContact> list = findByProposalId(
			proposalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposal contacts before and after the current proposal contact in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalContactId the primary key of the current proposal contact
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposal contact
	 * @throws NoSuchProposalContactException if a proposal contact with the primary key could not be found
	 */
	@Override
	public ProposalContact[] findByProposalId_PrevAndNext(
			long proposalContactId, long proposalId,
			OrderByComparator<ProposalContact> orderByComparator)
		throws NoSuchProposalContactException {

		ProposalContact proposalContact = findByPrimaryKey(proposalContactId);

		Session session = null;

		try {
			session = openSession();

			ProposalContact[] array = new ProposalContactImpl[3];

			array[0] = getByProposalId_PrevAndNext(
				session, proposalContact, proposalId, orderByComparator, true);

			array[1] = proposalContact;

			array[2] = getByProposalId_PrevAndNext(
				session, proposalContact, proposalId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProposalContact getByProposalId_PrevAndNext(
		Session session, ProposalContact proposalContact, long proposalId,
		OrderByComparator<ProposalContact> orderByComparator,
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

		sb.append(_SQL_SELECT_PROPOSALCONTACT_WHERE);

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
			sb.append(ProposalContactModelImpl.ORDER_BY_JPQL);
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
						proposalContact)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProposalContact> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the proposal contacts where proposalId = &#63; from the database.
	 *
	 * @param proposalId the proposal ID
	 */
	@Override
	public void removeByProposalId(long proposalId) {
		for (ProposalContact proposalContact :
				findByProposalId(
					proposalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(proposalContact);
		}
	}

	/**
	 * Returns the number of proposal contacts where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the number of matching proposal contacts
	 */
	@Override
	public int countByProposalId(long proposalId) {
		FinderPath finderPath = _finderPathCountByProposalId;

		Object[] finderArgs = new Object[] {proposalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROPOSALCONTACT_WHERE);

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
		"proposalContact.proposalId = ?";

	public ProposalContactPersistenceImpl() {
		setModelClass(ProposalContact.class);

		setModelImplClass(ProposalContactImpl.class);
		setModelPKClass(long.class);

		setTable(ProposalContactTable.INSTANCE);
	}

	/**
	 * Caches the proposal contact in the entity cache if it is enabled.
	 *
	 * @param proposalContact the proposal contact
	 */
	@Override
	public void cacheResult(ProposalContact proposalContact) {
		entityCache.putResult(
			ProposalContactImpl.class, proposalContact.getPrimaryKey(),
			proposalContact);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the proposal contacts in the entity cache if it is enabled.
	 *
	 * @param proposalContacts the proposal contacts
	 */
	@Override
	public void cacheResult(List<ProposalContact> proposalContacts) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (proposalContacts.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProposalContact proposalContact : proposalContacts) {
			if (entityCache.getResult(
					ProposalContactImpl.class,
					proposalContact.getPrimaryKey()) == null) {

				cacheResult(proposalContact);
			}
		}
	}

	/**
	 * Clears the cache for all proposal contacts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProposalContactImpl.class);

		finderCache.clearCache(ProposalContactImpl.class);
	}

	/**
	 * Clears the cache for the proposal contact.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProposalContact proposalContact) {
		entityCache.removeResult(ProposalContactImpl.class, proposalContact);
	}

	@Override
	public void clearCache(List<ProposalContact> proposalContacts) {
		for (ProposalContact proposalContact : proposalContacts) {
			entityCache.removeResult(
				ProposalContactImpl.class, proposalContact);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProposalContactImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProposalContactImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new proposal contact with the primary key. Does not add the proposal contact to the database.
	 *
	 * @param proposalContactId the primary key for the new proposal contact
	 * @return the new proposal contact
	 */
	@Override
	public ProposalContact create(long proposalContactId) {
		ProposalContact proposalContact = new ProposalContactImpl();

		proposalContact.setNew(true);
		proposalContact.setPrimaryKey(proposalContactId);

		proposalContact.setCompanyId(CompanyThreadLocal.getCompanyId());

		return proposalContact;
	}

	/**
	 * Removes the proposal contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proposalContactId the primary key of the proposal contact
	 * @return the proposal contact that was removed
	 * @throws NoSuchProposalContactException if a proposal contact with the primary key could not be found
	 */
	@Override
	public ProposalContact remove(long proposalContactId)
		throws NoSuchProposalContactException {

		return remove((Serializable)proposalContactId);
	}

	/**
	 * Removes the proposal contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the proposal contact
	 * @return the proposal contact that was removed
	 * @throws NoSuchProposalContactException if a proposal contact with the primary key could not be found
	 */
	@Override
	public ProposalContact remove(Serializable primaryKey)
		throws NoSuchProposalContactException {

		Session session = null;

		try {
			session = openSession();

			ProposalContact proposalContact = (ProposalContact)session.get(
				ProposalContactImpl.class, primaryKey);

			if (proposalContact == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProposalContactException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(proposalContact);
		}
		catch (NoSuchProposalContactException noSuchEntityException) {
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
	protected ProposalContact removeImpl(ProposalContact proposalContact) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(proposalContact)) {
				proposalContact = (ProposalContact)session.get(
					ProposalContactImpl.class,
					proposalContact.getPrimaryKeyObj());
			}

			if (proposalContact != null) {
				session.delete(proposalContact);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (proposalContact != null) {
			clearCache(proposalContact);
		}

		return proposalContact;
	}

	@Override
	public ProposalContact updateImpl(ProposalContact proposalContact) {
		boolean isNew = proposalContact.isNew();

		if (!(proposalContact instanceof ProposalContactModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(proposalContact.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					proposalContact);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in proposalContact proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProposalContact implementation " +
					proposalContact.getClass());
		}

		ProposalContactModelImpl proposalContactModelImpl =
			(ProposalContactModelImpl)proposalContact;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (proposalContact.getCreateDate() == null)) {
			if (serviceContext == null) {
				proposalContact.setCreateDate(date);
			}
			else {
				proposalContact.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!proposalContactModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				proposalContact.setModifiedDate(date);
			}
			else {
				proposalContact.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(proposalContact);
			}
			else {
				proposalContact = (ProposalContact)session.merge(
					proposalContact);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProposalContactImpl.class, proposalContactModelImpl, false, true);

		if (isNew) {
			proposalContact.setNew(false);
		}

		proposalContact.resetOriginalValues();

		return proposalContact;
	}

	/**
	 * Returns the proposal contact with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the proposal contact
	 * @return the proposal contact
	 * @throws NoSuchProposalContactException if a proposal contact with the primary key could not be found
	 */
	@Override
	public ProposalContact findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProposalContactException {

		ProposalContact proposalContact = fetchByPrimaryKey(primaryKey);

		if (proposalContact == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProposalContactException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return proposalContact;
	}

	/**
	 * Returns the proposal contact with the primary key or throws a <code>NoSuchProposalContactException</code> if it could not be found.
	 *
	 * @param proposalContactId the primary key of the proposal contact
	 * @return the proposal contact
	 * @throws NoSuchProposalContactException if a proposal contact with the primary key could not be found
	 */
	@Override
	public ProposalContact findByPrimaryKey(long proposalContactId)
		throws NoSuchProposalContactException {

		return findByPrimaryKey((Serializable)proposalContactId);
	}

	/**
	 * Returns the proposal contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proposalContactId the primary key of the proposal contact
	 * @return the proposal contact, or <code>null</code> if a proposal contact with the primary key could not be found
	 */
	@Override
	public ProposalContact fetchByPrimaryKey(long proposalContactId) {
		return fetchByPrimaryKey((Serializable)proposalContactId);
	}

	/**
	 * Returns all the proposal contacts.
	 *
	 * @return the proposal contacts
	 */
	@Override
	public List<ProposalContact> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposal contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposal contacts
	 * @param end the upper bound of the range of proposal contacts (not inclusive)
	 * @return the range of proposal contacts
	 */
	@Override
	public List<ProposalContact> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposal contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposal contacts
	 * @param end the upper bound of the range of proposal contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proposal contacts
	 */
	@Override
	public List<ProposalContact> findAll(
		int start, int end,
		OrderByComparator<ProposalContact> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the proposal contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProposalContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposal contacts
	 * @param end the upper bound of the range of proposal contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of proposal contacts
	 */
	@Override
	public List<ProposalContact> findAll(
		int start, int end,
		OrderByComparator<ProposalContact> orderByComparator,
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

		List<ProposalContact> list = null;

		if (useFinderCache) {
			list = (List<ProposalContact>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROPOSALCONTACT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROPOSALCONTACT;

				sql = sql.concat(ProposalContactModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProposalContact>)QueryUtil.list(
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
	 * Removes all the proposal contacts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProposalContact proposalContact : findAll()) {
			remove(proposalContact);
		}
	}

	/**
	 * Returns the number of proposal contacts.
	 *
	 * @return the number of proposal contacts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROPOSALCONTACT);

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
		return "proposalContactId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROPOSALCONTACT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProposalContactModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the proposal contact persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByProposalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProposalId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"proposalId"}, true);

		_finderPathWithoutPaginationFindByProposalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProposalId",
			new String[] {Long.class.getName()}, new String[] {"proposalId"},
			true);

		_finderPathCountByProposalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProposalId",
			new String[] {Long.class.getName()}, new String[] {"proposalId"},
			false);

		ProposalContactUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ProposalContactUtil.setPersistence(null);

		entityCache.removeCache(ProposalContactImpl.class.getName());
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

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PROPOSALCONTACT =
		"SELECT proposalContact FROM ProposalContact proposalContact";

	private static final String _SQL_SELECT_PROPOSALCONTACT_WHERE =
		"SELECT proposalContact FROM ProposalContact proposalContact WHERE ";

	private static final String _SQL_COUNT_PROPOSALCONTACT =
		"SELECT COUNT(proposalContact) FROM ProposalContact proposalContact";

	private static final String _SQL_COUNT_PROPOSALCONTACT_WHERE =
		"SELECT COUNT(proposalContact) FROM ProposalContact proposalContact WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "proposalContact.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProposalContact exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProposalContact exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProposalContactPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}
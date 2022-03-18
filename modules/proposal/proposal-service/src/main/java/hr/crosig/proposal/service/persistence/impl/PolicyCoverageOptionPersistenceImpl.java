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

import hr.crosig.proposal.exception.NoSuchPolicyCoverageOptionException;
import hr.crosig.proposal.model.PolicyCoverageOption;
import hr.crosig.proposal.model.impl.PolicyCoverageOptionImpl;
import hr.crosig.proposal.model.impl.PolicyCoverageOptionModelImpl;
import hr.crosig.proposal.service.persistence.PolicyCoverageOptionPersistence;
import hr.crosig.proposal.service.persistence.PolicyCoverageOptionUtil;
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
 * The persistence implementation for the policy coverage option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PolicyCoverageOptionPersistence.class)
public class PolicyCoverageOptionPersistenceImpl
	extends BasePersistenceImpl<PolicyCoverageOption>
	implements PolicyCoverageOptionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PolicyCoverageOptionUtil</code> to access the policy coverage option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PolicyCoverageOptionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PolicyCoverageOptionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PolicyCoverageOption.class);

		setModelImplClass(PolicyCoverageOptionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the policy coverage option in the entity cache if it is enabled.
	 *
	 * @param policyCoverageOption the policy coverage option
	 */
	@Override
	public void cacheResult(PolicyCoverageOption policyCoverageOption) {
		entityCache.putResult(
			PolicyCoverageOptionImpl.class,
			policyCoverageOption.getPrimaryKey(), policyCoverageOption);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the policy coverage options in the entity cache if it is enabled.
	 *
	 * @param policyCoverageOptions the policy coverage options
	 */
	@Override
	public void cacheResult(List<PolicyCoverageOption> policyCoverageOptions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (policyCoverageOptions.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PolicyCoverageOption policyCoverageOption :
				policyCoverageOptions) {

			if (entityCache.getResult(
					PolicyCoverageOptionImpl.class,
					policyCoverageOption.getPrimaryKey()) == null) {

				cacheResult(policyCoverageOption);
			}
		}
	}

	/**
	 * Clears the cache for all policy coverage options.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PolicyCoverageOptionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the policy coverage option.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PolicyCoverageOption policyCoverageOption) {
		entityCache.removeResult(
			PolicyCoverageOptionImpl.class, policyCoverageOption);
	}

	@Override
	public void clearCache(List<PolicyCoverageOption> policyCoverageOptions) {
		for (PolicyCoverageOption policyCoverageOption :
				policyCoverageOptions) {

			entityCache.removeResult(
				PolicyCoverageOptionImpl.class, policyCoverageOption);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				PolicyCoverageOptionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new policy coverage option with the primary key. Does not add the policy coverage option to the database.
	 *
	 * @param policyCoverageOptionId the primary key for the new policy coverage option
	 * @return the new policy coverage option
	 */
	@Override
	public PolicyCoverageOption create(long policyCoverageOptionId) {
		PolicyCoverageOption policyCoverageOption =
			new PolicyCoverageOptionImpl();

		policyCoverageOption.setNew(true);
		policyCoverageOption.setPrimaryKey(policyCoverageOptionId);

		policyCoverageOption.setCompanyId(CompanyThreadLocal.getCompanyId());

		return policyCoverageOption;
	}

	/**
	 * Removes the policy coverage option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage option
	 * @return the policy coverage option that was removed
	 * @throws NoSuchPolicyCoverageOptionException if a policy coverage option with the primary key could not be found
	 */
	@Override
	public PolicyCoverageOption remove(long policyCoverageOptionId)
		throws NoSuchPolicyCoverageOptionException {

		return remove((Serializable)policyCoverageOptionId);
	}

	/**
	 * Removes the policy coverage option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the policy coverage option
	 * @return the policy coverage option that was removed
	 * @throws NoSuchPolicyCoverageOptionException if a policy coverage option with the primary key could not be found
	 */
	@Override
	public PolicyCoverageOption remove(Serializable primaryKey)
		throws NoSuchPolicyCoverageOptionException {

		Session session = null;

		try {
			session = openSession();

			PolicyCoverageOption policyCoverageOption =
				(PolicyCoverageOption)session.get(
					PolicyCoverageOptionImpl.class, primaryKey);

			if (policyCoverageOption == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPolicyCoverageOptionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(policyCoverageOption);
		}
		catch (NoSuchPolicyCoverageOptionException noSuchEntityException) {
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
	protected PolicyCoverageOption removeImpl(
		PolicyCoverageOption policyCoverageOption) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(policyCoverageOption)) {
				policyCoverageOption = (PolicyCoverageOption)session.get(
					PolicyCoverageOptionImpl.class,
					policyCoverageOption.getPrimaryKeyObj());
			}

			if (policyCoverageOption != null) {
				session.delete(policyCoverageOption);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (policyCoverageOption != null) {
			clearCache(policyCoverageOption);
		}

		return policyCoverageOption;
	}

	@Override
	public PolicyCoverageOption updateImpl(
		PolicyCoverageOption policyCoverageOption) {

		boolean isNew = policyCoverageOption.isNew();

		if (!(policyCoverageOption instanceof PolicyCoverageOptionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(policyCoverageOption.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					policyCoverageOption);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in policyCoverageOption proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PolicyCoverageOption implementation " +
					policyCoverageOption.getClass());
		}

		PolicyCoverageOptionModelImpl policyCoverageOptionModelImpl =
			(PolicyCoverageOptionModelImpl)policyCoverageOption;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (policyCoverageOption.getCreateDate() == null)) {
			if (serviceContext == null) {
				policyCoverageOption.setCreateDate(date);
			}
			else {
				policyCoverageOption.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!policyCoverageOptionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				policyCoverageOption.setModifiedDate(date);
			}
			else {
				policyCoverageOption.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(policyCoverageOption);
			}
			else {
				policyCoverageOption = (PolicyCoverageOption)session.merge(
					policyCoverageOption);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PolicyCoverageOptionImpl.class, policyCoverageOption, false, true);

		if (isNew) {
			policyCoverageOption.setNew(false);
		}

		policyCoverageOption.resetOriginalValues();

		return policyCoverageOption;
	}

	/**
	 * Returns the policy coverage option with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the policy coverage option
	 * @return the policy coverage option
	 * @throws NoSuchPolicyCoverageOptionException if a policy coverage option with the primary key could not be found
	 */
	@Override
	public PolicyCoverageOption findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPolicyCoverageOptionException {

		PolicyCoverageOption policyCoverageOption = fetchByPrimaryKey(
			primaryKey);

		if (policyCoverageOption == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPolicyCoverageOptionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return policyCoverageOption;
	}

	/**
	 * Returns the policy coverage option with the primary key or throws a <code>NoSuchPolicyCoverageOptionException</code> if it could not be found.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage option
	 * @return the policy coverage option
	 * @throws NoSuchPolicyCoverageOptionException if a policy coverage option with the primary key could not be found
	 */
	@Override
	public PolicyCoverageOption findByPrimaryKey(long policyCoverageOptionId)
		throws NoSuchPolicyCoverageOptionException {

		return findByPrimaryKey((Serializable)policyCoverageOptionId);
	}

	/**
	 * Returns the policy coverage option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage option
	 * @return the policy coverage option, or <code>null</code> if a policy coverage option with the primary key could not be found
	 */
	@Override
	public PolicyCoverageOption fetchByPrimaryKey(long policyCoverageOptionId) {
		return fetchByPrimaryKey((Serializable)policyCoverageOptionId);
	}

	/**
	 * Returns all the policy coverage options.
	 *
	 * @return the policy coverage options
	 */
	@Override
	public List<PolicyCoverageOption> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy coverage options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy coverage options
	 * @param end the upper bound of the range of policy coverage options (not inclusive)
	 * @return the range of policy coverage options
	 */
	@Override
	public List<PolicyCoverageOption> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy coverage options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy coverage options
	 * @param end the upper bound of the range of policy coverage options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy coverage options
	 */
	@Override
	public List<PolicyCoverageOption> findAll(
		int start, int end,
		OrderByComparator<PolicyCoverageOption> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy coverage options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyCoverageOptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy coverage options
	 * @param end the upper bound of the range of policy coverage options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy coverage options
	 */
	@Override
	public List<PolicyCoverageOption> findAll(
		int start, int end,
		OrderByComparator<PolicyCoverageOption> orderByComparator,
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

		List<PolicyCoverageOption> list = null;

		if (useFinderCache) {
			list = (List<PolicyCoverageOption>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POLICYCOVERAGEOPTION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POLICYCOVERAGEOPTION;

				sql = sql.concat(PolicyCoverageOptionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PolicyCoverageOption>)QueryUtil.list(
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
	 * Removes all the policy coverage options from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PolicyCoverageOption policyCoverageOption : findAll()) {
			remove(policyCoverageOption);
		}
	}

	/**
	 * Returns the number of policy coverage options.
	 *
	 * @return the number of policy coverage options
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_POLICYCOVERAGEOPTION);

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
		return _SQL_SELECT_POLICYCOVERAGEOPTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PolicyCoverageOptionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the policy coverage option persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new PolicyCoverageOptionModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PolicyCoverageOption.class.getName()));

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

		_setPolicyCoverageOptionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPolicyCoverageOptionUtilPersistence(null);

		entityCache.removeCache(PolicyCoverageOptionImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPolicyCoverageOptionUtilPersistence(
		PolicyCoverageOptionPersistence policyCoverageOptionPersistence) {

		try {
			Field field = PolicyCoverageOptionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, policyCoverageOptionPersistence);
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

	private static final String _SQL_SELECT_POLICYCOVERAGEOPTION =
		"SELECT policyCoverageOption FROM PolicyCoverageOption policyCoverageOption";

	private static final String _SQL_COUNT_POLICYCOVERAGEOPTION =
		"SELECT COUNT(policyCoverageOption) FROM PolicyCoverageOption policyCoverageOption";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"policyCoverageOption.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PolicyCoverageOption exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyCoverageOptionPersistenceImpl.class);

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

	private static class PolicyCoverageOptionModelArgumentsResolver
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

			PolicyCoverageOptionModelImpl policyCoverageOptionModelImpl =
				(PolicyCoverageOptionModelImpl)baseModel;

			long columnBitmask =
				policyCoverageOptionModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					policyCoverageOptionModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						policyCoverageOptionModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					policyCoverageOptionModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PolicyCoverageOptionModelImpl policyCoverageOptionModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						policyCoverageOptionModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = policyCoverageOptionModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}
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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import hr.crosig.proposal.exception.NoSuchInsuredRoleException;
import hr.crosig.proposal.model.InsuredRole;
import hr.crosig.proposal.model.impl.InsuredRoleImpl;
import hr.crosig.proposal.model.impl.InsuredRoleModelImpl;
import hr.crosig.proposal.service.persistence.InsuredRolePersistence;
import hr.crosig.proposal.service.persistence.InsuredRoleUtil;
import hr.crosig.proposal.service.persistence.impl.constants.AP_ProposalPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;

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
 * The persistence implementation for the insured role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = InsuredRolePersistence.class)
public class InsuredRolePersistenceImpl
	extends BasePersistenceImpl<InsuredRole> implements InsuredRolePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>InsuredRoleUtil</code> to access the insured role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		InsuredRoleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public InsuredRolePersistenceImpl() {
		setModelClass(InsuredRole.class);

		setModelImplClass(InsuredRoleImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the insured role in the entity cache if it is enabled.
	 *
	 * @param insuredRole the insured role
	 */
	@Override
	public void cacheResult(InsuredRole insuredRole) {
		entityCache.putResult(
			InsuredRoleImpl.class, insuredRole.getPrimaryKey(), insuredRole);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the insured roles in the entity cache if it is enabled.
	 *
	 * @param insuredRoles the insured roles
	 */
	@Override
	public void cacheResult(List<InsuredRole> insuredRoles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (insuredRoles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (InsuredRole insuredRole : insuredRoles) {
			if (entityCache.getResult(
					InsuredRoleImpl.class, insuredRole.getPrimaryKey()) ==
						null) {

				cacheResult(insuredRole);
			}
		}
	}

	/**
	 * Clears the cache for all insured roles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(InsuredRoleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the insured role.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InsuredRole insuredRole) {
		entityCache.removeResult(InsuredRoleImpl.class, insuredRole);
	}

	@Override
	public void clearCache(List<InsuredRole> insuredRoles) {
		for (InsuredRole insuredRole : insuredRoles) {
			entityCache.removeResult(InsuredRoleImpl.class, insuredRole);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(InsuredRoleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new insured role with the primary key. Does not add the insured role to the database.
	 *
	 * @param InsuredRoleId the primary key for the new insured role
	 * @return the new insured role
	 */
	@Override
	public InsuredRole create(long InsuredRoleId) {
		InsuredRole insuredRole = new InsuredRoleImpl();

		insuredRole.setNew(true);
		insuredRole.setPrimaryKey(InsuredRoleId);

		return insuredRole;
	}

	/**
	 * Removes the insured role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param InsuredRoleId the primary key of the insured role
	 * @return the insured role that was removed
	 * @throws NoSuchInsuredRoleException if a insured role with the primary key could not be found
	 */
	@Override
	public InsuredRole remove(long InsuredRoleId)
		throws NoSuchInsuredRoleException {

		return remove((Serializable)InsuredRoleId);
	}

	/**
	 * Removes the insured role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the insured role
	 * @return the insured role that was removed
	 * @throws NoSuchInsuredRoleException if a insured role with the primary key could not be found
	 */
	@Override
	public InsuredRole remove(Serializable primaryKey)
		throws NoSuchInsuredRoleException {

		Session session = null;

		try {
			session = openSession();

			InsuredRole insuredRole = (InsuredRole)session.get(
				InsuredRoleImpl.class, primaryKey);

			if (insuredRole == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInsuredRoleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(insuredRole);
		}
		catch (NoSuchInsuredRoleException noSuchEntityException) {
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
	protected InsuredRole removeImpl(InsuredRole insuredRole) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(insuredRole)) {
				insuredRole = (InsuredRole)session.get(
					InsuredRoleImpl.class, insuredRole.getPrimaryKeyObj());
			}

			if (insuredRole != null) {
				session.delete(insuredRole);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (insuredRole != null) {
			clearCache(insuredRole);
		}

		return insuredRole;
	}

	@Override
	public InsuredRole updateImpl(InsuredRole insuredRole) {
		boolean isNew = insuredRole.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(insuredRole);
			}
			else {
				insuredRole = (InsuredRole)session.merge(insuredRole);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(InsuredRoleImpl.class, insuredRole, false, true);

		if (isNew) {
			insuredRole.setNew(false);
		}

		insuredRole.resetOriginalValues();

		return insuredRole;
	}

	/**
	 * Returns the insured role with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the insured role
	 * @return the insured role
	 * @throws NoSuchInsuredRoleException if a insured role with the primary key could not be found
	 */
	@Override
	public InsuredRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInsuredRoleException {

		InsuredRole insuredRole = fetchByPrimaryKey(primaryKey);

		if (insuredRole == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInsuredRoleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return insuredRole;
	}

	/**
	 * Returns the insured role with the primary key or throws a <code>NoSuchInsuredRoleException</code> if it could not be found.
	 *
	 * @param InsuredRoleId the primary key of the insured role
	 * @return the insured role
	 * @throws NoSuchInsuredRoleException if a insured role with the primary key could not be found
	 */
	@Override
	public InsuredRole findByPrimaryKey(long InsuredRoleId)
		throws NoSuchInsuredRoleException {

		return findByPrimaryKey((Serializable)InsuredRoleId);
	}

	/**
	 * Returns the insured role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param InsuredRoleId the primary key of the insured role
	 * @return the insured role, or <code>null</code> if a insured role with the primary key could not be found
	 */
	@Override
	public InsuredRole fetchByPrimaryKey(long InsuredRoleId) {
		return fetchByPrimaryKey((Serializable)InsuredRoleId);
	}

	/**
	 * Returns all the insured roles.
	 *
	 * @return the insured roles
	 */
	@Override
	public List<InsuredRole> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the insured roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InsuredRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insured roles
	 * @param end the upper bound of the range of insured roles (not inclusive)
	 * @return the range of insured roles
	 */
	@Override
	public List<InsuredRole> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the insured roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InsuredRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insured roles
	 * @param end the upper bound of the range of insured roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of insured roles
	 */
	@Override
	public List<InsuredRole> findAll(
		int start, int end, OrderByComparator<InsuredRole> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the insured roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InsuredRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insured roles
	 * @param end the upper bound of the range of insured roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of insured roles
	 */
	@Override
	public List<InsuredRole> findAll(
		int start, int end, OrderByComparator<InsuredRole> orderByComparator,
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

		List<InsuredRole> list = null;

		if (useFinderCache) {
			list = (List<InsuredRole>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_INSUREDROLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_INSUREDROLE;

				sql = sql.concat(InsuredRoleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<InsuredRole>)QueryUtil.list(
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
	 * Removes all the insured roles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (InsuredRole insuredRole : findAll()) {
			remove(insuredRole);
		}
	}

	/**
	 * Returns the number of insured roles.
	 *
	 * @return the number of insured roles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_INSUREDROLE);

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
		return "InsuredRoleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_INSUREDROLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return InsuredRoleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the insured role persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new InsuredRoleModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", InsuredRole.class.getName()));

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

		_setInsuredRoleUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setInsuredRoleUtilPersistence(null);

		entityCache.removeCache(InsuredRoleImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setInsuredRoleUtilPersistence(
		InsuredRolePersistence insuredRolePersistence) {

		try {
			Field field = InsuredRoleUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, insuredRolePersistence);
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

	private static final String _SQL_SELECT_INSUREDROLE =
		"SELECT insuredRole FROM InsuredRole insuredRole";

	private static final String _SQL_COUNT_INSUREDROLE =
		"SELECT COUNT(insuredRole) FROM InsuredRole insuredRole";

	private static final String _ORDER_BY_ENTITY_ALIAS = "insuredRole.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No InsuredRole exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		InsuredRolePersistenceImpl.class);

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

	private static class InsuredRoleModelArgumentsResolver
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

			InsuredRoleModelImpl insuredRoleModelImpl =
				(InsuredRoleModelImpl)baseModel;

			long columnBitmask = insuredRoleModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(insuredRoleModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						insuredRoleModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(insuredRoleModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			InsuredRoleModelImpl insuredRoleModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = insuredRoleModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = insuredRoleModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}
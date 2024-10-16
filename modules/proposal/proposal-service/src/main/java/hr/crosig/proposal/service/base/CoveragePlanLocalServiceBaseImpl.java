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

package hr.crosig.proposal.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import hr.crosig.proposal.model.CoveragePlan;
import hr.crosig.proposal.service.CoveragePlanLocalService;
import hr.crosig.proposal.service.CoveragePlanLocalServiceUtil;
import hr.crosig.proposal.service.persistence.CoveragePlanPersistence;
import hr.crosig.proposal.service.persistence.InsuredRolePersistence;
import hr.crosig.proposal.service.persistence.PolicyCoverageOptPersistence;
import hr.crosig.proposal.service.persistence.PolicyOptionsPersistence;
import hr.crosig.proposal.service.persistence.ProductPersistence;
import hr.crosig.proposal.service.persistence.ProductRolePersistence;
import hr.crosig.proposal.service.persistence.ProposalContactPersistence;
import hr.crosig.proposal.service.persistence.ProposalPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the coverage plan local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link hr.crosig.proposal.service.impl.CoveragePlanLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see hr.crosig.proposal.service.impl.CoveragePlanLocalServiceImpl
 * @generated
 */
public abstract class CoveragePlanLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, CoveragePlanLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CoveragePlanLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CoveragePlanLocalServiceUtil</code>.
	 */

	/**
	 * Adds the coverage plan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CoveragePlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param coveragePlan the coverage plan
	 * @return the coverage plan that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CoveragePlan addCoveragePlan(CoveragePlan coveragePlan) {
		coveragePlan.setNew(true);

		return coveragePlanPersistence.update(coveragePlan);
	}

	/**
	 * Creates a new coverage plan with the primary key. Does not add the coverage plan to the database.
	 *
	 * @param coveragePlanId the primary key for the new coverage plan
	 * @return the new coverage plan
	 */
	@Override
	@Transactional(enabled = false)
	public CoveragePlan createCoveragePlan(long coveragePlanId) {
		return coveragePlanPersistence.create(coveragePlanId);
	}

	/**
	 * Deletes the coverage plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CoveragePlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param coveragePlanId the primary key of the coverage plan
	 * @return the coverage plan that was removed
	 * @throws PortalException if a coverage plan with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CoveragePlan deleteCoveragePlan(long coveragePlanId)
		throws PortalException {

		return coveragePlanPersistence.remove(coveragePlanId);
	}

	/**
	 * Deletes the coverage plan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CoveragePlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param coveragePlan the coverage plan
	 * @return the coverage plan that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CoveragePlan deleteCoveragePlan(CoveragePlan coveragePlan) {
		return coveragePlanPersistence.remove(coveragePlan);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CoveragePlan.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return coveragePlanPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return coveragePlanPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return coveragePlanPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return coveragePlanPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return coveragePlanPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CoveragePlan fetchCoveragePlan(long coveragePlanId) {
		return coveragePlanPersistence.fetchByPrimaryKey(coveragePlanId);
	}

	/**
	 * Returns the coverage plan with the primary key.
	 *
	 * @param coveragePlanId the primary key of the coverage plan
	 * @return the coverage plan
	 * @throws PortalException if a coverage plan with the primary key could not be found
	 */
	@Override
	public CoveragePlan getCoveragePlan(long coveragePlanId)
		throws PortalException {

		return coveragePlanPersistence.findByPrimaryKey(coveragePlanId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(coveragePlanLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CoveragePlan.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("coveragePlanId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			coveragePlanLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(CoveragePlan.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"coveragePlanId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(coveragePlanLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CoveragePlan.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("coveragePlanId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return coveragePlanPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return coveragePlanLocalService.deleteCoveragePlan(
			(CoveragePlan)persistedModel);
	}

	public BasePersistence<CoveragePlan> getBasePersistence() {
		return coveragePlanPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return coveragePlanPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the coverage plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.CoveragePlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coverage plans
	 * @param end the upper bound of the range of coverage plans (not inclusive)
	 * @return the range of coverage plans
	 */
	@Override
	public List<CoveragePlan> getCoveragePlans(int start, int end) {
		return coveragePlanPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of coverage plans.
	 *
	 * @return the number of coverage plans
	 */
	@Override
	public int getCoveragePlansCount() {
		return coveragePlanPersistence.countAll();
	}

	/**
	 * Updates the coverage plan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CoveragePlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param coveragePlan the coverage plan
	 * @return the coverage plan that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CoveragePlan updateCoveragePlan(CoveragePlan coveragePlan) {
		return coveragePlanPersistence.update(coveragePlan);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CoveragePlanLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		coveragePlanLocalService = (CoveragePlanLocalService)aopProxy;

		_setLocalServiceUtilService(coveragePlanLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CoveragePlanLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CoveragePlan.class;
	}

	protected String getModelClassName() {
		return CoveragePlan.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = coveragePlanPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		CoveragePlanLocalService coveragePlanLocalService) {

		try {
			Field field = CoveragePlanLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, coveragePlanLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected CoveragePlanLocalService coveragePlanLocalService;

	@Reference
	protected CoveragePlanPersistence coveragePlanPersistence;

	@Reference
	protected InsuredRolePersistence insuredRolePersistence;

	@Reference
	protected PolicyCoverageOptPersistence policyCoverageOptPersistence;

	@Reference
	protected PolicyOptionsPersistence policyOptionsPersistence;

	@Reference
	protected ProductPersistence productPersistence;

	@Reference
	protected ProductRolePersistence productRolePersistence;

	@Reference
	protected ProposalPersistence proposalPersistence;

	@Reference
	protected ProposalContactPersistence proposalContactPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}
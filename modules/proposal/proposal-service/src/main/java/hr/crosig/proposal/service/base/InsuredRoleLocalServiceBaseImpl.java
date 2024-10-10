/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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

import hr.crosig.proposal.model.InsuredRole;
import hr.crosig.proposal.service.InsuredRoleLocalService;
import hr.crosig.proposal.service.persistence.CoveragePlanPersistence;
import hr.crosig.proposal.service.persistence.InsuredRolePersistence;
import hr.crosig.proposal.service.persistence.PolicyCoverageOptPersistence;
import hr.crosig.proposal.service.persistence.PolicyOptionsPersistence;
import hr.crosig.proposal.service.persistence.ProductPersistence;
import hr.crosig.proposal.service.persistence.ProductRolePersistence;
import hr.crosig.proposal.service.persistence.ProposalContactPersistence;
import hr.crosig.proposal.service.persistence.ProposalPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the insured role local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link hr.crosig.proposal.service.impl.InsuredRoleLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see hr.crosig.proposal.service.impl.InsuredRoleLocalServiceImpl
 * @generated
 */
public abstract class InsuredRoleLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, InsuredRoleLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>InsuredRoleLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>hr.crosig.proposal.service.InsuredRoleLocalServiceUtil</code>.
	 */

	/**
	 * Adds the insured role to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InsuredRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param insuredRole the insured role
	 * @return the insured role that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public InsuredRole addInsuredRole(InsuredRole insuredRole) {
		insuredRole.setNew(true);

		return insuredRolePersistence.update(insuredRole);
	}

	/**
	 * Creates a new insured role with the primary key. Does not add the insured role to the database.
	 *
	 * @param InsuredRoleId the primary key for the new insured role
	 * @return the new insured role
	 */
	@Override
	@Transactional(enabled = false)
	public InsuredRole createInsuredRole(long InsuredRoleId) {
		return insuredRolePersistence.create(InsuredRoleId);
	}

	/**
	 * Deletes the insured role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InsuredRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param InsuredRoleId the primary key of the insured role
	 * @return the insured role that was removed
	 * @throws PortalException if a insured role with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public InsuredRole deleteInsuredRole(long InsuredRoleId)
		throws PortalException {

		return insuredRolePersistence.remove(InsuredRoleId);
	}

	/**
	 * Deletes the insured role from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InsuredRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param insuredRole the insured role
	 * @return the insured role that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public InsuredRole deleteInsuredRole(InsuredRole insuredRole) {
		return insuredRolePersistence.remove(insuredRole);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return insuredRolePersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			InsuredRole.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return insuredRolePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.InsuredRoleModelImpl</code>.
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

		return insuredRolePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.InsuredRoleModelImpl</code>.
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

		return insuredRolePersistence.findWithDynamicQuery(
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
		return insuredRolePersistence.countWithDynamicQuery(dynamicQuery);
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

		return insuredRolePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public InsuredRole fetchInsuredRole(long InsuredRoleId) {
		return insuredRolePersistence.fetchByPrimaryKey(InsuredRoleId);
	}

	/**
	 * Returns the insured role with the primary key.
	 *
	 * @param InsuredRoleId the primary key of the insured role
	 * @return the insured role
	 * @throws PortalException if a insured role with the primary key could not be found
	 */
	@Override
	public InsuredRole getInsuredRole(long InsuredRoleId)
		throws PortalException {

		return insuredRolePersistence.findByPrimaryKey(InsuredRoleId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(insuredRoleLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(InsuredRole.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("InsuredRoleId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			insuredRoleLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(InsuredRole.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"InsuredRoleId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(insuredRoleLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(InsuredRole.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("InsuredRoleId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return insuredRolePersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement InsuredRoleLocalServiceImpl#deleteInsuredRole(InsuredRole) to avoid orphaned data");
		}

		return insuredRoleLocalService.deleteInsuredRole(
			(InsuredRole)persistedModel);
	}

	@Override
	public BasePersistence<InsuredRole> getBasePersistence() {
		return insuredRolePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return insuredRolePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the insured roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.InsuredRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of insured roles
	 * @param end the upper bound of the range of insured roles (not inclusive)
	 * @return the range of insured roles
	 */
	@Override
	public List<InsuredRole> getInsuredRoles(int start, int end) {
		return insuredRolePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of insured roles.
	 *
	 * @return the number of insured roles
	 */
	@Override
	public int getInsuredRolesCount() {
		return insuredRolePersistence.countAll();
	}

	/**
	 * Updates the insured role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InsuredRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param insuredRole the insured role
	 * @return the insured role that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public InsuredRole updateInsuredRole(InsuredRole insuredRole) {
		return insuredRolePersistence.update(insuredRole);
	}

	@Deactivate
	protected void deactivate() {
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			InsuredRoleLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		insuredRoleLocalService = (InsuredRoleLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return InsuredRoleLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return InsuredRole.class;
	}

	protected String getModelClassName() {
		return InsuredRole.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = insuredRolePersistence.getDataSource();

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

	@Reference
	protected CoveragePlanPersistence coveragePlanPersistence;

	protected InsuredRoleLocalService insuredRoleLocalService;

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

	private static final Log _log = LogFactoryUtil.getLog(
		InsuredRoleLocalServiceBaseImpl.class);

}
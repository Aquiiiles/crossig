/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CoveragePlanLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CoveragePlanLocalService
 * @generated
 */
public class CoveragePlanLocalServiceWrapper
	implements CoveragePlanLocalService,
			   ServiceWrapper<CoveragePlanLocalService> {

	public CoveragePlanLocalServiceWrapper() {
		this(null);
	}

	public CoveragePlanLocalServiceWrapper(
		CoveragePlanLocalService coveragePlanLocalService) {

		_coveragePlanLocalService = coveragePlanLocalService;
	}

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
	@Override
	public hr.crosig.proposal.model.CoveragePlan addCoveragePlan(
		hr.crosig.proposal.model.CoveragePlan coveragePlan) {

		return _coveragePlanLocalService.addCoveragePlan(coveragePlan);
	}

	@Override
	public hr.crosig.proposal.model.CoveragePlan addCoveragePlan(
			String name, String category, String description)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coveragePlanLocalService.addCoveragePlan(
			name, category, description);
	}

	/**
	 * Creates a new coverage plan with the primary key. Does not add the coverage plan to the database.
	 *
	 * @param coveragePlanId the primary key for the new coverage plan
	 * @return the new coverage plan
	 */
	@Override
	public hr.crosig.proposal.model.CoveragePlan createCoveragePlan(
		long coveragePlanId) {

		return _coveragePlanLocalService.createCoveragePlan(coveragePlanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coveragePlanLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public hr.crosig.proposal.model.CoveragePlan deleteCoveragePlan(
		hr.crosig.proposal.model.CoveragePlan coveragePlan) {

		return _coveragePlanLocalService.deleteCoveragePlan(coveragePlan);
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
	@Override
	public hr.crosig.proposal.model.CoveragePlan deleteCoveragePlan(
			long coveragePlanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coveragePlanLocalService.deleteCoveragePlan(coveragePlanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coveragePlanLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _coveragePlanLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _coveragePlanLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _coveragePlanLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _coveragePlanLocalService.dynamicQuery(dynamicQuery);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _coveragePlanLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _coveragePlanLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _coveragePlanLocalService.dynamicQueryCount(dynamicQuery);
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _coveragePlanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public hr.crosig.proposal.model.CoveragePlan fetchCoveragePlan(
		long coveragePlanId) {

		return _coveragePlanLocalService.fetchCoveragePlan(coveragePlanId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _coveragePlanLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the coverage plan with the primary key.
	 *
	 * @param coveragePlanId the primary key of the coverage plan
	 * @return the coverage plan
	 * @throws PortalException if a coverage plan with the primary key could not be found
	 */
	@Override
	public hr.crosig.proposal.model.CoveragePlan getCoveragePlan(
			long coveragePlanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coveragePlanLocalService.getCoveragePlan(coveragePlanId);
	}

	@Override
	public hr.crosig.proposal.model.CoveragePlan getCoveragePlanByName(
		String name) {

		return _coveragePlanLocalService.getCoveragePlanByName(name);
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
	public java.util.List<hr.crosig.proposal.model.CoveragePlan>
		getCoveragePlans(int start, int end) {

		return _coveragePlanLocalService.getCoveragePlans(start, end);
	}

	@Override
	public java.util.List<hr.crosig.proposal.dto.CoveragePlanDTO>
		getCoveragePlansByCategory(String category) {

		return _coveragePlanLocalService.getCoveragePlansByCategory(category);
	}

	/**
	 * Returns the number of coverage plans.
	 *
	 * @return the number of coverage plans
	 */
	@Override
	public int getCoveragePlansCount() {
		return _coveragePlanLocalService.getCoveragePlansCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _coveragePlanLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _coveragePlanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _coveragePlanLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public hr.crosig.proposal.model.CoveragePlan updateCoveragePlan(
		hr.crosig.proposal.model.CoveragePlan coveragePlan) {

		return _coveragePlanLocalService.updateCoveragePlan(coveragePlan);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _coveragePlanLocalService.getBasePersistence();
	}

	@Override
	public CoveragePlanLocalService getWrappedService() {
		return _coveragePlanLocalService;
	}

	@Override
	public void setWrappedService(
		CoveragePlanLocalService coveragePlanLocalService) {

		_coveragePlanLocalService = coveragePlanLocalService;
	}

	private CoveragePlanLocalService _coveragePlanLocalService;

}
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link InsuredRoleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see InsuredRoleLocalService
 * @generated
 */
public class InsuredRoleLocalServiceWrapper
	implements InsuredRoleLocalService,
			   ServiceWrapper<InsuredRoleLocalService> {

	public InsuredRoleLocalServiceWrapper() {
		this(null);
	}

	public InsuredRoleLocalServiceWrapper(
		InsuredRoleLocalService insuredRoleLocalService) {

		_insuredRoleLocalService = insuredRoleLocalService;
	}

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
	@Override
	public hr.crosig.proposal.model.InsuredRole addInsuredRole(
		hr.crosig.proposal.model.InsuredRole insuredRole) {

		return _insuredRoleLocalService.addInsuredRole(insuredRole);
	}

	/**
	 * Creates a new insured role with the primary key. Does not add the insured role to the database.
	 *
	 * @param InsuredRoleId the primary key for the new insured role
	 * @return the new insured role
	 */
	@Override
	public hr.crosig.proposal.model.InsuredRole createInsuredRole(
		long InsuredRoleId) {

		return _insuredRoleLocalService.createInsuredRole(InsuredRoleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _insuredRoleLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public hr.crosig.proposal.model.InsuredRole deleteInsuredRole(
		hr.crosig.proposal.model.InsuredRole insuredRole) {

		return _insuredRoleLocalService.deleteInsuredRole(insuredRole);
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
	@Override
	public hr.crosig.proposal.model.InsuredRole deleteInsuredRole(
			long InsuredRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _insuredRoleLocalService.deleteInsuredRole(InsuredRoleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _insuredRoleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _insuredRoleLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _insuredRoleLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _insuredRoleLocalService.dynamicQuery();
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

		return _insuredRoleLocalService.dynamicQuery(dynamicQuery);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _insuredRoleLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _insuredRoleLocalService.dynamicQuery(
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

		return _insuredRoleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _insuredRoleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public hr.crosig.proposal.model.InsuredRole fetchInsuredRole(
		long InsuredRoleId) {

		return _insuredRoleLocalService.fetchInsuredRole(InsuredRoleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _insuredRoleLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<hr.crosig.proposal.dto.InsuredRoleDTO>
		getAllInsuredRole() {

		return _insuredRoleLocalService.getAllInsuredRole();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _insuredRoleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the insured role with the primary key.
	 *
	 * @param InsuredRoleId the primary key of the insured role
	 * @return the insured role
	 * @throws PortalException if a insured role with the primary key could not be found
	 */
	@Override
	public hr.crosig.proposal.model.InsuredRole getInsuredRole(
			long InsuredRoleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _insuredRoleLocalService.getInsuredRole(InsuredRoleId);
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
	public java.util.List<hr.crosig.proposal.model.InsuredRole> getInsuredRoles(
		int start, int end) {

		return _insuredRoleLocalService.getInsuredRoles(start, end);
	}

	/**
	 * Returns the number of insured roles.
	 *
	 * @return the number of insured roles
	 */
	@Override
	public int getInsuredRolesCount() {
		return _insuredRoleLocalService.getInsuredRolesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _insuredRoleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _insuredRoleLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public hr.crosig.proposal.model.InsuredRole updateInsuredRole(
		hr.crosig.proposal.model.InsuredRole insuredRole) {

		return _insuredRoleLocalService.updateInsuredRole(insuredRole);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _insuredRoleLocalService.getBasePersistence();
	}

	@Override
	public InsuredRoleLocalService getWrappedService() {
		return _insuredRoleLocalService;
	}

	@Override
	public void setWrappedService(
		InsuredRoleLocalService insuredRoleLocalService) {

		_insuredRoleLocalService = insuredRoleLocalService;
	}

	private InsuredRoleLocalService _insuredRoleLocalService;

}
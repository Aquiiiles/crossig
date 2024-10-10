/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PolicyOptionsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyOptionsLocalService
 * @generated
 */
public class PolicyOptionsLocalServiceWrapper
	implements PolicyOptionsLocalService,
			   ServiceWrapper<PolicyOptionsLocalService> {

	public PolicyOptionsLocalServiceWrapper() {
		this(null);
	}

	public PolicyOptionsLocalServiceWrapper(
		PolicyOptionsLocalService policyOptionsLocalService) {

		_policyOptionsLocalService = policyOptionsLocalService;
	}

	/**
	 * Adds the policy options to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyOptionsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyOptions the policy options
	 * @return the policy options that was added
	 */
	@Override
	public hr.crosig.proposal.model.PolicyOptions addPolicyOptions(
		hr.crosig.proposal.model.PolicyOptions policyOptions) {

		return _policyOptionsLocalService.addPolicyOptions(policyOptions);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyOptionsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new policy options with the primary key. Does not add the policy options to the database.
	 *
	 * @param policyOptionsId the primary key for the new policy options
	 * @return the new policy options
	 */
	@Override
	public hr.crosig.proposal.model.PolicyOptions createPolicyOptions(
		long policyOptionsId) {

		return _policyOptionsLocalService.createPolicyOptions(policyOptionsId);
	}

	@Override
	public hr.crosig.proposal.dto.PolicyOptionsDTO createPolicyOptions(
		hr.crosig.proposal.dto.PolicyOptionsDTO policyOptionsDTO,
		hr.crosig.proposal.model.Proposal proposal) {

		return _policyOptionsLocalService.createPolicyOptions(
			policyOptionsDTO, proposal);
	}

	@Override
	public void deleteAllByProposalId(long proposalId)
		throws hr.crosig.proposal.exception.NoSuchPolicyOptionsException {

		_policyOptionsLocalService.deleteAllByProposalId(proposalId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyOptionsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the policy options with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyOptionsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyOptionsId the primary key of the policy options
	 * @return the policy options that was removed
	 * @throws PortalException if a policy options with the primary key could not be found
	 */
	@Override
	public hr.crosig.proposal.model.PolicyOptions deletePolicyOptions(
			long policyOptionsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyOptionsLocalService.deletePolicyOptions(policyOptionsId);
	}

	/**
	 * Deletes the policy options from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyOptionsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyOptions the policy options
	 * @return the policy options that was removed
	 */
	@Override
	public hr.crosig.proposal.model.PolicyOptions deletePolicyOptions(
		hr.crosig.proposal.model.PolicyOptions policyOptions) {

		return _policyOptionsLocalService.deletePolicyOptions(policyOptions);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _policyOptionsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _policyOptionsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _policyOptionsLocalService.dynamicQuery();
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

		return _policyOptionsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.PolicyOptionsModelImpl</code>.
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

		return _policyOptionsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.PolicyOptionsModelImpl</code>.
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

		return _policyOptionsLocalService.dynamicQuery(
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

		return _policyOptionsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _policyOptionsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public hr.crosig.proposal.model.PolicyOptions fetchPolicyOptions(
		long policyOptionsId) {

		return _policyOptionsLocalService.fetchPolicyOptions(policyOptionsId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _policyOptionsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _policyOptionsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyOptionsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyOptionsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the policy options with the primary key.
	 *
	 * @param policyOptionsId the primary key of the policy options
	 * @return the policy options
	 * @throws PortalException if a policy options with the primary key could not be found
	 */
	@Override
	public hr.crosig.proposal.model.PolicyOptions getPolicyOptions(
			long policyOptionsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyOptionsLocalService.getPolicyOptions(policyOptionsId);
	}

	/**
	 * Returns a range of all the policy optionses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.PolicyOptionsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy optionses
	 * @param end the upper bound of the range of policy optionses (not inclusive)
	 * @return the range of policy optionses
	 */
	@Override
	public java.util.List<hr.crosig.proposal.model.PolicyOptions>
		getPolicyOptionses(int start, int end) {

		return _policyOptionsLocalService.getPolicyOptionses(start, end);
	}

	/**
	 * Returns the number of policy optionses.
	 *
	 * @return the number of policy optionses
	 */
	@Override
	public int getPolicyOptionsesCount() {
		return _policyOptionsLocalService.getPolicyOptionsesCount();
	}

	@Override
	public hr.crosig.proposal.dto.PolicyOptionsDTO getProposalPolicyOptions(
		long proposalId) {

		return _policyOptionsLocalService.getProposalPolicyOptions(proposalId);
	}

	/**
	 * Updates the policy options in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyOptionsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyOptions the policy options
	 * @return the policy options that was updated
	 */
	@Override
	public hr.crosig.proposal.model.PolicyOptions updatePolicyOptions(
		hr.crosig.proposal.model.PolicyOptions policyOptions) {

		return _policyOptionsLocalService.updatePolicyOptions(policyOptions);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _policyOptionsLocalService.getBasePersistence();
	}

	@Override
	public PolicyOptionsLocalService getWrappedService() {
		return _policyOptionsLocalService;
	}

	@Override
	public void setWrappedService(
		PolicyOptionsLocalService policyOptionsLocalService) {

		_policyOptionsLocalService = policyOptionsLocalService;
	}

	private PolicyOptionsLocalService _policyOptionsLocalService;

}
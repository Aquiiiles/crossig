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

package hr.crosig.proposal.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PolicyCoverageOptLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCoverageOptLocalService
 * @generated
 */
public class PolicyCoverageOptLocalServiceWrapper
	implements PolicyCoverageOptLocalService,
			   ServiceWrapper<PolicyCoverageOptLocalService> {

	public PolicyCoverageOptLocalServiceWrapper(
		PolicyCoverageOptLocalService policyCoverageOptLocalService) {

		_policyCoverageOptLocalService = policyCoverageOptLocalService;
	}

	/**
	 * Adds the policy coverage opt to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyCoverageOptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyCoverageOpt the policy coverage opt
	 * @return the policy coverage opt that was added
	 */
	@Override
	public hr.crosig.proposal.model.PolicyCoverageOpt addPolicyCoverageOpt(
		hr.crosig.proposal.model.PolicyCoverageOpt policyCoverageOpt) {

		return _policyCoverageOptLocalService.addPolicyCoverageOpt(
			policyCoverageOpt);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyCoverageOptLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new policy coverage opt with the primary key. Does not add the policy coverage opt to the database.
	 *
	 * @param policyCoverageOptionId the primary key for the new policy coverage opt
	 * @return the new policy coverage opt
	 */
	@Override
	public hr.crosig.proposal.model.PolicyCoverageOpt createPolicyCoverageOpt(
		long policyCoverageOptionId) {

		return _policyCoverageOptLocalService.createPolicyCoverageOpt(
			policyCoverageOptionId);
	}

	@Override
	public hr.crosig.proposal.dto.PolicyCoverageOptionDTO
		createPolicyCoverageOpt(
			hr.crosig.proposal.dto.PolicyCoverageOptionDTO
				policyCoverageOptDTO) {

		return _policyCoverageOptLocalService.createPolicyCoverageOpt(
			policyCoverageOptDTO);
	}

	@Override
	public void deleteAllByProposalId(long proposalId) {
		_policyCoverageOptLocalService.deleteAllByProposalId(proposalId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyCoverageOptLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the policy coverage opt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyCoverageOptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage opt
	 * @return the policy coverage opt that was removed
	 * @throws PortalException if a policy coverage opt with the primary key could not be found
	 */
	@Override
	public hr.crosig.proposal.model.PolicyCoverageOpt deletePolicyCoverageOpt(
			long policyCoverageOptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyCoverageOptLocalService.deletePolicyCoverageOpt(
			policyCoverageOptionId);
	}

	/**
	 * Deletes the policy coverage opt from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyCoverageOptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyCoverageOpt the policy coverage opt
	 * @return the policy coverage opt that was removed
	 */
	@Override
	public hr.crosig.proposal.model.PolicyCoverageOpt deletePolicyCoverageOpt(
		hr.crosig.proposal.model.PolicyCoverageOpt policyCoverageOpt) {

		return _policyCoverageOptLocalService.deletePolicyCoverageOpt(
			policyCoverageOpt);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _policyCoverageOptLocalService.dynamicQuery();
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

		return _policyCoverageOptLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.PolicyCoverageOptModelImpl</code>.
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

		return _policyCoverageOptLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.PolicyCoverageOptModelImpl</code>.
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

		return _policyCoverageOptLocalService.dynamicQuery(
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

		return _policyCoverageOptLocalService.dynamicQueryCount(dynamicQuery);
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

		return _policyCoverageOptLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public hr.crosig.proposal.model.PolicyCoverageOpt fetchPolicyCoverageOpt(
		long policyCoverageOptionId) {

		return _policyCoverageOptLocalService.fetchPolicyCoverageOpt(
			policyCoverageOptionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _policyCoverageOptLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _policyCoverageOptLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyCoverageOptLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyCoverageOptLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the policy coverage opt with the primary key.
	 *
	 * @param policyCoverageOptionId the primary key of the policy coverage opt
	 * @return the policy coverage opt
	 * @throws PortalException if a policy coverage opt with the primary key could not be found
	 */
	@Override
	public hr.crosig.proposal.model.PolicyCoverageOpt getPolicyCoverageOpt(
			long policyCoverageOptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyCoverageOptLocalService.getPolicyCoverageOpt(
			policyCoverageOptionId);
	}

	/**
	 * Returns a range of all the policy coverage opts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.PolicyCoverageOptModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy coverage opts
	 * @param end the upper bound of the range of policy coverage opts (not inclusive)
	 * @return the range of policy coverage opts
	 */
	@Override
	public java.util.List<hr.crosig.proposal.model.PolicyCoverageOpt>
		getPolicyCoverageOpts(int start, int end) {

		return _policyCoverageOptLocalService.getPolicyCoverageOpts(start, end);
	}

	/**
	 * Returns the number of policy coverage opts.
	 *
	 * @return the number of policy coverage opts
	 */
	@Override
	public int getPolicyCoverageOptsCount() {
		return _policyCoverageOptLocalService.getPolicyCoverageOptsCount();
	}

	@Override
	public java.util.List<hr.crosig.proposal.dto.PolicyCoverageOptionDTO>
		getProposalCoverageOptions(long proposalId) {

		return _policyCoverageOptLocalService.getProposalCoverageOptions(
			proposalId);
	}

	/**
	 * Updates the policy coverage opt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyCoverageOptLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyCoverageOpt the policy coverage opt
	 * @return the policy coverage opt that was updated
	 */
	@Override
	public hr.crosig.proposal.model.PolicyCoverageOpt updatePolicyCoverageOpt(
		hr.crosig.proposal.model.PolicyCoverageOpt policyCoverageOpt) {

		return _policyCoverageOptLocalService.updatePolicyCoverageOpt(
			policyCoverageOpt);
	}

	@Override
	public hr.crosig.proposal.dto.PolicyCoverageOptionDTO
			updatePolicyCoverageOpt(
				hr.crosig.proposal.dto.PolicyCoverageOptionDTO
					policyCoverageOptDTO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyCoverageOptLocalService.updatePolicyCoverageOpt(
			policyCoverageOptDTO);
	}

	@Override
	public PolicyCoverageOptLocalService getWrappedService() {
		return _policyCoverageOptLocalService;
	}

	@Override
	public void setWrappedService(
		PolicyCoverageOptLocalService policyCoverageOptLocalService) {

		_policyCoverageOptLocalService = policyCoverageOptLocalService;
	}

	private PolicyCoverageOptLocalService _policyCoverageOptLocalService;

}
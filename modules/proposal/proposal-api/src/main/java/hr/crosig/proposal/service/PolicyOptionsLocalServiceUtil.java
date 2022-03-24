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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import hr.crosig.proposal.model.PolicyOptions;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PolicyOptions. This utility wraps
 * <code>hr.crosig.proposal.service.impl.PolicyOptionsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyOptionsLocalService
 * @generated
 */
public class PolicyOptionsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>hr.crosig.proposal.service.impl.PolicyOptionsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static PolicyOptions addPolicyOptions(PolicyOptions policyOptions) {
		return getService().addPolicyOptions(policyOptions);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new policy options with the primary key. Does not add the policy options to the database.
	 *
	 * @param policyOptionsId the primary key for the new policy options
	 * @return the new policy options
	 */
	public static PolicyOptions createPolicyOptions(long policyOptionsId) {
		return getService().createPolicyOptions(policyOptionsId);
	}

	public static hr.crosig.proposal.dto.PolicyOptionsDTO createPolicyOptions(
		hr.crosig.proposal.dto.PolicyOptionsDTO policyOptionsDTO,
		hr.crosig.proposal.model.Proposal proposal) {

		return getService().createPolicyOptions(policyOptionsDTO, proposal);
	}

	public static void deleteAllByProposalId(long proposalId)
		throws hr.crosig.proposal.exception.NoSuchPolicyOptionsException {

		getService().deleteAllByProposalId(proposalId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static PolicyOptions deletePolicyOptions(long policyOptionsId)
		throws PortalException {

		return getService().deletePolicyOptions(policyOptionsId);
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
	public static PolicyOptions deletePolicyOptions(
		PolicyOptions policyOptions) {

		return getService().deletePolicyOptions(policyOptions);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static PolicyOptions fetchPolicyOptions(long policyOptionsId) {
		return getService().fetchPolicyOptions(policyOptionsId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the policy options with the primary key.
	 *
	 * @param policyOptionsId the primary key of the policy options
	 * @return the policy options
	 * @throws PortalException if a policy options with the primary key could not be found
	 */
	public static PolicyOptions getPolicyOptions(long policyOptionsId)
		throws PortalException {

		return getService().getPolicyOptions(policyOptionsId);
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
	public static List<PolicyOptions> getPolicyOptionses(int start, int end) {
		return getService().getPolicyOptionses(start, end);
	}

	/**
	 * Returns the number of policy optionses.
	 *
	 * @return the number of policy optionses
	 */
	public static int getPolicyOptionsesCount() {
		return getService().getPolicyOptionsesCount();
	}

	public static hr.crosig.proposal.dto.PolicyOptionsDTO
		getProposalPolicyOptions(long proposalId) {

		return getService().getProposalPolicyOptions(proposalId);
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
	public static PolicyOptions updatePolicyOptions(
		PolicyOptions policyOptions) {

		return getService().updatePolicyOptions(policyOptions);
	}

	public static PolicyOptionsLocalService getService() {
		return _service;
	}

	private static volatile PolicyOptionsLocalService _service;

}
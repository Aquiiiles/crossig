/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProposalLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProposalLocalService
 * @generated
 */
public class ProposalLocalServiceWrapper
	implements ProposalLocalService, ServiceWrapper<ProposalLocalService> {

	public ProposalLocalServiceWrapper() {
		this(null);
	}

	public ProposalLocalServiceWrapper(
		ProposalLocalService proposalLocalService) {

		_proposalLocalService = proposalLocalService;
	}

	/**
	 * Adds the proposal to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProposalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proposal the proposal
	 * @return the proposal that was added
	 */
	@Override
	public hr.crosig.proposal.model.Proposal addProposal(
		hr.crosig.proposal.model.Proposal proposal) {

		return _proposalLocalService.addProposal(proposal);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proposalLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new proposal with the primary key. Does not add the proposal to the database.
	 *
	 * @param proposalId the primary key for the new proposal
	 * @return the new proposal
	 */
	@Override
	public hr.crosig.proposal.model.Proposal createProposal(long proposalId) {
		return _proposalLocalService.createProposal(proposalId);
	}

	@Override
	public hr.crosig.proposal.dto.ProposalDTO createProposal(
		hr.crosig.proposal.dto.ProposalDTO proposalDTO) {

		return _proposalLocalService.createProposal(proposalDTO);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proposalLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProposalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proposalId the primary key of the proposal
	 * @return the proposal that was removed
	 * @throws PortalException if a proposal with the primary key could not be found
	 */
	@Override
	public hr.crosig.proposal.model.Proposal deleteProposal(long proposalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proposalLocalService.deleteProposal(proposalId);
	}

	/**
	 * Deletes the proposal from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProposalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proposal the proposal
	 * @return the proposal that was removed
	 */
	@Override
	public hr.crosig.proposal.model.Proposal deleteProposal(
		hr.crosig.proposal.model.Proposal proposal) {

		return _proposalLocalService.deleteProposal(proposal);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _proposalLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _proposalLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _proposalLocalService.dynamicQuery();
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

		return _proposalLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.ProposalModelImpl</code>.
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

		return _proposalLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.ProposalModelImpl</code>.
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

		return _proposalLocalService.dynamicQuery(
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

		return _proposalLocalService.dynamicQueryCount(dynamicQuery);
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

		return _proposalLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public hr.crosig.proposal.model.Proposal fetchProposal(long proposalId) {
		return _proposalLocalService.fetchProposal(proposalId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _proposalLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<hr.crosig.proposal.dto.ProposalDTO> getAgentProposals(
		long agentUserId) {

		return _proposalLocalService.getAgentProposals(agentUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _proposalLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _proposalLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proposalLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the proposal with the primary key.
	 *
	 * @param proposalId the primary key of the proposal
	 * @return the proposal
	 * @throws PortalException if a proposal with the primary key could not be found
	 */
	@Override
	public hr.crosig.proposal.model.Proposal getProposal(long proposalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proposalLocalService.getProposal(proposalId);
	}

	@Override
	public hr.crosig.proposal.dto.ProposalDTO getProposalDTO(long proposalId) {
		return _proposalLocalService.getProposalDTO(proposalId);
	}

	/**
	 * Returns a range of all the proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.ProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposals
	 * @param end the upper bound of the range of proposals (not inclusive)
	 * @return the range of proposals
	 */
	@Override
	public java.util.List<hr.crosig.proposal.model.Proposal> getProposals(
		int start, int end) {

		return _proposalLocalService.getProposals(start, end);
	}

	/**
	 * Returns the number of proposals.
	 *
	 * @return the number of proposals
	 */
	@Override
	public int getProposalsCount() {
		return _proposalLocalService.getProposalsCount();
	}

	@Override
	public hr.crosig.proposal.dto.ProposalDTO updateProposal(
			long proposalId, hr.crosig.proposal.dto.ProposalDTO proposalDTO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proposalLocalService.updateProposal(proposalId, proposalDTO);
	}

	/**
	 * Updates the proposal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProposalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proposal the proposal
	 * @return the proposal that was updated
	 */
	@Override
	public hr.crosig.proposal.model.Proposal updateProposal(
		hr.crosig.proposal.model.Proposal proposal) {

		return _proposalLocalService.updateProposal(proposal);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _proposalLocalService.getBasePersistence();
	}

	@Override
	public ProposalLocalService getWrappedService() {
		return _proposalLocalService;
	}

	@Override
	public void setWrappedService(ProposalLocalService proposalLocalService) {
		_proposalLocalService = proposalLocalService;
	}

	private ProposalLocalService _proposalLocalService;

}
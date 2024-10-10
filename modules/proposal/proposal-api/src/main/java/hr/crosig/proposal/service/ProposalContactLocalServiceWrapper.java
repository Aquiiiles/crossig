/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProposalContactLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProposalContactLocalService
 * @generated
 */
public class ProposalContactLocalServiceWrapper
	implements ProposalContactLocalService,
			   ServiceWrapper<ProposalContactLocalService> {

	public ProposalContactLocalServiceWrapper() {
		this(null);
	}

	public ProposalContactLocalServiceWrapper(
		ProposalContactLocalService proposalContactLocalService) {

		_proposalContactLocalService = proposalContactLocalService;
	}

	/**
	 * Adds the proposal contact to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProposalContactLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proposalContact the proposal contact
	 * @return the proposal contact that was added
	 */
	@Override
	public hr.crosig.proposal.model.ProposalContact addProposalContact(
		hr.crosig.proposal.model.ProposalContact proposalContact) {

		return _proposalContactLocalService.addProposalContact(proposalContact);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proposalContactLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new proposal contact with the primary key. Does not add the proposal contact to the database.
	 *
	 * @param proposalContactId the primary key for the new proposal contact
	 * @return the new proposal contact
	 */
	@Override
	public hr.crosig.proposal.model.ProposalContact createProposalContact(
		long proposalContactId) {

		return _proposalContactLocalService.createProposalContact(
			proposalContactId);
	}

	@Override
	public hr.crosig.proposal.dto.ProposalContactDTO createProposalContact(
		hr.crosig.proposal.dto.ProposalContactDTO proposalContactDTO,
		hr.crosig.proposal.model.Proposal proposal) {

		return _proposalContactLocalService.createProposalContact(
			proposalContactDTO, proposal);
	}

	@Override
	public void deleteAllByProposalId(long proposalId) {
		_proposalContactLocalService.deleteAllByProposalId(proposalId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proposalContactLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the proposal contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProposalContactLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proposalContactId the primary key of the proposal contact
	 * @return the proposal contact that was removed
	 * @throws PortalException if a proposal contact with the primary key could not be found
	 */
	@Override
	public hr.crosig.proposal.model.ProposalContact deleteProposalContact(
			long proposalContactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proposalContactLocalService.deleteProposalContact(
			proposalContactId);
	}

	/**
	 * Deletes the proposal contact from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProposalContactLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proposalContact the proposal contact
	 * @return the proposal contact that was removed
	 */
	@Override
	public hr.crosig.proposal.model.ProposalContact deleteProposalContact(
		hr.crosig.proposal.model.ProposalContact proposalContact) {

		return _proposalContactLocalService.deleteProposalContact(
			proposalContact);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _proposalContactLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _proposalContactLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _proposalContactLocalService.dynamicQuery();
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

		return _proposalContactLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.ProposalContactModelImpl</code>.
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

		return _proposalContactLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.ProposalContactModelImpl</code>.
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

		return _proposalContactLocalService.dynamicQuery(
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

		return _proposalContactLocalService.dynamicQueryCount(dynamicQuery);
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

		return _proposalContactLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public hr.crosig.proposal.model.ProposalContact fetchProposalContact(
		long proposalContactId) {

		return _proposalContactLocalService.fetchProposalContact(
			proposalContactId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _proposalContactLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _proposalContactLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _proposalContactLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proposalContactLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the proposal contact with the primary key.
	 *
	 * @param proposalContactId the primary key of the proposal contact
	 * @return the proposal contact
	 * @throws PortalException if a proposal contact with the primary key could not be found
	 */
	@Override
	public hr.crosig.proposal.model.ProposalContact getProposalContact(
			long proposalContactId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proposalContactLocalService.getProposalContact(
			proposalContactId);
	}

	/**
	 * Returns a range of all the proposal contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hr.crosig.proposal.model.impl.ProposalContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposal contacts
	 * @param end the upper bound of the range of proposal contacts (not inclusive)
	 * @return the range of proposal contacts
	 */
	@Override
	public java.util.List<hr.crosig.proposal.model.ProposalContact>
		getProposalContacts(int start, int end) {

		return _proposalContactLocalService.getProposalContacts(start, end);
	}

	@Override
	public java.util.List<hr.crosig.proposal.dto.ProposalContactDTO>
		getProposalContacts(long proposalId) {

		return _proposalContactLocalService.getProposalContacts(proposalId);
	}

	/**
	 * Returns the number of proposal contacts.
	 *
	 * @return the number of proposal contacts
	 */
	@Override
	public int getProposalContactsCount() {
		return _proposalContactLocalService.getProposalContactsCount();
	}

	/**
	 * Updates the proposal contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProposalContactLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proposalContact the proposal contact
	 * @return the proposal contact that was updated
	 */
	@Override
	public hr.crosig.proposal.model.ProposalContact updateProposalContact(
		hr.crosig.proposal.model.ProposalContact proposalContact) {

		return _proposalContactLocalService.updateProposalContact(
			proposalContact);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _proposalContactLocalService.getBasePersistence();
	}

	@Override
	public ProposalContactLocalService getWrappedService() {
		return _proposalContactLocalService;
	}

	@Override
	public void setWrappedService(
		ProposalContactLocalService proposalContactLocalService) {

		_proposalContactLocalService = proposalContactLocalService;
	}

	private ProposalContactLocalService _proposalContactLocalService;

}
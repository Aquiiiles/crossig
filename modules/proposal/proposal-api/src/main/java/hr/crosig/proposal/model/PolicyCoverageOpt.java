/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the PolicyCoverageOpt service. Represents a row in the &quot;AP_Proposal_PolicyCoverageOpt&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCoverageOptModel
 * @generated
 */
@ImplementationClassName("hr.crosig.proposal.model.impl.PolicyCoverageOptImpl")
@ProviderType
public interface PolicyCoverageOpt
	extends PersistedModel, PolicyCoverageOptModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>hr.crosig.proposal.model.impl.PolicyCoverageOptImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PolicyCoverageOpt, Long>
		POLICY_COVERAGE_OPTION_ID_ACCESSOR =
			new Accessor<PolicyCoverageOpt, Long>() {

				@Override
				public Long get(PolicyCoverageOpt policyCoverageOpt) {
					return policyCoverageOpt.getPolicyCoverageOptionId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<PolicyCoverageOpt> getTypeClass() {
					return PolicyCoverageOpt.class;
				}

			};

}
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
 * The extended model interface for the ProductRole service. Represents a row in the &quot;AP_Proposal_ProductRole&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProductRoleModel
 * @generated
 */
@ImplementationClassName("hr.crosig.proposal.model.impl.ProductRoleImpl")
@ProviderType
public interface ProductRole extends PersistedModel, ProductRoleModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>hr.crosig.proposal.model.impl.ProductRoleImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ProductRole, Long> PRODUCT_ROLE_ID_ACCESSOR =
		new Accessor<ProductRole, Long>() {

			@Override
			public Long get(ProductRole productRole) {
				return productRole.getProductRoleId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ProductRole> getTypeClass() {
				return ProductRole.class;
			}

		};

}
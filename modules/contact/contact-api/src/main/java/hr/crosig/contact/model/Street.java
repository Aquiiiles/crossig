/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.contact.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Street service. Represents a row in the &quot;AP_Contact_Street&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StreetModel
 * @generated
 */
@ImplementationClassName("hr.crosig.contact.model.impl.StreetImpl")
@ProviderType
public interface Street extends PersistedModel, StreetModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>hr.crosig.contact.model.impl.StreetImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Street, Long> STREET_ID_ACCESSOR =
		new Accessor<Street, Long>() {

			@Override
			public Long get(Street street) {
				return street.getStreetId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Street> getTypeClass() {
				return Street.class;
			}

		};

}
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import hr.crosig.proposal.model.PolicyOptionsTable;
import hr.crosig.proposal.model.impl.PolicyOptionsImpl;
import hr.crosig.proposal.model.impl.PolicyOptionsModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from PolicyOptions.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=hr.crosig.proposal.model.impl.PolicyOptionsImpl",
		"table.name=AP_Proposal_PolicyOptions"
	},
	service = ArgumentsResolver.class
)
public class PolicyOptionsModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		PolicyOptionsModelImpl policyOptionsModelImpl =
			(PolicyOptionsModelImpl)baseModel;

		long columnBitmask = policyOptionsModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(policyOptionsModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					policyOptionsModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(policyOptionsModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return PolicyOptionsImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return PolicyOptionsTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		PolicyOptionsModelImpl policyOptionsModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = policyOptionsModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = policyOptionsModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}
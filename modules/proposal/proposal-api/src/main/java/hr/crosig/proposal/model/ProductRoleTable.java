/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.proposal.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AP_Proposal_ProductRole&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProductRole
 * @generated
 */
public class ProductRoleTable extends BaseTable<ProductRoleTable> {

	public static final ProductRoleTable INSTANCE = new ProductRoleTable();

	public final Column<ProductRoleTable, Long> productRoleId = createColumn(
		"productRoleId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProductRoleTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductRoleTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductRoleTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductRoleTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductRoleTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductRoleTable, Long> productId = createColumn(
		"productId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductRoleTable, Long> roleId = createColumn(
		"roleId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ProductRoleTable() {
		super("AP_Proposal_ProductRole", ProductRoleTable::new);
	}

}
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
 * The table class for the &quot;AP_Proposal_InsuredRole&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see InsuredRole
 * @generated
 */
public class InsuredRoleTable extends BaseTable<InsuredRoleTable> {

	public static final InsuredRoleTable INSTANCE = new InsuredRoleTable();

	public final Column<InsuredRoleTable, Long> InsuredRoleId = createColumn(
		"InsuredRoleId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<InsuredRoleTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InsuredRoleTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InsuredRoleTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InsuredRoleTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<InsuredRoleTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<InsuredRoleTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InsuredRoleTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InsuredRoleTable, String> externalId = createColumn(
		"externalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private InsuredRoleTable() {
		super("AP_Proposal_InsuredRole", InsuredRoleTable::new);
	}

}
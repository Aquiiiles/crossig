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
 * The table class for the &quot;AP_Proposal_CoveragePlan&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CoveragePlan
 * @generated
 */
public class CoveragePlanTable extends BaseTable<CoveragePlanTable> {

	public static final CoveragePlanTable INSTANCE = new CoveragePlanTable();

	public final Column<CoveragePlanTable, Long> coveragePlanId = createColumn(
		"coveragePlanId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CoveragePlanTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CoveragePlanTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CoveragePlanTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CoveragePlanTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CoveragePlanTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CoveragePlanTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CoveragePlanTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CoveragePlanTable, String> category = createColumn(
		"category", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private CoveragePlanTable() {
		super("AP_Proposal_CoveragePlan", CoveragePlanTable::new);
	}

}
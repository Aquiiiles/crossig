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
 * The table class for the &quot;AP_Proposal_PolicyCoverageOpt&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCoverageOpt
 * @generated
 */
public class PolicyCoverageOptTable extends BaseTable<PolicyCoverageOptTable> {

	public static final PolicyCoverageOptTable INSTANCE =
		new PolicyCoverageOptTable();

	public final Column<PolicyCoverageOptTable, Long> policyCoverageOptionId =
		createColumn(
			"policyCoverageOptionId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<PolicyCoverageOptTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyCoverageOptTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyCoverageOptTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PolicyCoverageOptTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PolicyCoverageOptTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PolicyCoverageOptTable, Long> proposalId = createColumn(
		"proposalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyCoverageOptTable, String> coverageOptionsName =
		createColumn(
			"coverageOptionsName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PolicyCoverageOptTable, String> coverageOptionsValue =
		createColumn(
			"coverageOptionsValue", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PolicyCoverageOptTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PolicyCoverageOptTable() {
		super("AP_Proposal_PolicyCoverageOpt", PolicyCoverageOptTable::new);
	}

}
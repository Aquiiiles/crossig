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
 * The table class for the &quot;AP_Proposal_PolicyOptions&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyOptions
 * @generated
 */
public class PolicyOptionsTable extends BaseTable<PolicyOptionsTable> {

	public static final PolicyOptionsTable INSTANCE = new PolicyOptionsTable();

	public final Column<PolicyOptionsTable, Long> policyOptionsId =
		createColumn(
			"policyOptionsId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PolicyOptionsTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, Long> proposalId = createColumn(
		"proposalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, String> currency = createColumn(
		"currency_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, Date> termsDate = createColumn(
		"termsDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, String> productCategory =
		createColumn(
			"productCategory", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, String> productExtNumber =
		createColumn(
			"productExtNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, Date> issueDate = createColumn(
		"issueDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, Date> contractStartDate =
		createColumn(
			"contractStartDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, Date> contractEndDate =
		createColumn(
			"contractEndDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, String> contractPeriod =
		createColumn(
			"contractPeriod", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, Integer> durationYear =
		createColumn(
			"durationYear", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, Date> policyStartDate =
		createColumn(
			"policyStartDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, Date> policyEndDate = createColumn(
		"policyEndDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, Integer> policyNumberDays =
		createColumn(
			"policyNumberDays", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<PolicyOptionsTable, String> communicationMethod =
		createColumn(
			"communicationMethod", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private PolicyOptionsTable() {
		super("AP_Proposal_PolicyOptions", PolicyOptionsTable::new);
	}

}
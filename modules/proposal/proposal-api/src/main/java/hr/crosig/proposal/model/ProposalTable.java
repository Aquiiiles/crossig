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
 * The table class for the &quot;AP_Proposal_Proposal&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Proposal
 * @generated
 */
public class ProposalTable extends BaseTable<ProposalTable> {

	public static final ProposalTable INSTANCE = new ProposalTable();

	public final Column<ProposalTable, Long> proposalId = createColumn(
		"proposalId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProposalTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProposalTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProposalTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProposalTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProposalTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProposalTable, String> externalProposalNumber =
		createColumn(
			"externalProposalNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProposalTable, Date> lastUpdate = createColumn(
		"lastUpdate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProposalTable, String> origin = createColumn(
		"origin", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProposalTable, Long> agentUserId = createColumn(
		"agentUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProposalTable, String> policyHolderExtNumber =
		createColumn(
			"policyHolderExtNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProposalTable, String> insuredObjectExtNumber =
		createColumn(
			"insuredObjectExtNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProposalTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProposalTable() {
		super("AP_Proposal_Proposal", ProposalTable::new);
	}

}
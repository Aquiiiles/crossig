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
 * The table class for the &quot;AP_Proposal_ProposalContact&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProposalContact
 * @generated
 */
public class ProposalContactTable extends BaseTable<ProposalContactTable> {

	public static final ProposalContactTable INSTANCE =
		new ProposalContactTable();

	public final Column<ProposalContactTable, Long> proposalContactId =
		createColumn(
			"proposalContactId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProposalContactTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProposalContactTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProposalContactTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProposalContactTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProposalContactTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProposalContactTable, Long> proposalId = createColumn(
		"proposalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProposalContactTable, String> contactExtNumber =
		createColumn(
			"contactExtNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProposalContactTable, String> insuredRoles =
		createColumn(
			"insuredRoles", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProposalContactTable() {
		super("AP_Proposal_ProposalContact", ProposalContactTable::new);
	}

}
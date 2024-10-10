/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package hr.crosig.contact.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AP_Contact_Street&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Street
 * @generated
 */
public class StreetTable extends BaseTable<StreetTable> {

	public static final StreetTable INSTANCE = new StreetTable();

	public final Column<StreetTable, Long> streetId = createColumn(
		"streetId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<StreetTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<StreetTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<StreetTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StreetTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<StreetTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<StreetTable, Long> externalId = createColumn(
		"externalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<StreetTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StreetTable, Long> cityId = createColumn(
		"cityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private StreetTable() {
		super("AP_Contact_Street", StreetTable::new);
	}

}
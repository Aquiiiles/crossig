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
 * The table class for the &quot;AP_Contact_City&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see City
 * @generated
 */
public class CityTable extends BaseTable<CityTable> {

	public static final CityTable INSTANCE = new CityTable();

	public final Column<CityTable, Long> cityId = createColumn(
		"cityId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CityTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CityTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CityTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CityTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CityTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CityTable, Long> externalId = createColumn(
		"externalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CityTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CityTable, String> zipCode = createColumn(
		"zipCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CityTable, String> boxNumber = createColumn(
		"boxNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CityTable, String> postName = createColumn(
		"postName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private CityTable() {
		super("AP_Contact_City", CityTable::new);
	}

}
package hr.crosig.contact.util;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Davy Duran
 */
public abstract class BulkHelper {

	public static int bulkDelete(
		Session session, String table, String criteria) {

		return _bulkDelete(
			session, String.format(_DELETE_SQL_ROW_PROCESSED, table), table,
			criteria);
	}

	public static int bulkDelete(
		Session session, String table, String rowProcessed, String status) {

		return _bulkDelete(
			session, String.format(_DELETE_SQL_STATUS, table), table,
			rowProcessed, status);
	}

	public static int bulkDeleteAll(Session session, String table) {
		return _bulkDelete(session, String.format(_TRUNCATE_SQL, table), table);
	}

	public static int bulkDeleteByColumnValues(
		Session session, String table, String columnName, String columnValues) {

		return _bulkDelete(
			session,
			String.format(
				_DELETE_SQL_BY_COLUMN, table, columnName, columnValues),
			table);
	}

	private static int _bulkDelete(
		Session session, String sql, String tableName, String... criteria) {

		SQLQuery query = session.createSynchronizedSQLQuery(sql);

		int pos = 0;

		for (String c : criteria) {
			query.setString(pos++, c);
		}

		int rows = query.executeUpdate();

		if (_log.isInfoEnabled()) {
			_log.info(rows + " rows deleted from " + tableName);
		}

		return rows;
	}

	private static final String _DELETE_SQL = "DELETE FROM %s";

	private static final String _DELETE_SQL_BY_COLUMN =
		_DELETE_SQL + " WHERE %s IN (%s)";

	private static final String _DELETE_SQL_ROW_PROCESSED =
		_DELETE_SQL + " WHERE rowProcessed != ?";

	private static final String _DELETE_SQL_STATUS =
		_DELETE_SQL_ROW_PROCESSED + " and processStatus != ?";

	private static final String _TRUNCATE_SQL = "TRUNCATE TABLE %s ";

	private static final String _UPDATE_SQL =
		"UPDATE %s SET rowProcessed = ? WHERE rowProcessed = ?";

	private static final Log _log = LogFactoryUtil.getLog(BulkHelper.class);

}
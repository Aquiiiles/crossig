/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package hr.crosig.proposal.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import hr.crosig.proposal.model.CoveragePlan;
import hr.crosig.proposal.model.CoveragePlanModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CoveragePlan service. Represents a row in the &quot;AP_Proposal_CoveragePlan&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CoveragePlanModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CoveragePlanImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CoveragePlanImpl
 * @generated
 */
public class CoveragePlanModelImpl
	extends BaseModelImpl<CoveragePlan> implements CoveragePlanModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a coverage plan model instance should use the <code>CoveragePlan</code> interface instead.
	 */
	public static final String TABLE_NAME = "AP_Proposal_CoveragePlan";

	public static final Object[][] TABLE_COLUMNS = {
		{"coveragePlanId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"category", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("coveragePlanId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("category", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AP_Proposal_CoveragePlan (coveragePlanId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,description VARCHAR(75) null,category VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table AP_Proposal_CoveragePlan";

	public static final String ORDER_BY_JPQL =
		" ORDER BY coveragePlan.coveragePlanId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY AP_Proposal_CoveragePlan.coveragePlanId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COVERAGEPLANID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public CoveragePlanModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _coveragePlanId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCoveragePlanId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _coveragePlanId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CoveragePlan.class;
	}

	@Override
	public String getModelClassName() {
		return CoveragePlan.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CoveragePlan, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CoveragePlan, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CoveragePlan, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CoveragePlan)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CoveragePlan, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CoveragePlan, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CoveragePlan)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CoveragePlan, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CoveragePlan, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CoveragePlan>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CoveragePlan.class.getClassLoader(), CoveragePlan.class,
			ModelWrapper.class);

		try {
			Constructor<CoveragePlan> constructor =
				(Constructor<CoveragePlan>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<CoveragePlan, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CoveragePlan, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CoveragePlan, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CoveragePlan, Object>>();
		Map<String, BiConsumer<CoveragePlan, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CoveragePlan, ?>>();

		attributeGetterFunctions.put(
			"coveragePlanId", CoveragePlan::getCoveragePlanId);
		attributeSetterBiConsumers.put(
			"coveragePlanId",
			(BiConsumer<CoveragePlan, Long>)CoveragePlan::setCoveragePlanId);
		attributeGetterFunctions.put("companyId", CoveragePlan::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CoveragePlan, Long>)CoveragePlan::setCompanyId);
		attributeGetterFunctions.put("userId", CoveragePlan::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<CoveragePlan, Long>)CoveragePlan::setUserId);
		attributeGetterFunctions.put("userName", CoveragePlan::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CoveragePlan, String>)CoveragePlan::setUserName);
		attributeGetterFunctions.put("createDate", CoveragePlan::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CoveragePlan, Date>)CoveragePlan::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CoveragePlan::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CoveragePlan, Date>)CoveragePlan::setModifiedDate);
		attributeGetterFunctions.put("name", CoveragePlan::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<CoveragePlan, String>)CoveragePlan::setName);
		attributeGetterFunctions.put(
			"description", CoveragePlan::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<CoveragePlan, String>)CoveragePlan::setDescription);
		attributeGetterFunctions.put("category", CoveragePlan::getCategory);
		attributeSetterBiConsumers.put(
			"category",
			(BiConsumer<CoveragePlan, String>)CoveragePlan::setCategory);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getCoveragePlanId() {
		return _coveragePlanId;
	}

	@Override
	public void setCoveragePlanId(long coveragePlanId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_coveragePlanId = coveragePlanId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalName() {
		return getColumnOriginalValue("name");
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@Override
	public String getCategory() {
		if (_category == null) {
			return "";
		}
		else {
			return _category;
		}
	}

	@Override
	public void setCategory(String category) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_category = category;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CoveragePlan.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CoveragePlan toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CoveragePlan>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CoveragePlanImpl coveragePlanImpl = new CoveragePlanImpl();

		coveragePlanImpl.setCoveragePlanId(getCoveragePlanId());
		coveragePlanImpl.setCompanyId(getCompanyId());
		coveragePlanImpl.setUserId(getUserId());
		coveragePlanImpl.setUserName(getUserName());
		coveragePlanImpl.setCreateDate(getCreateDate());
		coveragePlanImpl.setModifiedDate(getModifiedDate());
		coveragePlanImpl.setName(getName());
		coveragePlanImpl.setDescription(getDescription());
		coveragePlanImpl.setCategory(getCategory());

		coveragePlanImpl.resetOriginalValues();

		return coveragePlanImpl;
	}

	@Override
	public int compareTo(CoveragePlan coveragePlan) {
		long primaryKey = coveragePlan.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CoveragePlan)) {
			return false;
		}

		CoveragePlan coveragePlan = (CoveragePlan)object;

		long primaryKey = coveragePlan.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CoveragePlan> toCacheModel() {
		CoveragePlanCacheModel coveragePlanCacheModel =
			new CoveragePlanCacheModel();

		coveragePlanCacheModel.coveragePlanId = getCoveragePlanId();

		coveragePlanCacheModel.companyId = getCompanyId();

		coveragePlanCacheModel.userId = getUserId();

		coveragePlanCacheModel.userName = getUserName();

		String userName = coveragePlanCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			coveragePlanCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			coveragePlanCacheModel.createDate = createDate.getTime();
		}
		else {
			coveragePlanCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			coveragePlanCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			coveragePlanCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		coveragePlanCacheModel.name = getName();

		String name = coveragePlanCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			coveragePlanCacheModel.name = null;
		}

		coveragePlanCacheModel.description = getDescription();

		String description = coveragePlanCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			coveragePlanCacheModel.description = null;
		}

		coveragePlanCacheModel.category = getCategory();

		String category = coveragePlanCacheModel.category;

		if ((category != null) && (category.length() == 0)) {
			coveragePlanCacheModel.category = null;
		}

		return coveragePlanCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CoveragePlan, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CoveragePlan, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CoveragePlan, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((CoveragePlan)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CoveragePlan, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CoveragePlan, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CoveragePlan, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CoveragePlan)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CoveragePlan>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _coveragePlanId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _description;
	private String _category;

	public <T> T getColumnValue(String columnName) {
		Function<CoveragePlan, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CoveragePlan)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("coveragePlanId", _coveragePlanId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("category", _category);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("coveragePlanId", 1L);

		columnBitmasks.put("companyId", 2L);

		columnBitmasks.put("userId", 4L);

		columnBitmasks.put("userName", 8L);

		columnBitmasks.put("createDate", 16L);

		columnBitmasks.put("modifiedDate", 32L);

		columnBitmasks.put("name", 64L);

		columnBitmasks.put("description", 128L);

		columnBitmasks.put("category", 256L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CoveragePlan _escapedModel;

}
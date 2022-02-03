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

package hr.crosig.contact.model.impl;

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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import hr.crosig.contact.model.Street;
import hr.crosig.contact.model.StreetModel;

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
 * The base model implementation for the Street service. Represents a row in the &quot;AP_Contact_Street&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>StreetModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StreetImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StreetImpl
 * @generated
 */
public class StreetModelImpl
	extends BaseModelImpl<Street> implements StreetModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a street model instance should use the <code>Street</code> interface instead.
	 */
	public static final String TABLE_NAME = "AP_Contact_Street";

	public static final Object[][] TABLE_COLUMNS = {
		{"streetId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"cityId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("streetId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cityId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AP_Contact_Street (streetId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,cityId LONG)";

	public static final String TABLE_SQL_DROP = "drop table AP_Contact_Street";

	public static final String ORDER_BY_JPQL = " ORDER BY street.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY AP_Contact_Street.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CITYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 2L;

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

	public StreetModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _streetId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStreetId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _streetId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Street.class;
	}

	@Override
	public String getModelClassName() {
		return Street.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Street, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Street, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Street, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Street)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Street, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Street, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Street)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Street, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Street, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Street>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Street.class.getClassLoader(), Street.class, ModelWrapper.class);

		try {
			Constructor<Street> constructor =
				(Constructor<Street>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Street, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Street, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Street, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Street, Object>>();
		Map<String, BiConsumer<Street, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Street, ?>>();

		attributeGetterFunctions.put("streetId", Street::getStreetId);
		attributeSetterBiConsumers.put(
			"streetId", (BiConsumer<Street, Long>)Street::setStreetId);
		attributeGetterFunctions.put("companyId", Street::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Street, Long>)Street::setCompanyId);
		attributeGetterFunctions.put("userId", Street::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Street, Long>)Street::setUserId);
		attributeGetterFunctions.put("userName", Street::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Street, String>)Street::setUserName);
		attributeGetterFunctions.put("createDate", Street::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Street, Date>)Street::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Street::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Street, Date>)Street::setModifiedDate);
		attributeGetterFunctions.put("name", Street::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Street, String>)Street::setName);
		attributeGetterFunctions.put("cityId", Street::getCityId);
		attributeSetterBiConsumers.put(
			"cityId", (BiConsumer<Street, Long>)Street::setCityId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getStreetId() {
		return _streetId;
	}

	@Override
	public void setStreetId(long streetId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_streetId = streetId;
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
	public long getCityId() {
		return _cityId;
	}

	@Override
	public void setCityId(long cityId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cityId = cityId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCityId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("cityId"));
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
			getCompanyId(), Street.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Street toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Street>
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
		StreetImpl streetImpl = new StreetImpl();

		streetImpl.setStreetId(getStreetId());
		streetImpl.setCompanyId(getCompanyId());
		streetImpl.setUserId(getUserId());
		streetImpl.setUserName(getUserName());
		streetImpl.setCreateDate(getCreateDate());
		streetImpl.setModifiedDate(getModifiedDate());
		streetImpl.setName(getName());
		streetImpl.setCityId(getCityId());

		streetImpl.resetOriginalValues();

		return streetImpl;
	}

	@Override
	public int compareTo(Street street) {
		int value = 0;

		value = getName().compareTo(street.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Street)) {
			return false;
		}

		Street street = (Street)object;

		long primaryKey = street.getPrimaryKey();

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
	public CacheModel<Street> toCacheModel() {
		StreetCacheModel streetCacheModel = new StreetCacheModel();

		streetCacheModel.streetId = getStreetId();

		streetCacheModel.companyId = getCompanyId();

		streetCacheModel.userId = getUserId();

		streetCacheModel.userName = getUserName();

		String userName = streetCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			streetCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			streetCacheModel.createDate = createDate.getTime();
		}
		else {
			streetCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			streetCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			streetCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		streetCacheModel.name = getName();

		String name = streetCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			streetCacheModel.name = null;
		}

		streetCacheModel.cityId = getCityId();

		return streetCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Street, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Street, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Street, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Street)this);

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
		Map<String, Function<Street, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Street, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Street, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Street)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Street>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _streetId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private long _cityId;

	public <T> T getColumnValue(String columnName) {
		Function<Street, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Street)this);
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

		_columnOriginalValues.put("streetId", _streetId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("cityId", _cityId);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("streetId", 1L);

		columnBitmasks.put("companyId", 2L);

		columnBitmasks.put("userId", 4L);

		columnBitmasks.put("userName", 8L);

		columnBitmasks.put("createDate", 16L);

		columnBitmasks.put("modifiedDate", 32L);

		columnBitmasks.put("name", 64L);

		columnBitmasks.put("cityId", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Street _escapedModel;

}
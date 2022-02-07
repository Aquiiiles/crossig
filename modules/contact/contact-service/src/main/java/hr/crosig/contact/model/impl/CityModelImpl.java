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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import hr.crosig.contact.model.City;
import hr.crosig.contact.model.CityModel;

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
 * The base model implementation for the City service. Represents a row in the &quot;AP_Contact_City&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CityModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CityImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CityImpl
 * @generated
 */
public class CityModelImpl extends BaseModelImpl<City> implements CityModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a city model instance should use the <code>City</code> interface instead.
	 */
	public static final String TABLE_NAME = "AP_Contact_City";

	public static final Object[][] TABLE_COLUMNS = {
		{"cityId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"externalId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"zipCode", Types.VARCHAR}, {"boxNumber", Types.VARCHAR},
		{"postName", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("cityId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("externalId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("zipCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("boxNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("postName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AP_Contact_City (cityId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,externalId LONG,name VARCHAR(75) null,zipCode VARCHAR(75) null,boxNumber VARCHAR(75) null,postName VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table AP_Contact_City";

	public static final String ORDER_BY_JPQL = " ORDER BY city.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY AP_Contact_City.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 1L;

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

	public CityModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return City.class;
	}

	@Override
	public String getModelClassName() {
		return City.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<City, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<City, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<City, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((City)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<City, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<City, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((City)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<City, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<City, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, City>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			City.class.getClassLoader(), City.class, ModelWrapper.class);

		try {
			Constructor<City> constructor =
				(Constructor<City>)proxyClass.getConstructor(
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

	private static final Map<String, Function<City, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<City, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<City, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<City, Object>>();
		Map<String, BiConsumer<City, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<City, ?>>();

		attributeGetterFunctions.put("cityId", City::getCityId);
		attributeSetterBiConsumers.put(
			"cityId", (BiConsumer<City, Long>)City::setCityId);
		attributeGetterFunctions.put("companyId", City::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<City, Long>)City::setCompanyId);
		attributeGetterFunctions.put("userId", City::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<City, Long>)City::setUserId);
		attributeGetterFunctions.put("userName", City::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<City, String>)City::setUserName);
		attributeGetterFunctions.put("createDate", City::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<City, Date>)City::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", City::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<City, Date>)City::setModifiedDate);
		attributeGetterFunctions.put("externalId", City::getExternalId);
		attributeSetterBiConsumers.put(
			"externalId", (BiConsumer<City, Long>)City::setExternalId);
		attributeGetterFunctions.put("name", City::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<City, String>)City::setName);
		attributeGetterFunctions.put("zipCode", City::getZipCode);
		attributeSetterBiConsumers.put(
			"zipCode", (BiConsumer<City, String>)City::setZipCode);
		attributeGetterFunctions.put("boxNumber", City::getBoxNumber);
		attributeSetterBiConsumers.put(
			"boxNumber", (BiConsumer<City, String>)City::setBoxNumber);
		attributeGetterFunctions.put("postName", City::getPostName);
		attributeSetterBiConsumers.put(
			"postName", (BiConsumer<City, String>)City::setPostName);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
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
	public long getExternalId() {
		return _externalId;
	}

	@Override
	public void setExternalId(long externalId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_externalId = externalId;
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
	public String getZipCode() {
		if (_zipCode == null) {
			return "";
		}
		else {
			return _zipCode;
		}
	}

	@Override
	public void setZipCode(String zipCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_zipCode = zipCode;
	}

	@Override
	public String getBoxNumber() {
		if (_boxNumber == null) {
			return "";
		}
		else {
			return _boxNumber;
		}
	}

	@Override
	public void setBoxNumber(String boxNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_boxNumber = boxNumber;
	}

	@Override
	public String getPostName() {
		if (_postName == null) {
			return "";
		}
		else {
			return _postName;
		}
	}

	@Override
	public void setPostName(String postName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_postName = postName;
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
			getCompanyId(), City.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public City toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, City>
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
		CityImpl cityImpl = new CityImpl();

		cityImpl.setCityId(getCityId());
		cityImpl.setCompanyId(getCompanyId());
		cityImpl.setUserId(getUserId());
		cityImpl.setUserName(getUserName());
		cityImpl.setCreateDate(getCreateDate());
		cityImpl.setModifiedDate(getModifiedDate());
		cityImpl.setExternalId(getExternalId());
		cityImpl.setName(getName());
		cityImpl.setZipCode(getZipCode());
		cityImpl.setBoxNumber(getBoxNumber());
		cityImpl.setPostName(getPostName());

		cityImpl.resetOriginalValues();

		return cityImpl;
	}

	@Override
	public int compareTo(City city) {
		int value = 0;

		value = getName().compareTo(city.getName());

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

		if (!(object instanceof City)) {
			return false;
		}

		City city = (City)object;

		long primaryKey = city.getPrimaryKey();

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
	public CacheModel<City> toCacheModel() {
		CityCacheModel cityCacheModel = new CityCacheModel();

		cityCacheModel.cityId = getCityId();

		cityCacheModel.companyId = getCompanyId();

		cityCacheModel.userId = getUserId();

		cityCacheModel.userName = getUserName();

		String userName = cityCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cityCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cityCacheModel.createDate = createDate.getTime();
		}
		else {
			cityCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cityCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cityCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cityCacheModel.externalId = getExternalId();

		cityCacheModel.name = getName();

		String name = cityCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			cityCacheModel.name = null;
		}

		cityCacheModel.zipCode = getZipCode();

		String zipCode = cityCacheModel.zipCode;

		if ((zipCode != null) && (zipCode.length() == 0)) {
			cityCacheModel.zipCode = null;
		}

		cityCacheModel.boxNumber = getBoxNumber();

		String boxNumber = cityCacheModel.boxNumber;

		if ((boxNumber != null) && (boxNumber.length() == 0)) {
			cityCacheModel.boxNumber = null;
		}

		cityCacheModel.postName = getPostName();

		String postName = cityCacheModel.postName;

		if ((postName != null) && (postName.length() == 0)) {
			cityCacheModel.postName = null;
		}

		return cityCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<City, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<City, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<City, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((City)this);

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
		Map<String, Function<City, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<City, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<City, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((City)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, City>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _cityId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _externalId;
	private String _name;
	private String _zipCode;
	private String _boxNumber;
	private String _postName;

	public <T> T getColumnValue(String columnName) {
		Function<City, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((City)this);
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

		_columnOriginalValues.put("cityId", _cityId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("externalId", _externalId);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("zipCode", _zipCode);
		_columnOriginalValues.put("boxNumber", _boxNumber);
		_columnOriginalValues.put("postName", _postName);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("cityId", 1L);

		columnBitmasks.put("companyId", 2L);

		columnBitmasks.put("userId", 4L);

		columnBitmasks.put("userName", 8L);

		columnBitmasks.put("createDate", 16L);

		columnBitmasks.put("modifiedDate", 32L);

		columnBitmasks.put("externalId", 64L);

		columnBitmasks.put("name", 128L);

		columnBitmasks.put("zipCode", 256L);

		columnBitmasks.put("boxNumber", 512L);

		columnBitmasks.put("postName", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private City _escapedModel;

}
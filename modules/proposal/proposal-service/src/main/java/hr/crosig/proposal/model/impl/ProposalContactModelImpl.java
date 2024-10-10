/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import hr.crosig.proposal.model.ProposalContact;
import hr.crosig.proposal.model.ProposalContactModel;

import java.io.Serializable;

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
 * The base model implementation for the ProposalContact service. Represents a row in the &quot;AP_Proposal_ProposalContact&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProposalContactModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProposalContactImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalContactImpl
 * @generated
 */
public class ProposalContactModelImpl
	extends BaseModelImpl<ProposalContact> implements ProposalContactModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a proposal contact model instance should use the <code>ProposalContact</code> interface instead.
	 */
	public static final String TABLE_NAME = "AP_Proposal_ProposalContact";

	public static final Object[][] TABLE_COLUMNS = {
		{"proposalContactId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"proposalId", Types.BIGINT}, {"contactExtNumber", Types.VARCHAR},
		{"insuredRoles", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("proposalContactId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("proposalId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("contactExtNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("insuredRoles", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AP_Proposal_ProposalContact (proposalContactId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,proposalId LONG,contactExtNumber VARCHAR(75) null,insuredRoles VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table AP_Proposal_ProposalContact";

	public static final String ORDER_BY_JPQL =
		" ORDER BY proposalContact.proposalContactId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY AP_Proposal_ProposalContact.proposalContactId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PROPOSALID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PROPOSALCONTACTID_COLUMN_BITMASK = 2L;

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

	public ProposalContactModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _proposalContactId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProposalContactId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _proposalContactId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProposalContact.class;
	}

	@Override
	public String getModelClassName() {
		return ProposalContact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProposalContact, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ProposalContact, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProposalContact, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ProposalContact)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProposalContact, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProposalContact, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProposalContact)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProposalContact, Object>>
		getAttributeGetterFunctions() {

		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProposalContact, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<ProposalContact, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<ProposalContact, Object>>
				attributeGetterFunctions =
					new LinkedHashMap
						<String, Function<ProposalContact, Object>>();

			attributeGetterFunctions.put(
				"proposalContactId", ProposalContact::getProposalContactId);
			attributeGetterFunctions.put(
				"companyId", ProposalContact::getCompanyId);
			attributeGetterFunctions.put("userId", ProposalContact::getUserId);
			attributeGetterFunctions.put(
				"userName", ProposalContact::getUserName);
			attributeGetterFunctions.put(
				"createDate", ProposalContact::getCreateDate);
			attributeGetterFunctions.put(
				"modifiedDate", ProposalContact::getModifiedDate);
			attributeGetterFunctions.put(
				"proposalId", ProposalContact::getProposalId);
			attributeGetterFunctions.put(
				"contactExtNumber", ProposalContact::getContactExtNumber);
			attributeGetterFunctions.put(
				"insuredRoles", ProposalContact::getInsuredRoles);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<ProposalContact, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<ProposalContact, ?>>
				attributeSetterBiConsumers =
					new LinkedHashMap<String, BiConsumer<ProposalContact, ?>>();

			attributeSetterBiConsumers.put(
				"proposalContactId",
				(BiConsumer<ProposalContact, Long>)
					ProposalContact::setProposalContactId);
			attributeSetterBiConsumers.put(
				"companyId",
				(BiConsumer<ProposalContact, Long>)
					ProposalContact::setCompanyId);
			attributeSetterBiConsumers.put(
				"userId",
				(BiConsumer<ProposalContact, Long>)ProposalContact::setUserId);
			attributeSetterBiConsumers.put(
				"userName",
				(BiConsumer<ProposalContact, String>)
					ProposalContact::setUserName);
			attributeSetterBiConsumers.put(
				"createDate",
				(BiConsumer<ProposalContact, Date>)
					ProposalContact::setCreateDate);
			attributeSetterBiConsumers.put(
				"modifiedDate",
				(BiConsumer<ProposalContact, Date>)
					ProposalContact::setModifiedDate);
			attributeSetterBiConsumers.put(
				"proposalId",
				(BiConsumer<ProposalContact, Long>)
					ProposalContact::setProposalId);
			attributeSetterBiConsumers.put(
				"contactExtNumber",
				(BiConsumer<ProposalContact, String>)
					ProposalContact::setContactExtNumber);
			attributeSetterBiConsumers.put(
				"insuredRoles",
				(BiConsumer<ProposalContact, String>)
					ProposalContact::setInsuredRoles);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@Override
	public long getProposalContactId() {
		return _proposalContactId;
	}

	@Override
	public void setProposalContactId(long proposalContactId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_proposalContactId = proposalContactId;
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
	public long getProposalId() {
		return _proposalId;
	}

	@Override
	public void setProposalId(long proposalId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_proposalId = proposalId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalProposalId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("proposalId"));
	}

	@Override
	public String getContactExtNumber() {
		if (_contactExtNumber == null) {
			return "";
		}
		else {
			return _contactExtNumber;
		}
	}

	@Override
	public void setContactExtNumber(String contactExtNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_contactExtNumber = contactExtNumber;
	}

	@Override
	public String getInsuredRoles() {
		if (_insuredRoles == null) {
			return "";
		}
		else {
			return _insuredRoles;
		}
	}

	@Override
	public void setInsuredRoles(String insuredRoles) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_insuredRoles = insuredRoles;
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
			getCompanyId(), ProposalContact.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProposalContact toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProposalContact>
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
		ProposalContactImpl proposalContactImpl = new ProposalContactImpl();

		proposalContactImpl.setProposalContactId(getProposalContactId());
		proposalContactImpl.setCompanyId(getCompanyId());
		proposalContactImpl.setUserId(getUserId());
		proposalContactImpl.setUserName(getUserName());
		proposalContactImpl.setCreateDate(getCreateDate());
		proposalContactImpl.setModifiedDate(getModifiedDate());
		proposalContactImpl.setProposalId(getProposalId());
		proposalContactImpl.setContactExtNumber(getContactExtNumber());
		proposalContactImpl.setInsuredRoles(getInsuredRoles());

		proposalContactImpl.resetOriginalValues();

		return proposalContactImpl;
	}

	@Override
	public ProposalContact cloneWithOriginalValues() {
		ProposalContactImpl proposalContactImpl = new ProposalContactImpl();

		proposalContactImpl.setProposalContactId(
			this.<Long>getColumnOriginalValue("proposalContactId"));
		proposalContactImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		proposalContactImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		proposalContactImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		proposalContactImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		proposalContactImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		proposalContactImpl.setProposalId(
			this.<Long>getColumnOriginalValue("proposalId"));
		proposalContactImpl.setContactExtNumber(
			this.<String>getColumnOriginalValue("contactExtNumber"));
		proposalContactImpl.setInsuredRoles(
			this.<String>getColumnOriginalValue("insuredRoles"));

		return proposalContactImpl;
	}

	@Override
	public int compareTo(ProposalContact proposalContact) {
		long primaryKey = proposalContact.getPrimaryKey();

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

		if (!(object instanceof ProposalContact)) {
			return false;
		}

		ProposalContact proposalContact = (ProposalContact)object;

		long primaryKey = proposalContact.getPrimaryKey();

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
	public CacheModel<ProposalContact> toCacheModel() {
		ProposalContactCacheModel proposalContactCacheModel =
			new ProposalContactCacheModel();

		proposalContactCacheModel.proposalContactId = getProposalContactId();

		proposalContactCacheModel.companyId = getCompanyId();

		proposalContactCacheModel.userId = getUserId();

		proposalContactCacheModel.userName = getUserName();

		String userName = proposalContactCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			proposalContactCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			proposalContactCacheModel.createDate = createDate.getTime();
		}
		else {
			proposalContactCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			proposalContactCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			proposalContactCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		proposalContactCacheModel.proposalId = getProposalId();

		proposalContactCacheModel.contactExtNumber = getContactExtNumber();

		String contactExtNumber = proposalContactCacheModel.contactExtNumber;

		if ((contactExtNumber != null) && (contactExtNumber.length() == 0)) {
			proposalContactCacheModel.contactExtNumber = null;
		}

		proposalContactCacheModel.insuredRoles = getInsuredRoles();

		String insuredRoles = proposalContactCacheModel.insuredRoles;

		if ((insuredRoles != null) && (insuredRoles.length() == 0)) {
			proposalContactCacheModel.insuredRoles = null;
		}

		return proposalContactCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProposalContact, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ProposalContact, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProposalContact, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((ProposalContact)this);

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

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ProposalContact>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					ProposalContact.class, ModelWrapper.class);

	}

	private long _proposalContactId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _proposalId;
	private String _contactExtNumber;
	private String _insuredRoles;

	public <T> T getColumnValue(String columnName) {
		Function<ProposalContact, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ProposalContact)this);
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

		_columnOriginalValues.put("proposalContactId", _proposalContactId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("proposalId", _proposalId);
		_columnOriginalValues.put("contactExtNumber", _contactExtNumber);
		_columnOriginalValues.put("insuredRoles", _insuredRoles);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("proposalContactId", 1L);

		columnBitmasks.put("companyId", 2L);

		columnBitmasks.put("userId", 4L);

		columnBitmasks.put("userName", 8L);

		columnBitmasks.put("createDate", 16L);

		columnBitmasks.put("modifiedDate", 32L);

		columnBitmasks.put("proposalId", 64L);

		columnBitmasks.put("contactExtNumber", 128L);

		columnBitmasks.put("insuredRoles", 256L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ProposalContact _escapedModel;

}
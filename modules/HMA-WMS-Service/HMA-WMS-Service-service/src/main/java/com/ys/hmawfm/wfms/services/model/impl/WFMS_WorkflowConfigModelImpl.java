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

package com.ys.hmawfm.wfms.services.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig;
import com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfigModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the WFMS_WorkflowConfig service. Represents a row in the &quot;WFMS_WorkflowConfig&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link WFMS_WorkflowConfigModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WFMS_WorkflowConfigImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_WorkflowConfigImpl
 * @see WFMS_WorkflowConfig
 * @see WFMS_WorkflowConfigModel
 * @generated
 */
@ProviderType
public class WFMS_WorkflowConfigModelImpl extends BaseModelImpl<WFMS_WorkflowConfig>
	implements WFMS_WorkflowConfigModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a WFMS_WorkflowConfig model instance should use the {@link WFMS_WorkflowConfig} interface instead.
	 */
	public static final String TABLE_NAME = "WFMS_WorkflowConfig";
	public static final Object[][] TABLE_COLUMNS = {
			{ "wfcId", Types.BIGINT },
			{ "createdBy", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedBy", Types.VARCHAR },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "configKey", Types.VARCHAR },
			{ "configLabel", Types.VARCHAR },
			{ "contentType", Types.VARCHAR },
			{ "content", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("wfcId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createdBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("configKey", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("configLabel", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contentType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table WFMS_WorkflowConfig (wfcId LONG not null primary key,createdBy VARCHAR(75) null,createDate DATE null,modifiedBy VARCHAR(75) null,modifiedDate DATE null,configKey VARCHAR(75) null,configLabel VARCHAR(75) null,contentType VARCHAR(75) null,content TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table WFMS_WorkflowConfig";
	public static final String ORDER_BY_JPQL = " ORDER BY wfms_WorkflowConfig.configLabel ASC";
	public static final String ORDER_BY_SQL = " ORDER BY WFMS_WorkflowConfig.configLabel ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.ys.hmawfm.wfms.services.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.ys.hmawfm.wfms.services.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.ys.hmawfm.wfms.services.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig"),
			true);
	public static final long CONFIGKEY_COLUMN_BITMASK = 1L;
	public static final long CONFIGLABEL_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.ys.hmawfm.wfms.services.service.util.ServiceProps.get(
				"lock.expiration.time.com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig"));

	public WFMS_WorkflowConfigModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _wfcId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWfcId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wfcId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return WFMS_WorkflowConfig.class;
	}

	@Override
	public String getModelClassName() {
		return WFMS_WorkflowConfig.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("wfcId", getWfcId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("configKey", getConfigKey());
		attributes.put("configLabel", getConfigLabel());
		attributes.put("contentType", getContentType());
		attributes.put("content", getContent());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long wfcId = (Long)attributes.get("wfcId");

		if (wfcId != null) {
			setWfcId(wfcId);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String configKey = (String)attributes.get("configKey");

		if (configKey != null) {
			setConfigKey(configKey);
		}

		String configLabel = (String)attributes.get("configLabel");

		if (configLabel != null) {
			setConfigLabel(configLabel);
		}

		String contentType = (String)attributes.get("contentType");

		if (contentType != null) {
			setContentType(contentType);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	@Override
	public long getWfcId() {
		return _wfcId;
	}

	@Override
	public void setWfcId(long wfcId) {
		_wfcId = wfcId;
	}

	@Override
	public String getCreatedBy() {
		if (_createdBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _createdBy;
		}
	}

	@Override
	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public String getModifiedBy() {
		if (_modifiedBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _modifiedBy;
		}
	}

	@Override
	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
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

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getConfigKey() {
		if (_configKey == null) {
			return StringPool.BLANK;
		}
		else {
			return _configKey;
		}
	}

	@Override
	public void setConfigKey(String configKey) {
		_columnBitmask |= CONFIGKEY_COLUMN_BITMASK;

		if (_originalConfigKey == null) {
			_originalConfigKey = _configKey;
		}

		_configKey = configKey;
	}

	public String getOriginalConfigKey() {
		return GetterUtil.getString(_originalConfigKey);
	}

	@Override
	public String getConfigLabel() {
		if (_configLabel == null) {
			return StringPool.BLANK;
		}
		else {
			return _configLabel;
		}
	}

	@Override
	public void setConfigLabel(String configLabel) {
		_columnBitmask = -1L;

		_configLabel = configLabel;
	}

	@Override
	public String getContentType() {
		if (_contentType == null) {
			return StringPool.BLANK;
		}
		else {
			return _contentType;
		}
	}

	@Override
	public void setContentType(String contentType) {
		_contentType = contentType;
	}

	@Override
	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			WFMS_WorkflowConfig.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WFMS_WorkflowConfig toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (WFMS_WorkflowConfig)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		WFMS_WorkflowConfigImpl wfms_WorkflowConfigImpl = new WFMS_WorkflowConfigImpl();

		wfms_WorkflowConfigImpl.setWfcId(getWfcId());
		wfms_WorkflowConfigImpl.setCreatedBy(getCreatedBy());
		wfms_WorkflowConfigImpl.setCreateDate(getCreateDate());
		wfms_WorkflowConfigImpl.setModifiedBy(getModifiedBy());
		wfms_WorkflowConfigImpl.setModifiedDate(getModifiedDate());
		wfms_WorkflowConfigImpl.setConfigKey(getConfigKey());
		wfms_WorkflowConfigImpl.setConfigLabel(getConfigLabel());
		wfms_WorkflowConfigImpl.setContentType(getContentType());
		wfms_WorkflowConfigImpl.setContent(getContent());

		wfms_WorkflowConfigImpl.resetOriginalValues();

		return wfms_WorkflowConfigImpl;
	}

	@Override
	public int compareTo(WFMS_WorkflowConfig wfms_WorkflowConfig) {
		int value = 0;

		value = getConfigLabel().compareTo(wfms_WorkflowConfig.getConfigLabel());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WFMS_WorkflowConfig)) {
			return false;
		}

		WFMS_WorkflowConfig wfms_WorkflowConfig = (WFMS_WorkflowConfig)obj;

		long primaryKey = wfms_WorkflowConfig.getPrimaryKey();

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

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		WFMS_WorkflowConfigModelImpl wfms_WorkflowConfigModelImpl = this;

		wfms_WorkflowConfigModelImpl._setModifiedDate = false;

		wfms_WorkflowConfigModelImpl._originalConfigKey = wfms_WorkflowConfigModelImpl._configKey;

		wfms_WorkflowConfigModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WFMS_WorkflowConfig> toCacheModel() {
		WFMS_WorkflowConfigCacheModel wfms_WorkflowConfigCacheModel = new WFMS_WorkflowConfigCacheModel();

		wfms_WorkflowConfigCacheModel.wfcId = getWfcId();

		wfms_WorkflowConfigCacheModel.createdBy = getCreatedBy();

		String createdBy = wfms_WorkflowConfigCacheModel.createdBy;

		if ((createdBy != null) && (createdBy.length() == 0)) {
			wfms_WorkflowConfigCacheModel.createdBy = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			wfms_WorkflowConfigCacheModel.createDate = createDate.getTime();
		}
		else {
			wfms_WorkflowConfigCacheModel.createDate = Long.MIN_VALUE;
		}

		wfms_WorkflowConfigCacheModel.modifiedBy = getModifiedBy();

		String modifiedBy = wfms_WorkflowConfigCacheModel.modifiedBy;

		if ((modifiedBy != null) && (modifiedBy.length() == 0)) {
			wfms_WorkflowConfigCacheModel.modifiedBy = null;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			wfms_WorkflowConfigCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			wfms_WorkflowConfigCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		wfms_WorkflowConfigCacheModel.configKey = getConfigKey();

		String configKey = wfms_WorkflowConfigCacheModel.configKey;

		if ((configKey != null) && (configKey.length() == 0)) {
			wfms_WorkflowConfigCacheModel.configKey = null;
		}

		wfms_WorkflowConfigCacheModel.configLabel = getConfigLabel();

		String configLabel = wfms_WorkflowConfigCacheModel.configLabel;

		if ((configLabel != null) && (configLabel.length() == 0)) {
			wfms_WorkflowConfigCacheModel.configLabel = null;
		}

		wfms_WorkflowConfigCacheModel.contentType = getContentType();

		String contentType = wfms_WorkflowConfigCacheModel.contentType;

		if ((contentType != null) && (contentType.length() == 0)) {
			wfms_WorkflowConfigCacheModel.contentType = null;
		}

		wfms_WorkflowConfigCacheModel.content = getContent();

		String content = wfms_WorkflowConfigCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			wfms_WorkflowConfigCacheModel.content = null;
		}

		return wfms_WorkflowConfigCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{wfcId=");
		sb.append(getWfcId());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", configKey=");
		sb.append(getConfigKey());
		sb.append(", configLabel=");
		sb.append(getConfigLabel());
		sb.append(", contentType=");
		sb.append(getContentType());
		sb.append(", content=");
		sb.append(getContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>wfcId</column-name><column-value><![CDATA[");
		sb.append(getWfcId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>configKey</column-name><column-value><![CDATA[");
		sb.append(getConfigKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>configLabel</column-name><column-value><![CDATA[");
		sb.append(getConfigLabel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentType</column-name><column-value><![CDATA[");
		sb.append(getContentType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = WFMS_WorkflowConfig.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			WFMS_WorkflowConfig.class
		};
	private long _wfcId;
	private String _createdBy;
	private Date _createDate;
	private String _modifiedBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _configKey;
	private String _originalConfigKey;
	private String _configLabel;
	private String _contentType;
	private String _content;
	private long _columnBitmask;
	private WFMS_WorkflowConfig _escapedModel;
}
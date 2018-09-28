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

package com.ddt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.ddt.model.TestimonialAshok;
import com.ddt.model.TestimonialAshokModel;
import com.ddt.model.TestimonialAshokSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TestimonialAshok service. Represents a row in the &quot;WDDTS_TestimonialAshok&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TestimonialAshokModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TestimonialAshokImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TestimonialAshokImpl
 * @see TestimonialAshok
 * @see TestimonialAshokModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TestimonialAshokModelImpl extends BaseModelImpl<TestimonialAshok>
	implements TestimonialAshokModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a testimonial ashok model instance should use the {@link TestimonialAshok} interface instead.
	 */
	public static final String TABLE_NAME = "WDDTS_TestimonialAshok";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "id_", Types.BIGINT },
			{ "TestimonialContent", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("TestimonialContent", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table WDDTS_TestimonialAshok (uuid_ VARCHAR(75) null,id_ LONG not null primary key,TestimonialContent VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table WDDTS_TestimonialAshok";
	public static final String ORDER_BY_JPQL = " ORDER BY testimonialAshok.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY WDDTS_TestimonialAshok.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(ddtservice.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ddt.model.TestimonialAshok"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(ddtservice.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ddt.model.TestimonialAshok"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(ddtservice.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ddt.model.TestimonialAshok"),
			true);
	public static final long UUID_COLUMN_BITMASK = 1L;
	public static final long ID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TestimonialAshok toModel(TestimonialAshokSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TestimonialAshok model = new TestimonialAshokImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setTestimonialContent(soapModel.getTestimonialContent());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TestimonialAshok> toModels(
		TestimonialAshokSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TestimonialAshok> models = new ArrayList<TestimonialAshok>(soapModels.length);

		for (TestimonialAshokSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(ddtservice.service.util.ServiceProps.get(
				"lock.expiration.time.com.ddt.model.TestimonialAshok"));

	public TestimonialAshokModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TestimonialAshok.class;
	}

	@Override
	public String getModelClassName() {
		return TestimonialAshok.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("TestimonialContent", getTestimonialContent());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String TestimonialContent = (String)attributes.get("TestimonialContent");

		if (TestimonialContent != null) {
			setTestimonialContent(TestimonialContent);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@JSON
	@Override
	public String getTestimonialContent() {
		if (_TestimonialContent == null) {
			return StringPool.BLANK;
		}
		else {
			return _TestimonialContent;
		}
	}

	@Override
	public void setTestimonialContent(String TestimonialContent) {
		_TestimonialContent = TestimonialContent;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TestimonialAshok.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TestimonialAshok toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TestimonialAshok)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TestimonialAshokImpl testimonialAshokImpl = new TestimonialAshokImpl();

		testimonialAshokImpl.setUuid(getUuid());
		testimonialAshokImpl.setId(getId());
		testimonialAshokImpl.setTestimonialContent(getTestimonialContent());

		testimonialAshokImpl.resetOriginalValues();

		return testimonialAshokImpl;
	}

	@Override
	public int compareTo(TestimonialAshok testimonialAshok) {
		long primaryKey = testimonialAshok.getPrimaryKey();

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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestimonialAshok)) {
			return false;
		}

		TestimonialAshok testimonialAshok = (TestimonialAshok)obj;

		long primaryKey = testimonialAshok.getPrimaryKey();

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
		TestimonialAshokModelImpl testimonialAshokModelImpl = this;

		testimonialAshokModelImpl._originalUuid = testimonialAshokModelImpl._uuid;

		testimonialAshokModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TestimonialAshok> toCacheModel() {
		TestimonialAshokCacheModel testimonialAshokCacheModel = new TestimonialAshokCacheModel();

		testimonialAshokCacheModel.uuid = getUuid();

		String uuid = testimonialAshokCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			testimonialAshokCacheModel.uuid = null;
		}

		testimonialAshokCacheModel.id = getId();

		testimonialAshokCacheModel.TestimonialContent = getTestimonialContent();

		String TestimonialContent = testimonialAshokCacheModel.TestimonialContent;

		if ((TestimonialContent != null) && (TestimonialContent.length() == 0)) {
			testimonialAshokCacheModel.TestimonialContent = null;
		}

		return testimonialAshokCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", TestimonialContent=");
		sb.append(getTestimonialContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.ddt.model.TestimonialAshok");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TestimonialContent</column-name><column-value><![CDATA[");
		sb.append(getTestimonialContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TestimonialAshok.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TestimonialAshok.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _id;
	private String _TestimonialContent;
	private long _columnBitmask;
	private TestimonialAshok _escapedModel;
}
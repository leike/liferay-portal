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

package com.liferay.journal.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.journal.model.JournalArticleLocalization;
import com.liferay.journal.model.JournalArticleLocalizationModel;

import com.liferay.petra.string.StringBundler;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the JournalArticleLocalization service. Represents a row in the &quot;JournalArticleLocalization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link JournalArticleLocalizationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JournalArticleLocalizationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticleLocalizationImpl
 * @see JournalArticleLocalization
 * @see JournalArticleLocalizationModel
 * @generated
 */
@ProviderType
public class JournalArticleLocalizationModelImpl extends BaseModelImpl<JournalArticleLocalization>
	implements JournalArticleLocalizationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a journal article localization model instance should use the {@link JournalArticleLocalization} interface instead.
	 */
	public static final String TABLE_NAME = "JournalArticleLocalization";
	public static final Object[][] TABLE_COLUMNS = {
			{ "articleLocalizationId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "articlePK", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "description_", Types.VARCHAR },
			{ "languageId", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("articleLocalizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("articlePK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("languageId", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table JournalArticleLocalization (articleLocalizationId LONG not null primary key,companyId LONG,articlePK LONG,title VARCHAR(400) null,description_ STRING null,languageId VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table JournalArticleLocalization";
	public static final String ORDER_BY_JPQL = " ORDER BY journalArticleLocalization.articleLocalizationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY JournalArticleLocalization.articleLocalizationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.journal.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.journal.model.JournalArticleLocalization"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.journal.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.journal.model.JournalArticleLocalization"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.journal.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.journal.model.JournalArticleLocalization"),
			true);
	public static final long ARTICLEPK_COLUMN_BITMASK = 1L;
	public static final long LANGUAGEID_COLUMN_BITMASK = 2L;
	public static final long ARTICLELOCALIZATIONID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.journal.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.journal.model.JournalArticleLocalization"));

	public JournalArticleLocalizationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _articleLocalizationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setArticleLocalizationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _articleLocalizationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return JournalArticleLocalization.class;
	}

	@Override
	public String getModelClassName() {
		return JournalArticleLocalization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<JournalArticleLocalization, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<JournalArticleLocalization, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<JournalArticleLocalization, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((JournalArticleLocalization)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<JournalArticleLocalization, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<JournalArticleLocalization, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((JournalArticleLocalization)this,
					entry.getValue());
			}
		}
	}

	public Map<String, Function<JournalArticleLocalization, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<JournalArticleLocalization, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<JournalArticleLocalization, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<JournalArticleLocalization, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<JournalArticleLocalization, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<JournalArticleLocalization, Object>>();
		Map<String, BiConsumer<JournalArticleLocalization, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<JournalArticleLocalization, ?>>();


		attributeGetterFunctions.put("articleLocalizationId", JournalArticleLocalization::getArticleLocalizationId);
		attributeSetterBiConsumers.put("articleLocalizationId", (BiConsumer<JournalArticleLocalization, Long>)JournalArticleLocalization::setArticleLocalizationId);
		attributeGetterFunctions.put("companyId", JournalArticleLocalization::getCompanyId);
		attributeSetterBiConsumers.put("companyId", (BiConsumer<JournalArticleLocalization, Long>)JournalArticleLocalization::setCompanyId);
		attributeGetterFunctions.put("articlePK", JournalArticleLocalization::getArticlePK);
		attributeSetterBiConsumers.put("articlePK", (BiConsumer<JournalArticleLocalization, Long>)JournalArticleLocalization::setArticlePK);
		attributeGetterFunctions.put("title", JournalArticleLocalization::getTitle);
		attributeSetterBiConsumers.put("title", (BiConsumer<JournalArticleLocalization, String>)JournalArticleLocalization::setTitle);
		attributeGetterFunctions.put("description", JournalArticleLocalization::getDescription);
		attributeSetterBiConsumers.put("description", (BiConsumer<JournalArticleLocalization, String>)JournalArticleLocalization::setDescription);
		attributeGetterFunctions.put("languageId", JournalArticleLocalization::getLanguageId);
		attributeSetterBiConsumers.put("languageId", (BiConsumer<JournalArticleLocalization, String>)JournalArticleLocalization::setLanguageId);


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@Override
	public long getArticleLocalizationId() {
		return _articleLocalizationId;
	}

	@Override
	public void setArticleLocalizationId(long articleLocalizationId) {
		_articleLocalizationId = articleLocalizationId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getArticlePK() {
		return _articlePK;
	}

	@Override
	public void setArticlePK(long articlePK) {
		_columnBitmask |= ARTICLEPK_COLUMN_BITMASK;

		if (!_setOriginalArticlePK) {
			_setOriginalArticlePK = true;

			_originalArticlePK = _articlePK;
		}

		_articlePK = articlePK;
	}

	public long getOriginalArticlePK() {
		return _originalArticlePK;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
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
		_description = description;
	}

	@Override
	public String getLanguageId() {
		if (_languageId == null) {
			return "";
		}
		else {
			return _languageId;
		}
	}

	@Override
	public void setLanguageId(String languageId) {
		_columnBitmask |= LANGUAGEID_COLUMN_BITMASK;

		if (_originalLanguageId == null) {
			_originalLanguageId = _languageId;
		}

		_languageId = languageId;
	}

	public String getOriginalLanguageId() {
		return GetterUtil.getString(_originalLanguageId);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			JournalArticleLocalization.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JournalArticleLocalization toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (JournalArticleLocalization)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		JournalArticleLocalizationImpl journalArticleLocalizationImpl = new JournalArticleLocalizationImpl();

		journalArticleLocalizationImpl.setArticleLocalizationId(getArticleLocalizationId());
		journalArticleLocalizationImpl.setCompanyId(getCompanyId());
		journalArticleLocalizationImpl.setArticlePK(getArticlePK());
		journalArticleLocalizationImpl.setTitle(getTitle());
		journalArticleLocalizationImpl.setDescription(getDescription());
		journalArticleLocalizationImpl.setLanguageId(getLanguageId());

		journalArticleLocalizationImpl.resetOriginalValues();

		return journalArticleLocalizationImpl;
	}

	@Override
	public int compareTo(JournalArticleLocalization journalArticleLocalization) {
		long primaryKey = journalArticleLocalization.getPrimaryKey();

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

		if (!(obj instanceof JournalArticleLocalization)) {
			return false;
		}

		JournalArticleLocalization journalArticleLocalization = (JournalArticleLocalization)obj;

		long primaryKey = journalArticleLocalization.getPrimaryKey();

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
		JournalArticleLocalizationModelImpl journalArticleLocalizationModelImpl = this;

		journalArticleLocalizationModelImpl._originalArticlePK = journalArticleLocalizationModelImpl._articlePK;

		journalArticleLocalizationModelImpl._setOriginalArticlePK = false;

		journalArticleLocalizationModelImpl._originalLanguageId = journalArticleLocalizationModelImpl._languageId;

		journalArticleLocalizationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JournalArticleLocalization> toCacheModel() {
		JournalArticleLocalizationCacheModel journalArticleLocalizationCacheModel =
			new JournalArticleLocalizationCacheModel();

		journalArticleLocalizationCacheModel.articleLocalizationId = getArticleLocalizationId();

		journalArticleLocalizationCacheModel.companyId = getCompanyId();

		journalArticleLocalizationCacheModel.articlePK = getArticlePK();

		journalArticleLocalizationCacheModel.title = getTitle();

		String title = journalArticleLocalizationCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			journalArticleLocalizationCacheModel.title = null;
		}

		journalArticleLocalizationCacheModel.description = getDescription();

		String description = journalArticleLocalizationCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			journalArticleLocalizationCacheModel.description = null;
		}

		journalArticleLocalizationCacheModel.languageId = getLanguageId();

		String languageId = journalArticleLocalizationCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			journalArticleLocalizationCacheModel.languageId = null;
		}

		return journalArticleLocalizationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<JournalArticleLocalization, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<JournalArticleLocalization, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<JournalArticleLocalization, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply(
					(JournalArticleLocalization)this));
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
		Map<String, Function<JournalArticleLocalization, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<JournalArticleLocalization, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<JournalArticleLocalization, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply(
					(JournalArticleLocalization)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = JournalArticleLocalization.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			JournalArticleLocalization.class, ModelWrapper.class
		};
	private long _articleLocalizationId;
	private long _companyId;
	private long _articlePK;
	private long _originalArticlePK;
	private boolean _setOriginalArticlePK;
	private String _title;
	private String _description;
	private String _languageId;
	private String _originalLanguageId;
	private long _columnBitmask;
	private JournalArticleLocalization _escapedModel;
}
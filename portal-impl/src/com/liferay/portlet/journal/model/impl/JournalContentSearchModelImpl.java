/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.journal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.journal.model.JournalContentSearch;
import com.liferay.portlet.journal.model.JournalContentSearchModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the JournalContentSearch service. Represents a row in the &quot;JournalContentSearch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.journal.model.JournalContentSearchModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JournalContentSearchImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalContentSearchImpl
 * @see com.liferay.portlet.journal.model.JournalContentSearch
 * @see com.liferay.portlet.journal.model.JournalContentSearchModel
 * @generated
 */
public class JournalContentSearchModelImpl extends BaseModelImpl<JournalContentSearch>
	implements JournalContentSearchModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a journal content search model instance should use the {@link com.liferay.portlet.journal.model.JournalContentSearch} interface instead.
	 */
	public static final String TABLE_NAME = "JournalContentSearch";
	public static final Object[][] TABLE_COLUMNS = {
			{ "contentSearchId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "privateLayout", Types.BOOLEAN },
			{ "layoutId", Types.BIGINT },
			{ "portletId", Types.VARCHAR },
			{ "articleId", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table JournalContentSearch (contentSearchId LONG not null primary key,groupId LONG,companyId LONG,privateLayout BOOLEAN,layoutId LONG,portletId VARCHAR(200) null,articleId VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table JournalContentSearch";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.journal.model.JournalContentSearch"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.journal.model.JournalContentSearch"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.journal.model.JournalContentSearch"));

	public JournalContentSearchModelImpl() {
	}

	public long getPrimaryKey() {
		return _contentSearchId;
	}

	public void setPrimaryKey(long pk) {
		setContentSearchId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_contentSearchId);
	}

	public long getContentSearchId() {
		return _contentSearchId;
	}

	public void setContentSearchId(long contentSearchId) {
		_contentSearchId = contentSearchId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public boolean getPrivateLayout() {
		return _privateLayout;
	}

	public boolean isPrivateLayout() {
		return _privateLayout;
	}

	public void setPrivateLayout(boolean privateLayout) {
		if (!_setOriginalPrivateLayout) {
			_setOriginalPrivateLayout = true;

			_originalPrivateLayout = _privateLayout;
		}

		_privateLayout = privateLayout;
	}

	public boolean getOriginalPrivateLayout() {
		return _originalPrivateLayout;
	}

	public long getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(long layoutId) {
		if (!_setOriginalLayoutId) {
			_setOriginalLayoutId = true;

			_originalLayoutId = _layoutId;
		}

		_layoutId = layoutId;
	}

	public long getOriginalLayoutId() {
		return _originalLayoutId;
	}

	public String getPortletId() {
		if (_portletId == null) {
			return StringPool.BLANK;
		}
		else {
			return _portletId;
		}
	}

	public void setPortletId(String portletId) {
		if (_originalPortletId == null) {
			_originalPortletId = _portletId;
		}

		_portletId = portletId;
	}

	public String getOriginalPortletId() {
		return GetterUtil.getString(_originalPortletId);
	}

	public String getArticleId() {
		if (_articleId == null) {
			return StringPool.BLANK;
		}
		else {
			return _articleId;
		}
	}

	public void setArticleId(String articleId) {
		if (_originalArticleId == null) {
			_originalArticleId = _articleId;
		}

		_articleId = articleId;
	}

	public String getOriginalArticleId() {
		return GetterUtil.getString(_originalArticleId);
	}

	public JournalContentSearch toEscapedModel() {
		if (isEscapedModel()) {
			return (JournalContentSearch)this;
		}
		else {
			return (JournalContentSearch)Proxy.newProxyInstance(JournalContentSearch.class.getClassLoader(),
				new Class[] { JournalContentSearch.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					JournalContentSearch.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		JournalContentSearchImpl journalContentSearchImpl = new JournalContentSearchImpl();

		JournalContentSearchModelImpl journalContentSearchModelImpl = journalContentSearchImpl;

		journalContentSearchImpl.setContentSearchId(getContentSearchId());

		journalContentSearchImpl.setGroupId(getGroupId());

		journalContentSearchModelImpl._originalGroupId = journalContentSearchModelImpl._groupId;

		journalContentSearchModelImpl._setOriginalGroupId = false;
		journalContentSearchImpl.setCompanyId(getCompanyId());

		journalContentSearchImpl.setPrivateLayout(getPrivateLayout());

		journalContentSearchModelImpl._originalPrivateLayout = journalContentSearchModelImpl._privateLayout;

		journalContentSearchModelImpl._setOriginalPrivateLayout = false;
		journalContentSearchImpl.setLayoutId(getLayoutId());

		journalContentSearchModelImpl._originalLayoutId = journalContentSearchModelImpl._layoutId;

		journalContentSearchModelImpl._setOriginalLayoutId = false;
		journalContentSearchImpl.setPortletId(getPortletId());

		journalContentSearchModelImpl._originalPortletId = journalContentSearchModelImpl._portletId;

		journalContentSearchImpl.setArticleId(getArticleId());

		journalContentSearchModelImpl._originalArticleId = journalContentSearchModelImpl._articleId;

		return journalContentSearchImpl;
	}

	public int compareTo(JournalContentSearch journalContentSearch) {
		long pk = journalContentSearch.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		JournalContentSearch journalContentSearch = null;

		try {
			journalContentSearch = (JournalContentSearch)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = journalContentSearch.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{contentSearchId=");
		sb.append(getContentSearchId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", privateLayout=");
		sb.append(getPrivateLayout());
		sb.append(", layoutId=");
		sb.append(getLayoutId());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.journal.model.JournalContentSearch");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contentSearchId</column-name><column-value><![CDATA[");
		sb.append(getContentSearchId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>privateLayout</column-name><column-value><![CDATA[");
		sb.append(getPrivateLayout());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layoutId</column-name><column-value><![CDATA[");
		sb.append(getLayoutId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contentSearchId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private boolean _privateLayout;
	private boolean _originalPrivateLayout;
	private boolean _setOriginalPrivateLayout;
	private long _layoutId;
	private long _originalLayoutId;
	private boolean _setOriginalLayoutId;
	private String _portletId;
	private String _originalPortletId;
	private String _articleId;
	private String _originalArticleId;
	private transient ExpandoBridge _expandoBridge;
}
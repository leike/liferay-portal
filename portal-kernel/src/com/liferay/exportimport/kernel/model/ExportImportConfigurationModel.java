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

package com.liferay.exportimport.kernel.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ExportImportConfiguration service. Represents a row in the &quot;ExportImportConfiguration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.exportimport.model.impl.ExportImportConfigurationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.exportimport.model.impl.ExportImportConfigurationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExportImportConfiguration
 * @see com.liferay.portlet.exportimport.model.impl.ExportImportConfigurationImpl
 * @see com.liferay.portlet.exportimport.model.impl.ExportImportConfigurationModelImpl
 * @generated
 */
@ProviderType
public interface ExportImportConfigurationModel extends BaseModel<ExportImportConfiguration>,
	GroupedModel, MVCCModel, ShardedModel, TrashedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a export import configuration model instance should use the {@link ExportImportConfiguration} interface instead.
	 */

	/**
	 * Returns the primary key of this export import configuration.
	 *
	 * @return the primary key of this export import configuration
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this export import configuration.
	 *
	 * @param primaryKey the primary key of this export import configuration
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this export import configuration.
	 *
	 * @return the mvcc version of this export import configuration
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this export import configuration.
	 *
	 * @param mvccVersion the mvcc version of this export import configuration
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the export import configuration ID of this export import configuration.
	 *
	 * @return the export import configuration ID of this export import configuration
	 */
	public long getExportImportConfigurationId();

	/**
	 * Sets the export import configuration ID of this export import configuration.
	 *
	 * @param exportImportConfigurationId the export import configuration ID of this export import configuration
	 */
	public void setExportImportConfigurationId(long exportImportConfigurationId);

	/**
	 * Returns the group ID of this export import configuration.
	 *
	 * @return the group ID of this export import configuration
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this export import configuration.
	 *
	 * @param groupId the group ID of this export import configuration
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this export import configuration.
	 *
	 * @return the company ID of this export import configuration
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this export import configuration.
	 *
	 * @param companyId the company ID of this export import configuration
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this export import configuration.
	 *
	 * @return the user ID of this export import configuration
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this export import configuration.
	 *
	 * @param userId the user ID of this export import configuration
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this export import configuration.
	 *
	 * @return the user uuid of this export import configuration
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this export import configuration.
	 *
	 * @param userUuid the user uuid of this export import configuration
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this export import configuration.
	 *
	 * @return the user name of this export import configuration
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this export import configuration.
	 *
	 * @param userName the user name of this export import configuration
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this export import configuration.
	 *
	 * @return the create date of this export import configuration
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this export import configuration.
	 *
	 * @param createDate the create date of this export import configuration
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this export import configuration.
	 *
	 * @return the modified date of this export import configuration
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this export import configuration.
	 *
	 * @param modifiedDate the modified date of this export import configuration
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this export import configuration.
	 *
	 * @return the name of this export import configuration
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this export import configuration.
	 *
	 * @param name the name of this export import configuration
	 */
	public void setName(String name);

	/**
	 * Returns the description of this export import configuration.
	 *
	 * @return the description of this export import configuration
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this export import configuration.
	 *
	 * @param description the description of this export import configuration
	 */
	public void setDescription(String description);

	/**
	 * Returns the type of this export import configuration.
	 *
	 * @return the type of this export import configuration
	 */
	public int getType();

	/**
	 * Sets the type of this export import configuration.
	 *
	 * @param type the type of this export import configuration
	 */
	public void setType(int type);

	/**
	 * Returns the settings of this export import configuration.
	 *
	 * @return the settings of this export import configuration
	 */
	@AutoEscape
	public String getSettings();

	/**
	 * Sets the settings of this export import configuration.
	 *
	 * @param settings the settings of this export import configuration
	 */
	public void setSettings(String settings);

	/**
	 * Returns the status of this export import configuration.
	 *
	 * @return the status of this export import configuration
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this export import configuration.
	 *
	 * @param status the status of this export import configuration
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this export import configuration.
	 *
	 * @return the status by user ID of this export import configuration
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this export import configuration.
	 *
	 * @param statusByUserId the status by user ID of this export import configuration
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this export import configuration.
	 *
	 * @return the status by user uuid of this export import configuration
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this export import configuration.
	 *
	 * @param statusByUserUuid the status by user uuid of this export import configuration
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this export import configuration.
	 *
	 * @return the status by user name of this export import configuration
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this export import configuration.
	 *
	 * @param statusByUserName the status by user name of this export import configuration
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this export import configuration.
	 *
	 * @return the status date of this export import configuration
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this export import configuration.
	 *
	 * @param statusDate the status date of this export import configuration
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the trash entry created when this export import configuration was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this export import configuration.
	 *
	 * @return the trash entry created when this export import configuration was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws PortalException;

	/**
	 * Returns the class primary key of the trash entry for this export import configuration.
	 *
	 * @return the class primary key of the trash entry for this export import configuration
	 */
	@Override
	public long getTrashEntryClassPK();

	/**
	 * Returns the trash handler for this export import configuration.
	 *
	 * @return the trash handler for this export import configuration
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler();

	/**
	 * Returns <code>true</code> if this export import configuration is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this export import configuration is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash();

	/**
	 * Returns <code>true</code> if the parent of this export import configuration is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this export import configuration is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer();

	@Override
	public boolean isInTrashExplicitly();

	@Override
	public boolean isInTrashImplicitly();

	/**
	 * Returns <code>true</code> if this export import configuration is approved.
	 *
	 * @return <code>true</code> if this export import configuration is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this export import configuration is denied.
	 *
	 * @return <code>true</code> if this export import configuration is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this export import configuration is a draft.
	 *
	 * @return <code>true</code> if this export import configuration is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this export import configuration is expired.
	 *
	 * @return <code>true</code> if this export import configuration is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this export import configuration is inactive.
	 *
	 * @return <code>true</code> if this export import configuration is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this export import configuration is incomplete.
	 *
	 * @return <code>true</code> if this export import configuration is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this export import configuration is pending.
	 *
	 * @return <code>true</code> if this export import configuration is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this export import configuration is scheduled.
	 *
	 * @return <code>true</code> if this export import configuration is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(ExportImportConfiguration exportImportConfiguration);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ExportImportConfiguration> toCacheModel();

	@Override
	public ExportImportConfiguration toEscapedModel();

	@Override
	public ExportImportConfiguration toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
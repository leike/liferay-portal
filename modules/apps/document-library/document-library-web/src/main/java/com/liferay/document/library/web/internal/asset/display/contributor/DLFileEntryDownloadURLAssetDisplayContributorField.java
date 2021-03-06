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

package com.liferay.document.library.web.internal.asset.display.contributor;

import com.liferay.asset.display.contributor.AssetDisplayContributorField;
import com.liferay.document.library.util.DLURLHelper;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(
	property = "model.class.name=com.liferay.document.library.kernel.model.DLFileEntry",
	service = AssetDisplayContributorField.class
)
public class DLFileEntryDownloadURLAssetDisplayContributorField
	implements AssetDisplayContributorField<FileEntry> {

	@Override
	public String getKey() {
		return "downloadURL";
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(
			ResourceBundleUtil.getBundle(locale, getClass()), "download-url");
	}

	@Override
	public String getType() {
		return "text";
	}

	@Override
	public String getValue(FileEntry fileEntry, Locale locale) {
		try {
			return _dlurlHelper.getDownloadURL(
				fileEntry, fileEntry.getFileVersion(), null, StringPool.BLANK);
		}
		catch (Exception pe) {
			return null;
		}
	}

	@Reference
	private DLURLHelper _dlurlHelper;

}
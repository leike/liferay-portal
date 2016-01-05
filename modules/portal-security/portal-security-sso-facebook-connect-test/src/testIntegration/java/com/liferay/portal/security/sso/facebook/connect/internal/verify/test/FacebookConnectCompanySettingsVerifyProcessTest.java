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

package com.liferay.portal.security.sso.facebook.connect.internal.verify.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.settings.Settings;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.sso.facebook.connect.constants.FacebookConnectConstants;
import com.liferay.portal.security.sso.facebook.connect.constants.LegacyFacebookConnectPropsKeys;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.verify.test.BaseCompanySettingsVerifyProcessTestCase;

import javax.portlet.PortletPreferences;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Stian Sigvartsen
 */
@RunWith(Arquillian.class)
public class FacebookConnectCompanySettingsVerifyProcessTest
	extends BaseCompanySettingsVerifyProcessTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Override
	protected void doVerify(
		PortletPreferences portletPreferences, Settings settings) {

		Assert.assertTrue(
			Validator.isNull(
				portletPreferences.getValue(
					LegacyFacebookConnectPropsKeys.AUTH_ENABLED,
					StringPool.BLANK)));

		Assert.assertEquals(
			StringPool.TRUE,
			settings.getValue(
				FacebookConnectConstants.AUTH_ENABLED, StringPool.FALSE));

		Assert.assertEquals(
				"test_app_id",
				settings.getValue(FacebookConnectConstants.APP_ID, ""));

		Assert.assertEquals(
				"test_app_secret",
				settings.getValue(FacebookConnectConstants.APP_SECRET, ""));

		Assert.assertEquals(
				"test_graph_url",
				settings.getValue(FacebookConnectConstants.GRAPH_URL, ""));

		Assert.assertEquals(
				"test_oauth_auth_url",
				settings.getValue(FacebookConnectConstants.OAUTH_AUTH_URL, ""));

		Assert.assertEquals(
				"test_oauth_redirect_url",
				settings.getValue(
					FacebookConnectConstants.OAUTH_REDIRECT_URL, ""));

		Assert.assertEquals(
				"test_oauth_token_url",
				settings.getValue(
					FacebookConnectConstants.OAUTH_TOKEN_URL, ""));

		Assert.assertEquals(
				StringPool.TRUE,
				settings.getValue(
					FacebookConnectConstants.VERIFIED_ACCOUNT_REQUIRED,
					StringPool.FALSE));
	}

	@Override
	protected String getSettingsId() {
		return FacebookConnectConstants.SERVICE_NAME;
	}

	@Override
	protected String getVerifyProcessName() {
		return "com.liferay.portal.security.sso.facebook.connect";
	}

	@Override
	protected void populateLegacyProperties(UnicodeProperties properties) {
		properties.put(LegacyFacebookConnectPropsKeys.AUTH_ENABLED, "true");
		properties.put(LegacyFacebookConnectPropsKeys.APP_ID, "test_app_id");
		properties.put(
			LegacyFacebookConnectPropsKeys.APP_SECRET, "test_app_secret");
		properties.put(
			LegacyFacebookConnectPropsKeys.GRAPH_URL, "test_graph_url");
		properties.put(
			LegacyFacebookConnectPropsKeys.OAUTH_AUTH_URL,
			"test_oauth_auth_url");
		properties.put(
			LegacyFacebookConnectPropsKeys.OAUTH_REDIRECT_URL,
			"test_oauth_redirect_url");
		properties.put(
			LegacyFacebookConnectPropsKeys.OAUTH_TOKEN_URL,
			"test_oauth_token_url");
		properties.put(
			LegacyFacebookConnectPropsKeys.VERIFIED_ACCOUNT_REQUIRED, "true");
	}

}
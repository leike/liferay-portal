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

package com.liferay.oauth2.provider.rest.internal.endpoint.authorize;

import com.liferay.oauth2.provider.configuration.OAuth2ProviderConfiguration;
import com.liferay.oauth2.provider.rest.internal.endpoint.constants.OAuth2ProviderRestEndpointConstants;
import com.liferay.oauth2.provider.rest.internal.endpoint.liferay.LiferayOAuthDataProvider;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

import org.apache.cxf.rs.security.oauth2.provider.SubjectCreator;
import org.apache.cxf.rs.security.oauth2.services.AuthorizationCodeGrantService;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tomas Polesovsky
 */
@Component(
	configurationPid = "com.liferay.oauth2.provider.configuration.OAuth2ProviderConfiguration",
	immediate = true
)
public class AuthorizationCodeGrantServiceRegistrator {

	@Activate
	public void activate(
		BundleContext bundleContext, Map<String, Object> properties) {

		OAuth2ProviderConfiguration oAuth2ProviderConfiguration =
			ConfigurableUtil.createConfigurable(
				OAuth2ProviderConfiguration.class, properties);

		if (!oAuth2ProviderConfiguration.allowAuthorizationCodeGrant() &&
			!oAuth2ProviderConfiguration.allowAuthorizationCodePKCEGrant()) {

			return;
		}

		AuthorizationCodeGrantService authorizationCodeGrantService =
			new AuthorizationCodeGrantService();

		authorizationCodeGrantService.setCanSupportPublicClients(
			oAuth2ProviderConfiguration.allowAuthorizationCodePKCEGrant());

		authorizationCodeGrantService.setDataProvider(
			_liferayOAuthDataProvider);

		authorizationCodeGrantService.setSubjectCreator(_subjectCreator);

		Dictionary<String, Object> endpointProperties = new Hashtable<>();

		endpointProperties.put(
			OAuth2ProviderRestEndpointConstants.
				LIFERAY_OAUTH2_ENDPOINT_RESOURCE,
			true);

		_endpointServiceRegistration = bundleContext.registerService(
			Object.class, authorizationCodeGrantService, endpointProperties);
	}

	@Deactivate
	public void deactivate() {
		if (_endpointServiceRegistration != null) {
			_endpointServiceRegistration.unregister();
		}
	}

	private ServiceRegistration<Object> _endpointServiceRegistration;

	@Reference
	private LiferayOAuthDataProvider _liferayOAuthDataProvider;

	@Reference
	private SubjectCreator _subjectCreator;

}
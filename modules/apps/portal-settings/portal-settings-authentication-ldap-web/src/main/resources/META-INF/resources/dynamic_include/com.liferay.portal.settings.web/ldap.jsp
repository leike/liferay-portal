<%--
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
--%>

<%@ include file="/dynamic_include/init.jsp" %>

<%
String authenticationURL = currentURL + "#_LFR_FN_authentication";

boolean ldapAuthEnabled = ldapAuthConfiguration.enabled();
String ldapAuthMethod = ldapAuthConfiguration.method();
boolean ldapAuthRequired = ldapAuthConfiguration.required();
boolean ldapExportGroupEnabled = ldapExportConfiguration.exportGroupEnabled();
boolean ldapImportCreateRolePerGroup = ldapImportConfiguration.importCreateRolePerGroup();
boolean ldapImportEnabled = ldapImportConfiguration.importEnabled();
int ldapImportInterval = ldapImportConfiguration.importInterval();
long ldapImportLockExpirationTime = ldapImportConfiguration.importLockExpirationTime();
boolean ldapImportGroupCacheEnabled = ldapImportConfiguration.importGroupCacheEnabled();
String ldapImportMethod = ldapImportConfiguration.importMethod();
boolean ldapImportOnStartup = ldapImportConfiguration.importOnStartup();
String ldapImportUserSyncStrategy = ldapImportConfiguration.importUserSyncStrategy();
boolean ldapImportUserPasswordAutogenerated = ldapImportConfiguration.importUserPasswordAutogenerated();
String ldapImportUserPasswordDefault = ldapImportConfiguration.importUserPasswordDefault();
boolean ldapImportUserPasswordEnabled = ldapImportConfiguration.importUserPasswordEnabled();
String ldapPasswordEncryptionAlgorithm = ldapAuthConfiguration.passwordEncryptionAlgorithm();
boolean ldapPasswordPolicyEnabled = ldapAuthConfiguration.passwordPolicyEnabled();

boolean ldapExportEnabled = !(ldapImportConfiguration.importUserPasswordAutogenerated() && ldapImportEnabled) && ldapExportConfiguration.exportEnabled();
%>

<aui:fieldset>
	<liferay-ui:error key="ldapExportAndImportOnPasswordAutogeneration" message="ldap-export-must-not-be-enabled-when-autogeneration-of-user-passwords-is-enabled-for-ldap-import" />

	<aui:input label="enabled" name='<%= "ldap--" + LDAPConstants.AUTH_ENABLED + "--" %>' type="checkbox" value="<%= ldapAuthEnabled %>" />

	<aui:input label="required" name='<%= "ldap--" + LDAPConstants.AUTH_REQUIRED + "--" %>' type="checkbox" value="<%= ldapAuthRequired %>" />

	<aui:select label="method" name='<%= "ldap--" + LDAPConstants.AUTH_METHOD + "--" %>' value="<%= ldapAuthMethod %>">
		<aui:option label="bind" value="<%= LDAPConstants.AUTH_METHOD_BIND %>" />
		<aui:option label="password-compare" value="<%= LDAPConstants.AUTH_METHOD_PASSWORD_COMPARE %>" />
	</aui:select>

	<aui:select label="password-encryption-algorithm" name='<%= "ldap--" + LDAPConstants.PASSWORD_ENCRYPTION_ALGORITHM + "--" %>' value="<%= ldapPasswordEncryptionAlgorithm %>">
		<aui:option label="bcrypt" value="<%= LDAPSettingsConstants.BCRYPT %>" />
		<aui:option label="md2" value="<%= LDAPSettingsConstants.MD2 %>" />
		<aui:option label="md5" value="<%= LDAPSettingsConstants.MD5 %>" />
		<aui:option label="none" value="<%= LDAPSettingsConstants.NONE %>" />
		<aui:option label="sha" value="<%= LDAPSettingsConstants.SHA %>" />
		<aui:option label="sha-256" value="<%= LDAPSettingsConstants.SHA_256 %>" />
		<aui:option label="sha-384" value="<%= LDAPSettingsConstants.SHA_384 %>" />
		<aui:option label="ssha" value="<%= LDAPSettingsConstants.SSHA %>" />
		<aui:option label="ufc-crypt" value="<%= LDAPSettingsConstants.UFC_CRYPT %>" />
	</aui:select>
</aui:fieldset>

<h3><liferay-ui:message key="ldap-servers" /></h3>

<c:if test="<%= ldapAuthEnabled && ldapServerConfigurations.isEmpty() %>">
	<div class="alert alert-info">
		<liferay-ui:message key="default-ldap-server-settings-are-in-use-please-add-an-ldap-server-to-override-the-default-settings" />
	</div>
</c:if>

<aui:button-row>

	<%
	PortletURL addServerURL = renderResponse.createRenderURL();

	addServerURL.setParameter("mvcRenderCommandName", "/portal_settings/edit_ldap_server");
	addServerURL.setParameter("redirect", authenticationURL);
	%>

	<aui:button href="<%= addServerURL.toString() %>" name="addButton" value="add" />
</aui:button-row>

<aui:fieldset>
	<aui:input id='<%= PortalUtil.generateRandomKey(request, "portal_settings_authentication_ldap") %>' name="<%= ActionRequest.ACTION_NAME %>" type="hidden" value="/portal_settings/ldap" />
	<aui:input name='<%= "ldap--" + LDAPConstants.AUTH_SERVER_PRIORITY + "--" %>' type="hidden" />

	<c:if test="<%= !ldapServerConfigurations.isEmpty() %>">
		<br /><br />

		<div class="ldap-servers searchcontainer-content">
			<table class="table table-bordered table-hover table-striped">
				<thead class="table-columns">
					<tr>
						<th class="table-header">
							<liferay-ui:message key="ldap-server-id" />
						</th>
						<th class="table-header">
							<liferay-ui:message key="ldap-server-name" />
						</th>
						<th class="table-header"></th>
					</tr>
				</thead>

				<tbody class="table-data">

					<%
					for (LDAPServerConfiguration ldapServerConfiguration : ldapServerConfigurations) {
						long ldapServerId = ldapServerConfiguration.ldapServerId();

						String ldapServerName = ldapServerConfiguration.serverName();
					%>

						<tr data-ldapServerId="<%= ldapServerId %>">
							<td class="table-cell">
								<%= ldapServerId %>
							</td>
							<td class="table-cell">
								<%= HtmlUtil.escape(ldapServerName) %>
							</td>
							<td align="right" class="table-cell">
								<div class="control">
									<c:if test="<%= ldapServerConfigurations.size() > 1 %>">
										<liferay-ui:icon
											iconCssClass="icon-arrow-up"
											message="up"
											url='<%= "javascript:" + renderResponse.getNamespace() + "raiseLDAPServerPriority(" + ldapServerId + ");" %>'
										/>

										<liferay-ui:icon
											iconCssClass="icon-arrow-down"
											message="down"
											url='<%= "javascript:" + renderResponse.getNamespace() + "lowerLDAPServerPriority(" + ldapServerId + ");" %>'
										/>
									</c:if>

									<portlet:renderURL var="editURL">
										<portlet:param name="mvcRenderCommandName" value="/portal_settings/edit_ldap_server" />
										<portlet:param name="redirect" value="<%= authenticationURL %>" />
										<portlet:param name="ldapServerId" value="<%= String.valueOf(ldapServerId) %>" />
									</portlet:renderURL>

									<liferay-ui:icon
										iconCssClass="icon-edit"
										message="edit"
										url="<%= editURL %>"
									/>

									<portlet:actionURL name="/portal_settings/edit_ldap_server" var="deleteURL">
										<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
										<portlet:param name="redirect" value="<%= authenticationURL %>" />
										<portlet:param name="ldapServerId" value="<%= String.valueOf(ldapServerId) %>" />
									</portlet:actionURL>

									<liferay-ui:icon-delete
										showIcon="<%= true %>"
										url="<%= deleteURL %>"
									/>
								</div>
							</td>
						</tr>

					<%
					}
					%>

				</tbody>
			</table>
		</div>
	</c:if>
</aui:fieldset>

<h3><liferay-ui:message key="import-export" /></h3>

<aui:fieldset>
	<c:choose>
		<c:when test="<%= ldapImportConfiguration.importUserPasswordAutogenerated() %>">
			<aui:input helpMessage="import-enabled-user-password-autogenerated-help" id="ldapImportEnabled" label="enable-import" name='<%= "ldap--" + LDAPConstants.IMPORT_ENABLED + "--" %>' onClick='<%= renderResponse.getNamespace() + "enableExport()" %>' type="checkbox" value="<%= ldapImportEnabled %>" />
		</c:when>
		<c:otherwise>
			<aui:input id="ldapImportEnabled" label="enable-import" name='<%= "ldap--" + LDAPConstants.IMPORT_ENABLED + "--" %>' type="checkbox" value="<%= ldapImportEnabled %>" />
		</c:otherwise>
	</c:choose>

	<div id="<portlet:namespace />importEnabledSettings">
		<aui:input label="enable-import-on-startup" name='<%= "ldap--" + LDAPConstants.IMPORT_ON_STARTUP + "--" %>' type="checkbox" value="<%= ldapImportOnStartup %>" />
	</div>

	<aui:input label="import-interval" name='<%= "ldap--" + LDAPConstants.IMPORT_INTERVAL + "--" %>' type="text" value="<%= ldapImportInterval %>" />

	<aui:select label="select-import-method" name='<%= "ldap--" + LDAPConstants.IMPORT_METHOD + "--" %>' value="<%= ldapImportMethod %>">
		<aui:option label="group" value="<%= LDAPSettingsConstants.IMPORT_METHOD_GROUP %>" />
		<aui:option label="user" value="<%= LDAPSettingsConstants.IMPORT_METHOD_USER %>" />
	</aui:select>

	<aui:input label="import-lock-expiration-time" name='<%= "ldap--" + LDAPConstants.IMPORT_LOCK_EXPIRATION_TIME + "--" %>' type="text" value="<%= ldapImportLockExpirationTime %>" />

	<aui:select label="import-user-sync-strategy" name='<%= "ldap--" + LDAPConstants.IMPORT_USER_SYNC_STRATEGY + "--" %>' value="<%= ldapImportUserSyncStrategy %>">
		<aui:option label="auth-type" value="<%= LDAPSettingsConstants.IMPORT_USER_SYNC_STRATEGY_AUTH_TYPE %>" />
		<aui:option label="uuid" value="<%= LDAPSettingsConstants.IMPORT_USER_SYNC_STRATEGY_UUID %>" />
	</aui:select>

	<aui:input label="enable-user-password-on-import" name='<%= "ldap--" + LDAPConstants.IMPORT_USER_PASSWORD_ENABLED + "--" %>' type="checkbox" value="<%= ldapImportUserPasswordEnabled %>" />

	<aui:input label="autogenerate-user-password-on-import" name='<%= "ldap--" + LDAPConstants.IMPORT_USER_PASSWORD_AUTOGENERATED + "--" %>' type="checkbox" value="<%= ldapImportUserPasswordAutogenerated %>" />

	<aui:input label="default-user-password" name='<%= "ldap--" + LDAPConstants.IMPORT_USER_PASSWORD_DEFAULT + "--" %>' type="text" value="<%= ldapImportUserPasswordDefault %>" />

	<aui:input label="enable-group-cache-on-import" name='<%= "ldap--" + LDAPConstants.IMPORT_GROUP_CACHE_ENABLED + "--" %>' type="checkbox" value="<%= ldapImportGroupCacheEnabled %>" />

	<aui:input label="create-role-per-group-on-import" name='<%= "ldap--" + LDAPConstants.IMPORT_CREATE_ROLE_PER_GROUP + "--" %>' type="checkbox" value="<%= ldapImportCreateRolePerGroup %>" />

	<aui:input disabled="<%= ldapImportConfiguration.importUserPasswordAutogenerated() && ldapImportEnabled %>" id="ldapExportEnabled" label="enable-export" name='<%= "ldap--" + LDAPConstants.EXPORT_ENABLED + "--" %>' type="checkbox" value="<%= ldapExportEnabled %>" />

	<aui:input id="ldapExportGroupEnabled" label="enable-group-export" name='<%= "ldap--" + LDAPConstants.EXPORT_GROUP_ENABLED + "--" %>' type="checkbox" value="<%= ldapExportGroupEnabled %>" />
</aui:fieldset>

<h3><liferay-ui:message key="password-policy" /></h3>

<aui:fieldset>
	<aui:input helpMessage="ldap-password-policy-help" label="use-ldap-password-policy" name='<%= "ldap--" + LDAPConstants.PASSWORD_POLICY_ENABLED + "--" %>' type="checkbox" value="<%= ldapPasswordPolicyEnabled %>" />
</aui:fieldset>

<c:if test="<%= ldapImportConfiguration.importUserPasswordAutogenerated() %>">
	<script>
		function <portlet:namespace />enableExport() {
			var exportCheckbox = document.getElementById('<portlet:namespace />ldapExportEnabled');
			var importCheckbox = document.getElementById('<portlet:namespace />ldapImportEnabled');

			if (exportCheckbox && importCheckbox) {
				exportCheckbox.disabled = importCheckbox.checked;
			}
		}
	</script>
</c:if>

<script>
	function <portlet:namespace />changeLDAPServerPriority(ldapServerId, action) {
		var ldapServer = document.querySelector('.ldap-servers tr[data-ldapServerId="' + ldapServerId + '"]');

		if (ldapServer) {
			var swapLdapServer = ldapServer.nextElementSibling;

			if (action === 'raise') {
				swapLdapServer = ldapServer.previousElementSibling;
			}

			if (swapLdapServer) {
				var parentNode = ldapServer.parentNode;

				if (action === 'raise') {
					parentNode.insertBefore(ldapServer, swapLdapServer);
				}
				else {
					parentNode.insertBefore(swapLdapServer, ldapServer);
				}
			}
		}

		<portlet:namespace />saveLdap();
	}

	function <portlet:namespace />lowerLDAPServerPriority(ldapServerId) {
		<portlet:namespace />changeLDAPServerPriority(ldapServerId, 'lower');
	}

	function <portlet:namespace />raiseLDAPServerPriority(ldapServerId) {
		<portlet:namespace />changeLDAPServerPriority(ldapServerId, 'raise');
	}

	function <portlet:namespace />saveLdap() {
		var ldapServerIdsNodes = document.querySelectorAll('.ldap-servers .table-data tr');

		var ldapServerIds = Array.prototype.map.call(
			ldapServerIdsNodes,
			function(ldapServerIdsNode) {
				return ldapServerIdsNode.dataset.ldapserverid;
			}
		);

		Liferay.Util.setFormValues(
			document.<portlet:namespace />fm,
			{
				'ldap--<%= LDAPConstants.AUTH_SERVER_PRIORITY %>--': ldapServerIds.join(',')
			}
		);
	}

	Liferay.Util.toggleBoxes('<portlet:namespace />ldapImportEnabled', '<portlet:namespace />importEnabledSettings');
</script>
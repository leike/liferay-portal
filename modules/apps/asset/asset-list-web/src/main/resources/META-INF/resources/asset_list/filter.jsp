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

<%@ include file="/init.jsp" %>

<portlet:actionURL name="/asset_list/edit_asset_list_entry_filters" var="editAssetListEntryFiltersURL" />

<liferay-frontend:edit-form
	action="<%= editAssetListEntryFiltersURL %>"
	method="post"
	name="fm"
>
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="assetListEntryId" type="hidden" value="<%= assetListDisplayContext.getAssetListEntryId() %>" />
	<aui:input name="segmentsEntryId" type="hidden" value="<%= assetListDisplayContext.getSegmentsEntryId() %>" />

	<liferay-frontend:edit-form-body>
		<h1 class="sheet-title">
			<liferay-ui:message key="filter" />
		</h1>

		<liferay-frontend:fieldset-group>
			<liferay-frontend:fieldset>
				<liferay-asset:asset-tags-error />

				<liferay-ui:error exception="<%= DuplicateQueryRuleException.class %>">

					<%
					DuplicateQueryRuleException dqre = (DuplicateQueryRuleException)errorException;
					%>

					<liferay-util:buffer
						var="messageArgument"
					>
						<em>(<liferay-ui:message key='<%= dqre.isContains() ? "contains" : "does-not-contain" %>' /> - <liferay-ui:message key='<%= dqre.isAndOperator() ? "all" : "any" %>' /> - <liferay-ui:message key='<%= Objects.equals(dqre.getName(), "assetTags") ? "tags" : "categories" %>' />)</em>
					</liferay-util:buffer>

					<liferay-ui:message arguments="<%= messageArgument %>" key="only-one-rule-with-the-combination-x-is-supported" translateArguments="<%= false %>" />
				</liferay-ui:error>

				<p><liferay-ui:message key="displayed-assets-must-match-these-rules" /></p>

				<div id="<portlet:namespace />ConditionForm"></div>

				<%
				Map<String, Object> context = new HashMap<>();

				context.put("categorySelectorURL", editAssetListDisplayContext.getCategorySelectorURL());
				context.put("groupIds", ListUtil.toList(editAssetListDisplayContext.getReferencedModelsGroupIds()));
				context.put("id", "autofield");
				context.put("namespace", liferayPortletResponse.getNamespace());
				context.put("pathThemeImages", themeDisplay.getPathThemeImages());
				context.put("rules", editAssetListDisplayContext.getAutoFieldRulesJSONArray());
				context.put("tagSelectorURL", editAssetListDisplayContext.getTagSelectorURL());
				context.put("vocabularyIds", editAssetListDisplayContext.getVocabularyIds());
				%>

				<soy:component-renderer
					context="<%= context %>"
					module="js/AutoField.es"
					templateNamespace="com.liferay.asset.list.web.AutoField.render"
				/>
			</liferay-frontend:fieldset>
		</liferay-frontend:fieldset-group>
	</liferay-frontend:edit-form-body>

	<liferay-frontend:edit-form-footer>
		<aui:button type="submit" />

		<aui:button href="<%= editAssetListDisplayContext.getRedirectURL() %>" type="cancel" />
	</liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>
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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.taglib.search.ResultRow" %><%@
page import="com.liferay.user.associated.data.display.UADEntityDisplay" %><%@
page import="com.liferay.user.associated.data.entity.UADEntity" %><%@
page import="com.liferay.user.associated.data.web.internal.constants.UserAssociatedDataWebKeys" %><%@
page import="com.liferay.user.associated.data.web.internal.display.ManageUserAssociatedDataEntitiesDisplay" %><%@
page import="com.liferay.user.associated.data.web.internal.util.UADEntitySetComposite" %><%@
page import="com.liferay.user.associated.data.web.internal.util.UADEntityTypeComposite" %>

<%@ page import="java.util.List" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
long selUserId = ParamUtil.getLong(request, "selUserId");
%>
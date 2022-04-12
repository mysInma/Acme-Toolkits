<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:input-textbox code="authenticated.announcement.form.label.title" path="title"/>
	<acme:input-textarea code="authenticated.announcement.form.label.description" path="description"/>
	<acme:input-url code="authenticated.announcement.form.label.link" path="link"/>
	<acme:input-textbox code="authenticated.announcement.form.label.critical" path="critical"/>
</acme:form>

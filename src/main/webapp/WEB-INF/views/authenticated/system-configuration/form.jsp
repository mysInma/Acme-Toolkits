<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="authenticated.system-configuration.form.label.system-currency" path="system-currency"/>
	<acme:input-textbox code="authenticated.system-configuration.form.label.accepted-currencies" path="accepted-Currencies"/>
</acme:form>

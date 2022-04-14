<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>

	<acme:input-textbox code="administrator.system-configuration.form.label.system-currency" path="system-currency"/>
	<acme:input-textarea code="administrator.system-configuration.form.label.accepted-currencies" path="accepted-currencies"/>
	<acme:input-textarea code="administrator.system-configuration.form.label.strong-spam-terms" path="strong-spam-terms"/>
	<acme:input-double code="administrator.system-configuration.form.label.strong-threshold" path="strong-threshold"/>
	<acme:input-textarea code="administrator.system-configuration.form.label.weak-spam-terms" path="weak-spam-terms"/>
	<acme:input-double code="administrator.system-configuration.form.label.weak-threshold" path="weak-threshold"/>
	

</acme:form>
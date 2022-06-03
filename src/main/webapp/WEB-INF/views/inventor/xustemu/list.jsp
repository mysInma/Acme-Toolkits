<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.xustemu.list.label.code" path="code" width="10%"/>
	<acme:list-column code="inventor.xustemu.list.label.creationMoment" path="creationMoment" width="10%"/>
	<acme:list-column code="inventor.xustemu.list.label.subject" path="subject" width="10%"/>
	<acme:list-column code="inventor.xustemu.list.label.codeItem" path="codeItem" width="10%"/>	
</acme:list>	

	<acme:button code="inventor.xustemu.form.button.create" action="/inventor/xustemu/create"/>
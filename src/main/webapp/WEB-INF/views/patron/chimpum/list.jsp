<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="patron.chimpum.list.label.code" path="code" width="10%"/>
	<acme:list-column code="patron.chimpum.list.label.creationMoment" path="creationMoment" width="10%"/>
	<acme:list-column code="patron.chimpum.list.label.title" path="title" width="10%"/>
	<acme:list-column code="patron.chimpum.list.label.codeItem" path="codeItem" width="10%"/>	
</acme:list>	

	<acme:button code="patron.chimpum.form.button.create" action="/patron/chimpum/create"/>
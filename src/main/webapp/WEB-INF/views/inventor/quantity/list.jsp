<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.quantity.list.label.item.name" path="item.name" width="50%"/>
	<acme:list-column code="inventor.quantity.list.label.value" path="value" width="30%"/>	
</acme:list>

<acme:button  test="${showCreate && publishedItems}" code="inventor.quantity.list.button.create" action="/inventor/quantity/create?toolkitId=${toolkitId}"/>

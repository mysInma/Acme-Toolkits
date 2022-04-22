<%@ page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${ readonly }">

	<acme:input-textbox code="inventor.item.form.label.name" path="name"/>
	<acme:input-textbox code="inventor.item.form.label.code" path="code"/>
	<acme:input-textbox code="inventor.item.form.label.technology" path="technology"/>
	<acme:input-textbox code="inventor.item.form.label.description" path="description"/>
	<acme:input-money code="inventor.item.form.label.price" path="price"/>
	<acme:input-url code="inventor.item.form.label.link" path="link"/>
	<acme:input-select code="inventor.item.form.label.type" path="type">
		<acme:input-option code="inventor.item.form.label.component" value="COMPONENT" selected="${ type == 'COMPONENT' }"/>
		<acme:input-option code="inventor.item.form.label.tool" value="TOOL" selected="${ type == 'TOOL' }"/>
	</acme:input-select>
	<acme:input-url code="inventor.item.form.label.link" path="link"/>
	
	<acme:button code="inventor.item.form.button.inventor" action="/any/user-account/show?id=${ inventorId }"/>
</acme:form>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="inventor.toolkit.form.label.code" path="code"/>
	<acme:input-textarea code="inventor.toolkit.form.label.title" path="title"/>
	<acme:input-textbox code="inventor.toolkit.form.label.description" path="description"/>
	<acme:input-textarea code="inventor.toolkit.form.label.notes" path="notes"/>
	<acme:input-url code="inventor.toolkit.form.label.link" path="link"/>
	<acme:input-money code="inventor.toolkit.form.label.total-price" path="totalPrice"/> 
	<acme:input-textarea code="inventor.toolkit.form.label.published" path="published"/> 
	
	<acme:button code="inventor.toolkit.form.button.tool" action="/inventor/item/list-tool-toolkit?id=${ toolkitId }"/>
	<acme:button code="inventor.toolkit.form.button.component" action="/inventor/item/list-component-toolkit?id=${ toolkitId }"/>	
	
	
</acme:form>
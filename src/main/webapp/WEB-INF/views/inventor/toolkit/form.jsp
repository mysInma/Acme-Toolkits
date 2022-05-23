<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="inventor.toolkit.form.label.code" path="code"/>
	<acme:input-textarea code="inventor.toolkit.form.label.title" path="title"/>
	<acme:input-textbox code="inventor.toolkit.form.label.description" path="description"/>
	<acme:input-textarea code="inventor.toolkit.form.label.notes" path="notes"/>
	<acme:input-url code="inventor.toolkit.form.label.link" path="link"/>

		
	
	
		<jstl:choose>
		<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish')}">
				<acme:input-money readonly="true" code="inventor.toolkit.form.label.total-price" path="totalPrice"/>
				<acme:input-textarea readonly="true" code="inventor.toolkit.form.label.published" path="published"/> 
		</jstl:when>
		<jstl:when test="${command == 'create'}">
			<acme:input-select code="inventor.toolkit.form.label.published" path="published">
				<acme:input-option code="true" value="true" selected="${published == true}"/>
				<acme:input-option code="false" value="false" selected="${published == false }"/>
		</acme:input-select>
		</jstl:when>
		
	</jstl:choose> 
	
	<acme:button code="inventor.toolkit.form.button.tool" action="/inventor/item/list-tool-toolkit?id=${ toolkitId }"/>
	<acme:button code="inventor.toolkit.form.button.component" action="/inventor/item/list-component-toolkit?id=${ toolkitId }"/>	
	
	<jstl:choose>
		<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish') && published == false }">
			<acme:submit code="inventor.toolkit.form.button.update" action="/inventor/toolkit/update?id=${id}"/>
			<acme:submit code="inventor.toolkit.form.button.delete" action="/inventor/toolkit/delete"/>
			<acme:submit code="inventor.toolkit.form.button.publish" action="/inventor/toolkit/publish"/>
		</jstl:when>
		<jstl:when test="${command == 'create'}">
			<acme:submit code="inventor.toolkit.form.button.create" action="/inventor/toolkit/create"/>
		</jstl:when>
	</jstl:choose> 
	
	
	
</acme:form>

	
	


	


<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readOnly}"> 
	
	
	<jstl:choose>		
	
		<jstl:when test="${published == false}">
		<acme:input-textbox code="inventor.quantity.form.label.value" path="value"/>
		</jstl:when>
		<jstl:otherwise>
		<acme:input-textbox code="inventor.quantity.form.label.value" path="value" readonly="true"/>
		</jstl:otherwise>
		
	</jstl:choose>
	
	
	<jstl:choose>		
	
		<jstl:when test="${acme:anyOf(command, 'show,update,delete')}">
			<acme:input-textbox code="inventor.item.form.label.name" path="item.name" readonly="true"/>			
			<acme:input-textbox code="inventor.item.form.label.code" path="item.code" readonly="true"/>
			<acme:input-textbox code="inventor.item.form.label.technology" path="item.technology" readonly="true"/>
			<acme:input-textarea code="inventor.item.form.label.description" path="item.description" readonly="true"/>
			<acme:input-textbox code="inventor.item.form.label.type" path="item.type" readonly="true"/>
			<acme:input-textbox code="inventor.item.form.label.link" path="item.link" readonly="true"/>
			<acme:submit test="${published == false}" code="inventor.quantity.form.button.update" action="/inventor/quantity/update"/>
			<acme:submit test="${published == false}" code="inventor.quantity.form.button.delete" action="/inventor/quantity/delete"/>		
		</jstl:when>
	
		<jstl:when test="${command == 'create'}">		
			<acme:input-select code="inventor.quantity.form.label.select.item" path="item.id">
				<jstl:forEach items="${items}" var="optionItem">
					<acme:input-option code="${optionItem.name}" value="${optionItem.id}"/>
				</jstl:forEach>
			</acme:input-select>
			<acme:submit code="inventor.quantity.form.button.create" action="/inventor/quantity/create?toolkitId=${toolkitId}"/>			
		</jstl:when>	
		
	</jstl:choose>
	
</acme:form>


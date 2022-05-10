<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form> 
	<acme:input-textbox readonly="${acme:anyOf(command, 'show, update, delete, publish') && draftMode == true}" placeholder="PAT-012-A" code="patron.patronage.form.label.code" path="code"/>
	<acme:input-select code="patron.patronage.form.label.status" path="status">
		<acme:input-option code="PROPOSED" value="PROPOSED" selected="${status == 'PROPOSED'}"/>
		<acme:input-option code="DENIED" value="DENIED" selected="${status == 'DENIED'}"/>
		<acme:input-option code="ACCEPTED" value="ACCEPTED" selected="${status == 'ACCEPTED'}"/>
	</acme:input-select>
	<acme:input-textbox code="patron.patronage.form.label.legalStuff" path="legalStuff"/>
	<acme:input-money code="patron.patronage.form.label.budget" path="budget"/>
	<acme:input-moment readonly="${command == 'create'}" code="patron.patronage.form.label.creationMoment" path="creationMoment"/>
	<acme:input-moment code="patron.patronage.form.label.startDate" path="startDate"/>
	<acme:input-moment code="patron.patronage.form.label.finishDate" path="finishDate"/>
	<acme:input-url code="patron.patronage.form.label.link" path="link"/>
    
    <jstl:choose>
		<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish') && draftMode == true}">
			<h2><acme:message code="patron.patronage.form.label.info"/></h2>
			<acme:input-textbox readonly="true" code="patron.patronage.form.label.inventorFullName" path="inventorFullName"/>
			<acme:input-textbox readonly="true" code="patron.patronage.form.label.name" path="inventorName"/>
			<acme:input-textbox readonly="true" code="patron.patronage.form.label.surname" path="inventorSurname"/>
			<acme:input-email readonly="true" code="patron.patronage.form.label.email" path="inventorEmail"/>
		
			<acme:submit code="patron.patronage.form.button.update" action="/patron/patronage/update"/>
			<acme:submit code="patron.patronage.form.button.delete" action="/patron/patronage/delete"/>
			<acme:submit code="patron.patronage.form.button.publish" action="/patron/patronage/publish"/>
		</jstl:when>
		<jstl:when test="${command == 'create'}">
			<acme:input-select code="patron.patronage.form.label.inventor-select" path="inventorId">
				<jstl:forEach items="${inventors}" var="inventor">
					<acme:input-option code="${inventor.userAccount.identity.fullName}" value="${inventor.id}"/>
				</jstl:forEach>
			</acme:input-select>
		
			<acme:submit code="patron.patronage.form.button.create" action="/patron/patronage/create"/>
		</jstl:when>		
	</jstl:choose>
</acme:form>
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form> 
	<acme:input-moment code="inventor.patronage-report.form.label.creationMoment" path="creationMoment"/>
	<acme:input-textbox code="inventor.patronage-report.form.label.memorandum" path="memorandum"/>
	<acme:input-url code="inventor.patronage-report.form.label.link" path="link"/>
	
	<jstl:if test="${readonly}">
	<h2><acme:message code="inventor.patronage-report.form.label.patronage.info"/></h2>
	<acme:input-select code="inventor.patronage-report.form.label.patronage.status" path="patronageStatus">
		<acme:input-option code="inventor.patronage-report.form.label.patronage.status.proposed" value="PROPOSED" selected="${ type == 'PROPOSED' }"/>
		<acme:input-option code="inventor.patronage-report.form.label.patronage.status.accepted" value="ACCEPTED" selected="${ type == 'ACCEPTED' }"/>
		<acme:input-option code="inventor.patronage-report.form.label.patronage.status.denied" value="DENIED" selected="${ type == 'DENIED' }"/>
	</acme:input-select>
	<acme:input-textbox code="inventor.patronage-report.form.label.patronage.code" path="patronageCode"/>
	<acme:input-textbox code="inventor.patronage-report.form.label.patronage.legalStuff" path="patronageLegalStuff"/>
	<acme:input-money code="inventor.patronage-report.form.label.patronage.budget" path="patronageBudget"/>
	<acme:input-moment code="inventor.patronage-report.form.label.patronage.creationMoment" path="patronageCreationMoment"/>
	<acme:input-moment code="inventor.patronage-report.form.label.patronage.startDate" path="patronageStartDate"/>
	<acme:input-moment code="inventor.patronage-report.form.label.patronage.finishDate" path="patronageFinishDate"/>
	<acme:input-url code="inventor.patronage-report.form.label.patronage.link" path="patronageLink"/>
	</jstl:if>
	
	<jstl:if test="${!readonly}">
		<acme:input-select code="inventor.patronage-report.form.label.patronageCollection" path="patronage">
			<jstl:forEach items="${patronageCollection}" var="patronage">
				<acme:input-option code="${patronage.code}" value="${patronage.id}"/>
			</jstl:forEach>
		</acme:input-select>
	
		<acme:input-checkbox code="inventor.patronage-report.form.button.confirmation" path="confirmation"/>
		<acme:submit code="inventor.patronage-report.form.button.create" action="/inventor/patronage-report/create"/>
	</jstl:if>
	
</acme:form>
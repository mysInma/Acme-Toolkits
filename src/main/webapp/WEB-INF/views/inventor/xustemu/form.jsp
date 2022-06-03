<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form> 
    <acme:input-textbox code="inventor.xustemu.form.label.code" path="code"/>
    <acme:input-moment code="inventor.xustemu.form.label.creationMoment" path="creationMoment"/>
    <acme:input-textbox code="inventor.xustemu.form.label.subject" path="subject"/>
    <acme:input-textarea code="inventor.xustemu.form.label.summary" path="summary"/>
    <acme:input-moment code="inventor.xustemu.form.label.startDate" path="startDate"/>
    <acme:input-moment code="inventor.xustemu.form.label.finishDate" path="finishDate"/>
    <acme:input-url code="inventor.xustemu.form.label.moreInfo" path="moreInfo"/>
    
    
      <jstl:choose>
      
      <jstl:when test="${acme:anyOf(command, 'show, update,delete')}"> 
      			 <acme:input-money readonly="true" code="inventor.xustemu.form.label.amount" path="amount"/>
				<acme:input-textbox code="inventor.xustemu.form.label.codeItem" path="codeItem"/>
				<acme:submit code="inventor.xustemu.form.button.delete" action="/inventor/xustemu/delete"/>
				<acme:submit code="inventor.xustemu.form.button.update" action="/inventor/xustemu/update?id=${id}"/>
		</jstl:when>

        <jstl:when test="${command == 'create'}">
        	<acme:input-money code="inventor.xustemu.form.label.amount" path="amount"/>
          	<acme:input-select code="inventor.xustemu.form.label.item" path="itemId">
            	<jstl:forEach items="${items}" var="item">
                		<acme:input-option code="${item.getName()}" value="${item.getId()}" selected="${ item.getId() == itemId}"/>
                </jstl:forEach>
            </acme:input-select>
			<acme:submit code="inventor.xustemu.form.button.create" action="/inventor/xustemu/create"/>
  
        </jstl:when>
    </jstl:choose>

</acme:form>